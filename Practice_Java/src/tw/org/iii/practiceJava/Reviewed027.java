package tw.org.iii.practiceJava;

public class Reviewed027 {
/*	20180804AM2 Brad25 Lab27 建構式
 * 	
 * 	>任何一個類別都會有建構式
 * 	>因為任何一個類別都會有父類別
 *  >如果類別內沒有定義建構式, 就會使用他的父類別的無傳參數建構式, 作為他的預設建構式.
 *  >如果類別內有自己所定義的建構式, 就不再尋求父類別的無傳參數建構式
 */
	public static void main(String[] args) {
//		Reviewed0271 b1 = new Reviewed0271();
		Reviewed0271 b2 = new Reviewed0271(2);
//		Reviewed0271 b3 = new Reviewed0271(); // 如果該類別有自訂建構式, 父類別就不會給預設建構式.
		Reviewed0272 b4 = new Reviewed0272();
		
		Reviewed0271 b5 = new Reviewed0271(2);
		
		
		// 為什麼兩個都是false?
		System.out.println(b2.equals(b5)); // <--這裡的equals是Object的方法, 與String.equals不同
		System.out.println(b2 == b5);
		System.out.println(b2.isSame(b5));
		
	}

}




class Reviewed0271 {
	private int a;
	
	Reviewed0271(int a) {
//		super();//	<--呼叫父類別的建構式,產生父類別的物件實體(所以才能呼叫父類別的方法?). 只能在第一道敘述句 (預設會自動產生此敘述句)
		this.a = a;
		System.out.println("Reviewed0271");
	}
	
	// 改寫父類別的方法equals (快捷鍵: equ +alt+/)
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object) 
	 * Override改寫的存取修飾字需要大於或等於被改寫的父類別方法
	 * -->發揚光大
	 * 
	 */
	
//	@Override	// notation for compiler
//	public boolean equals(Object obj) {	// 存取修飾字要大於等於原被改寫的方法
//		return ((Reviewed0271)obj).getA() == a; //	(Reviewed0271)obj  強迫轉型
//	}
	
	public int getA() {	// 因為屬性a被封裝, 所以用public方法存取a
		return a;
	}
	
	// 不Override equals-->自創
	public boolean isSame(Reviewed0271 obj) {
		return this.getA() == a;
	}
}

/*
 * 	另建立一個Lab272並繼承Lab271, 為何不能繼承?
 * 	沒有建構式-->尋求父類別的建構式-->父類別為有參數建構式-->編譯失敗
 *  
 *  ! 任何物件只要在記憶體內存在, 其父類別以上的類別都會存在於記憶體內.
 *  	(祖宗八代都會在XD)
 *  	Java是透過建構式處理這部分.
 */

/*	建構式內容 20180804AM2
 * 	如果第一道敘述句沒有寫super()/this() --> 預設自動帶入super();
 * 	
 * 	如果寫了super()/super(參數);就不寫this
 * 	如果寫了this(); 就不寫super;
 */

class Reviewed0272 extends Reviewed0271 {
	Reviewed0272() {
//		super();	// 第一道敘述句如果不寫,其實有隱含super();在裡面
		super(3);	// super();永遠寫在建構式的第一道敘述句->先處理父類別的建構式. (父類別有傳參數建構式)
	}
	
	
}

class Reviewed0273 extends Reviewed0272 {
	
}