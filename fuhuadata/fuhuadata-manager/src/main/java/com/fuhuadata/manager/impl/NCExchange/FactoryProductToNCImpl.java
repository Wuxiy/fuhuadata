package com.fuhuadata.manager.impl.NCExchange;

import com.fuhuadata.dao.NCExchange.FactoryToNc;
import com.fuhuadata.domain.supplier.ProduceFactoryProduct;
import com.fuhuadata.manager.NCExchange.FactoryProductToNC;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.servlet.ServletContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 供应商产品发送nc
 * Created by zhangxiang on 2017/6/7.
 */
public class FactoryProductToNCImpl implements FactoryProductToNC {

    private static final Log log = LogFactory.getLog(FactoryProductToNCImpl.class);

    @Autowired
    ServletContext servletContext;
    @Autowired
    private FactoryToNc factoryToNc;

    private String xmlName;
    private String realPath;
    @Override
    public void sendFactoryProduct(List<ProduceFactoryProduct> factoryProducts) throws Exception {
        realPath = servletContext.getRealPath("/");
        factoryProductToXMl(factoryProducts);
        String resFile=NcExchangeToolUtil.getRefFile(realPath,""+factoryProducts.get(0).getFactoryId(),"factoryProductBackFile");
        org.jdom.Element root=null;
        try {
            root=NcExchangeToolUtil.xmlSendNcTool(xmlName,resFile);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("发送nc失败",e);
            throw e;
        }
        String resSuc = root.getAttributeValue("successful");
        List<org.jdom.Element> list = root.getChildren();
        String pk_supplierext="";
        String resultCode="";
        for (org.jdom.Element e : list) {
            pk_supplierext=e.getChildText("content");
            resultCode=e.getChildText("resultcode");
        }
        if (null!=resSuc){
            if (resSuc.equals("N")){
                log.error("导入nc失败");
            }else if (resSuc.equals("Y")){
                log.info("导入nc成功");
                //将nc回传的pk_supplierext写入crm
            }else {
                log.error("读回写文件出错");
            }
        }else {
            log.error("未找到回执文件的successful属性");
        }

    }

    private String factoryProductToXMl(List<ProduceFactoryProduct> factoryProducts){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document=builder.newDocument();
            Element root=document.createElement("ufinterface");
            root.setAttribute("account","01");
            root.setAttribute("billtype","supplierext");
            root.setAttribute("groupcode","0001");
            root.setAttribute("isexchange","Y");
            root.setAttribute("replace","Y");
            root.setAttribute("sender","ET");
            document.appendChild(root);
            Element bill=document.createElement("bill");
            bill.setAttribute("id","factoryProduct"+factoryProducts.get(0).getFactoryId());
            root.appendChild(bill);
            Element billhead=document.createElement("billhead");
            bill.appendChild(billhead);

            Element pk_supplier=document.createElement("pk_supplier");
            pk_supplier.appendChild(document.createTextNode(factoryToNc.getPkSupplierById(factoryProducts.get(0).getFactoryId())));
            billhead.appendChild(pk_supplier);

            Element pk_supplierext_p=document.createElement("pk_supplierext_p");
            billhead.appendChild(pk_supplierext_p);
            for (ProduceFactoryProduct factoryProduct:factoryProducts){
                Element item=document.createElement("item");
                pk_supplierext_p.appendChild(item);

                Map<String,String> nodeValue=new HashMap<String, String>();
                if (factoryProduct.getCategoryId()!=null){
                    nodeValue.put("cmarbasclassid",""+factoryProduct.getCategoryId());
                }
                if (factoryProduct.getCmaterialId()!=null){
                    nodeValue.put("cmaterialid",""+factoryProduct.getCmaterialId());
                }
                if (factoryProduct.getCapacity()!=null){
                    nodeValue.put("vprodyear",factoryProduct.getCapacity());
                }
                nodeValue.put("pk_purchaseorg","0001");
                if (factoryProduct.getRemark()!=null){
                    nodeValue.put("vbmemo",factoryProduct.getRemark());
                }
                for(Map.Entry<String ,String> entry:nodeValue.entrySet()){
                    Element ele=document.createElement(entry.getKey());
                    ele.appendChild(document.createTextNode(entry.getValue()));
                    item.appendChild(ele);
                }

            }
            xmlName=NcExchangeToolUtil.getXmlName(realPath,""+factoryProducts.get(0).getFactoryId(),"factoryProduct");
            NcExchangeToolUtil.documentTreeToXML(document,xmlName);

        }catch (Exception e){
            log.error("生成xml出错",e);
            e.printStackTrace();
        }
        return xmlName;
    }

}
