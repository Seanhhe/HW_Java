package tw.org.iii.practiceJava;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*	20180812PM1 序列化 (物件輸出) Brad55
 * 	ObjectOutputStream
 * 	
 * 	物件的輸入輸出
 * 	其屬性具有意義
 * 	
 * 	
 * 	物件的序列化
 * 	某物件被序列化之前, 需要宣告該物件類別擁有可序列化的介面
 * 	(序列化介面沒有任何實作, 僅需宣告即可)
 * 
 * 	Bike物件--序列化-->Object
 * 	
 * 	> 如果物件中有屬性不想讓他序列化\
 */
public class Rev057_Serial {

	public static void main(String[] args) {
		// 物件二 腳踏車
		Reviewed_Bike b1 = new Reviewed_Bike();
		b1.upSpeed();b1.upSpeed();b1.upSpeed();
		System.out.println(b1.getSpeed());
		
		// 物件一 學生
		Student s1 = new Student(60, 65, 70, b1);
		// 學生的腳踏車的速度 (物件擁有物件)
		s1.bike.upSpeed(2);
		System.out.println(s1.calAvg() + " & " + s1.calSum());
		System.out.println(s1.bike.getSpeed());
		
		
		
		
		try (ObjectOutputStream oout = 
				new ObjectOutputStream(new FileOutputStream("dir2/rev57.object"))) {
			// 輸出Student
			oout.writeObject(s1);
			// 輸出第二個物件
			oout.writeObject(b1);
			System.out.println("Save OK");
		}catch (Exception e) {
			System.out.println(e);
		}

	}

}

// 要被輸出的物件
class Student implements Serializable {
	// 要執行序列化的物件,需要宣告實作序列化界面
	int ch, eng, math;
	
	// 讓學生擁有腳踏車物件 Reviewed_Bike
	Reviewed_Bike bike;
	
	public Student(int ch, int eng, int math, Reviewed_Bike bike) {
		this.ch = ch;
		this. eng = eng;
		this.math = math;
		this.bike = bike;
	}
	
	int calSum() {
		return ch + eng + math;
	}
	
	double calAvg() {
		return calSum()/3.0;
	}
}
