package com.fuhuadata.web.util;

import com.fuhuadata.domain.query.Result;
import com.fuhuadata.domain.query.ResultPojo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.BindException;
import java.util.List;
import java.util.Map;

/**
 * File Upload
 * Created by intanswer on 2017/3/6.
 */
@Controller
@RequestMapping(value = "/upload/*")
public class FileController {
    private static final Log log = LogFactory.getLog(FileController.class);

    @RequestMapping(value = "into",method = RequestMethod.GET)
    public ModelAndView upload(){
        return new ModelAndView("knowledgeBase/uploadFile");
    }
    /**
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST)
    @ResponseBody
    public ResultPojo uploadFile(@RequestParam(value="file") MultipartFile file, HttpServletRequest request) {
        Result result = new Result();
        String path=null;
        File tempFile=null;
        try {
                if (!file.isEmpty()) {
                    try {
                        path = request.getSession().getServletContext().getRealPath("images/");//保存在服务器
                        System.out.println(path);

                        String fileName = file.getOriginalFilename();
                        tempFile = new File(path, fileName);
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

    @RequestMapping(value = "/deleteFile",method = RequestMethod.POST)
    @ResponseBody
    public ResultPojo deleteFile(@RequestBody String[] imagePaths){
        Result result = new Result();
        try {
            if (imagePaths != null && imagePaths.length > 0) {
                for (int i = 0; i < imagePaths.length; i++) {
                    File file = new File(imagePaths[i]);
                    // 路径为文件且不为空则进行删除
                    if (file.isFile() && file.exists()) {
                        file.delete();
                    }
                }
            }
        }catch(Exception e){
            result.setSuccess(false);
            log.error("文件删除出错",e);
        }
        return result.getResultPojo();
    }

}
