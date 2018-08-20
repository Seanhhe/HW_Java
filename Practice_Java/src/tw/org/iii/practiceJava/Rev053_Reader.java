package tw.org.iii.practiceJava;

import java.io.FileReader;

/*	20180812AM2 Reader
 * 	讀取字元資料用
 * 	=> Reader & Writer
 * 	
 */

public class Rev053_Reader {

	public static void main(String[] args) {
		
		try {
			FileReader reader = new FileReader("dir1/Rev.txt");
//			int v = reader.read();
//			System.out.print((char)v);
//			v = reader.read();
//			System.out.print((char)v);
//			v = reader.read();
//			System.out.print((char)v);
//			v = reader.read();
//			System.out.print((char)v);
//			v = reader.read();
//			System.out.print((char)v);
			
			int temp; // 將資料放在這
			char[] b = new char[4096];  // 一次讀幾個
			while (( temp = reader.read(b) ) != -1) {
				System.out.print(new String(b, 0, temp));
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
