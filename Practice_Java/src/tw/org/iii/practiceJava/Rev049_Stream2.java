package tw.org.iii.practiceJava;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*	20180812AM1 串流_輸出 
 * 	FileOutputStream_API
 * 
 * 	資料讀寫並沒有同步
 * 	作業系統程序
 * 	非同步
 */

public class Rev049_Stream2 {

	public static void main(String[] args) {
//		try {
//			// 物件內的路徑為不存在的檔案, 執行後產生新檔
//			FileOutputStream fout = new FileOutputStream("dir1/Rev2.txt");
//			
//			// 寫入
//			// write(傳入byte[]) {把字串透過getBytes方法轉型}
//			// fout.write("Hello, World".getBytes());
//			
//			/*	檔案不在會自動創新檔
//			 * 	檔案若在會清空後再寫入
//			 * 
//			 * 	若內容有東西但未寫write就flush 一樣是清空後再寫入(只是寫入沒東西)
//			 * 
//			 * 	!注意權限問題:(作業系統權限)
//			 * 	如果使用者對於指定的路徑要有寫入的權限
//			 * 	如果檔案有存在,要看使用者對於該檔案是否有寫入的權限
//			 * 
//			 * 	如果不希望清空? -->建構式: FileOutputStream(String name, boolean append)
//			 */
//			
//			fout.write("Hello, World; OK1\n".getBytes());
//			fout.write("Hello, World; OK2\n".getBytes());
//			fout.write("Hello, World; OK3\n".getBytes());
//			
//			fout.flush();
//			fout.close();
//		} catch (FileNotFoundException e) {
//			// 正常程式開發如果產出後要記得把log移除...
//			System.out.println(e);
//		} catch (IOException e) {
//			System.out.println(e);
//		}
		
		
		try {
			// 建構式預設append為false
			// 串流在建立時就決定是否要append (初始化時指標的位置)
			FileOutputStream fout = new FileOutputStream("dir1/Rev3.txt", true);
			fout.write("Hello, world\n".getBytes());
			fout.write("Hello, world\n".getBytes());
			fout.write("Hello, world\n".getBytes());
			fout.flush();
			fout.close();
			System.out.println("OK");	// 顯示OK代表前面三行都沒有意外
		}catch (IOException e) {
			System.out.println(e);
		}
		
		
		/*	檔案系統 File
		 * 	檔案內容改名-->內容不變
		 * 	剪下貼上(同分割區)-->換掉檔案的Parent
		 * 	剪下貼上(不同分割區)-->在目標路徑建立新檔案->將原檔案內容讀取到記憶體再寫入到新檔案位置.
		 * 	複製貼上(同分割區)-->在目標路徑建立新檔案->將原檔案內容讀取到記憶體再寫入到新檔案位置.
		 * 	刪除-->
		 * 	硬碟
		 * 	格式化-->建立資料儲存格
		 */
	}

}
