package com.alex.filegateway.controller;

import com.alex.filegateway.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author alex
 */
@RestController
@RequestMapping("flu")
public class FileUplaod {

    @Value("${file.upload.unEncryptionPath.path}")
    private String unEncryptionPath;
    @Autowired
    private Util util;

    @GetMapping("unEncryption")
    public ModelAndView unEncryption() {
        return new ModelAndView ("fileUpload");
    }

    @PostMapping("unEncryption-upload")
    public String create(@RequestPart MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String filePath = unEncryptionPath + fileName;
        File dest = new File(filePath);
        try {
            Files.copy(file.getInputStream(), dest.toPath());
        } catch (Error | IOException e){
            util.log(e);
            return "Upload file fail : " + e;
        }
        return "Upload file success : " + dest.getAbsolutePath();
    }

}
