package tw.org.iii.practiceJava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*	20180811PM2 17:00 Brad46 串流Part1
 * 	INPUT STREAM
 * 	
 * 	java.io.InputStream
 * 		java.io.FileInputStream
 */
public class Rev048_Stream1 {

	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("dir1/Rev.txt");
			
			// read();一次只讀一個byte
//			int a = fin.read(); 
//			System.out.println(a); // 印出字元碼!?
//			int b = fin.read();
//			System.out.println(b);
			
			// 如何讀出完整的檔案內容
			// 寫法一
//			int temp;
//			do {
//				temp = fin.read();
//				// 把讀進來的字元碼強制轉型成字元
//				System.out.print((char)temp);
//			}while (temp != -1);
			
			
			// 寫法二 [老師的版本]
//			int temp;
//			do {
//				temp = fin.read(); // assign
//				// 先assign 再進行比對
//				if (temp == -1) {
//					break; // 離開迴圈
//				} else {
//					System.out.print((char)temp);
//				}
//			} while (true);
			
			/*	為什麼檔案大小與字元數量有差異?
			 * 	因為有換列符號2byte(\r\n) [Windows]
			 * 	Unix系統=> \n 1 byte
			 */
			
			// 寫法三 [老師版本]
//			int temp;
//			while ((temp = fin.read()) != -1) {
//				System.out.print((char)temp);
//			}
			
			/*	檔案內容有中文-->印出亂碼
			 * 	因為一次只讀1 byte [1/2個中文字?]
			 * 	
			 * 	解法: Java支援Unicode
			 */
			
			/*	試著印出正確的中文字
			 * 	運用陣列一次讀出多個byte
			 * 	僅部分可行且效能上會差很多
			 */
			int temp; // 將資料放在這
			byte[] b = new byte[4096];  // 一次讀幾個
			while (( temp = fin.read(b) ) != -1) {
				System.out.print(new String(b, 0, temp));
				System.out.println(temp);
			}
			/*	問題依然無解
			 * 	如果今天資料檔案是中英數夾雜--依然讀取失敗
			 * 	因為一次讀三個未必能整除, 如果中文字串間有英數字,會印出亂碼
			 * 
			 * 	20180812AM2 利用Rev052的解法 或利用Reader&Writer
			 */
			
			
			
			
			
			/*	重點!!!
			 * 	InputStream 讀取單位為byte, 不適合讀取字串內容!
			 * 	-->較適合讀取Binary檔案(非文字檔:影像/音訊/.....)
			 * 	
			 * 	讀取的File-->含兩大類: 文字檔&非文字檔 (Binary file)
			 */
			
			fin.close(); // 如果沒使用autoclose(1.7版後), 要記得關閉串流
		} catch (FileNotFoundException e) {
			// FileNF為IOE的子類別, 故順序需在IOE之上
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}


/*	20180812AM1 FileInputStream_API
 * 	
 * 	某些方法會與不同作業系統的檔案系統有關
 * 	課程主要介紹大部分的常用功能
 * 	
 * 	輸出比輸入簡單
 */
