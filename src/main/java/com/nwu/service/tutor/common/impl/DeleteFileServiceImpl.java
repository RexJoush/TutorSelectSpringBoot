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

    /**
     * 删除文件
     * @param httpPath http://10.8.47.148:8081/downFile/uploadFile/20133220/学术论文/社科类论文/导师遴选.rar
     * @return ok err
     */
    @Override
    public String delFile(String httpPath) {

        if (!"".equals(httpPath)) {
            try {
                String path = URLDecoder.decode(httpPath, "UTF-8");
                String realPath= upLoadFile.getFilePath() + path.substring(44, path.length() - 1);
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
