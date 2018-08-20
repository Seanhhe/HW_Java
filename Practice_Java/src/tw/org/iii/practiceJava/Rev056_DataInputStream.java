package tw.org.iii.practiceJava;

import java.io.DataInputStream;
import java.io.FileInputStream;

/*	20180812PM1 Brad54 DataInputStream
 * 	
 * 	自動關閉串流 auto-close
 * 	try (宣告要autoclose的物件) 
 * 		{要執行的內容 } 
 * 			catch (例外) {例外處理}
 * 		
 */
public class Rev056_DataInputStream {

	public static void main(String[] args) {
		try ( DataInputStream din =
				new DataInputStream(
						new FileInputStream("dir2/rev55.txt")); ) 
			{// 裡面的會自動關閉
			int stage = din.readInt();
			String username = din.readUTF();
			boolean isSound = din.readBoolean();
			System.out.println(stage + ":" + username+";"+isSound);
					
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
