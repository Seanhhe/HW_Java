package textbookPractice;

public class ch3hw1 {

	public static void main(String[] args) {
		// Chapter 3 課後練習
		// 以程式算出 1000, 495 之間的最大公因數
		// 輾轉相除法?
		
		int m = 1000;
		int n = 495;
		//	最大公因數為5
		
		int b = m / n;
		int a = m % n;
		
		if (a < n) {
			int d = n / a;
			int c = n % a;
			System.out.println(d+"...."+c);
		}
		
		
		System.out.println(b+"...."+a);
	}

}
