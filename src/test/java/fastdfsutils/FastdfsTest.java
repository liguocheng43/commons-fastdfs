package fastdfsutils;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;

/**
 * FastdfsTest
 * @author LEE.SIU.WAH
 * @email lixiaohua7@163.com
 * @date 2017年6月20日 上午11:04:38
 * @version 1.0
 */
public class FastdfsTest {

	@Before
	public void beforeAll() throws Exception {
		/** 加载配置文件，产生绝对路径 */
	String conf_filename = this.getClass()
			.getResource("/fdfs_client.conf").getPath();
	/** 初始化客户端全局的对象 */
		ClientGlobal.init(conf_filename);
	}
	
	/** 上传文件 */
	@Test
	public void upload_file() throws Exception{

		/** 创建存储客户端对象 */
		StorageClient storageClient = new StorageClient();
		/** 上传文件 */
		//String[] arr = storageClient.upload_file("C:/Users/Public/Pictures/Sample Pictures/15.jpg", "jpg", null);
		String[] arr = storageClient.upload_file("D:/1.txt", "txt", null);
		/**
		 * 访问路径：http://192.168.12.131/group1/M00/00/00/wKgMg1o53fOAL1CRAABonuLw4M4127.jpg
		 * [group1, M00/00/00/wKgMgFlIkk2AHfnLAABonuLw4M4075.jpg]
		 * 数组中的第一个元素：组的名称
		 * 数组中的第二个元素：文件存储的路径
		 */
		//[group1, M00/00/00/wKio_lviRKOAXOagAAGoBEhGR7I633.jpg]
		System.out.println(Arrays.toString(arr));
	}
	
	/** 文件下载 */
	@Test
	public void download_file() throws Exception{
		/** 创建存储客户端对象 */
		StorageClient storageClient = new StorageClient();
		/** 下载文件 */
		byte[] data = storageClient.download_file("group1", "M00/00/00/wKio_lviSiOAVec_AAAAPKT9LQE821.txt");
		System.out.println(data.length);
		FileOutputStream fos = new FileOutputStream(new File("D:/fastdfs-utils/src/test/resources/1.txt"));
		fos.write(data);
		fos.flush();
		fos.close();
	}
	
	/** 删除文件 */
	@Test
	public void delete_file() throws Exception{
		/** 创建存储客户端对象 */
		StorageClient storageClient = new StorageClient();
		/** 删除文件 */
		int res = storageClient.delete_file("group1", "M00/00/00/wKio_lviRW6AT9J6AAGoBEhGR7I475.jpg");
		System.out.println(res);
	}
}