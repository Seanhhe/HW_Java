package tw.org.iii.practiceJava;

public class Reviewed024_TWid {

	public static void main(String[] args) {
		/*
		 * 
		 */
		
//			static 練習
//		Reviewed_TWid.checkId("123");
////		Reviewed_TWid.m1("123");
//		
//		// 必須擁有物件才可以執行m1方法(沒有static)
//		Reviewed_TWid id1 = new Reviewed_TWid();
//		id1.m1("AAA");
//		id1.checkId("1123");
		
		//	假設使用者使用檢查身分證程式
		if (Reviewed_TWid.checkId("A123456789") == true) {
			System.out.println("OK");
		}else {
			System.out.println("NO");
		}
		
		
		// 字串處理API練習-->為了第一個英文字判斷
		
		// 英文字串長度
		String a = "A123456789";
		System.out.println(a.length());
		
		//	中文字串長度
		String b = "資策會";
		System.out.println(b.length());
		
		// substring (回傳一個新物件)
		String c = "abcdefg";
		System.out.println(c.substring(0, 1));
		// charAt(index);
		System.out.println(c.charAt(0));
		
		// .indexOf
		String c1 = "A123456789";
		String c2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String c3 = c1.substring(0, 1);	//抽出第一個字
		
		if (c1.length() == 10) {
			if ( c2.indexOf(c3) >= 0) {	// 比對字串,c3是否有在c2裡 (沒有會回傳-1)
				System.out.println("OK1");	
			}
 		}else {	
			System.out.println("False");
		}
		
		// .matches + [正規表示法]
		if (c1.matches("^[A-Z][12][0-9]{8}$")) {
			System.out.println("Ya!");
		} else {
			System.out.println("NOOOO");
		}
		
		String d = "0912123456";
		if (d.matches("^09........$")) {
			System.out.println("PHONE");
		}else {
			System.out.println("ORZ");
		}
		
		// 課外練習: 如何檢查Email?
		
		System.out.println("--------------------");
		
		if (Reviewed_TWid.checkId("A123456789")==true) {
			System.out.println("ID correct");
		}else {
			System.out.println("ID ng");
		}
		
		/*
		 * 	.concat() --> 回傳一個新的字串, 舊字串+傳入的新字串
		 * 	這個方法呼叫重點在return
		 * 	字串內容一旦給定/該物件一旦形成, 該字串不能更改.
		 * 	可運用string buffer
		 * 	指向新的記憶體位址(含舊字串與新字串)
		 * 	原記憶體位址沒人指向
		 * 	
		 * 
		 * 	要擁有物件實體
		 * 	1. new 出新物件
		 * 	2. 透過其他static方法傳回物件實體
		 * 
		 * 	
		 */
		
		String e = "0912123456";
		System.out.println(e.concat("abc"));
		
		// 測試createId
		Reviewed_TWid id1 = Reviewed_TWid.createTWid("A123456789");
		System.out.println(id1 == null);
		
		System.out.println("---四個建構式測試&地區性別顯示 (共五種方法)---");
		
		// 測試四個建構式 [五種方法]
		Reviewed_TWid id2 = new Reviewed_TWid(false,15);
		System.out.println(id2.getId()+" "+id2.gender()+" "+id2.showArea());
		
		Reviewed_TWid id3 = new Reviewed_TWid(true);
		System.out.println(id3.getId()+" "+id3.gender()+" "+id3.showArea());
		
		Reviewed_TWid id4 = new Reviewed_TWid(19);
		System.out.println(id4.getId()+" "+id4.gender()+" "+id4.showArea());
		
		Reviewed_TWid id5 = new Reviewed_TWid();
		System.out.println(id5.getId()+" "+id5.gender()+" "+id5.showArea());
		
		Reviewed_TWid id6 = Reviewed_TWid.createTWid("A123456789");
		System.out.println(id6.getId()+" "+id6.gender()+" "+id6.showArea());
		
	}
}
