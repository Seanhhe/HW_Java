package tw.org.iii.practiceJava;

public class Reviewed012 {

	public static void main(String[] args) {
		// Switch
		
//		char a = 97;
//		short a = 97;
//		int a = 123;
		
//		long a = 123; // long 不行~
//		float a = 12; // float 不行~
//		double a = 123; // double 也不行
		
		byte a = 97;
		
		// 重點: "基本"型態中, switch只能用byte, int, short, char.
		// float, double, long, boolean 都不可以用!
		
		switch (a) {
		case 97:
			System.out.println("a");
			break;
		case 'A':
			System.out.println("A");
			break;
		case 10:
			System.out.println("10");
			break;
//		case '資':	// 因為是byte所以有錯誤--> 資的16進位超出byte範圍
//			System.out.println("資");
//			break;
		default:
			System.out.println("default");
			break;
		
		}
		
		System.out.println("-----範例二(類別/物件型別的字串可以比)-----");
		
		// 類別型態的字串也可以進行比對! (認證版本考六的沒有)
		
		// BTW 字串跟字元在JAVA中的關係分得很開得哦XD
//		String a = 'a'; //指定字元(單引號)給字串會編譯失敗
		
		
		String b = "Hi";
		
		switch (b) {
		case "Hello":
			System.out.println("Hi!");
			break;
		case "Hi":
			System.out.println("Hello!");
			break;
			default:
				System.out.println("Default2");
		}
		

	}

}
