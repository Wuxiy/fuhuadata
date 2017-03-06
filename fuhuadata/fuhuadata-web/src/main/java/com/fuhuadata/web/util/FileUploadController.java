package com.fuhuadata.web.util;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

/**
 * File Upload
 * Created by intanswer on 2017/3/6.
 */
public class FileUploadController {
    /**
     *
     * @param fileName
     * @param clientFile
     * @param session
     * @return
     */
    @RequestMapping(value="/uploadFile", method= RequestMethod.POST)
    public String uploadFile(@RequestParam("fileName") String fileName,
                             @RequestParam("clientFile") MultipartFile clientFile, HttpSession session){
        if (!clientFile.isEmpty()) {

            //在这里就可以对file进行处理了，可以根据自己的需求把它存到数据库或者服务器的某个文件夹

            System.out.println("================="+clientFile.getSize());
        }
        return "";
    }
}
