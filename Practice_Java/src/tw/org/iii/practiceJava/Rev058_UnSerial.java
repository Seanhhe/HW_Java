package tw.org.iii.practiceJava;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/*	20180812PM2 Brad56 解序列化
 * 	
 * 	讀取物件, 每個東西都是有意義的.
 * 	較為常用
 * 
 * 	序列化的目的在於,把物件變成資料.
 * 	可以透過網際網路將物件傳遞到遠端.
 * 	
 * 	物件重要的東西是屬性
 * 	序列化其實主要是序列其屬性資料
 * 
 * 	多個物件也可以解序列化, 但要注意其順序也需和序列化時一樣
 */

public class Rev058_UnSerial {

	public static void main(String[] args) {
		try (ObjectInputStream oin = new ObjectInputStream(
					new FileInputStream("dir2/rev57.object"))) {
			
			Object obj1 = oin.readObject(); // 在記憶體中建立物件實體,儲存讀出的物件
			Student s1 = (Student)obj1; // 把讀出的物件轉型回原形
			System.out.println(s1.calAvg()+":"+s1.calSum());
			
			// 學生的腳踏車 (物件中的物件)
			System.out.println(s1.bike.getSpeed());
			
			
			// 物件二腳踏車
			Reviewed_Bike b1 = (Reviewed_Bike)oin.readObject();
			System.out.println("腳踏車:"+ b1.getSpeed());
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
