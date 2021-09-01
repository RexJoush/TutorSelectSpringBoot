package com.nwu.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * 上传文件/删除文件
 */
@Component
public class UpLoadFile {
    private static String FilePath;
    @Value(value = "${FilePath}")
    public void setFilePath(String realpath) {
        FilePath = realpath;
    }
    /**
     *
     * @param uploadFile 上传的文件
     * @param req   http
     * @param typeName 上传文件所属名称  例：学术论文/文科
     * @param tutorId   教师工号
     * @return  文件存储路径
     */
    public String upload(MultipartFile uploadFile , HttpServletRequest req, String typeName, String tutorId) {
        String format = tutorId+"/"+typeName;
        File file = new File(FilePath+format);
        if (!file.isDirectory()){
            file.mkdirs();
        }
        long time = new Date().getTime();
        String oldName= uploadFile.getOriginalFilename();
        String newName=oldName.substring(0,oldName.lastIndexOf(".")) + time + oldName.substring(oldName.lastIndexOf("."),oldName.length());

        try{
            uploadFile.transferTo(new File(file,oldName));
            //String filePath= req.getScheme()+"://"+ req.getServerName() +":"+req.getServerPort()+"/uploadFile/"+format+"/"+oldName;
            // http://localhost:8081/upfile/uploadFile/20133220/%E5%AD%A6%E6%9C%AF%E8%AE%BA%E6%96%87/%E5%AF%BC%E5%B8%88%E9%81%B4%E9%80%89.rar
            String filePath= req.getScheme()+"://"+ req.getServerName() +":"+req.getServerPort()+"/downFile/uploadFile/"+format+"/"+newName;
            return filePath;
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return "";
    }
    //http://localhost:8081/downFile/uploadFile/20133220/学术论文/社科类论文/导师遴选.rar
    /**
     * 删除文件
     * @param path 路径中的文件
     * @return ok err
     */
    public String delFile(String path){
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
