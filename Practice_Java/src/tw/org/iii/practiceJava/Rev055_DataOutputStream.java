package tw.org.iii.practiceJava;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
/*	20180812PM1 串接 DataOutputStream Brad53
 * 
 */
import java.io.IOException;

public class Rev055_DataOutputStream {

	public static void main(String[] args) {
		try {
			DataOutputStream dout = 
					new DataOutputStream(
							new FileOutputStream("dir2/rev55.txt"));
			dout.writeInt(4);
			dout.writeUTF("Hello");
			dout.writeBoolean(false);
			dout.flush();
			dout.close();
			System.out.println("OK");
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
