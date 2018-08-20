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
		
		Student s1 = new Student(60, 65, 70);
		System.out.println(s1.calAvg() + " & " + s1.calSum());
		
		try (ObjectOutputStream oout = 
				new ObjectOutputStream(new FileOutputStream("dir2/rev57.object"))) {
			// 輸出Student
			oout.writeObject(s1);
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
	
	public Student(int ch, int eng, int math) {
		this.ch = ch;
		this. eng = eng;
		this.math = math;
	}
	
	int calSum() {
		return ch + eng + math;
	}
	
	double calAvg() {
		return calSum()/3.0;
	}
}
