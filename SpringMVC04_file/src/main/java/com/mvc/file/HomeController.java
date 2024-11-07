package com.mvc.file;

import com.mvc.file.common.FileValidator;
import com.mvc.file.common.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Controller
public class HomeController {

    @Autowired
    private FileValidator fileValidator;

    @RequestMapping(value = "/form.do")
    public String getUploadForm() {
        return "uploadForm";
    }


    @RequestMapping("/upload.do")
    public String fileUpload(UploadFile uploadFile, BindingResult result, Model model) {
        System.out.println(uploadFile.getDesc());
        System.out.println(uploadFile.getMpfile().getOriginalFilename());

        fileValidator.validate(uploadFile, result);
        if(result.hasErrors()) {
            return "uploadForm";
        }

        UploadFile fileobj = new UploadFile();
        fileobj.setFilename(uploadFile.getMpfile().getOriginalFilename());
        fileobj.setDesc(uploadFile.getDesc());

        MultipartFile file = uploadFile.getMpfile();

        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            File storage = new File("E:\\storage\\");
            if(!storage.exists()) {
                storage.mkdir();
            }

            File newfile = new File("E:\\storage\\" + fileobj.getFilename());
            if (!newfile.exists()) {
                newfile.createNewFile();
            }

            inputStream = file.getInputStream();
            outputStream = new FileOutputStream(newfile);

            int res = 0;
            byte[] b = new byte[(int)file.getSize()];

            while((res = inputStream.read(b)) != -1) {
                outputStream.write(b, 0, res);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        model.addAttribute("fileobj", fileobj);
        return "uploadFile";
    }
}
