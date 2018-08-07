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
		Reviewed0271 b3 = new Reviewed0271();
	}

}

/*
 *  另建立一個Lab272並繼承Lab271, 為何不能繼承?
 *  沒有建構式-->尋求父類別的建構式-->父類別為有參數建構式-->編譯失敗
 *  
 *  ! 任何物件只要在記憶體內存在, 其父類別以上的類別都會存在於記憶體內.
 *  	(祖宗八代都會在XD)
 *  	Java是透過建構式處理這部分.
 */


class Reviewed0271 {
	private int a;
	
	Reviewed0271(int a) {
		this.a = a;
		System.out.println("Reviewed0271");
	}
}

class Reviewed0272 extends Reviewed0271 {
	Reviewed0272() {
		super();
		super(3);
	}
}