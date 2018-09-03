package tw.org.iii.bookPractice;

public class chapter3homework {

	public static void main(String[] args) {
		//	1.	如果有 m, n 兩個變數, 分別儲存 1000, 495 兩個值, 請使用程式算出最大公因數.
//		int m = 1000;
//		int n = 495;
//		int cd = 0;
//		// 窮舉法
//		for (int i=1; i < m/2; i++) {
//			int t = m%i;
//			int g = n%i;
//			if (t==0 && g ==0) {
//				cd = i;
//			}
//		}
//		System.out.println(cd);
//		
//		// 輾轉相除法
//		int h = chapter3homework.gcd(m, n);
//		System.out.println(h);
		
		//	2.	在三位數的整數中, 例如153可以滿足 1^3 + 5^3 + 3^3 = 153, 這樣的阿姆斯壯數, 試以程式找出所有三位數的阿姆斯壯數.
//		int j = (153/1) % 10;	// 個位數
//		int k = (153/10) % 10;	// 十位數
//		int g = (153/100) % 10; // 百位數
//		System.out.println(""+j+k+g);
		
		for (int i = 100; i<1000; i++) {
			int a = (i/100) % 10; // 百位數
			int b = (i/10) % 10;	// 十位數
			int c = (i/1) % 10;	// 個位數
			
			int d = a*(a*a)+ b*(b*b)+ c*(c*c);
			
			if (d == i) {
				System.out.println(i);
			}
			
		}
	}
	
	static int gcd(int a, int b) {
		//	輾轉相除法
		if (b == 0) {
			return a;
		}
		return a%b == 0?b:gcd(b, a%b);
	}
	
	
}
