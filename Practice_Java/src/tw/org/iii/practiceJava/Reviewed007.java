package tw.org.iii.practiceJava;

public class Reviewed007 {

	public static void main(String[] args) {
		// 分數及格或不及格
//		int score = 51;
//		
//		if (score >= 60) {
//			System.out.println("PASS");
//		}else {
//			System.out.println("FAILED");
//		}
				
		//	亂數產生分數並分級
		//	Math.random()-->0.0~1.0 (Returns a double value with a positive sign, greater than or equal to 0.0 and less than 1.0.)
		
		
		int rscore = (int)(Math.random() * 101);
//		System.out.println(rscore);
		
		if (rscore >= 90) {
			System.out.println(rscore);
			System.out.println("A");
		}else {
			if (rscore >= 80) {
				System.out.println(rscore);
				System.out.println("B");
			}else {
				if (rscore >= 70) {
					System.out.println(rscore);
					System.out.println("C");
				}else {
					if (rscore >= 60) {
						System.out.println(rscore);
						System.out.println("D");
					}else {
						System.out.println(rscore);
						System.out.println("FAILED");
					}
				}
			}
		}
		
		//	為什麼要乘與常數101?
		//	random-->0.0~1.0
		//	當*100後強制轉型完後, 最多只有到99 (99.99999--強制轉型->99)
		//	當*101-->101.0取整數100.9999--> 100
		
		//	Java其實沒有if...else if, 是縮排簡寫後才會有好像有if...else if的錯覺

	}

}
