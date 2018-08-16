package tw.org.iii.practiceJava;
/*	類別
 * 
 */
import p1.Rev01;

public class Rev042 {

	public static void main(String[] args) {
		Rev01 obj1 = new Rev01();
		
		// 名字相同但import只能寫一個, 故須把完整檔名寫出p2.Rev01
		p2.Rev01 obj2 = new p2.Rev01();
		
		// 因為存取修飾字: p2.Lab02 非public 只能由相同Package的類別來存取
		// p2.Lab02 obj2 = new p2.Lab02();
	}

}
