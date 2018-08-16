package tw.org.iii.practiceJava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/*	20180811PM2 17:00 Brad46 串流Part1
 * 	INPUT STREAM
 * 	
 * 	java.io.InputStream
 * 		java.io.FileInputStream
 */
public class Rev048_Stream1 {

	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("dir1/Rev.txt");
			
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}

	}

}
