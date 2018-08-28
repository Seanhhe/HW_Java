package tw.org.iii.practiceJava;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/*	20180825AM1 Brad78 00:47:00~1:22
 * 	執行緒與網路存取_應用
 * 	同時抓取多張圖片
 */

public class Rev080_Thread {

	public static void main(String[] args) {
		System.out.println("Start Time: "+System.currentTimeMillis());
		
		String[] urls = {
			"https://images7.alphacoders.com/595/595191.jpg",
			"https://wallpapershome.com/images/wallpapers/night-sky-5120x2880-5k-4k-wallpaper-8k-stars-night-mountains-nebula-5497.jpg",
			"https://wallpapershome.com/images/wallpapers/ducati-monster-796-5184x3456-night-sky-motorcycle-racing-bike-sport-3660.jpg"
		};
		
		String[] targets = {
			"Rev0801.jpg","Rev0802.jpg","Rev0803.jpg"
		};
		
//		for (int i = 0; i < urls.length; i++) {
//			new FetchURLImage(urls[i], targets[i]).start();;
//			// start方法 =>同時進行
//			// 一樣是循序進行 只是每一個start都被依序丟給 run pool
//			// 減少CPU閒置的時間
//		}
		
		for (int i = 0; i < urls.length; i++) {
			new FetchURLImage(urls[i], targets[i]).run();;
			// run方法 =>普通物件方法 循序進行
			// 無持行緒的生命表現 循序一個接一個=> 易被延遲
		}

	}

}

class FetchURLImage extends Thread {
	// 要抓取的網址
	private String url;
	// 儲存的目的地
	private String target;
	
	public FetchURLImage(String url, String target) {
		this.url = url;
		this.target = target;
	}
	
	
	@Override
	public void run() {
		URL source;
		try {
			// 讀入目標URL
			source = new URL(url);
			
			// 網路連接
			HttpURLConnection conn = (HttpURLConnection)source.openConnection();
			conn.connect();
			
			// 輸入串接
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
			
			// 輸出
			FileOutputStream fout = new FileOutputStream("dir1/" + target);
			
			// 讀取
			byte[] buf = new byte[4096*1024];
			int len = 0;
			while ((len = bin.read(buf)) != -1) {
				fout.write(buf, 0, len); // 一次寫多少
			}
			fout.flush();
			fout.close();
			bin.close();
			
			System.out.println(target +" :OK");
		} catch (MalformedURLException e) {
			System.out.println(target + ": Error1");
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(target + ": Error2");
			System.out.println(e);
		}
		System.out.println("END TIME: " +System.currentTimeMillis());
	}
}