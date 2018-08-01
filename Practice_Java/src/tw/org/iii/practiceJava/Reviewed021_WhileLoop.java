package tw.org.iii.practiceJava;

public class Reviewed021_WhileLoop {

	public static void main(String[] args) {
		// 	Brad19 20180801
		//	while&do...while 前測與後測迴圈
		
		int a = 1;
		while (a < 10) {
			System.out.println(a++);
		}
		
		// 比較上下兩者, 有沒有很像
		
		int b = 1;
		for (;b<10;) {
			System.out.println(b++);
		}
		
		
		// 後測迴圈 
		
		int c = 1;
		do {	// 先做一次
			System.out.println(c++);
		}while(c<10);	//判斷要不要繼續做
		

	}

}
