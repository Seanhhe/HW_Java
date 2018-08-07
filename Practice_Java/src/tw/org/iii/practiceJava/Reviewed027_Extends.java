package tw.org.iii.practiceJava;

public class Reviewed027_Extends {
/*	Brad24 
 * 	
 */
	public static void main(String[] args) {
		Reviewed_Bike b1 = new Reviewed_Bike();
		Reviewed_Scooter s1 = new Reviewed_Scooter();
		
		System.out.println(b1.getSpeed());
		System.out.println(s1.getSpeed());
		
		/* s1 可以印出 bike的speed, 可是speed不是private嗎?
		 * s1 繼承Bike的方法 getSpeed--> 執行時是到父類別物件執行
		 * 當s1物件存在時, 其父類別早就存在
		 * s1的初始化是先進行其父類別的建構式, 再進行子類別中的建構式.
		 * 
		 */
		
		System.out.println("--------------");
		
		/*	多型 
		 * 
		 */
	}

}
