package tw.org.iii.practiceJava;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;


/*	20180818PM1 Brad69 URL 38:00
 * 	> OpenData試玩 
 * 	http://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx?
 * 	> JSON格式轉換
 *	JSON 格式 => import json package (org.json)
 *
 *
 *	>> 行動裝置使用OPENDATA
 *		資料處理-->另架伺服器固定至該政府單位撈資料, 整理後再讓行動裝置端定期來抓取更新資料.
 *		-> 減少政府單位伺服器的繁忙/ 手機端資料拿到的已是整理過的資料(手機端演算法減少)
 * 	
 * 	URL
 * 	URLConnection
 *	HttpURLConnection
 */
public class Rev071_OpenData {

	public static void main(String[] args) {
		try {
			// URL包含通訊協定
			URL url = new URL("http://data.coa.gov.tw/Service/OpenData/ODwsv/ODwsvTravelFood.aspx?");
			
			// 強制轉型回HttpURLConnection 
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			
			// 取得輸入串流
			conn.connect();
			
			// 讀取資料(串接)
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			
			
			String line; // 一段一段的文字
			
			StringBuffer sb = new StringBuffer(); // 串接後完成的字串
			while ((line = reader.readLine()) != null) {
				//	一列一列輸出到本地端
				sb.append(line); //	串接字串
			}
			// 關閉串流
			reader.close();
			
			//	把String轉換成JSON
			parseJSON(sb.toString());
			
			System.out.println("Download OK");
		} catch (MalformedURLException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	//	解析JSON的方法
	/*	將下載下來的JSON Package複製貼上至專案中
	 * 	記得package名稱寫成org.json 配合來源檔案設定
	 * 	http://stleary.github.io/JSON-java/index.html
	 * 	Android開發已將JSON API納入為官方API
	 */
	private static void parseJSON(String json) {
		/*	Opendata原始來源是陣列JSON
		 * 
		 */
		
		try {
			// 讀入字串資料轉成JSONArray (解析第一層)
			JSONArray root = new JSONArray(json);
			//System.out.println(root.length());
			
			//	尋訪JSON陣列裡的元素
			//	注意! JSON陣列裡面有可能是物件也有可能是另一層陣列
			//	要懂得判讀元素格式
			
			for (int i = 0; i < root.length();i++) {
				JSONObject obj = root.getJSONObject(i);
				String name = obj.getString("Name");
				String addr = obj.getString("Address");
				String tel = obj.getString("Tel");
				System.out.println(name + " : " + addr + " : "+tel);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
	}
	
}
