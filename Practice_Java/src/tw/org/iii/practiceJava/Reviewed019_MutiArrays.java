package tw.org.iii.practiceJava;

public class Reviewed019_MutiArrays {

	public static void main(String[] args) {
		// Brad18
		
		/*
		 * 認識多維陣列
		 * 
		 * 陣列是存放在記憶體的位置
		 * 要以線性的觀念來理解,而非空間
		 * 
		 * 					  |--[0]
		 * 			  |---[0]=|--[1]
		 *            |   指向   |--[2]
		 *            |
		 * 			  |
		 * int[][] b =|
		 *            |       |--[0]
		 *            |       |--[1]
		 *            |---[1]-|--[2]
		 *                    |--[3] 
		 *                    
		 * 永遠用一維的觀點看多維 (因為線性的關係)
		 * 
		 * 前一層決定了才可決定下一層
		 * 
		 * for each的用法-->尋訪陣列(著重在讀出陣列的值,而非其Index)
		 * 	冒號左邊的變數是被尋訪陣列的元素型別
		 */
		
		int[][] a = new int[2][3]; // 以空間來講是2x3, 但這是特例.
		int[][] b = new int[2][];
 		b[0] = new int[3];
 		b[1] = new int[4];
		
 		System.out.println("----陣列a----");
 		System.out.println("陣列a長度: " + a.length);
 		System.out.println("陣列a[0]長度: "+ a[0].length);
 		System.out.println("陣列a[1]長度: "+ a[1].length);
 		System.out.println();
 		System.out.println("----陣列b----");
 		System.out.println("陣列b長度: " + b.length);
 		System.out.println("陣列b[0]長度: "+ b[0].length);
 		System.out.println("陣列b[1]長度: "+ b[1].length);
 		
 		System.out.println();
 		System.out.println("---尋訪陣列a---");
 		
		// 尋訪陣列
 		for (int i=0; i<a.length; i++) {
 			for (int j=0; j<a[i].length;j++) {
 				System.out.print(a[i][j] + ",");
 			}
 			System.out.println();
 		}
 		
 		System.out.println();
 		System.out.println("---尋訪陣列b---");
 		
 		// 尋訪陣列b
 	 	for (int i=0; i<b.length; i++) {
 	 		for (int j=0; j<b[i].length;j++) {
 	 			System.out.print(b[i][j] + ",");
 	 		}
 	 		System.out.println();
 	 	}
 	 	
 	 	System.out.println();
 		System.out.println("---使用for each_尋訪陣列a---");
 	 	
 	 	// for each 練習 (尋訪陣列的另一種方法: 著重在陣列的值)
 		
 	 	for(int[] layer1 : a) {	// 第一層
 	 		for(int layer2 : layer1) {	// 第二層
 	 			System.out.print(layer2+";");
 	 		}
 	 		System.out.println();
 	 	}
 	 	
 	 	System.out.println();
 		System.out.println("---使用for each_尋訪陣列b---");
 	 	
 	 	// 陣列b
 	 	for(int[] layer1 : b) {	// 第一層
 	 		for(int layer2 : layer1) {	// 第二層
 	 			System.out.print(layer2+";");
 	 		}
 	 		System.out.println();
 	 	}
	}

}
