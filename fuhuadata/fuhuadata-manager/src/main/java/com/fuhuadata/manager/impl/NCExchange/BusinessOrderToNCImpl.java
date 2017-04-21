package com.fuhuadata.manager.impl.NCExchange;

import com.fuhuadata.dao.BusinessOrderDao;
import com.fuhuadata.dao.BusinessOrderProductDao;
import com.fuhuadata.domain.BusinessOrder;
import com.fuhuadata.domain.BusinessOrderProduct;
import com.fuhuadata.domain.query.QueryBusinessOrderProduct;
import com.fuhuadata.manager.NCExchange.BusinessOrderToNC;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.DocumentHelper;
import org.dom4j.io.DocumentSource;
import org.jdom.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangxiang on 2017/4/10.
 */
public class BusinessOrderToNCImpl implements BusinessOrderToNC{

    private static final Log log = LogFactory.getLog(BusinessOrderToNCImpl.class);
    @Autowired
    private BusinessOrderDao businessOrderDao;
    @Autowired
    private BusinessOrderProductDao businessOrderProductDao;

    /**
     * 返回值为"1"则NC转换成功
     * @param orderId
     * @return
     */
    @Override
    public String sendBusinessOrder(String orderId) {

        /*
        将订单实体转换成xml。
         */
            BusinessOrder orderBaseInfo = businessOrderDao.getBusinessOrderByOrderId(orderId);
            QueryBusinessOrderProduct qbop = new QueryBusinessOrderProduct();
            qbop.setOrderId(orderId);
            List<BusinessOrderProduct> orderProducts = businessOrderProductDao.getList(qbop);
            String xmlName= businessOrderToXML(orderBaseInfo, orderProducts);
        /*
        将xml文件传送到nc端
         */
        String pk_order=null;
        String resultCode=null;
        try {
            // 获取Servlet连接并设置请求的方法
            String url = "http://192.168.30.30:8300/service/XChangeServlet?account=01&groupcode=0001";
            URL realURL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) realURL.openConnection();
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-type", "text/xml");
            connection.setRequestMethod("POST");


            File file = new File("fuhuadata-manager/src/main/resource/indocs"+xmlName);
            BufferedOutputStream out = new BufferedOutputStream(connection.getOutputStream());
            BufferedInputStream input = new BufferedInputStream(new FileInputStream(file));
            int length;
            byte[] buffer = new byte[1000];
            while ((length = input.read(buffer, 0, 1000)) != -1) {
                out.write(buffer, 0, length);
            }
            input.close();
            out.close();
            // 从连接的输入流中取得回执信息
            /***************从输入流取得Doc***************/
            InputStream inputStream = connection.getInputStream();

            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader bufreader = new BufferedReader(isr);
            String xmlString = "";
            int c;
            System.out.println("==================Beging====================");
            while ((c = bufreader.read()) != -1) {
                System.out.print((char) c);
                xmlString += (char) c;
            }
            input.close();
            System.out.println("===================End======================");
            org.dom4j.Document resDoc = DocumentHelper.parseText(xmlString);


            // 对回执结果的后续处理
            /************document转化为xml*************/
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            DocumentSource source = new DocumentSource(resDoc);
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            //设置文档的换行与缩进
            transformer.setOutputProperty(OutputKeys.INDENT, "YES");


            //设置日期格式
            SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
            String resFile = "fuhuadata-manager/src/main/resource/indocs/orderBackFile" + fmt.format(new Date()) + ".xml";
            StreamResult result = new StreamResult(new File(resFile));
            transformer.transform(source, result);
            System.out.println("======生成回执文件成功=======");


            /**************jdom解析XML*****************/
            org.jdom.input.SAXBuilder saxReader = new SAXBuilder();
            org.jdom.Document document1 = saxReader.build(new File(resFile));
            org.jdom.Element root = document1.getRootElement();
            //获取根元素,得到导入用友是否成功successful的值,值为Y:成功 N:失败
            String resSuc = root.getAttributeValue("successful");
            List<org.jdom.Element> list = root.getChildren();
            for (org.jdom.Element e : list) {
                System.out.println("-------------------------");
                System.out.println("filename---> " + e.getChildText("filename"));
                System.out.println("resultcode---> " + e.getChildText("resultcode"));
                System.out.println("resultdescription---> " + e.getChildText("resultdescription"));
                System.out.println("content--> " + e.getChildText("content"));
                System.out.println("--------------------------------------");
                pk_order=e.getChildText("content");
                resultCode=e.getChildText("resultcode");
            }

            //后面对回执结果做判断,然后改变导入状态就行了
            if (null != resSuc) {
                if (resSuc.equals("N")) {
                    log.info("导入nc失败");
                } else if (resSuc.equals("Y")) {
                    log.info("导入nc成功");
                    //接下来的代码，修改状态
                    orderBaseInfo.setStatus(2);
                    orderBaseInfo.setNcOrderId(pk_order);
                    businessOrderDao.updateBusinessOrderByOrderId(orderBaseInfo);
                } else {
                    System.out.println("出现未知错误");
                }
            } else {
                System.out.println("未找到successful属性");
            }
        }catch (Exception e){
            log.error("发送nc出错",e);
        }

