package tw.org.iii.practiceJava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.net.Socket;

/*	20180818AM2 Brad64
 * 	將本機上的指定圖檔傳遞到67號程式
 * 	
 * 	發送端
 * 
 * 	如何傳送檔案名稱等資訊並一次傳送?
 * 	=> 自訂通訊協定
 * 	1024byte前為資訊, 後為內容
 * 	甚至可以隱藏特定資訊/加密 (某段資料才是真實資料)
 * 
 * 	
 */
public class Rev066_Socket {

	public static void main(String[] args) {
		/*	1. read local file
		 * 	2. send tcp data
		 */
//		try {
//			byte[] buf = new byte[4096];
//			
//			Socket socket = new Socket("172.20.10.5", 7777);
//			OutputStream out = socket.getOutputStream();
//			
//			// 先寫的是這邊--> 寫code的順序與思考邏輯
//			FileInputStream fin = new FileInputStream("dir1/image.jpg");
//			
//			int len;
//			while ((len = fin.read(buf)) != -1) {
//				// 每讀入一段4096就寫出, 最後一段不滿4096就看長度多少就發出多少
//				out.write(buf, 0, len);
//			}
//			fin.close();
//			
//			out.flush();
//			out.close();
//			socket.close();
//			System.out.println("Sent");
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		// 提升寫出的速度
		try {
			// 直接把檔案一次讀進buffer中
			File file = new File("dir1/image.jpg");
			byte[] buf = new byte[(int)file.length()];
			new FileInputStream(file).read(buf);
			
			// 建立socket
			Socket socket = new Socket("172.20.10.5", 7777);
			OutputStream out = socket.getOutputStream();
			
			// 把資料寫到socket
			out.write(buf);
			
			out.flush();
			out.close();
			
			socket.close();
			System.out.println("Sent");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
