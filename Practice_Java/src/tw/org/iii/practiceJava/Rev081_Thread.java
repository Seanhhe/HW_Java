package tw.org.iii.practiceJava;

/*	20180825AM1 Brad79 Thread 
 * 	執行緒的另一個議題
 * 	=> 執行過程中插入另外一個執行緒 join
 * 
 */

public class Rev081_Thread {

	public static void main(String[] args) {
		

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
		
		try {
			// B
			for (int i=0; i < 10;i++) {
				System.out.println(name + " : " + i);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			// 發生例外時直接離開迴圈
			System.out.println(e);
		}
	}
}