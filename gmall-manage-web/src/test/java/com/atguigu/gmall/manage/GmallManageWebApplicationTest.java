package com.atguigu.gmall.manage;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ClassName :GmallManageWebApplicationTest
 * Package :com.atguigu.gmall.manage
 * Description :
 *
 * @author :张哈哈
 * @date :2020/4/20 22:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallManageWebApplicationTest {

    @Test
    public void fileUpload(){

        //配置fdfs的全局链接地址
        String path = GmallManageWebApplication.class.getResource("/tracker.conf").getPath();//获取配置文件的路径
        try {
            ClientGlobal.init(path);
            TrackerClient trackerClient = new TrackerClient();
            //获得一个TrackerServer的实例
            TrackerServer trackerServer = trackerClient.getConnection();
            //通过TrackerServer获得一个storage的链接客户端
            StorageClient storageClient = new StorageClient(trackerServer, null);

            String[] uploadFile = storageClient.upload_file("d:a.jpg", "jpg", null);

            String url = "http://192.168.221.128";
            for (String fileInfo : uploadFile) {
                url += "/"+fileInfo;
            }

            System.out.println(url);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
