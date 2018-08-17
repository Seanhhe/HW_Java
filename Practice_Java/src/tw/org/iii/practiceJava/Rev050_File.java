package tw.org.iii.practiceJava;
/*	20180812AM1 Brad48 File 檔案
 * 	
 * 	檔案的複製/剪下貼上
 * 	
 */

import java.io.File;

public class Rev050_File {

	public static void main(String[] args) {
		// (同分割區)剪下貼上 (Rev4-->5)
//		File f1 = new File("dir1/Rev4.txt");
//		File f2 = new File("dir2/Rev5.txt");
//		
//		if (f1.renameTo(f2)) {
//			System.out.println("OK");
//		} else {
//			System.out.println("Error");
//		}
		
		// (不同分割區) 剪下貼上
		File f1 = new File("dir2/Rev5.txt");
		File f2 = new File("D:/LabJava/dir1/Rev6.txt");
		
		if (f1.renameTo(f2)) {
			System.out.println("OK");
		} else {
			System.out.println("Error");
		}

	}

}
