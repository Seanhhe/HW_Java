package textbookPractice;

public class ch3hw1 {

	public static void main(String[] args) {
		// Chapter 3 課後練習
		// 以程式算出 1000, 495 之間的最大公因數
		// 輾轉相除法?
		
		int m = 1000;
		int n = 495;
		
		int b = m / n;
		int a = m % n;
		
		
		System.out.println(b+"...."+a);
	}

}
