package tw.org.iii.practiceJava; //執行環境所在的實體"路徑"

/*20180729AM 物件 Bike
 * 以Bike為例建立物件
 * 這個檔案是建立Bike類別
 * 
 * Java的字串是物件 擁有很多方法
 * 
 * */

public class Reviewed_Bike {
	
	//	宣告屬性 (宣告private限制其存取範圍)
	double speed;
	
	//	建構式
	Reviewed_Bike() { // 建構式的初始化.
		System.out.println("BIKE Initiate");
	}
	
	Reviewed_Bike(double speed) {
		this.speed = speed;		// this.speed 本類別的物件實體的速度
	}
	
//	Reviewed_Bike(int inputSpeed) {
//		this.speed = inputSpeed;
//	}
	
	//	方法
	void upSpeed(){	//
		this.speed = this.speed==0?1:this.speed*1.4;
	}
	
	// 變更加速度(變速器) [同名異數]
	void upSpeed(int gear) {
		this.speed = this.speed==0?1:this.speed*1.4*gear;
	}
	
	void downSpeed() {
		this.speed = this.speed==1?0:this.speed*0.5;
	}
	
	//	宣告傳回時要帶型別
	double getSpeed() {	//	double 宣告回傳的值的類別
		return this.speed;
	}
	
	
}
