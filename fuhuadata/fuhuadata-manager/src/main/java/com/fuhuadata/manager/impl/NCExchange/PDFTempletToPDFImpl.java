package com.fuhuadata.manager.impl.NCExchange;


import com.fuhuadata.dao.BusinessOrderProductComponentDao;
import com.fuhuadata.dao.BusinessProductRequireDao;
import com.fuhuadata.domain.BusinessOrderProduct;
import com.fuhuadata.domain.BusinessOrderProductComponent;
import com.fuhuadata.domain.BusinessProductRequire;
import com.fuhuadata.domain.PackingArchives;
import com.fuhuadata.manager.NCExchange.PDFTempletToPDF;
import com.fuhuadata.manager.PackingArchivesManager;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContext;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zhangxiang on 2017/5/11.
 */
public class PDFTempletToPDFImpl implements PDFTempletToPDF {
    @Autowired
    private BusinessOrderProductComponentDao businessOrderProductComponentDao;
    @Autowired
    private BusinessProductRequireDao businessProductRequireDao;
    @Autowired
    private PackingArchivesManager packingArchivesManager;
    @Autowired
    ServletContext servletContext;
    private static final String LINUX_BASE = "/usr/local/tomcat8.0/apache-tomcat-8.0.39/webapps/fuhuadata-web";
    private static final String pdf_Base="/lib/pdfFile/";

