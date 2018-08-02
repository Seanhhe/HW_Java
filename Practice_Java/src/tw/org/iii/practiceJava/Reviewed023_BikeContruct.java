package tw.org.iii.practiceJava;

public class Reviewed023_BikeContruct {

	public static void main(String[] args) {
		/*
		 * Brad22
		 * 物件的初始化-->建構式
		 * 
		 */
		Reviewed_Bike b1, b2;
		b1 = new Reviewed_Bike();
		System.out.println(b1.getSpeed());
		
		b2 = new Reviewed_Bike(1.4);
		System.out.println(b2.getSpeed());
		
		b2.upSpeed();
		System.out.println(b2.getSpeed());
		b2.upSpeed(20);
		System.out.println(b2.getSpeed());
	}

}
