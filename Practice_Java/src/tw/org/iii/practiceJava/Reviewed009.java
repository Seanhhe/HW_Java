package tw.org.iii.practiceJava;

public class Reviewed009 {

	public static void main(String[] args) {
		// Reviewed 20180731AM
		
		/*
		 * if...else --> 算是一種二分法 (Boolean[true/false])
		 * if 條件式中使用 &&, || 的差異, 執行或不執行
		 * a++, --a -->differences
		 */
		
		/*
		 * && --> 兩者為真才為真
		 * || --> 其中一者為真即為真
		 * 	程式執行順序為由左至右
		 */
		
		
		// && 兩者都會執行的情況; a++ => 先判斷a值才會執行++運算
		// 第一個為真, 第二個也要判斷
		int a = 12, b = 3;
		
		if (a++ >= 12 && b-- <= 3) {
			System.out.println("OK_1:a = "+a+ "; b = " + b);
		}else {
			System.out.println("Wrong_1:a ="+a+"; b = "+ b);
		}
		
		System.out.println("--------------");
		
		
		// [Practice] && the first condition is wrong. The second condition will not be execute.
		
		int a1 = 12, b1 = 3;
		if (a1++ < 12 && b1-- <= 3) {
			System.out.println("OK_try1:a1 = "+a1+ "; b1 = " + b1);
		}else {
			System.out.println("Wrong_try1:a1 = "+a1+ "; b1 = " + b1);
		}
		
		System.out.println("--------------");
		
		//	使用||-->由左到右執行, 先執行的如果為true, 後面的跳過不執行, 直接進到判斷結果
		
		int c = 12, d = 3;
		if (c++ >= 12 || b-- <= 3) { 	// b--不會執行
			System.out.println("OK_2:c = "+c+ "; d = " + d);
		}else {
			System.out.println("Wrong_2:c = "+c+ "; d = " + d);
		}
		
		System.out.println("--------------");
		
		//	--e => 先執行運算再比較 [&&]
		
		int e = 12, f = 3;
		if (--e <= 12 && ++f > 3) {
			System.out.println("OK_3:e = "+e+ "; f = " + f);
		}else {
			System.out.println("Wrong_3:e = "+e+ "; f = " + f);
		}
		
		System.out.println("--------------");
		
		//	--g => 先執行運算再比較 [||]
		
		int g = 12, h = 3;
		if (--g <= 12 || ++h > 3) {
			System.out.println("OK_4:g = "+g+ "; h = " + h);
		}else {
			System.out.println("Wrong_4:g = "+g+ "; h = " + h);
		}
		
		System.out.println("--------------");
		
//		| / & OR/ AND-->二進位運算
		
//		^ --> XOR 二進位運算
		
		System.out.println("--------------");
		
//		JAVA 兩種結尾方式=> 分號/ 大括號的程式區塊
		
			if (a >=10);
			{
				// 程式區塊
				System.out.println("III");
			}
		
	}

}
