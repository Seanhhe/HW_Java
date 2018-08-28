package tw.org.iii.practiceJava;

/*	20180825AM1 Brad79 Thread 
 * 	執行緒的另一個議題
 * 	=> 執行過程中插入另外一個執行緒 => join
 * 	
 * 	run & join 差異
 * 	run => 循序執行
 * 	join => 可以是同一執行緒內也可能是兩個不同執行緒 讓他插隊
 */

public class Rev081_Thread {

	public static void main(String[] args) {
		Rev811 obj1 = new Rev811("A");
		obj1.start();
		
		try {
			Thread.sleep(1000);
			// main thread 睡一秒
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		// 大於等於1秒之後才會到這裡
		Rev811 obj2 = new Rev811("B");
		obj2.start(); // 不代表馬上執行 只代表進到Run Pool
		
		System.out.println("OK1");
		
		// 插入obj2在Main thread下
		try {
			// 在A執行緒中呼叫B執行緒.join=>插入到A中
			obj2.join();
			// obj2.join(2000); // 只join兩秒, 兩秒後又是三條緒在跑
			// OK2最後才被執行
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println("OK2");
	}

}

class Rev811 extends Thread {
	String name;
	public Rev811(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		/*	A原本寫法是把try catch寫在迴圈內
		 * 	B另一寫法是反過來將迴圈寫在try catch內
		 * 	有何差異? (結構)
		 * 	或是說發生例外時要break
		 * 	A 與 B 的差異? 
		 * 	=> A: 發生例外時該次拋出例外但還會繼續迴圈
		 *	=> B: 發生例外時會直接拋出並跳離迴圈
		 */
		
//		for (int i=0; i < 10;i++) {
			// A
//			System.out.println(name + " : " + i);
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				System.out.println(e);
//			}
//		}
		
//		try {
//			// B
//			for (int i=0; i < 10;i++) {
//				System.out.println(name + " : " + i);
//				Thread.sleep(500);
//			}
//		} catch (InterruptedException e) {
//			// 發生例外時直接離開迴圈
//			System.out.println(e);
//		}
		
		
		try {
			// 無窮迴圈 AM2 00:15:00
			// obj1/obj2 生命結束前只要到i%3==0 => new Rev811 => 無窮迴圈
			for (int i = 1; i < 5; i++) {
				System.out.println(name + ":" + i);
				if (i % 3 == 0) {
					Rev811 obj2 = new Rev811(name + i);
					obj2.start();
					obj2.join();
				} else {
					Thread.sleep(500);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}