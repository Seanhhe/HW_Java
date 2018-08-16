package tw.org.iii.practiceJava;
/*	0811AM2 Brad41 例外 Reviewed
 * 	
 * 	樹狀架構:
 * 	Throwable (可拋出的物件) [java.lang.Throwable]
 * 		|--Error (可能是硬體上的錯誤等, 無法處裡.)
 * 		|--Exception (軟體上可處理的狀況)
 * 			|--RuntimeException (unchecked exception 執行階段發生的)
 * 			|--other exception (checked exception 需要事先檢查/處理的)
 * 	
 * 	E.g. 衝墾丁發生車禍(例外出現)-->報警(處理)-->處理完沒事繼續前往目的地(繼續執行)
 */
public class Rev043_Except {

	public static void main(String[] args) {
		
		/*	編譯通過,但是執行後發生例外 java.lang.ArithmeticException.
		 *	=> is a RuntimeException
		 */
		int a = 10, b = 0;
		//int c = a / b;
//		System.out.println(c); 
		
		/*	陣列Index範圍 int -->編譯可過
		 * 	但是 拋出ArrayIndexOutOfBoundsException
		 */
		int[] d = new int[3];
		// System.out.println(d[3]);
		
//		int a = 10, b = 3;
//		int c = a / b;
//		System.out.println(c); // 成功執行
//		// System.out.println(d[3]); // 拋出例外
//		System.out.println("GG");	// 程式提前終止 所以沒有執行
		
//		try {
//			System.out.println(d[3]);
//		} catch (ArrayIndexOutOfBoundsException e) {
//			// 捕捉到例外後的處理方法 (沒寫就是不處裡)
//			// 處理完後程式繼續執行
//			System.out.println("有問題哦");
//		}
//		System.out.println("GG");
		
//		try {
//			System.out.println(d[3]);
//		} catch (ArithmeticException e) {
//			// 預設要抓的例外非實際發生的-->抓不到
//			System.out.println("有問題哦");
//		}
//		System.out.println("GG");
		
		
//		try {
//			System.out.println("Before");
//			System.out.println(d[13]); 
//			System.out.println("After"); // 這句並沒有執行, 因為前一句有例外產生(有狀況)直接跳到catch
//		} catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println("有狀況1");
//		} catch (ArithmeticException e) {
//			// 增加其他例外條件, 讓程式一個一個判斷
//			System.out.println("有狀況2");
//		}
//		System.out.println("END");
		
		
		
		try {
			b = 0;
			int c = a / b;
			System.out.println(c); // 這裡先有狀況就先拋出
			System.out.println(d[13]); // 前面有狀況, 所以這句根本沒執行, 雖然他也有狀況
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("有狀況1");
		}
		catch (ArithmeticException e) {
			System.out.println("有狀況2");
		}
		System.out.println("END");
		
		/*	前面練習中的例外關係圖
		 * 	Exception
		 * 	|-->RuntimeException
		 * 		|--> ArithmeticExcept
		 * 		|--> I..
		 * 			|-->Array
		 * 	catch的順序
		 * 	-->如果非直系血親=沒差
		 * 	-->若為直系血親-->子類別(細部處理)要放在父類別上面
		 */
		
		try {
			int c = a / b;
			System.out.println(c); // 這裡先有狀況就先拋出
			System.out.println(d[13]); // 前面有狀況, 所以這句根本沒執行, 雖然他也有狀況
		}catch (ArithmeticException e) { 
			System.out.println("有狀況1");
		}
		catch (RuntimeException e) { 
			// 除了數學以外都由這個接住, 視情況也可以全都給他接
			System.out.println("有狀況2");
		}
		System.out.println("END");
		
//		try {
//			int c = a / b;
//			System.out.println(c); // 這裡先有狀況就先拋出
//			System.out.println(d[13]); // 前面有狀況, 所以這句根本沒執行, 雖然他也有狀況
//		} catch (RuntimeException e) { 
//			// 除了數學以外都由這個接住, 視情況也可以全都給他接
//			System.out.println("有狀況2");
//		}
//		catch (ArithmeticException e) { 
//			// 比RuntimeE小 所以接不到
//			System.out.println("有狀況1");
//		}
//		System.out.println("END");
		
		
		
		
		//-------------------------------------------
		/*	補充(與exception觀念無關): 
		 * 	浮點運算中的0並不是真的0, 而是非常接近0的數.
		 */
//		double a = 10, b = 3;
//		double c = a / b;
//		System.out.println(c);
//		double d = 0;
//		double e = 10 / d;
//		System.out.println(e);
//		double f = 0, g =0;
//		double h = f / g;
//		System.out.println(h);
		
	}
	
	
}