        return resultCode;
    }

    private String businessOrderToXML(BusinessOrder orderBaseInfo, List<BusinessOrderProduct> orderProducts){
        String xmlName=null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document=builder.newDocument();
            Element root=document.createElement("ufinterface");
            root.setAttribute("account","01");
            root.setAttribute("billtype","5715");
            root.setAttribute("groupcode","0001");
            root.setAttribute("isexchange","Y");
            root.setAttribute("replace","Y");
            root.setAttribute("sender","ET");
            document.appendChild(root);
            Element bill=document.createElement("bill");
            bill.setAttribute("id","et5715"+orderBaseInfo.getOrderId());
            root.appendChild(bill);
            Element billhead=document.createElement("billhead");
            bill.appendChild(billhead);
            /*
            订单基本信息转换 表头xml
             */
            Element pk_group=document.createElement("pk_group");
            pk_group.appendChild(document.createTextNode("0001"));
            billhead.appendChild(pk_group);
            Map<String,String> nodeValue=new HashMap<String, String>();
            nodeValue.put("pk_org",orderBaseInfo.getSaleOrganizationId());
            nodeValue.put("ccustomerid",orderBaseInfo.getCustomerId());
            nodeValue.put("ctradecountryid",orderBaseInfo.getTradeCountry());
            nodeValue.put("cemployeeid",orderBaseInfo.getSalesManId());
            nodeValue.put("cdeptvid",orderBaseInfo.getDepartmentId());
            nodeValue.put("corigcurrencyid",orderBaseInfo.getCurrency());
            nodeValue.put("nexchangerate",""+orderBaseInfo.getNexchangerate());
            nodeValue.put("nusdexchgrate",""+orderBaseInfo.getNusdexchgrate());
            nodeValue.put("cpaytermid",orderBaseInfo.getCollectionAgreement());
            nodeValue.put("ctradewordid",orderBaseInfo.getTradeTerm());
            //nodeValue.put("ctransporttypeid","");
            nodeValue.put("cloadportid",orderBaseInfo.getShipmentPort());
            nodeValue.put("cdestportid",orderBaseInfo.getDestinationPort());
            nodeValue.put("vdef6",""+orderBaseInfo.getGuaranteeRate());
            nodeValue.put("vdef16",""+orderBaseInfo.getCreditRate());
            nodeValue.put("vdef17",""+orderBaseInfo.getDiscountRate());
            nodeValue.put("vdef18",""+orderBaseInfo.getSaleRate());
            nodeValue.put("vdef19",""+orderBaseInfo.getManagementRate());
            nodeValue.put("vdef12",""+orderBaseInfo.getLossRate());
            //设定长期协议的协议状态为生效。
            nodeValue.put("fstatusflag","7");
            nodeValue.put("fpfstatusflag","1");
            for(Map.Entry<String ,String> entry:nodeValue.entrySet()){
                Element ele=document.createElement(entry.getKey());
                ele.appendChild(document.createTextNode(entry.getValue()));
                billhead.appendChild(ele);
            }
            /*
            产品信息转换 表体xml
             */
            Element pk_longpro_set=document.createElement("pk_longpro_set");
            billhead.appendChild(pk_longpro_set);
            Element pk_longpro_b=document.createElement("pk_longpro_b");
            billhead.appendChild(pk_longpro_b);

            int i=1;
            for(BusinessOrderProduct orderProduct:orderProducts){
                Element item=document.createElement("item");
                pk_longpro_b.appendChild(item);
                Map<String,String> productMap=new HashMap<String, String>();
                productMap.put("crowno",""+i);i++;
                productMap.put("cmaterialvid",""+orderProduct.getProductId());
                productMap.put("",orderProduct.getInternalSupplyId());
                productMap.put("nnum",""+orderProduct.getMainProductAmount());
                productMap.put("norigprice",""+orderProduct.getContractPrice());
                productMap.put("vbdef20",""+orderProduct.getCommissionPrice());
                //单耗
                productMap.put("vbdef7",""+orderProduct.getConvertRate());
                //采购单价
                productMap.put("vbdef8",""+orderProduct.getPurchasePrice());
                //海运单价
                productMap.put("vbdef9",""+orderProduct.getOceanFreight());
                //港杂单价
                productMap.put("vbdef10",""+orderProduct.getPortSurcharge());
                //原药基准价
                productMap.put("vbdef11",""+orderProduct.getAdvisePrice());
                //毛利率
                productMap.put("vbdef12",""+orderProduct.getGrossMargin());
                //加工费单价
                productMap.put("vbdef13",""+orderProduct.getProcessCost());
                //其他费用单价
                productMap.put("vbdef14",""+orderProduct.getOtherCost());
                //退税计算方式
                productMap.put("vbdef15",""+orderProduct.getTaxType());
                //退税率
                productMap.put("vbdef3",""+orderProduct.getTaxFree());
                //货柜数
                productMap.put("vbdef17",""+orderProduct.getCupboardNumber());
                //货柜类型
                productMap.put("cpackingid",""+orderProduct.getCupboardType());
                for(Map.Entry<String ,String> entry:productMap.entrySet()){
                    Element ele=document.createElement(entry.getKey());
                    ele.appendChild(document.createTextNode(entry.getValue()));
                    item.appendChild(ele);
                }

            }
            TransformerFactory tf = TransformerFactory.newInstance();
            // 此抽象类的实例能够将源树转换为结果树
            Transformer transformer = tf.newTransformer();
            DOMSource source = new DOMSource(document);
            transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
            // 一个节点后换行，你可以设置为true，然后尝试解析看打印结果
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            // 向文本输出流打印对象的格式化表示形式
            // 要保证你的文本输出后格式不乱码，打印对象需指定打印格式，以标记此文本支持的格式
            xmlName="order"+orderBaseInfo.getOrderId()+System.currentTimeMillis()+".xml";
            PrintWriter pw = new PrintWriter("fuhuadata-manager/src/main/resource/indocs"+xmlName, "utf-8");
            // 充当转换结果的持有者，可以为 XML、纯文本、HTML 或某些其他格式的标记
            StreamResult result = new StreamResult(pw);
            transformer.transform(source, result);

        }catch (Exception e){
            log.error("转换xml文件失败",e);
        }
        return xmlName;
    }

    public static void main(String[] args) {
        BusinessOrderToNC b=new BusinessOrderToNCImpl();
        b.sendBusinessOrder("20170322122021023");
    }

}
