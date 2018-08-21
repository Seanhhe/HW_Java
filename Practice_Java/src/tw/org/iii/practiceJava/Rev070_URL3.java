package tw.org.iii.practiceJava;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/*	20180818PM1 Brad68 URL 38:00
 * 	> WebService試玩 (網頁轉PDF下載)
 * 	https://pdfmyurl.com/
 * 	> 二進制檔案都可下載 (PDF/JPG/....)
 * 	URL
 * 	URLConnection
 *	HttpURLConnection
 *	
 *	可能應用: 網頁爬蟲程式
 */
public class Rev070_URL3 {

	public static void main(String[] args) {
		try {
			// URL包含通訊協定
			URL url = new URL("https://pdfmyurl.com/?url=https://tw.yahoo.com/");
			
			// 強制轉型回HttpURLConnection 
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
			
			// 取得輸入串流
			conn.connect();
			
			// 讀取資料
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
			
			// 檔案輸出
			FileOutputStream fout = new FileOutputStream("dir3/rev070.pdf");
			
			byte[] buf = new byte[4096];
			int len;
			while ((len = bin.read(buf)) != -1) {
				//	輸出到本地端
				fout.write(buf,0,len);
			}
			// 關閉串流
			bin.close();
			fout.flush();
			fout.close();
			System.out.println("Download OK");
		} catch (MalformedURLException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		

	}

}
