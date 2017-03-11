package com.fuhuadata.web.util;

import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import org.apache.commons.collections.map.MultiValueMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.BindException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * File Upload
 * Created by intanswer on 2017/3/6.
 */
@Controller
@RequestMapping(value = "/upload/*")
public class FileUploadController {
    private static final Log log = LogFactory.getLog(FileUploadController.class);

    @RequestMapping(value = "into",method = RequestMethod.GET)
    public ModelAndView upload(){
        return new ModelAndView("knowledgeBase/uploadFile");
    }
    /**
     *
     * @param files
     * @return
     */
    @RequestMapping("/uploadFile")
    @ResponseBody
    public ResultPojo uploadFile(@RequestParam("file") MultipartFile[] files, HttpServletRequest request) {
        Result result = new Result();
        String path=null;
        File tempFile=null;
        System.out.println(files.length);
        try {
            for (MultipartFile file : files) {

                if (file.isEmpty()) {
                    continue; //next pls
                }
                try {
                    path = request.getSession().getServletContext().getRealPath("images/");//保存在服务器
                    System.out.println(path);

                    String fileName = file.getOriginalFilename();
                    tempFile = new File(path,fileName);
                    System.out.println(tempFile);
                    if (!tempFile.getParentFile().exists()) {
                        tempFile.getParentFile().mkdir();
                    }
                    if (!tempFile.exists()) {
                        tempFile.createNewFile();
                    }
                    file.transferTo(tempFile);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }catch(Exception e){
            log.error("文件上传错误",e);
        }
        ResultPojo  resultPojo= result.getResultPojo();
        resultPojo.setData(tempFile);
        return resultPojo;
    }

    // 多文件上传
    @RequestMapping(value = "/uploadFile2", method = RequestMethod.POST)
    public ModelAndView fileUpload(HttpServletRequest request,
                                   HttpServletResponse response, BindException errors)
            throws Exception {

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
        org.springframework.util.MultiValueMap<String,MultipartFile> fileMap1=multipartRequest.getMultiFileMap();
            List<MultipartFile> files = fileMap1.get("files");
            if (files != null) {
                for (MultipartFile file : files) {
                    String path = request.getSession().getServletContext().getRealPath("images/");//保存在服务器
                    String fileName = file.getOriginalFilename();
                    File tempFile = new File(path, fileName);
                    System.out.println(tempFile);
                    if (!tempFile.getParentFile().exists()) {
                        tempFile.getParentFile().mkdir();
                    }
                    if (!tempFile.exists()) {
                        tempFile.createNewFile();
                        file.transferTo(tempFile);
                    }

                }
            }
        return new ModelAndView("/knowledgeBase/uploadFile");
    }


}
