package tw.org.iii.practiceJava;

/*	20180818PM2 Brad70 JAVA資料結構
 * 	
 * 	基本型別 int short byte
 * 	
 * 	大寫 Byte, Integer, Double,... 這是物件
 * 
 * 	Wrapper
 * 
 */

public class Rev072_Wrapper {

	@SuppressWarnings("deprecation") // for Integer
	public static void main(String[] args) {
//		Byte i = new Byte("20");
//		System.out.println(i);
		
		int a = 10;
		Integer b = new Integer(10); // 畫線仍可以使用但編譯器建議加上宣告
		Integer c = new Integer("10");
		Integer d = 10;	// 寫法與字串雷同 => auto-boxing 自動封箱
		
		/*	為什麼可以相加? 不是物件嗎?
		 * 	--> unWrapper; => auto-Unboxing
		 * 	-->	b 仍然是Integer物件
		 */
		
		System.out.println(a+3);
		System.out.println(b+4);
		System.out.println(d+6); // unWrapper; => auto-Unboxing
		System.out.println(a==b); // 與基本型別比較 => auto unboxing
		System.out.println(b.equals(a));  // 物件可以呼叫equals(obj) (a被auto boxing)
		System.out.println(b==c);  // 為什麼這裡會是false; 這裡比較的是物件
		System.out.println(c==a); // 與常數比較 	=> 自動拆箱
		System.out.println(a==d); // 與常數比較 	=> 自動拆箱
		System.out.println(c==d); // 為什麼這裡會是false; 這裡比較的是物件
	}

}