    private static String billrequire="{'oceanBillOfLading':'出具海运提单','freightForwardingBill':'出具货运提单','invoice':'需要发票'," +
            "'packingList':'需要箱单','qualityTestingReport':'质检单：','guaranteeSlip':'需要保单','reportCompanyTitle':'公司抬头：'," +
            "'dangerousCertificate':'危包证','beneficiaryCertification':'受益人证明','coo':'出具COO：'" +
            ",'fumigationCertificate':'熏蒸证书','msds':'出具MSDS','bankBill':'交单方式','examiningReport':'第三方质检报告','packingDeclaration':'需要Packing Declaration'," +
            "'importContainerWeightDeclaration':'需要Import Container Weight Declaration','manufacturerCertificate':'需要Manufacturer\\'s Certificate'," +
            "'needTDS':'需要TDS','needPriceCertificate':'需要Price Certificate'," +
            "'telexRelease':'提单签单方式：'}";
    private static String packageRequire="{'fullyClose':'打托（缠膜）：','postLabel':'帖唛','basePlate':'垫板','paperBoard':'纸板','gasbag':'气囊'," +
            "'dragNet':'拉网','fastenBelt':'紧固带','barcCode':'抄条码','americanDoorseal':'美式门封','bead':'护条'," +
            "'cornerProtection':'护角','wireFixed':'吨桶铁丝固定'}";
    @Override
    public String PDFTempletToPDFmanager(List<BusinessOrderProduct> orderProducts) {
        String pdfPath="";
        String filename="";
        String a=servletContext.getRealPath("/");
        try {
            String path = null;
            PdfReader reader=new PdfReader(a+"lib" + File.separator + "orderRequireTemplet.pdf");
            ByteArrayOutputStream bos=new ByteArrayOutputStream();
            PdfStamper ps=new PdfStamper(reader,bos);
            AcroFields s=ps.getAcroFields();

            BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",
                    BaseFont.EMBEDDED);
            Font font=new Font(bf,12,Font.NORMAL);

            for (BusinessOrderProduct orderProduct:orderProducts){
                s.setField("brand",orderProduct.getBrand());
                s.setField("name",orderProduct.getName());
                s.setField("customerProductName",orderProduct.getCustomerProductName());
                s.setField("specification",orderProduct.getSpecification());
                s.setField("pModel",orderProduct.getModel());

                int end=0;
                for (BusinessOrderProductComponent businessOrderProductComponent :businessOrderProductComponentDao.getProductComponentsByBusinessProductId(orderProduct.getId())){
                    s.setField("componentName_"+end,businessOrderProductComponent.getComponentName());
                    s.setField("consumption_"+end,""+businessOrderProductComponent.getConsumption());
                    end++;
                }
                BusinessProductRequire businessProductRequire = new BusinessProductRequire();
                businessProductRequire.setBusinessProductId(orderProduct.getId());
                businessProductRequire= businessProductRequireDao.getOneByQuery(businessProductRequire);
                //主包材
                s.setField("packName",businessProductRequire.getMainPackingType()==null?"":businessProductRequire.getMainPackingType());
                s.setField("spec",businessProductRequire.getSpecification()==null?"":businessProductRequire.getSpecification());
                s.setField("quality",businessProductRequire.getMaterial()==null?"":businessProductRequire.getMaterial());
                s.setField("model",businessProductRequire.getModel()==null?"":businessProductRequire.getModel());
                s.setField("bottleWeight",""+businessProductRequire.getBottleWeight()==null?"":""+businessProductRequire.getBottleWeight());
                s.setField("bottleCapColor",businessProductRequire.getBottleCapColor()==null?"":businessProductRequire.getBottleCapColor());
                s.setField("bottleBodyColor",businessProductRequire.getBottleBodyColor()==null?"":businessProductRequire.getBottleBodyColor());
                s.setField("hasCapLogo",businessProductRequire.getHasCapLogo()==0?"否":"是");
                s.setField("hasBodyLogo",businessProductRequire.getHasBodyLogo()==0?"否":"是");
                s.setField("bottleDiameter",""+businessProductRequire.getBottleDiameter());
                s.setField("hasDangerSign",businessProductRequire.getHasDangerSign()==0?"否":"是");
                s.setField("businessCheckNum",businessProductRequire.getBusinessCheckNum());
                s.setField("hasScaleLine",businessProductRequire.getHasScaleLine()==0 ? "否":"是");
                s.setField("hasSprayCode",businessProductRequire.getHasSprayCode()==0 ? "否":"是");
                s.setField("specialRequire",businessProductRequire.getSpecialRequire());
                //外包材
                if (businessProductRequire.getOuterPackingId()!=null){
                    PackingArchives packingArchives = packingArchivesManager.getPackingArchivesById(businessProductRequire.getOuterPackingId());
                    if (packingArchives!=null) {
                        s.setField("OPackName", packingArchives.getPackName() == null ? "" : packingArchives.getPackName());
                        s.setField("Ospec", packingArchives.getSpec() == null ? "" : packingArchives.getSpec());
                        s.setField("Oquality", packingArchives.getQuality() == null ? "" : packingArchives.getQuality());
                        s.setField("Osize", packingArchives.getSize() == null ? "" : packingArchives.getSize());
                        s.setField("sealingStyle", businessProductRequire.getSealingStyle() == null ? "" : businessProductRequire.getSealingStyle());
                        s.setField("outerPackingOtherRequire", businessProductRequire.getOuterPackingOtherRequire() == null ? "" : businessProductRequire.getOuterPackingOtherRequire());
                    }
                }
                if (businessProductRequire.getAuxiliaryMaterialIds()!=null && businessProductRequire.getAuxiliaryMaterialIds().length()>0){
                    List<PackingArchives> packingArchives=packingArchivesManager.getPackingArchivesByIds(businessProductRequire.getAuxiliaryMaterialIds());
                    int end1=0;
                    for (PackingArchives packingArchive:packingArchives){
                        s.setField("SPackName_"+end1,packingArchive.getPackName());
                        s.setField("Sspec_"+end1,packingArchive.getSpec());
                        s.setField("Squality_"+end1,packingArchive.getQuality());
                        end1++;
                    }
                }
                s.setField("otherRequire",businessProductRequire.getOtherRequire());
                //单据要求
                if(orderProduct.getDocumentaryRequire()!=null){
                    JSONObject json=JSONObject.fromObject(orderProduct.getDocumentaryRequire());
                    JSONObject jsonTem=JSONObject.fromObject(billrequire);
                    int end2=0;
                    Iterator it= json.keys();
                    while (it.hasNext()){
                        String key= (String) it.next();
                        String[] strings=new String[]{"cooContent","releaseDestination","reportCompanyTitle","cooContentText"};
                        if (Arrays.asList(strings).contains(key)){
                            continue;
                        }
                        if (!json.get(key).equals(0)){
                            if (key.equals("coo")){
                                if (json.get(key).equals("1")){
                                    if (json.get("cooContent").equals("a")){
                                        s.setField("billRequire_"+end2,jsonTem.get("coo")+"商检局-FORM A");
                                    }else if (json.get("cooContent").equals("e")){
                                        s.setField("billRequire_"+end2,jsonTem.get("coo")+"商检局-FORM E");
                                    }else if (json.get("cooContent").equals("p")){
                                        s.setField("billRequire_"+end2,jsonTem.get("coo")+"商检局-FORM P");
                                    }else if (json.get("cooContent").equals("au")){
                                        s.setField("billRequire_"+end2,jsonTem.get("coo")+"商检局-FORM AU");
                                    }
                                }else if (json.get(key).equals("2")){
                                    s.setField("billRequire_"+end2,jsonTem.get("coo")+"贸促会");
                                }else if (json.get(key).equals("3")){
                                    s.setField("billRequire_"+end2,jsonTem.get("coo")+"普通：（公司抬头）"+json.get("cooContentText"));
                                }
                            }else if (key.equals("telexRelease")) {
                                if (json.get(key).equals("1")) {
                                    s.setField("billRequire_" + end2, jsonTem.get("telexRelease") + "Sea Waybill");
                                } else if (json.get(key).equals("6")) {
                                    s.setField("billRequire_" + end2, jsonTem.get("telexRelease") + "其他签单方式：" + json.get("releaseDestination"));
                                } else if(json.get(key).equals("2")){
                                    s.setField("billRequire_" + end2, jsonTem.get("telexRelease") + "目的港放单");
                                }else if (json.get(key).equals("3")){
                                    s.setField("billRequire_" + end2, jsonTem.get("telexRelease") + "HBL（货代提单）");
                                }else if (json.get(key).equals("4")){
                                    s.setField("billRequire_" + end2, jsonTem.get("telexRelease") + "OBL（海运提单）");
                                }else if (json.get(key).equals("5")){
                                    s.setField("billRequire_" + end2, jsonTem.get("telexRelease") + "直接电放");
                                }
                            }else if (key.equals("qualityTestingReport")){
                                s.setField("billRequire_" + end2,""+jsonTem.get("qualityTestingReport")+jsonTem.get("reportCompanyTitle")+json.get("reportCompanyTitle"));
                            }else if (key.equals("bankBill")){
                                if (json.get(key).equals("1")){
                                    s.setField("billRequire_" + end2, jsonTem.get("bankBill") + "银行交单");
                                }else if (json.get(key).equals("2")){
                                    s.setField("billRequire_" + end2, jsonTem.get("bankBill") + "信用证交单");
                                }else if (json.get(key).equals("3")){
                                    s.setField("billRequire_" + end2, jsonTem.get("bankBill") + "直接寄单");
                                }
                            } else {
                                s.setField("billRequire_" + end2, (String) jsonTem.get(key));
                            }
                            end2++;
                        }


                    }
                    s.setField("billRequire_" + (++end2),"其他单据要求："+orderProduct.getOtherDocumentaryRequire());
                }
                //订舱出运要求
                s.setField("shippingAgentRequire",orderProduct.getShippingAgentRequire()==null?"":orderProduct.getShippingAgentRequire());
                if (orderProduct.getGoodsType()!=null){
                    s.setField("goodsType",orderProduct.getGoodsType()==0?"普货":"危险货");
                }
                s.setField("mianXiangQi",orderProduct.getMianxiangqi()==null?"":(""+orderProduct.getMianxiangqi()));
                s.setField("mianTuiQi",""+orderProduct.getMiantuiqi()==null?"":(""+orderProduct.getMiantuiqi()));
                s.setField("cupboardType",""+orderProduct.getCupboardType()==null?"":""+orderProduct.getCupboardType());
                //s.setField("cupboardPerNumber",""+orderProduct.getCupboardPerNumber()==null?"":""+orderProduct.getCupboardPerNumber());
                s.setField("cupboardNumber",""+orderProduct.getCupboardNumber()==null?"":""+orderProduct.getCupboardNumber());
                if (orderProduct.getPackageRequire()!=null){
                    JSONObject jsonPr=JSONObject.fromObject(orderProduct.getPackageRequire());
                    JSONObject prTemp=JSONObject.fromObject(packageRequire);
                    int end3=0;
                    Iterator it= jsonPr.keys();
                    while (it.hasNext()){
                        String key= (String) it.next();
                        String[] strings=new String[]{"inspectionInstitution"};
                        if (Arrays.asList(strings).contains(key)){
                            continue;
                        }
                        if (!jsonPr.get(key).equals(0)){
                            if (key.equals("inspectionOfLoading")){
                                if (jsonPr.get("inspectionOfLoading").equals("0")){
                                    s.setField("packageRequire_"+end3,"需要监装：商检,（机构名称）"+jsonPr.get("inspectionInstitution"));
                                }else if (jsonPr.get("inspectionOfLoading").equals("1")){
                                    s.setField("packageRequire_"+end3,"需要监装：法检,（机构名称）"+jsonPr.get("inspectionInstitution"));
                                }
                            }else if (key.equals("fullyClose")){
                                if (jsonPr.get("tray").equals("1")){
                                    s.setField("packageRequire_"+end3,prTemp.get("fullyClose")+"免熏蒸木质托盘");
                                }else if (jsonPr.get("tray").equals("2")){
                                    s.setField("packageRequire_"+end3,prTemp.get("fullyClose")+"熏蒸托盘");
                                }else if (jsonPr.get("tray").equals("3")){
                                    s.setField("packageRequire_"+end3,prTemp.get("fullyClose")+"塑料托盘");
                                }else if (jsonPr.get("tray").equals("4")){
                                    s.setField("packageRequire_"+end3,prTemp.get("fullyClose")+"订制托盘");
                                }
                            }else {
                                s.setField("packageRequire_"+end3,(String) prTemp.get(key));
                            }
                            end3++;
                        }
                    }

                }
                //附件图片
                String winpath = servletContext.getRealPath("");
                System.out.println(winpath);
                String os = System.getProperty("os.name");

                if(os.toLowerCase().startsWith("win")){
                    path=winpath;
                }else {
                    path=LINUX_BASE;
                }
                String realPath="";
                Image image=null;
                PdfContentByte over=ps.getOverContent(1);
                JSONArray jsonArray=JSONArray.fromObject(businessProductRequire.getImgInfo());
                for (int i=0;i<jsonArray.size();i++){
                    realPath=path+jsonArray.getJSONObject(i).get("imgpath");
                    System.out.println(realPath);
                    image=Image.getInstance(realPath);
                    image.scaleAbsolute(90,80);
                    if (i<4){
                        image.setAbsolutePosition(37+147*i,100);
                    }else {
                        image.setAbsolutePosition(37+147*(i-4),15);
                    }
                    over.addImage(image);
                }
            }
            ps.setFormFlattening(true);
            ps.close();
            long time=System.currentTimeMillis();
            filename="pdfFIle"+time+".pdf";
            File dir=new File(a+"lib/pdfFile/");
            if (!dir.exists()){
                dir.mkdirs();
            }
            pdfPath=a+"lib\\pdfFile\\"+filename;
            FileOutputStream fos=new FileOutputStream(pdfPath);
            fos.write(bos.toByteArray());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pdfPath;
    }
}
