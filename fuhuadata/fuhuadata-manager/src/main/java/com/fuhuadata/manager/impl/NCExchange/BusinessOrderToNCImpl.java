package com.fuhuadata.manager.impl.NCExchange;

import com.fuhuadata.dao.BusinessOrderDao;
import com.fuhuadata.dao.BusinessOrderProductDao;
import com.fuhuadata.dao.CustomerBaseInfoDao;
import com.fuhuadata.dao.NCExchange.OrderToNc;
import com.fuhuadata.domain.BusinessOrder;
import com.fuhuadata.domain.BusinessOrderProduct;
import com.fuhuadata.domain.CustomerBaseInfo;
import com.fuhuadata.manager.NCExchange.BusinessOrderToNC;
import com.fuhuadata.manager.NCExchange.CustomerInfoToNC;
import com.fuhuadata.manager.NCExchange.PDFTempletToPDF;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.DocumentHelper;
import org.dom4j.io.DocumentSource;
import org.jdom.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.servlet.ServletContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.math.BigDecimal;
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
    @Autowired
    private CustomerBaseInfoDao customerBaseInfoDao;
    @Autowired
    private CustomerInfoToNC customerInfoToNC;
    @Autowired
    private OrderToNc orderToNc;
    @Value("${ncurl}")
    private String ncUrl;
    @Value("${ctrantypeid}")
    private String ctrantypeid;
    @Value("${vtrantypecode}")
    private String vtrantypecode;
    @Autowired
    ServletContext servletContext;
    @Autowired
    private PDFTempletToPDF pDFTempletToPDF;
    /**
     * 返回值为"1"则NC转换成功
     * @param orderId
     * @return
     */
    @Override
    public String sendBusinessOrder(String orderId,List<Integer> orderProductsId) {
        //pdf导入nc长期协议调用接口需要的参数字段
        String creatorCode="";
        String pPath="";
        /*
        将订单实体转换成xml。
         */
            BusinessOrder orderBaseInfo = orderToNc.getBusinessOrderByOrderId(orderId);
            creatorCode=orderBaseInfo.getSalesManId();
            String customerId=orderBaseInfo.getCustomerId();
            CustomerBaseInfo customerBaseInfo=customerBaseInfoDao.getCustomerBaseInfoById(customerId);
            int customerType=customerBaseInfo.getCustomerType();
            String ncid=customerBaseInfo.getNcId();
            //判断该客户是否是合作客户，如果不是则转换成合作客户，并导入nc客户基本档案
            if (2==customerType){
                ncid=customerInfoToNC.sendCustomerInfo(customerBaseInfo);
            }
            String xmlName=null;
        List<BusinessOrderProduct> orderProducts=null;
            if (orderProductsId.size()!=0) {
                orderProducts = orderToNc.getOrderProductsById(orderProductsId);
                xmlName = businessOrderToXML(orderBaseInfo, orderProducts, ncid);
            }else {
                log.error("-----没有订单产品无法提交NC-----");
                return "";
            }

        /*
        将xml文件传送到nc端
         */

        //获取配置参数


        String pk_order=null;
        String resultCode=null;
        try {
            // 获取Servlet连接并设置请求的方法
            //Properties properties = new Properties();
            //InputStream inputS = new FileInputStream("fuhuadata-manager/src/main/resource/ncInfo.properties");
            //properties.load(inputS);
            //String ncurl = properties.getProperty("ncurl");

            URL realURL = new URL(ncUrl);
            HttpURLConnection connection = (HttpURLConnection) realURL.openConnection();
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-type", "text/xml");
            connection.setRequestMethod("POST");

            File file = new File(xmlName);
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

            InputStreamReader isr = new InputStreamReader(inputStream,"UTF-8");
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
            String a = servletContext.getRealPath("/");
            SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
            String resFile =a +"lib/NCBackFile/"+orderBaseInfo.getSalesManId()+ fmt.format(new Date()) + ".xml";
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
                    //修改状态
                    orderBaseInfo.setStatus(2);
                    orderBaseInfo.setNcOrderId(pk_order);
                    businessOrderDao.updateBusinessOrderByOrderId(orderBaseInfo);
                    //生成pdf附件
                    pPath=pk_order;
                    String pdfPath= pDFTempletToPDF.PDFTempletToPDFmanager(orderProducts);
                    //将pdf附件导入nc长期协议表
                    pdfSendToNC(pdfPath,creatorCode,pPath);
                } else {
                    log.error("出現未知错误");
                }
            } else {
                log.error("未找到回执文件的succeful属性");
            }
        }catch (Exception e){
            log.error("发送nc出错",e);
        }

        return resultCode;
    }
    private String businessOrderToXML(BusinessOrder orderBaseInfo, List<BusinessOrderProduct> orderProducts,String ncid){
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
            if(orderBaseInfo.getSaleOrganizationId()!=null) {
                nodeValue.put("pk_org", "" + orderBaseInfo.getSaleOrganizationId());
                nodeValue.put("pk_org_v","" + orderBaseInfo.getSaleOrganizationId());
                nodeValue.put("csettleorgvid",""+orderBaseInfo.getSaleOrganizationId());
                nodeValue.put("csettleorgid",""+orderBaseInfo.getSaleOrganizationId());
                nodeValue.put("carorgvid",""+orderBaseInfo.getSaleOrganizationId());
                nodeValue.put("carorgid",""+orderBaseInfo.getSaleOrganizationId());
                nodeValue.put("csettleorgvid",""+orderBaseInfo.getSaleOrganizationId());
                nodeValue.put("csettleorgid",""+orderBaseInfo.getSaleOrganizationId());
                nodeValue.put("carorgvid",""+orderBaseInfo.getSaleOrganizationId());
                nodeValue.put("carorgid",""+orderBaseInfo.getSaleOrganizationId());
            }
            nodeValue.put("ctrademodeid","10");
            nodeValue.put("ccustomerid",""+ncid);
            if (orderBaseInfo.getTradeCountry()!=null) {
                nodeValue.put("ctradecountryid", "" + orderBaseInfo.getTradeCountry());
            }if (orderBaseInfo.getSalesManId()!=null) {
                nodeValue.put("cemployeeid", "" + orderBaseInfo.getSalesManId());
            }
            if (orderBaseInfo.getDepartmentId()!=null) {
                nodeValue.put("cdeptvid", "" + orderBaseInfo.getDepartmentId());
                nodeValue.put("cdeptid","" + orderBaseInfo.getDepartmentId());
            }
            if (orderBaseInfo.getCurrency()!=null) {
                nodeValue.put("corigcurrencyid", "" + orderBaseInfo.getCurrency());
                //本位币
                nodeValue.put("ccurrencyid","" + orderBaseInfo.getCurrency());
                nodeValue.put("cusdcurrencyid","" + orderBaseInfo.getCurrency());
            }
            if (orderBaseInfo.getLastdelydate()!=null){
                nodeValue.put("vdef6",orderBaseInfo.getLastdelydate().toString());
            }

            //nc长期协议的 协议类型
            nodeValue.put("ctrantypeid",ctrantypeid);
            nodeValue.put("vtrantypecode",vtrantypecode);
            BigDecimal nexchangerate=orderBaseInfo.getNexchangerate();
            if (orderBaseInfo.getNexchangerate()!=null) {
                nodeValue.put("nexchangerate", "" + orderBaseInfo.getNexchangerate());
            }
            if (orderBaseInfo.getNusdexchgrate()!=null) {
                nodeValue.put("nusdexchgrate", "" + orderBaseInfo.getNusdexchgrate());
            }
            if (orderBaseInfo.getCollectionAgreement()!=null) {
                nodeValue.put("cpaytermid", "" + orderBaseInfo.getCollectionAgreement());
            }
            if (orderBaseInfo.getTradeTerm()!=null) {
                nodeValue.put("ctradewordid", "" + orderBaseInfo.getTradeTerm());
            }
            //nodeValue.put("ctransporttypeid","");
            if (orderBaseInfo.getShipmentPort()!=null) {
                nodeValue.put("cloadportid", "" + orderBaseInfo.getShipmentPort());
            }
            if (orderBaseInfo.getDestinationPort()!=null) {
                nodeValue.put("cdestportid", "" + orderBaseInfo.getDestinationPort());
            }
            if (orderBaseInfo.getGuaranteeRate()!=null) {
                nodeValue.put("vdef12", "" + orderBaseInfo.getGuaranteeRate());
            }
            if (orderBaseInfo.getCreditRate()!=null) {
                nodeValue.put("vdef2", "" + orderBaseInfo.getCreditRate());
            }
            if (orderBaseInfo.getDiscountRate()!=null) {
                nodeValue.put("vdef11", "" + orderBaseInfo.getDiscountRate());
            }
            if (orderBaseInfo.getSaleRate()!=null) {
                nodeValue.put("vdef3", "" + orderBaseInfo.getSaleRate());
            }
            if (orderBaseInfo.getManagementRate()!=null) {
                nodeValue.put("vdef4", "" + orderBaseInfo.getManagementRate());
            }
            if (orderBaseInfo.getLossRate()!=null) {
                nodeValue.put("vdef5", "" + orderBaseInfo.getLossRate());
            }
            if (orderBaseInfo.getCollectionAgreement()!=null){
                nodeValue.put("cpaytermid",""+orderBaseInfo.getCollectionAgreement());
            }
            //crmd订单id
            if (orderBaseInfo.getOrderId()!=null){
                nodeValue.put("vdef20",orderBaseInfo.getOrderId());
            }
            //是否使用信用险
            if (orderBaseInfo.getIsCreditRisk()==0){
                nodeValue.put("vdef7","N");
            }
            if (orderBaseInfo.getIsCreditRisk()==1){
                nodeValue.put("vdef7","Y");
            }

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
                //根据crm的物料id查询product_ware表里的nc物料code
                int wareId=orderProduct.getWareId();
                String materialCode=orderToNc.getCodeByWareId(wareId);
                if(materialCode!=null){
                    productMap.put("cmaterialvid",""+materialCode);
                    productMap.put("vbdef17",""+materialCode);
                }
                //内部供货单位
                if (orderProduct.getInternalSupplyId()!=null) {
                    productMap.put("vbdef18", orderProduct.getInternalSupplyId());
                }
                if (orderProduct.getMainProductAmount()!=null) {
                    productMap.put("nnum", "" + orderProduct.getMainProductAmount());
                    //报价数量
                    productMap.put("nqtunitnum","" + orderProduct.getMainProductAmount());
                }
                //报价换算率
                productMap.put("vqtunitrate","1");
                if (orderProduct.getContractPrice()!=null) {
                    //销售单价
                    productMap.put("norigprice", "" + orderProduct.getContractPrice());
                    //本币单价
                    BigDecimal nqtprice=orderProduct.getContractPrice().multiply(nexchangerate);
                    productMap.put("nqtprice","" + nqtprice);
                    //本币金额
                    BigDecimal nmny= nqtprice.multiply(orderProduct.getMainProductAmount());
                    productMap.put("nmny",""+nmny);
                    //主本币单价
                    productMap.put("nprice","" + orderProduct.getContractPrice());
                    //主美元单价
                    productMap.put("nusdprice",""+orderProduct.getContractPrice().multiply(orderBaseInfo.getNusdexchgrate()));
                }
                if (orderProduct.getCommissionPrice()!=null) {
                    productMap.put("vbdef13", "" + orderProduct.getCommissionPrice());
                }
                //单耗
                if (orderProduct.getConvertRate()!=null) {
                    productMap.put("vbdef7", "" + orderProduct.getConvertRate());
                }
                //采购单价
                if (orderProduct.getPurchasePrice()!=null) {
                    productMap.put("vbdef8", "" + orderProduct.getPurchasePrice());
                }
                //海运单价
                if (orderProduct.getOceanFreight()!=null) {
                    productMap.put("vbdef11", "" + orderProduct.getOceanFreight());
                }
                //港杂单价
                if (orderProduct.getPortSurcharge()!=null) {
                    productMap.put("vbdef12", "" + orderProduct.getPortSurcharge());
                }
                //原药基准价
                if (orderProduct.getAdvisePrice()!=null) {
                    productMap.put("vbdef9", "" + orderProduct.getAdvisePrice());
                }
                //毛利率
                if (orderProduct.getGrossMargin()!=null) {
                    productMap.put("vbdef12", "" + orderProduct.getGrossMargin());
                }
                //加工费单价
                if (orderProduct.getProcessCost()!=null) {
                    productMap.put("vbdef10", "" + orderProduct.getProcessCost());
                }
                //其他费用单价
                if (orderProduct.getOtherCost()!=null) {
                    productMap.put("vbdef14", "" + orderProduct.getOtherCost());
                }
                //退税计算方式
                if (orderProduct.getTaxType()!=null) {
                    if(orderProduct.getTaxType()==1){
                        productMap.put("vbdef15", "10");
                    }if(orderProduct.getTaxType()==2){
                        productMap.put("vbdef15", "20");
                    }else {
                        productMap.put("vbdef15", "30");
                    }
                }
                //退税率
                if (orderProduct.getTaxFree()!=null) {
                    productMap.put("vbdef3", "" + orderProduct.getTaxFree());
                }
                //货柜数
                if (orderProduct.getCupboardNumber()!=null) {
                    productMap.put("vbdef4", "" + orderProduct.getCupboardNumber());
                }
                //货柜类型
                if (orderProduct.getCupboardType()!=null) {
                    productMap.put("cpackingid", "" + orderProduct.getCupboardType());
                }
                //交货时间
                if (orderProduct.getDeliveryTime()!=null){
                    productMap.put("vbdef2",orderProduct.getDeliveryTime());
                }
                //价格计算类型
                if (orderProduct.getPriceType()!=null){
                    productMap.put("vbdef19",""+orderProduct.getPriceType());
                }
                //crmId
                if (orderProduct.getId()!=null){
                    productMap.put("vbdef20",""+orderProduct.getId());
                }

                for(Map.Entry<String ,String> entry:productMap.entrySet()){
                    String a=entry.getKey();
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

            String a = servletContext.getRealPath("/");
            File dir=new File(a+"lib/NCBackFile/");
            if (!dir.exists()){
                dir.mkdirs();
            }
            xmlName=a+"lib/NCBackFile/"+"order"+orderBaseInfo.getOrderId()+System.currentTimeMillis()+".xml";
            PrintWriter pw = new PrintWriter(xmlName, "utf-8");
            // 充当转换结果的持有者，可以为 XML、纯文本、HTML 或某些其他格式的标记
            StreamResult result = new StreamResult(pw);
            transformer.transform(source, result);

        }catch (Exception e){
            log.error("转换xml文件失败",e);
        }
        return xmlName;
    }

    private String pdfSendToNC(String pdfPath,String creatorCode,String pPath ) throws IOException {
        String filename=pdfPath.substring(pdfPath.lastIndexOf("\\")+1);
        File file=new File(pdfPath);long filelength= file.length();
        DataHandler dataHandler=new DataHandler(new FileDataSource(file));
        byte[] bytes=getBytes(pdfPath);
        com.fuhuadata.manager.impl.NCExchange.services.M5715FileManagerWsPortType service=new com.fuhuadata.manager.impl.NCExchange.services.M5715FileManagerWs().getM5715FileManagerWsSOAP11PortHttp();
        String wsResult= service.crmExchangeFileToNC(bytes,filename,filelength,creatorCode,pPath);
        return wsResult;
    }
    public void setNcUrl(String ncUrl) {
        this.ncUrl = ncUrl;
    }
    public String getNcUrl(){
        return this.ncUrl;
    }
    private byte[] getBytes(String filePath){
         byte[] buffer = null;
         try {
             File file = new File(filePath);
             FileInputStream fis = new FileInputStream(file);
             ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
             byte[] b = new byte[1000];
             int n;
             while ((n = fis.read(b)) != -1) {
                     bos.write(b, 0, n);
                 }
             fis.close();
             bos.close();
             buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
           e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

}
