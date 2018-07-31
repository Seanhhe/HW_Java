package tw.org.iii.practiceJava;

public class Reviewed015 {
	
	public static void main(String[] args) {
		
		
		/*
		 * 	Brad14
		 * 	迴圈應用練習_質數作業檢查
		 * 	1~100標出質數
		 * 
		 * 	1. 先印出1~100
		 * 	2. 怎麼找質數?
		 * 	3. 用迴圈檢查每產出的數字是否是質數
		 * 	4. 建立boolean值預設是質數,判斷紀錄
		 * 	5. 利用三元運算式在為質數的值前面加上標記
		 * 	
		 * 	三元運算式--> boolean?true時要做的:false要做的
		 */
		
		
		
		long start = System.currentTimeMillis();	// 千分之一秒的現在時間 (timestamp)
		for (int i = 1; i <= 100; i++) {
			boolean isPrime = true;		// 要放在這裡, 下一個數字的判斷才會成立啊~
			for (int j = 2; j < i; j++) { 	// 依序檢查當下的i是否是質數
				if (i%j == 0) {
					// 除了自己與1之外還可以整除某數-->不是質數
					isPrime = false;
					break;
				}
			}
			System.out.print(i+ (isPrime?"*":" ") +"\t");
			if (i%10 == 0) {System.out.println();}
		}
		System.out.println(System.currentTimeMillis()-start); // 印出自啟動到結束的時間
		
		System.out.println("--------效率更好的版本(數字除二)---------");
		long start1 = System.currentTimeMillis();	// 千分之一秒的現在時間 (timestamp)
		for (int i = 1; i <= 100; i++) {
			boolean isPrime = true;		// 要放在這裡, 下一個數字的判斷才會成立啊~
			for (int j = 2; j < i/2; j++) { 	// 依序檢查當下的i是否是質數
				if (i%j == 0) {
					// 除了自己與1之外還可以整除某數-->不是質數
					isPrime = false;
					break;
				}
			}
			System.out.print(i+ (isPrime?"*":" ") +"\t");
			if (i%10 == 0) {System.out.println();}
		}
		System.out.println(System.currentTimeMillis()-start1); // 印出自啟動到結束的時間
		
		
	}
}
