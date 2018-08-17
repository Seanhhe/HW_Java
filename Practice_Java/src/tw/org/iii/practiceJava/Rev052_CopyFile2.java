package tw.org.iii.practiceJava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/*	20180812AM1 複製檔案V2
 * 	
 * 	第一次 Rev051以byte方式讀取, 速度很慢, 如何改善?
 * 	
 * 	將檔案一次讀到陣列中再讀到新檔案裡
 * 	
 * 	陣列的長度就是原始資料的長度
 *	(Length回傳的是long要轉換成陣列index的int(最大2G 2^32次方), 一次性的buffer)
 */
public class Rev052_CopyFile2 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		
//		File source = new File("dir1/image.jpg");
//		byte[] buf = new byte[(int)source.length()];
//		
//		try {
//			FileInputStream fin = new FileInputStream(source);
//			fin.read(buf);
//			fin.close();
//			
//			FileOutputStream fout = new FileOutputStream("dir2/image3.jpg");
//			fout.write(buf);
//			fout.flush();
//			fout.close();
//			
//			System.out.println("OK: "+(System.currentTimeMillis()-start));
//		} catch (Exception e) {
//			System.out.println(e);
//		}
		
		// 長度限制 (原本為long強制轉型後喪失精度)
		int v1 = (int)5000000000L;
		long v2 = 5000000000L;
		System.out.println(v1);
		System.out.println(v2);
		
		// 改寫! 調整程式使其迎合超過2G以上的檔案
		
		File source = new File("dir1/image.jpg");
		final int limit = 2000000000; // 設定容器限制的大小
		// 用三元判斷式判斷
		byte[] buf = new byte[source.length()<limit?(int)source.length():limit];
		
		try {
			FileInputStream fin = new FileInputStream(source);
			FileOutputStream fout = new FileOutputStream("dir2/image4.jpg");
			
			int len = 0;
			while ((len = fin.read(buf)) != -1) {
				fout.write(buf, 0, len);
			}
			
			fin.close();
			
			fout.flush();
			fout.close();
			
			System.out.println("OK: "+(System.currentTimeMillis()-start));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
