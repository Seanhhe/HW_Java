package tw.org.iii.practiceJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/*	20180818PM1 Brad66 URL 05:33
 * 	> 讀出網頁的原始碼文字(html)
 * 
 * 	URL
 * 	URLConnection
 *	HttpURLConnection
 *	
 *	可能應用: 網頁爬蟲程式
 */
public class Rev068_URL {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.google.com.tw");
			
			// 強制轉型回HttpURLConnection
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			
			// 取得輸入串流
			conn.connect();
			
			// 串接讀取頁面原始碼
//			InputStream in = conn.getInputStream();
//			InputStreamReader isr = new InputStreamReader(in);
//			BufferedReader bufr = new BufferedReader(isr);
			
			// 串接的另一種簡寫法
			BufferedReader bufr = new BufferedReader(
					new InputStreamReader(
							conn.getInputStream()));
			
			
			String line;
			while ((line = bufr.readLine()) != null) {
				System.out.println(line);
			}
			
			// 關閉串流 (接成同一根管 關一個就可)
			bufr.close();
		} catch (MalformedURLException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		
		
		System.out.println("----------------------");
		
		// HTTPS
		try {
			URL url = new URL("https://www.ccu.edu.tw");
			
			// 強制轉型回HttpsURLConnection
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
			
			// 取得輸入串流
			conn.connect();
			
			// 串接讀取頁面原始碼
//			InputStream in = conn.getInputStream();
//			InputStreamReader isr = new InputStreamReader(in);
//			BufferedReader bufr = new BufferedReader(isr);
			
			// 串接的另一種簡寫法
			BufferedReader bufr = new BufferedReader(
					new InputStreamReader(
							conn.getInputStream()));
			
			
			String line;
			while ((line = bufr.readLine()) != null) {
				System.out.println(line);
			}
			
			// 關閉串流 (接成同一根管 關一個就可)
			bufr.close();
		} catch (MalformedURLException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
