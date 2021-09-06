package com.nwu.util;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;

@Component
public class SaveImage {

//    @Value(value = "${ImagePath}")
    private String imagePath = "D:\\RARZIP\\image\\";

//    public String getImagePath() {
//        return imagePath;
//    }
//
//    @Value(value = "${ImagePath}")
//    public void setImagePath(String imagePath) {
//        this.imagePath = imagePath;
//    }

    /**
     * 保存数据库图片到本地
     * @param blobImage byte[]
     * @param fileName  导师工号
     * @param request   httprequest
     * @return  path
     * @throws Exception
     */
    public static String ExportBlob(byte[] blobImage, String fileName, HttpServletRequest request) throws Exception {
        if(blobImage==null)
        {
            return "";
        }

        String path = new SaveImage().imagePath+fileName+".jpg";
        System.out.println(path);
        File file = new File(path);
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        try{
            for (int i=0 ;i<blobImage.length;i++){
                if (blobImage[i] < 0) {// 调整异常数据
                    blobImage[i] += 256;
                }
            }
            FileOutputStream outputStream = new FileOutputStream(path);
            outputStream.write(blobImage);
            outputStream.flush();//刷新
            outputStream.close();//关闭字节输出流
            String httpPath=request.getScheme()+"://"+ request.getServerName() +":"+request.getServerPort()+"/downFile/image/"+fileName+".jpg";
            System.out.println(httpPath);
            return httpPath;
        }
        catch (Exception e){
            return "";
        }
    }
}
