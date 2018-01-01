package com.it.tu.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

	@RequestMapping(value="/fileUpload")
    public String addUser(@RequestParam MultipartFile[] myfiles, HttpServletRequest request, HttpServletResponse response) throws IOException{

        String realPath = request.getSession().getServletContext().getRealPath("/upload");

        response.setContentType("text/plain; charset=UTF-8");

        PrintWriter out = response.getWriter();

        String originalFilename = null;
        for(MultipartFile myfile : myfiles){
            if(myfile.isEmpty()){
                out.print("1`Please select the file to upload");
                out.flush();
                return null;
            }else{
                originalFilename = myfile.getOriginalFilename();
                try {
                	
                	File targetFile = new File(realPath, originalFilename);  
                	
                    if(!targetFile.exists()){  
                        targetFile.mkdirs();  
                    }
                    myfile.transferTo(targetFile);   
                } catch(Exception e) {
                	
                	e.printStackTrace();
                }
            }
        }

        out.print("" + request.getContextPath() + "/upload/" + originalFilename);
        out.flush();
        return null;
    }
}
