package tw.org.iii.practiceJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/*	20180818AM2 Brad62 ServerSocket (TCP連線)
 * 	Server端(接收端)
 * 	
 * 	Socket -> 串流的觀念
 * 	
 */
public class Rev064_ServerSocket {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9999);
			Socket socket = server.accept();	//	完成三方交握
			
			/*	讀取資料
			 * 	一樣出現中文字問題: 如何解決?
			 * 	運用串接技巧 check last week's lab file
			 * 	socket=>完成三方交握
			 * 	Stream=>串流資料
			 */
			
			InputStream in = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			
			int len; String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			
			server.close();
			System.out.println("OK");
		} catch (IOException e) {
			System.out.println(e);
		}
		

	}

}
