package tw.org.iii.practiceJava;

public class Reviewed_99 {

	public static void main(String[] args) {
		// 迴圈應用練習_九九乘法表
		
		// 2X1=2 3X1=3 4X1=4
		// 2X2=4 3x2=6 4x2=8
		
		
		/*
		 *  解析:
		 *  1. 先想console如何印出-->由左至右
		 *  2. 先想辦法印出第一列 
		 *  3. 帶入第一層迴圈
		 *  4. 如何產生九列(乘上1~9)
		 *  5. 帶入第二層迴圈
		 *  6. 如何每四個換列
		 *  7. 帶入第三層迴圈
		 *  8. 變數怎麼改?
		 *  9. 注意! 每個常數都要有意義
		 *  
		 */
		
		
		System.out.println("-------九九乘法表-------");
		
		for (int k=0 ; k<4; k++) { // 跑兩大列
			for (int y = 1; y <= 9; y++) {	// 列
				for (int x = 2; x <=5; x++) { // 行
					int newc = x+(k*4); // 分四格
					int r = newc*y;
					System.out.print(newc+" x "+y+ " = "+r+"\t");
					
				}
				System.out.println();
			}
			System.out.println("---------------------");
		}
				
		
		

	}

}
