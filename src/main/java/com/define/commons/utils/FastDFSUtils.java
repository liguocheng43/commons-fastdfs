package com.define.commons.utils;

import org.apache.commons.io.FilenameUtils;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.springframework.core.io.ClassPathResource;

/**
 * fastdfs文件上传和下载工具类
 */
public class FastDFSUtils {
    static {
        try {
            //ClientGloble 读配置文件
            ClassPathResource resource = new ClassPathResource("fdfs_client.conf");
            ClientGlobal.init(resource.getClassLoader().getResource("fdfs_client.conf").getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param pic  文件二进制
     * @param name 文件名称
     * @param size 文件大小
     * @return group1/M00/00/01/wKjIgFWOYc6APpjAAAD-qk29i78248.jpg
     * @Description: 上传文件
     */
    public static String upload_file(byte[] pic, String name, long size) {
        String path = null;
        try {
            //客户端
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getConnection();
            StorageServer storageServer = null;
            StorageClient1 storageClient1 = new StorageClient1(trackerServer, storageServer);
            //文件11.jpg  根据文件名称得到文件后缀    jpg
            String ext = FilenameUtils.getExtension(name);
            NameValuePair[] meta_list = new NameValuePair[3];
            meta_list[0] = new NameValuePair("fileName", name);
            meta_list[1] = new NameValuePair("fileExt", ext);
            meta_list[2] = new NameValuePair("fileSize", String.valueOf(size));
            //  group1/M00/00/01/wKjIgFWOYc6APpjAAAD-qk29i78248.jpg
            path = storageClient1.upload_file1(pic, ext, meta_list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }

    /**
     * 文件下载
     * return:文件字节码
     * group_name:group1
     * romte_fileName:M00/00/01/wKjIgFWOYc6APpjAAAD-qk29i78248.jpg
     */
    public static byte[] download_file(String group_name, String romte_fileName) throws Exception {
        /** 创建存储客户端对象 */
        StorageClient storageClient = new StorageClient();
        /**
         * 文件下载
         */
        byte[] bytes = storageClient.download_file(group_name, romte_fileName);
        return bytes;
    }

    /**
     * 删除文件
     * return:0代表删除成功
     * group_name:group1
     * romte_fileName:M00/00/01/wKjIgFWOYc6APpjAAAD-qk29i78248.jpg
     */
    public static int delete_file(String group_name, String romte_fileName) throws Exception {
        /** 创建存储客户端对象 */
        StorageClient storageClient = new StorageClient();
        /** 删除文件 */
        int res = storageClient.delete_file(group_name, romte_fileName);
        return res;
    }
}
