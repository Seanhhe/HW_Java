package tw.org.iii.practiceJava;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/*	20180818PM1 Brad67 URL 28:17
 * 	> 讀出網頁的影像
 * 
 * 	URL
 * 	URLConnection
 *	HttpURLConnection
 *	
 *	可能應用: 網頁爬蟲程式
 */
public class Rev069_URL2 {

	public static void main(String[] args) {
		try {
			// URL包含通訊協定
			URL url = new URL("https://www.google.com/logos/doodles/2018/indonesia-independence-day-2018-5375682916909056-2x.jpg");
			
			// 強制轉型回HttpURLConnection 
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			
			// 取得輸入串流
			conn.connect();
			
			// 讀取資料
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
			
			// 檔案輸出
			FileOutputStream fout = new FileOutputStream("dir3/rev069.jpg");
			
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
