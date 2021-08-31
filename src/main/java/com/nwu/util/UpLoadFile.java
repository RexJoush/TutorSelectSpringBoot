package com.nwu.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

public class UpLoadFile {

    public String upload(MultipartFile uploadFile , HttpServletRequest req,String typeName,String tutorId){

        String realPath= "E://RARZIP/uploadFile/";
        String format = tutorId+"/"+typeName;
        File file = new File(realPath+format);
        if (!file.isDirectory()){
            file.mkdirs();
        }
        String oldName= uploadFile.getOriginalFilename();
        //String newName = oldName.substring(oldName.lastIndexOf("."),oldName.length());
        try{
            uploadFile.transferTo(new File(file,oldName));
        //String filePath= req.getScheme()+"://"+ req.getServerName() +":"+req.getServerPort()+"/uploadFile/"+format+"/"+oldName;
        // http://localhost:8081/upfile/uploadFile/20133220/%E5%AD%A6%E6%9C%AF%E8%AE%BA%E6%96%87/%E5%AF%BC%E5%B8%88%E9%81%B4%E9%80%89.rar
            String filePath= req.getScheme()+"://"+ req.getServerName() +":"+req.getServerPort()+"/downFile/uploadFile/"+format+"/"+oldName;
            return filePath;
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return "";
    }
    //http://localhost:8081/downFile/uploadFile/20133220/学术论文/社科类论文/导师遴选.rar
    public String delFile(String path){
        //42
        //路径中的文件
        String realPath= "E://RARZIP/uploadFile/"+path.substring(42, path.length() - 1);
        File file = new File(realPath);
        if (file.exists()){
            file.delete();
            return "ok";
        }
        else
        {
            return "err";
        }

    }
}
