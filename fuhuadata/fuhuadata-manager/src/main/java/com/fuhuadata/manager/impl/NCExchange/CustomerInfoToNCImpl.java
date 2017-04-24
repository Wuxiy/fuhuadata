package com.fuhuadata.manager.impl.NCExchange;

import com.fuhuadata.dao.CustomerBaseInfoDao;
import com.fuhuadata.dao.NCExchange.OrderToNc;
import com.fuhuadata.domain.CustomerBaseInfo;
import com.fuhuadata.manager.NCExchange.CustomerInfoToNC;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.DocumentHelper;
import org.dom4j.io.DocumentSource;
import org.jdom.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
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
import java.util.*;

/**
 * Created by zhangxiang on 2017/4/11.
 */
public class CustomerInfoToNCImpl implements CustomerInfoToNC{

    private static final Log log = LogFactory.getLog(CustomerInfoToNCImpl.class);
    @Autowired
    private CustomerBaseInfoDao customerBaseInfoDao;

    @Value("${ncurl}")
    private String ncUrl;

    @Autowired
    ServletContext servletContext;
    @Autowired
    OrderToNc orderToNc;

    @Override
    public String sendCustomerInfo(CustomerBaseInfo customerBaseInfo) {
         String xmlName= customerInfoToXML(customerBaseInfo);
        String ncid=null;
        try {
            //InputStream inputS = new FileInputStream("fuhuadata-manager/src/main/resource/ncInfo.properties");
            //Properties properties = new Properties();
            //properties.load(inputS);
            //String ncurl = properties.getProperty("ncurl");

            // 获取Servlet连接并设置请求的方法
            URL realURL = new URL(ncUrl);
            HttpURLConnection connection = (HttpURLConnection) realURL.openConnection();
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-type", "text/xml");
            connection.setRequestMethod("POST");

            String a = servletContext.getRealPath("/");
            File file = new File(a+xmlName);
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
            String resFile = a+fmt.format(new Date()) + ".xml";
            StreamResult result = new StreamResult(new File(resFile));
            transformer.transform(source, result);
            log.info("生成回执文件成功");

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
                ncid=e.getChildText("content");
            }

            //后面对回执结果做判断,然后改变导入状态就行了
            if (null != resSuc) {
                if (resSuc.equals("N")) {
                    log.info("导入nc失败");
                } else if (resSuc.equals("Y")) {
                    log.info("导入nc成功");
                    //修改状态
                    customerBaseInfo.setNcId(ncid);
                    customerBaseInfo.setCustomerType(1);
                    customerBaseInfoDao.updateCustomerBaseInfoById(customerBaseInfo.getCustomerId(),customerBaseInfo);
                } else {
                    log.info("出现未知错误");
                    System.out.println("出现未知错误");
                }
            } else {
                log.info("未找到successful属性");
                System.out.println("未找到successful属性");
            }
        }catch (Exception e){
            log.error("发送nc出错",e);
        }
        return ncid;
    }
    private String customerInfoToXML(CustomerBaseInfo customerBaseInfo){
        String xmlName=null;
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document=builder.newDocument();
            Element root=document.createElement("ufinterface");
            root.setAttribute("account","01");
            root.setAttribute("billtype","customer");
            root.setAttribute("groupcode","0001");
            root.setAttribute("isexchange","Y");
            root.setAttribute("replace","Y");
            root.setAttribute("sender","ET");
            document.appendChild(root);
            Element bill=document.createElement("bill");
            bill.setAttribute("id","customer"+customerBaseInfo.getCustomerId());
            root.appendChild(bill);
            Element billhead=document.createElement("billhead");
            bill.appendChild(billhead);

            Element pk_group=document.createElement("pk_group");
            pk_group.appendChild(document.createTextNode("0001"));
            billhead.appendChild(pk_group);
            Map<String,String> nodeValue=new HashMap<String, String>();

            if (customerBaseInfo.getSaleOrganizationId()!=null) {
                //String ncId=orderToNc.getOrgNcIdByOrgId();
                nodeValue.put("pk_org", customerBaseInfo.getSaleOrganizationId());
            }
            if (customerBaseInfo.getFullName()!=null) {
                nodeValue.put("name", customerBaseInfo.getFullName());
            }
            if (customerBaseInfo.getShortName()!=null) {
                nodeValue.put("shortname", customerBaseInfo.getShortName());
            }
            //客户基本分类
            if (customerBaseInfo.getCustclass()!=null) {
                nodeValue.put("pk_custclass", customerBaseInfo.getCustclass());
            }
            //国家
            if (customerBaseInfo.getCountryzone()!=null) {
                nodeValue.put("pk_country", customerBaseInfo.getCountryzone());
            }
            //时区
            if (customerBaseInfo.getTimezone()!=null) {
                nodeValue.put("pk_timezone", customerBaseInfo.getTimezone());
            }
            //数据格式
            if (customerBaseInfo.getFormatdoc()!=null) {
                nodeValue.put("pk_format", customerBaseInfo.getFormatdoc());
            }
            //客户类别（内部客户，外部客户）
            nodeValue.put("custprop","0");
            //地区分类
            if (customerBaseInfo.getCustomerAreaId()!=null) {
                nodeValue.put("pk_areacl", customerBaseInfo.getCustomerAreaId());
            }
            //nodeValue.put("","");

            for(Map.Entry<String ,String> entry:nodeValue.entrySet()){
                Element ele=document.createElement(entry.getKey());
                ele.appendChild(document.createTextNode(entry.getValue()));
                billhead.appendChild(ele);
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
            xmlName="customer"+customerBaseInfo.getCustomerId()+System.currentTimeMillis()+".xml";
            File fileUrl=new File(a+xmlName);
            if (!fileUrl.exists()){
                fileUrl.createNewFile();
            }
            PrintWriter pw = new PrintWriter(fileUrl,"utf-8");
            // 充当转换结果的持有者，可以为 XML、纯文本、HTML 或某些其他格式的标记
            StreamResult result = new StreamResult(pw);
            transformer.transform(source, result);

        }catch (Exception e){
            log.error("转换xml文件失败",e);
        }

        return xmlName;
    }


    public void setNcUrl(String ncUrl) {
        this.ncUrl = ncUrl;
    }
    public String getNcUrl(){
        return this.ncUrl;
    }

}
