package fastdfsutils;

import com.define.commons.utils.FastDFSUtils;
import org.junit.Test;

import java.io.File;

public class TestFastdfs {

/**
 * 文件上传
 */
@Test
public void upload_file() {
    File file = new File("D:\\2.txt");
    byte[] a = new byte[(int) file.length()];
    String s = FastDFSUtils.upload_file(a, "2.jpg", file.length());
    System.out.println(s);
}
/**
 * 文件下载
 */
@Test
public void download_file() throws Exception {
    byte[] group1s = FastDFSUtils.download_file("group1", "M00/00/00/wKio_lviT1SAR-zxAAAAAAAAAAA629.jpg");
    System.out.println(group1s.toString());
}
/**
 * 删除文件
 */
@Test
    public void deldte_file() throws Exception {
    int group = FastDFSUtils.delete_file("group1", "M00/00/00/wKio_lviT1SAR-zxAAAAAAAAAAA629.jpg");
    System.out.println(group);
}
}