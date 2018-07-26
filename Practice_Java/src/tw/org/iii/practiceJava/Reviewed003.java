package tw.org.iii.practiceJava;

public class Reviewed003 {

	public static void main(String[] args) {
		// 浮點數
		
		// 1.2直接被視為double
		// 浮點數在電腦裡不是0101的值
		float f1 = 1.2f;	// 加註f強制轉型
		System.out.println(f1);
		
		//	float fmax = java.lang.Float.MAX_VALUE;
		//	System.out.println(fmax);
		
		f1++;
		System.out.println(f1);
		
		f1 += 10;
		System.out.println(f1);
		
		float f2 = 1.3f;
		double d1 = 11.2;
		double d3 = f2 + d1;	//	int + float => float
		System.out.println(d3);
		

	}

}
