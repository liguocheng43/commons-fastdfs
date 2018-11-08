package com.define.commons.controller;

import com.define.commons.utils.FastDFSUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


/**
 * fastdfscontroller文件上传/下载/删除接口
 */
@RestController
@RequestMapping("/file")
public class FastDFSUtilsController {

    /**
     * 文件上传
     * @param file
     * @return 文件路径:group1/M00/00/00/wKio_lvikeOANa36AAJHlGw13Og494.jpg
     * @throws Exception
     */
    @PostMapping("/uploadFile")
    public String upload_file(@RequestParam MultipartFile file) throws Exception {
        String fileName = file.getOriginalFilename();
        String path = FastDFSUtils.upload_file(file.getBytes(), fileName, file.getSize());
        return path;
    }
      /**
     * 文件下载
       * String group_name:group1
       * String romte_fileName:M00/00/00/wKio_lvikeOANa36AAJHlGw13Og494.jpg
       * @return 文件字节数组
       */
     @PostMapping("/downloadFile")
      public byte[] download_file(@RequestParam("group_name") String group_name,@RequestParam("romte_fileName") String romte_fileName) throws Exception {
         byte[] bytes = FastDFSUtils.download_file(group_name, romte_fileName);
         return bytes;
     }

      /**
     * 文件删除
       * int:0代表删除成功
       * group_name：group1
       * String romte_fileName：M00/00/00/wKio_lvikeOANa36AAJHlGw13Og494.jpg
     */
     @PostMapping("/deleteFile")
     public int delete_file(@RequestParam("group_name")String group_name,@RequestParam("romte_fileName") String romte_fileName) throws Exception {
        return FastDFSUtils.delete_file(group_name,romte_fileName);
    }
}
