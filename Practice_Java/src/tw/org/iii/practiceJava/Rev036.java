package tw.org.iii.practiceJava;
/**	20180805PM1 繼承觀念的延伸
 * 	繼承表現多型
 * 	A類別透過extends父類別  可以 表現出多型(Override)
 * 	
 *	abstract 抽象 (修飾字)
 *	-->抽象類別
 *	--->強迫子類別一定要表現多型
 *	--->如果類別裡有抽象方法, 必須宣稱自己是抽象類別.
 *	--->也可以宣稱自己是抽象類別, 但內容無抽象方法
 *	--->一旦宣告為抽象類別, 該類別無法"直接"建立物件實體
 *	--->final類別不能為抽象類別/ final不會有子類別(多型)
 *	--->抽象類別也一定有建構式
 *	
 *	-->抽象方法
 *	--->有定義而無實作的方法
 *	--->前面一定要加上abstract修飾字
 */
public class Rev036 {

	public static void main(String[] args) {
		// Rev0361 obj1 = new Rev0361(); // 一旦宣告為抽象類別, 該類別無法直接建立物件實體
		Rev0361 obj1 = new Rev0362(); // 利用362實作 但宣告為361
		Rev0361 obj2 = new Rev0363();
		
		obj1.m2();	// 執行的是本體
		obj2.m2();	// 執行的是本體
		
	}

}

abstract class Rev0361 {
	void m1() {
		System.out.println("Rev0361: m1()");
	}
	
	// 抽象方法
	abstract void m2();
}

class Rev0362 extends Rev0361 {	// 繼承Rev0361抽象類別,必須實作m2, 如果沒有實作, 可以繼續抽象
	void m2() {	// 實作抽象方法m2
		System.out.println("Rev0362: m2()");
	}
}

class Rev0363 extends Rev0361 {
	void m2() {
		System.out.println("Rev0363: m2()");
	}
}

abstract class Rev0364 extends Rev0361 {	// 若不想實作父類別的抽象方法, 可以繼續抽象
	void m3() { // 也可以有自己的實作
		System.out.println("XX");
	}
}