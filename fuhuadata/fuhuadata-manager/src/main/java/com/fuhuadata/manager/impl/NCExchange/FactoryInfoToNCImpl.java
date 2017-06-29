package com.fuhuadata.manager.impl.NCExchange;

import com.fuhuadata.dao.NCExchange.FactoryToNc;
import com.fuhuadata.domain.common.BankAccBas;
import com.fuhuadata.domain.mybatis.supplier.SupplierLinkman;
import com.fuhuadata.domain.supplier.ProduceFactory;
import com.fuhuadata.manager.NCExchange.FactoryInfoToNC;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.servlet.ServletContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangxiang on 2017/5/27.
 */
public class FactoryInfoToNCImpl implements FactoryInfoToNC {

    private static final Log log = LogFactory.getLog(FactoryInfoToNCImpl.class);

    @Autowired
    ServletContext servletContext;
    @Autowired
    private FactoryToNc factoryToNc;

    private String xmlName;

    /**
     * 将加工厂基本信息发送nc
     * @param factoryInfo
     * @return
     */
    @Override
    public String sendFactoryInfo(ProduceFactory factoryInfo)  {
        String resFile= getRefFile(""+factoryInfo.getId(),"factoryBackFile");
        factoryInfoToXML(factoryInfo);
        org.jdom.Element root=null;
        try {
            root=NcExchangeToolUtil.xmlSendNcTool(xmlName,resFile);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("发送nc失败",e);
        }
        String resSuc = root.getAttributeValue("successful");
        List<org.jdom.Element> list = root.getChildren();
        String pk_factory="";
        String resultCode="";
        for (org.jdom.Element e : list) {
            pk_factory=e.getChildText("content");
            resultCode=e.getChildText("resultcode");
        }
        if (null!=resSuc){
            if (resSuc.equals("N")){
                log.error("导入nc失败");
            }else if (resSuc.equals("Y")){
                log.info("导入nc成功");
                //将nc回传的pk_factory写入crm中
                Map<String,Object> mapc=new HashMap<String, Object>();
                mapc.put("pk_supplier",pk_factory);
                mapc.put("id",factoryInfo.getId());
                //factoryToNc.updatePkFactory(mapc);
                for (BankAccBas bankAccBas:factoryInfo.getBanks()){
                    sendSupBankacc(bankAccBas,pk_factory);
                }
            }else {
                log.error("读回写文件出错");
            }
        }else {
            log.error("未找到回执文件的successful属性");
        }

        return resultCode;
    }

    /**
     * 将加工厂银行账户信息发送nc
     * @param bankAcc
     */
    private void sendSupBankacc(BankAccBas bankAcc,String pk_factory){
        String resFile=getRefFile(""+bankAcc.getId(),"bankBackFile");
        String bankXmlName= bankAccToXML(bankAcc,pk_factory);
        org.jdom.Element root=null;
        try {
            root=NcExchangeToolUtil.xmlSendNcTool(bankXmlName,resFile);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("发送nc失败",e);
        }
        String resSuc = root.getAttributeValue("successful");
        List<org.jdom.Element> list = root.getChildren();
        String pk_bankaccbas="";
        String resultCode="";
        for (org.jdom.Element e : list) {
            pk_bankaccbas=e.getChildText("content");
            resultCode=e.getChildText("resultcode");
        }
        if (null!=resSuc){
            if (resSuc.equals("N")){
                log.error("导入nc失败");
            }else if (resSuc.equals("Y")){
                log.info("导入nc成功");
                //将nc回传的pk_bankaccbas写入crm中
                Map<String,Object> mapc=new HashMap<String, Object>();
                mapc.put("pk_bankaccbas",pk_bankaccbas);
                mapc.put("id",bankAcc.getId());
                factoryToNc.updatePkBankaccbas(mapc);
            }else {
                log.error("读回写文件出错");
            }
        }else {
            log.error("未找到回执文件的successful属性");
        }
    }

