package tw.org.iii.practiceJava;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/*	20180812PM1 串接 Review
 * 	
 * 	串流
 * 	Java
 * 
 * 	什麼是串接?
 * 	自來水公司輸送水到家裡泡茶
 * 	A---|---|-->B
 *	一條一條管子(口徑不同)串接起來, 讓A串流到B
 *	每一條管都各自處理一些事情(各自有著不同的功能)
 *	先接水到茶壺(buffer1)再燒開並倒到小茶壺(buffer2)中再到茶杯(final)
 *	=> 資料不斷地進行移植串接
 *
 *	InputStream(byte by byte 讀取)
 *	文字資料(通常都有換列符號) 若要一列一個字串,會需要判斷
 *		
 * 	串接API=>方便存取資料
 * 
 * 	BufferReader.readLine();
 * 
 * 
 * 	FileReader(讀取檔案資料)-->BufferReader(透過FR建構出BR)
 * 	FileInputStream(讀取網路資料; 網路只有Stream)
 * 		-->InputStreamReader(透過FS建構)
 * 			-->BufferReader
 * 
 * 	應用: 不同系統輸出的資料透過串接方式統一格式
 * 	==>郵購公司與銀行系統
 */
public class Rev054 {
	
	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("dir1/rev54.csv");
			InputStreamReader isr = new InputStreamReader(fin, "UTF-8"); 
			// UTF-8/Big5 解決傳入的csv可能的編碼問題
			BufferedReader reader = new BufferedReader(isr);
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				// 直接顯示
				System.out.println(line);
				
				// 分別顯示
				String[] data = line.split(",");
				String num = data[0];
				String name = data[1];
				String phone = data[2];
				System.out.println("Number: "+num);
				System.out.println("Name: "+name);
				System.out.println("Phone: "+phone);
				
			}
			
			
			fin.close(); // 關fin的或isr都可以 同一串
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
