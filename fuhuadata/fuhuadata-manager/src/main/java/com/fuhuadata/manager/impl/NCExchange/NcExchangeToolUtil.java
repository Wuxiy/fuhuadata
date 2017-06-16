package com.fuhuadata.manager.impl.NCExchange;

import org.dom4j.DocumentHelper;
import org.dom4j.io.DocumentSource;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.w3c.dom.Document;

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

/**
 * 生成xml文件并发送nc的工具类
 * Created by zhangxiang on 2017/5/27.
 */
public class NcExchangeToolUtil {

    @Value("${ncurl}")
    private static String ncUrl;

    private static HttpURLConnection connection=null;
    static{
        URL realURL = null;
        try {
            realURL = new URL(ncUrl);
            connection = (HttpURLConnection) realURL.openConnection();
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-type", "text/xml");
            connection.setRequestMethod("POST");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将生成的xml文件发送到nc
     * @param xmlName 生成的xml文件的全路径文件名
     * @param resFile 回执文件的路径名
     * @return
     */
    public static Element xmlSendNcTool(String xmlName, String resFile) throws Exception {
        org.jdom.Element root=null;
        try {
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

            StreamResult result = new StreamResult(new File(resFile));
            transformer.transform(source, result);
            System.out.println("======生成回执文件成功=======");


            /**************jdom解析XML*****************/
            org.jdom.input.SAXBuilder saxReader = new SAXBuilder();
            org.jdom.Document document1 = saxReader.build(new File(resFile));
            root = document1.getRootElement();
            //获取根元素,得到导入用友是否成功successful的值,值为Y:成功 N:失败
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }finally {
            connection.disconnect();
        }
        return root;
    }

    /**
     * 将document树转换生成为xml文件。
     * @param document 需要转换成xml文件的document树
     * @param xmlName xml文件的全路径文件名
     */
    public static void documentTreeToXML(Document document,String xmlName) throws Exception {
        try {

        TransformerFactory tf = TransformerFactory.newInstance();
        // 此抽象类的实例能够将源树转换为结果树
        Transformer transformer = tf.newTransformer();
        DOMSource source = new DOMSource(document);
        transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
        // 一个节点后换行，你可以设置为true，然后尝试解析看打印结果
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        // 向文本输出流打印对象的格式化表示形式
        // 要保证你的文本输出后格式不乱码，打印对象需指定打印格式，以标记此文本支持的格式

        PrintWriter pw = new PrintWriter(xmlName, "utf-8");
        // 充当转换结果的持有者，可以为 XML、纯文本、HTML 或某些其他格式的标记
        StreamResult result = new StreamResult(pw);
        transformer.transform(source, result);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }

    }

    public static String getXmlName(String realPath,String id,String xmlType){
        String xmlName=realPath+"lib/NCBackFile/"+xmlType+id+System.currentTimeMillis()+".xml";
        return xmlName;
    }
    public static String getRefFile(String realPath, String id,String xmlType){
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
        String resFile =realPath +"lib/NCBackFile/"+xmlType+id+ fmt.format(new Date()) + ".xml";
        return resFile;
    }
}
