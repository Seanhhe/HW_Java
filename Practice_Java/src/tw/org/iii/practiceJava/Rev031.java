package tw.org.iii.practiceJava;

/**20180805AM1 Brad29 Rev
 * 	
 * 	宣告, 轉型, 呼叫
 * 
 * 	繼承&物件型別轉換
 * 	-> 宣告為某類別, 僅能呼叫該類別的方法.
 * 	-> 如何執行須看用何種類別實作
 * 	-> 呼叫不到就用不到更別說執行
 * 	
 * 	-> 假設001原本就是以B類別產生, 但是宣告為A類別, AB類別關係為父子, 故當強制轉型成B類別時, 原本不能呼叫的B類別方法就可以呼叫, 且可以執行.
 * 
 * 	-> 兩類別為直系血親: 編譯時期可過, 但不見得能執行
 * 	-->反之無法編譯
 * 
 * 
 * 	instanceof
 * 	->判斷骨子裡是否為該物件實體
 * 	-->實際應用分享
 * 		聯絡人內有分客戶/供應商/...
 * 		父類別都是聯絡人, 子類別是客戶...
 * 		先宣告為聯絡人
 * 		要使用客戶時=> 強制轉型成客戶
 * 	
 */


public class Rev031 {

	
	public static void main(String[] args) {
		Rev0311 obj1 = new Rev0311();
		obj1.m1();
		
		/** 為什麼obj2只能宣告m1();
		 * 	->宣告為什麼就只能呼叫其宣告下的方法
		 * 		->但是, 由於obj2是Rev0311()實作
		 * 		->所以呼叫的m1();是以Rev312的方法執行
		 * 	
		 * 	宣告為車子 但是是保時捷 XD
		 * 	但是你不知道它是保時捷, 所以你不知道它有turbo XD
		 */
		
		// 宣告為311 但骨子裡是312
		Rev0311 obj2 = new Rev0312();
		obj2.m1();
		
		
		// Rev0312 obj3 = obj2; // 父類別物件無法指定給子類別宣告
		
		Rev0312 obj3 = (Rev0312)obj2; //強制轉型
		obj3.m1();
		obj3.m2();
		System.out.println(obj2 == obj3); // 骨子裡真的是一樣的東西
		
		// Rev0312 obj4 = (Rev0312)obj1; // Runtime Exception (可編譯但不能執行)
		
		Rev0314 obj5 = new Rev0314();
		// Rev0312 obj = (Rev0312)obj5; // compiler error 編譯失敗: 因為非父子類別
		
		/**20180805AM2 instanceof
		 * ->比較骨子裡是哪種物件實體
		 */
		
		if (obj1 instanceof Rev0312) {
			Rev0312 obj4 = (Rev0312)obj1;
		}else {
			System.out.println("XX");
		}
		
		// obj1 是不是 Rev0311的物件實體
		System.out.println(obj1 instanceof Rev0311);
		System.out.println(obj1 instanceof Rev0312);
		
	}

}

/**class structure
 * 
 * Object
 * -->Rev0311
 * 	-->Rev0312
 * 		-->Rev0313
 * 
 * -->Rev0314
 * 
 *
 */



class Rev0311 {
	void m1() {
		System.out.println("Rev0311: m1()");
	}
}

class Rev0312 extends Rev0311 {
	@Override
	void m1() {
		System.out.println("Rev0312: m1()");
	}
	
	void m2() {
		System.out.println("Rev0312: m2()");
	}
}

class Rev0313 extends Rev0312 {
	void m3() {
		System.out.println("Rev0313: m3()");
	}
}

class Rev0314 {
	
}