package com.atguigu.gmall.manage.util;

import com.atguigu.gmall.bean.PmsProductInfo;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * ClassName :PmsUploadUtil
 * Package :com.atguigu.gmall.manage.util
 * Description :
 *
 * @author :张哈哈
 * @date :2020/4/20 23:38
 */
public class PmsUploadUtil {


    public static String uploadImg(MultipartFile multipartFile) {
        String imgUrl = "http://192.168.221.128";
        //上传文件
        //获得配置文件的路径
        String path = PmsUploadUtil.class.getResource("/tracker.conf").getPath();
        try {
            ClientGlobal.init(path);

            TrackerClient trackerClient = new TrackerClient();

            TrackerServer trackerServer = trackerClient.getConnection();

            StorageClient storageClient = new StorageClient(trackerServer,null);

            //获得上传的二进制文件对象
            byte[] bytes = multipartFile.getBytes();
            //获取文件后缀名
            String originalFilename = multipartFile.getOriginalFilename();//文件全名a.jpg
            int i = originalFilename.lastIndexOf(".");
            String extName = originalFilename.substring(i+1);

            String[] uploadFile = storageClient.upload_file(bytes, extName, null);
            for (String uploadInfo : uploadFile) {
                imgUrl += "/"+uploadInfo;
                
            }

        }  catch (Exception e) {
            e.printStackTrace();
        }
        return imgUrl;
    }
}
