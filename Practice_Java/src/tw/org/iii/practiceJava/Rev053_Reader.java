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
			int v = reader.read();
			System.out.print((char)v);
			v = reader.read();
			System.out.print((char)v);
			v = reader.read();
			System.out.print((char)v);
			v = reader.read();
			System.out.print((char)v);
			v = reader.read();
			System.out.print((char)v);
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
