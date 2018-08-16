package tw.org.iii.practiceJava;

import java.io.File;

/*	20180811PM1 I/O 輸入輸出 50:53 Brad44
 * 	1. 對檔案系統的一種操作
 * 	2. 對檔案的存取-->串流的觀念(把檔案讀出來)
 * 	
 * 	API_File (java.io.File)
 * 	
 */
public class Rev046_IO1 {

	public static void main(String[] args) {
		/*	印出分號與斜線
		 * 	不同作業系統印出的不同
		 * 	Path: Mac ":" Win ";"
		 * 	Separator: Mac "/" Win "\"
		 */
//		System.out.println(File.pathSeparatorChar);
//		System.out.println(File.separator);
		
		
		// File dir1 = new File("D:\\LabJava\dir1"); // escape sequence 跳脫字元 \d,\\,\n....
		//File dir1 = new File("D:\\LabJava\\dir1"); // 兩斜線-->代表一斜線
//		File dir1 = new File("D:/LabJava/dir1"); // [這個比較好] 使用Mac/linux系統的表現方式, JAVA"跨平台",所以可以這樣處理
//		System.out.println(dir1.exists()); // 該檔案目錄是否存在
		
		/*	字串內有左上右下斜的斜線-->除了跳脫字元外都會編譯失敗
		 */
		
		/*	跨平台觀念2
		 * 	static File[]	listRoots()
		 */
//		File[] roots = File.listRoots();
//		for (File root : roots) {
//			/*	取出該物件的絕對路徑
//			 * 	Win系統會顯示多根 C: D: E: ... (各磁碟機路徑)
//			 * 	Mac/Linux 只會顯示單根 /
//			 * 	根代表盡頭
//			 * 	
//			 * 	如果要寫跨平台程式: 請使用相對路徑
//			 * 	=> 原因就是各平台的單根與多根 (絕對路徑不同)
//			 */
//			System.out.println(root.getAbsolutePath());
//		}
		
		/*	跨平台觀念3 相對路徑
		 * 	每個本目錄都會知道自己的父目錄是誰
		 * 	-->一個串一個就可以產生樹狀架構
		 */
		
		File dir1 = new File("."); // .代表本目錄 (目前是專案目錄)
		System.out.println(dir1.getAbsolutePath());
		
		File dir2 = new File("./dir1"); 
		System.out.println(dir2.exists()); 
		
		/*	建議學習: File System & 作業系統
		 * 	讀/寫/執行
		 */
	}

}
