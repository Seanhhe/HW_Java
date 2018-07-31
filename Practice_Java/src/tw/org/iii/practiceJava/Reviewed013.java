package tw.org.iii.practiceJava;

public class Reviewed013 {

	public static void main(String[] args) {
		// Brad13
		
		// for 迴圈
		
		//	無窮迴圈
		//	for (;;) {
		//		// 可做好事也可做壞事
		//		// 好事: 伺服器應用
		//		// 壞事: DOS攻擊
		//	}
		
		/* for 迴圈執行順序
		 * for (step1;step2/step5;step4) {
		 * 		step3-1
		 * }
		 * step3-2
		 * 
		 * step1: 進來後只做一次
		 * step2: 條件檢驗
		 * step3-1: 內容執行
		 * step3-2: 跳出後執行
		 * step4: 每跑完一圈做一次
		 * step5: 檢驗
		 * 
		 * =>如果沒寫就跳過不做, 預設為true.
		 * 
		 */
		
		// ------------範例一-----------
		for (int i = 0; i < 10 ; i++) { // int i的生命範圍只在{}
			System.out.print(i+ ";");
		}
		
		System.out.println();
		System.out.println("---範例二----");
		
		// ------------範例二------------
		int a = 0;
		for (;a <3;) {
			System.out.print("inside: "+ a+ ";");
			a++;
		}
		System.out.println("outside: " + a);
		
		System.out.println();
		System.out.println("---範例三----");
		
		// ------------範例三------------
		int b = 0;
		for (m1();b <10;) {
			System.out.print(b+ ";");
			b++;
		}
		System.out.println("\noutside: " + b);
		
		System.out.println();
		System.out.println("---範例四----");
		
		// -------------範例四---------------
		
		int c = 0;
		for (m1(); c < 12; System.out.println("*****")) {
			System.out.println(c++);
		}
		System.out.println("final: "+c);
		
		// -------------範例五(無窮迴圈)---------------
		System.out.println();
		System.out.println("---範例五(無窮迴圈)----");
		
		
		int d = 0;
		for (m1(); ;System.out.println("$$$$$")) {
			System.out.println(d++);
		}
	
	}
	
	public static void m1() {
		int a = 10, b=3;
		System.out.println("m1: "+ (a/b));
	}

}
