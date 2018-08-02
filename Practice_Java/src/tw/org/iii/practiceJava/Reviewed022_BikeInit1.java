package tw.org.iii.practiceJava;

public class Reviewed022_BikeInit1 {

	public static void main(String[] args) {
		/*	Brad21 20180729AM2
		 *	建立Bike物件
		 */
		

		
//		int[] a1 = new int[2];	//	陣列也是物件
//		System.out.println(a1);
//		
//		int b2 = 123;	//	在記憶體的位置
//		System.out.println(b2);
		
		Reviewed_Bike b1 = new Reviewed_Bike();
		System.out.println(b1);	// 顯示出陣列at記憶體的位置 (物件的值就是記憶體的位置-->傳值)
		System.out.println(b1.getSpeed()); 	// has a-->. b1擁有的speed b1.speed
		
		b1.upSpeed();
		b1.upSpeed();
		b1.downSpeed();
		System.out.println(b1.getSpeed());
		
		
		// 提升速度至10以上
		Reviewed_Bike b2 = new Reviewed_Bike();
		for (int i=1; i<10; i++) {
			b2.upSpeed();
		}
		System.out.println(b2.getSpeed());
		
		// 提升速度不合理的做法-->使用者可以存取?!
//		b2.speed = 10;
//		System.out.println(b2.speed);
		
		

	}

}
