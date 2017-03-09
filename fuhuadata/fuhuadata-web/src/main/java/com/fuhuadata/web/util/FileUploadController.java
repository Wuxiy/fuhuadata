package com.fuhuadata.web.util;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * File Upload
 * Created by intanswer on 2017/3/6.
 */
@Controller
@RequestMapping(value = "/upload/*")
public class FileUploadController {

    @RequestMapping(value = "into",method = RequestMethod.GET)
    public ModelAndView upload(){
        return new ModelAndView("knowledgeBase/uploadFile");
    }
    /**
     *
     * @param files
     * @return
     */
    @RequestMapping(value="/uploadFile", method= RequestMethod.POST)
    public ModelAndView uploadFile(@RequestParam("file") MultipartFile[] files, HttpServletRequest request)
        throws IllegalStateException, IOException {

        System.out.println(files.length);
        for (MultipartFile file : files) {

            if (file.isEmpty()) {
                continue; //next pls
            }
            try {
                String path = request.getSession().getServletContext().getRealPath("images/");//保存在服务器
                System.out.println(path);
                String fileName = file.getOriginalFilename();
                File tempFile = new File(path, new Date().getTime() + String.valueOf(fileName));
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
        ModelAndView model = new ModelAndView("knowledgeBase/uploadFile");
        model.addObject("message","保存成功");
        return model;
    }

}
