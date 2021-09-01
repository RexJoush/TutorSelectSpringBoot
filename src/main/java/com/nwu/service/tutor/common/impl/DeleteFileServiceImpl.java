package com.nwu.service.tutor.common.impl;

import com.nwu.service.tutor.common.DeleteFileService;
import com.nwu.util.UpLoadFile;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Service
public class DeleteFileServiceImpl implements DeleteFileService{

    @Resource
    UpLoadFile upLoadFile;

    @Override
    public String delFile(String httpPath) {
        /**
         * 删除文件 http://localhost:8081/downFile/uploadFile/20133220/学术论文/社科类论文/导师遴选.rar
         * @param path 路径中的文件
         * @return ok err
         */
        if (!"".equals(httpPath)) {
            try {
                String path = URLDecoder.decode(httpPath, "UTF-8");
                System.out.println(upLoadFile.getFilePath());
                String realPath= upLoadFile.getFilePath() + path.substring(42, path.length() - 1);
                System.out.println(realPath);
                File file = new File(realPath);
                if (file.exists()){
                    file.delete();
                    return "ok";
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return "err";
    }
}
