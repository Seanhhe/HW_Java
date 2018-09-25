package p1;
/*	
 * 20180811AM2 Package
 */
public class Rev01 {
	private static int a = 10;
	private int b = 10;
	void m1() {
		//Rev02 obj1 = new Rev02(); // 呼叫不到不同package的Lab2
	}
	
	protected void m2() {
		// 存取修飾字為protected
		// -->相同package或為父子類別可看的到
	}
	
	public static void main(String[] args) {
		a++;
		Rev01 r1 = new Rev01();
		r1.b++;
		System.out.println(a);
		System.out.println(r1.b);
	}
}
