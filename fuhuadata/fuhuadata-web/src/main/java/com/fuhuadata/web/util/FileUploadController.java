package com.fuhuadata.web.util;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * File Upload
 * Created by intanswer on 2017/3/6.
 */
public class FileUploadController {
    /**
     *
     * @param fileName
     * @param file
     * @return
     */
    @RequestMapping(value="/uploadFile", method= RequestMethod.POST)
    public String uploadFile(@RequestParam("fileName") String fileName,
                             @RequestParam("clientFile") MultipartFile file)
        throws IllegalStateException, IOException {
            if (!file.isEmpty()) {
                file.transferTo(new File("d:/temp/"
                        + fileName
                        + file.getOriginalFilename().substring(
                        file.getOriginalFilename().lastIndexOf("."))));
                return "";
            } else {
                return "";
            }
        }
}
