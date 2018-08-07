package tw.org.iii.practiceJava;

public class Reviewed026_Extends {
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
			
			/*	多型 (宣告什麼就是什麼, 但是執行要看本體是甚麼)
			 * 	s3 宣告為Reviewed_Bike 就是 Reviewed_Bike
			 * 	但是! 執行動作是看操作的本體是甚麼-->s3的本體是Reviewed_Scooter物件實體
			 * 	所以, s3 可以呼叫 Reviewed_Bike的方法, 但是執行面要看Reviewed_Scooter
			 * 	
			 * 	一台車--->法拉利
			 * 	是台車-->加速不同
			 * 	=>多型
			 */
			
			Reviewed_Bike s3 = new Reviewed_Scooter();
			s3.upSpeed();
			s3.upSpeed();
			System.out.println(s3.getSpeed());
			
			System.out.println("--------------");
			
			/*	Overload & Override (重載與重新定義)
			 * 	
			 * 	Overload-->相同方法名稱 參數不同
			 * 	
			 * 	Override-->相同方法名稱相同參數, 實作內容不同(發揚光大)
			 * 	
			 * 
			 */
			
			Reviewed_Bike b3 = new Reviewed_Bike();
			Reviewed_Scooter s4 = new Reviewed_Scooter();
			b3.upSpeed();
			s4.upSpeed();
			System.out.println(b3.getSpeed());
			System.out.println(s4.getSpeed());
			s4.changeGear(3); // 發揚光大
			s4.upSpeed(); // override的方法
//			b3.changeGear 失敗 Bike裡沒有這個功能
			
			System.out.println(s4.getSpeed());
			
		}
}
