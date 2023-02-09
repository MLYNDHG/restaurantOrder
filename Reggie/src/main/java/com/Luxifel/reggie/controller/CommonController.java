package com.Luxifel.reggie.controller;

import com.Luxifel.reggie.mbg.model.AddressBook;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
@Api(tags = "common")
@RequestMapping("/common")
public class CommonController {

    @Value("${reggie.path}")
    private String basePath;

    @ApiOperation("hello")
    @GetMapping("/hello")
    public String hello(){
        return "hello,here is Reggie_take_out";
    }

    @PostMapping("/Test")
    public String Test(@RequestBody AddressBook addressBook){
        return "Test、API fox";
    }

    @PostMapping("/upload")
    public String upload(MultipartFile file){
        log.info(file.toString());
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.indexOf("."));
        String fileName = UUID.randomUUID()+suffix;
        File dir = new File(basePath);
        if(!dir.exists()){
            dir.mkdirs();
        }

        try {
            file.transferTo(new File(basePath+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }

    @GetMapping("/download")
    public void download(String name, HttpServletResponse httpServletResponse){
        try {
            httpServletResponse.setContentType("image/jpeg");
            FileInputStream fileInputStream = new FileInputStream(new File(basePath+name));
            ServletOutputStream outputStream = httpServletResponse.getOutputStream();
            int len = 0;
            byte[] bytes =new byte[1024];
            while((len=fileInputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,len);
                outputStream.flush();
            }
            outputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
