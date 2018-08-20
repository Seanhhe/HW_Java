package tw.org.iii.practiceJava;
/*	20180812PM2 Brad61 java.net
 * 	網際網路
 * 	API_java.net
 * 	->InetAddress (IP)
 * 		->沒有建構式?!
 * 			=>這類的類別通常會透過本類別的static方法來產生物件實體/透過別的類別來產生物件實體(與開發者的環境有關?)
 * 	
 * 	網際網路的觀念
 * 	=>交換資料
 * 
 * 	NAT 網路位址交換
 * 
 * 	FQDN
 * 	HOST NAME
 * 	主機名稱.Domain.root
 * 
 * 	一個真實的ip 只會存在在一台主機上 ==>大型網站透過DNS分流(輪巡機制)
 * 	一台主機可以有多個IP
 * 	
 * 	InetAddress.getByName("www.twitter.com"); 的查詢過程
 * 	=>從根問起(類似電話用查號台找)問DNS伺服器 [DNS有時候回覆的不見得是正確的, 例如公司限定網域]
 * 
 * 	網際網路_資料傳輸
 * 	UDP/TCP 封包
 * 	ICMP 封包
 * 
 * 	TODO HW 20180812 網際網路概論_鳥哥 http://linux.vbird.org/linux_server/0110network_basic.php
 */
public class Rev061_Net {

	public static void main(String[] args) {

	}

}
