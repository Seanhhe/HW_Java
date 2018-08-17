package tw.org.iii.practiceJava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/*	20180812AM1 Brad49 
 * 	檔案複製
 * 	透過FileInputStream&FileOutputStream
 * 	將檔案byte by byte讀到另一個檔案路徑上
 */
public class Rev051_CopyFile {

	public static void main(String[] args) {
		try {
			// 紀錄開始時間
			long start = System.currentTimeMillis();
			
			FileInputStream fin = new FileInputStream("dir1/image.jpg");
			FileOutputStream fout = new FileOutputStream("dir2/image2.jpg");
			
			// Read byte by byte
			int temp;
			while ((temp = fin.read()) != -1) {
				fout.write(temp);
			};
			fout.flush();
			fout.close();
			fin.close();
			
			// 確認有執行成功
			System.out.println("OK: " + (System.currentTimeMillis() - start));
		} catch (Exception e) {
			// 執行失敗
			System.out.println("ERROR");
			System.out.println(e);
		}

	}

}
