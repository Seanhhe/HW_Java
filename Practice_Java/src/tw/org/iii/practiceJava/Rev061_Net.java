package tw.org.iii.practiceJava;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*	20180812PM2 Brad61 java.net
 * 	網際網路
 * 	API_java.net
 * 	->InetAddress (IP)
 * 		->下有兩個子類別, 很少用到. 
 * 		->沒有建構式?!
 * 			=> 這類的類別通常會透過本類別的static方法來產生物件實體/透過別的類別來產生物件實體
 * 			=> 與執行者的環境有關, 環境允不允許new出該物件 (例如: 沒有網路怎麼產生網路連線物件)
 * 	
 * 	網際網路的觀念
 * 	=>交換資料
 * 
 * 	NAT 網路位址交換
 * 	
 * 	FQDN
 * 	HOST NAME
 * 	主機名稱.Domain.root (root server通常被省略)
 * 	www.iii.org.tw (<---閱讀方向)
 * 	
 * 	一個真實的ip 只會存在在一台實體主機上 ==>大型網站透過DNS分流(輪巡機制)
 * 	一台實體主機可以有多個IP
 * 	
 * 	InetAddress.getByName("www.twitter.com"); 的查詢過程
 * 	=>從根問起(類似電話用查號台找)問DNS伺服器 
 * 	[DNS有時候回覆的不見得是正確的, 例如公司限定網域]
 * 
 * 	網際網路_資料傳輸
 * 	UDP/TCP 封包
 * 	ICMP 封包 (Ping對方的時候)
 * 
 * 	TODO HW 20180812 網際網路概論_鳥哥 http://linux.vbird.org/linux_server/0110network_basic.php
 */
public class Rev061_Net {

	public static void main(String[] args) {
		try {
			InetAddress ip = InetAddress.getByName("www.google.com"); // 不用加http (這是通訊協定)
			System.out.println(ip.getHostAddress());	//	印出ip address
		} catch (UnknownHostException e) {
			//	如果輸入的ip有問題 就會拋出例外 : 拿不到物件實體, 並告知發生甚麼原因
			//	之前寫的身份證字號程式是以回傳null方式, 但其實用拋出例外會更好
			System.out.println(e);
		}
		
		
		System.out.println("---------------------");
		
		try {
			//	抓出所有的ip位址
			InetAddress[] ips = InetAddress.getAllByName("www.google.com"); // 不用加http (這是通訊協定)
			for (InetAddress ip : ips) {
				System.out.println(ip.getHostAddress());
			}
		} catch (UnknownHostException e) {
			//	如果輸入的ip有問題 就會拋出例外 : 拿不到物件實體, 並告知發生甚麼原因
			//	之前寫的身份證字號程式是以回傳null方式, 但其實用拋出例外會更好
			System.out.println(e);
		}
		
	}

}