    /**
     * 银行账户转换xml文件
     * @param bankAcc
     * @return
     */
    private String bankAccToXML(BankAccBas bankAcc,String pk_factory){
        String bankXmlName="";
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document=builder.newDocument();
            Element root=document.createElement("ufinterface");
            root.setAttribute("account","01");
            root.setAttribute("billtype","supbankacc");
            root.setAttribute("groupcode","0001");
            root.setAttribute("isexchange","Y");
            root.setAttribute("replace","Y");
            root.setAttribute("sender","ET");
            document.appendChild(root);
            Element bill=document.createElement("bill");
            bill.setAttribute("id","bankAcc"+bankAcc.getId());
            root.appendChild(bill);
            Element billhead=document.createElement("billhead");
            bill.appendChild(billhead);
            //
            Element bankaccbasVO=document.createElement("bankaccbasVO");
            billhead.appendChild(bankaccbasVO);
            Element pk_group=document.createElement("pk_group");
            pk_group.appendChild(document.createTextNode("0001"));
            bankaccbasVO.appendChild(pk_group);
            Element bankaccsub=document.createElement("bankaccsub");
            bankaccbasVO.appendChild(bankaccsub);
            Element item=document.createElement("item");
            bankaccsub.appendChild(item);
            Element isdefault=document.createElement("isdefault");
            isdefault.appendChild(document.createTextNode("N"));
            item.appendChild(isdefault);
            Element pk_currtype=document.createElement("pk_currtype");
            pk_currtype.appendChild(document.createTextNode(bankAcc.getPkCurrtype()));
            item.appendChild(pk_currtype);
            Map<String,String> nodeValue=new HashMap<String, String>();
            if(bankAcc.getAcctype()==0){
                nodeValue.put("accclass","3");
            }
            if (bankAcc.getAccname()!=null){
                nodeValue.put("accname",bankAcc.getAccname());
            }
            if (bankAcc.getAccnum()!=null){
                nodeValue.put("accnum",bankAcc.getAccnum());
            }
            //if (bankAcc.getAccopendate()!=null){
            //    nodeValue.put("accopendate",bankAcc.getAccopendate().toString());
            //}
            if (bankAcc.getAccountproperty()!=null){
                nodeValue.put("accountproperty",""+bankAcc.getAccountproperty());
            }
            if (bankAcc.getEnablestate()!=null){
                nodeValue.put("enablestate",""+bankAcc.getEnablestate());
            }
            if (bankAcc.getPkBankdoc()!=null){
                nodeValue.put("pk_bankdoc",bankAcc.getPkBankdoc());
            }
            if (bankAcc.getPkBanktype()!=null){
                nodeValue.put("pk_banktype",bankAcc.getPkBanktype());
            }
            if (bankAcc.getPkOrg()!=null){
                nodeValue.put("pk_org","0001");
            }
            if(bankAcc.getDeletedStatus()!=null && bankAcc.getDeletedStatus()==0){
                nodeValue.put("accstate","3");
            }else{
                nodeValue.put("accstate","0");
            }
            nodeValue.put("accountproperty","0");
            for(Map.Entry<String ,String> entry:nodeValue.entrySet()){
                Element ele=document.createElement(entry.getKey());
                ele.appendChild(document.createTextNode(entry.getValue()));
                bankaccbasVO.appendChild(ele);
            }
            Element custbankVO=document.createElement("custbankVO");
            billhead.appendChild(custbankVO);
            Element pk_cust=document.createElement("pk_cust");
            pk_cust.appendChild(document.createTextNode(""+pk_factory));
            custbankVO.appendChild(pk_cust);
            if (bankAcc.getPkBankaccbas()!=null){
                Element pk_custbank=document.createElement("pk_custbank");
                pk_custbank.appendChild(document.createTextNode(bankAcc.getPkBankaccbas()));
                custbankVO.appendChild(pk_custbank);
            }
            bankXmlName=getXmlName(""+bankAcc.getId(),"bankAcc");
            NcExchangeToolUtil.documentTreeToXML(document,bankXmlName);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("银行账户xml生成失败",e);
        }
        return bankXmlName;
    }

    /**
     * 加工厂基本信息转换xml文件
     * @param factoryInfo
     * @return
     */
    private String factoryInfoToXML(ProduceFactory factoryInfo){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document=builder.newDocument();
            Element root=document.createElement("ufinterface");
            root.setAttribute("account","01");
            root.setAttribute("billtype","supplier");
            root.setAttribute("groupcode","0001");
            root.setAttribute("isexchange","Y");
            root.setAttribute("replace","Y");
            root.setAttribute("sender","ET");
            document.appendChild(root);
            Element bill=document.createElement("bill");
            bill.setAttribute("id","supplier"+factoryInfo.getId());
            root.appendChild(bill);
            Element billhead=document.createElement("billhead");
            bill.appendChild(billhead);
            /*
             */
            Element pk_group=document.createElement("pk_group");
            pk_group.appendChild(document.createTextNode("0001"));
            billhead.appendChild(pk_group);
            Map<String,String> nodeValue=new HashMap<String, String>();
            if (factoryInfo.getPkOrg()!=null){
                nodeValue.put("pk_org",factoryInfo.getPkOrg());
            }
            if (factoryInfo.getPkSupplier()!=null){
                nodeValue.put("pk_supplier",factoryInfo.getPkSupplier());
            }
            if (factoryInfo.getName()!=null){
                nodeValue.put("name",factoryInfo.getName());
            }
            if (factoryInfo.getAbbr()!=null){
                nodeValue.put("shortname",factoryInfo.getAbbr());
            }
            if (factoryInfo.getRegisterfund()!=null){
                nodeValue.put("registerfund",""+factoryInfo.getRegisterfund());
            }
            //供应商基本分类
            nodeValue.put("pk_supplierclass","2504");
            //供应商类型
            nodeValue.put("supprop","0");
            //
            nodeValue.put("supstate","1");
            //国家地区
            nodeValue.put("pk_country","CN");
            //时区
            nodeValue.put("pk_timezone","P0800");
            //数据格式
            nodeValue.put("pk_format","ZH-CN");
            //启用状态
            nodeValue.put("enablestate","2");
            for(Map.Entry<String ,String> entry:nodeValue.entrySet()){
                Element ele=document.createElement(entry.getKey());
                ele.appendChild(document.createTextNode(entry.getValue()));
                billhead.appendChild(ele);
            }
            //联系人
            Element suplinkman=document.createElement("suplinkman");
            billhead.appendChild(suplinkman);
            for (SupplierLinkman supplierLinkman:factoryInfo.getLinkmen()){
                if (supplierLinkman.getDeletedStatus()==null) {
                    Element item = document.createElement("item");
                    suplinkman.appendChild(item);
                    if (supplierLinkman.getPkLinkman() != null) {
                        Element pk_linkman = document.createElement("pk_linkman");
                        item.appendChild(pk_linkman);
                    }
                    Element pk_linkman=document.createElement("pk_linkman");
                    item.appendChild(pk_linkman);
                    Element isdefault = document.createElement("isdefault");
                    isdefault.appendChild(document.createTextNode(supplierLinkman.getIsdefault() == 0 ? "N" : "Y"));
                    item.appendChild(isdefault);
                    Element linkmanvo = document.createElement("linkmanvo");
                    item.appendChild(linkmanvo);
                    if (supplierLinkman.getCode() != null) {
                        Element code = document.createElement("code");
                        code.appendChild(document.createTextNode(supplierLinkman.getCode()));
                        linkmanvo.appendChild(code);
                    }
                    if (supplierLinkman.getName() != null) {
                        Element name = document.createElement("name");
                        name.appendChild(document.createTextNode(supplierLinkman.getName()));
                        linkmanvo.appendChild(name);
                    }
                    if (supplierLinkman.getCell() != null) {
                        Element cell = document.createElement("cell");
                        cell.appendChild(document.createTextNode(supplierLinkman.getCell()));
                        linkmanvo.appendChild(cell);
                    }
                    if (supplierLinkman.getEmail() != null) {
                        Element email = document.createElement("email");
                        email.appendChild(document.createTextNode(supplierLinkman.getEmail()));
                        linkmanvo.appendChild(email);
                    }
                    if (supplierLinkman.getPhone() != null) {
                        Element phone = document.createElement("phone");
                        phone.appendChild(document.createTextNode(supplierLinkman.getPhone()));
                        linkmanvo.appendChild(phone);
                    }
                    //if (supplierLinkman.getBirthday() != null) {
                    //    Element birthday = document.createElement("birthday");
                    //    birthday.appendChild(document.createTextNode(supplierLinkman.getBirthday()));
                    //    linkmanvo.appendChild(birthday);
                    //}
                    if (supplierLinkman.getAddress() != null) {
                        Element address = document.createElement("address");
                        address.appendChild(document.createTextNode(supplierLinkman.getAddress()));
                        linkmanvo.appendChild(address);
                    }
                    if (supplierLinkman.getPostcode() != null) {
                        Element postcode = document.createElement("postcode");
                        postcode.appendChild(document.createTextNode(supplierLinkman.getPostcode()));
                        linkmanvo.appendChild(postcode);
                    }
                    if (supplierLinkman.getMeno() != null) {
                        Element memo = document.createElement("memo");
                        memo.appendChild(document.createTextNode(supplierLinkman.getMeno()));
                        linkmanvo.appendChild(memo);
                    }
                }
            }
            xmlName=getXmlName(""+factoryInfo.getId(),"factory");
            NcExchangeToolUtil.documentTreeToXML(document,xmlName);
        }catch (Exception e){
            e.printStackTrace();
            log.error("生成xml失败",e);
        }
        return xmlName;
    }
    private String getXmlName(String id,String xmlType){
        String a = servletContext.getRealPath("/");
        File dir=new File(a+"lib/NCBackFile/");
        if (!dir.exists()){
            dir.mkdirs();
        }
        String xmlName=a+"lib/NCBackFile/"+xmlType+id+System.currentTimeMillis()+".xml";
        return xmlName;
    }
    private String getRefFile(String id,String xmlType){
        String a = servletContext.getRealPath("/");
        File dir=new File(a+"lib/NCBackFile/");
        if (!dir.exists()){
            dir.mkdirs();
        }
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
        String resFile =a +"lib/NCBackFile/"+xmlType+id+ fmt.format(new Date()) + ".xml";
        return resFile;
    }
}
