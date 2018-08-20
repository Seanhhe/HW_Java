package tw.org.iii.practiceJava;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/*	20180812PM2 Brad58 解序列化(繼承結構)
 * 	
 * 	解序列化-->拿回原物件
 */

public class Rev060_UnSerial2 {

	public static void main(String[] args) {
		try (ObjectInputStream oin = new ObjectInputStream(
					new FileInputStream("dir2/rev59.object"))) {
			oin.readObject();
			System.out.println();
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
