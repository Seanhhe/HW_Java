package tw.org.iii.practiceJava;

public class Reviewed002 {

	public static void main(String[] args) {
		// int
		int a1 = 10, a2 = 3;
		int a3 = a1 + a2;
		System.out.println(a3);
		
		int a4 = a1 - a2;
		System.out.println(a4);
		
		int a5 = a1 * a2;
		System.out.println(a5);
		
		// 答案應該要是3.3333, 但是int型別在運算中已是用整數相除(int/int), 故產出一樣是整數.
		int a6 = a1 / a2;
		System.out.println(a6);
		
		//	int a7 = a1 / 3.0; 3.0是浮點數;
		
		
		//	為什麼這樣就不行?
		//	byte, short, int 之間運算, 皆會被視為是int (如果要byte需要強制轉型)
		byte b1 = 10, b2 = 3;
		byte b3 = (byte)(b1 / b2);
		System.out.println(b3);
		//	byte, short, int, long 之間運算, 皆會被視為是long
		
		//	常數運算
		byte b4 = 120 + 3;
		System.out.println(b4);
		
		//	b1是變數, 對於編譯器來說是變動值, 無法與常數運算. 
		//	byte b4 = b1 + 3;
		
		//	位元運算 (byte的範圍: -128~127)
		byte b5 = 127;
		b5++;
		System.out.println(b5); //	-128
		
		b5--;
		System.out.println(b5); //	127
		
		b5+=2;
		System.out.println(b5);
		
		b5-=2;
		System.out.println(b5);
		
		byte b6 = (byte)(127 + 5);
		System.out.println(b6);
		
		// *=, /=
		
	}

}
