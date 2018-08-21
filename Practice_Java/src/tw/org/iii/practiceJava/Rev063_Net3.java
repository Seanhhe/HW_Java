package tw.org.iii.practiceJava;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/*	20180818AM1 網路基本概論 00:54 Brad61
 * 	封包的接收與傳送
 * 	DatagramSocket
 *	DatagramPacket
 * 	發送方
 */
public class Rev063_Net3 {

	public static void main(String[] args) {
		//	發送方: port號選擇any available
		byte[] buf = "Hello, world".getBytes();
		try {
			DatagramSocket socket = new DatagramSocket();
			DatagramPacket packet = new DatagramPacket(buf
					, buf.length
					, InetAddress.getByName("192.168.1.2")
					, 8889);
			
			//	發送封包
			socket.send(packet);
			
			//	關閉封包
			socket.close();
		} catch (SocketException e) {
			System.out.println(e);
		} catch (UnknownHostException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
