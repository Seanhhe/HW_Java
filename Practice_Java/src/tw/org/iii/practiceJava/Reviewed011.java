package tw.org.iii.practiceJava;

public class Reviewed011 {

	public static void main(String[] args) {
		// 
		byte a = 10, b = 100;
		final byte c = 100;
		
		final byte d; 
		d = 123;
//		d = 11; // d已給final 不可再修改其值
		
		switch (a) {
		case 1:
			System.out.println("A");
			break;
		default: // default不一定要放最後
			System.out.println("我default啦");
//		case b: // case值必須是常數值 --> 編譯錯誤
//			System.out.println("B");
//			break;
		case c: // 這裡是因為 c變數已被宣告為final
			System.out.println("C");
			break;
		case c-90: // 原因同上, 因c已被宣告為final視為常數
			System.out.println("c-90");
//			break; // 在switch區塊裡是最後面的break, 可省略.
//		case d: // 有宣告final阿 為什麼不行? --> 因為變數宣告時沒有先給值, 後面給的case不接受
//			System.out.println("D");
//			break;
//		case 1000: // case值已經超過byte範圍
//			System.out.println("E");
//			break;
		}

	}

}
