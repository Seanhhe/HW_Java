package tw.org.iii.bookPractice;

public class ArraysDemo6 {

	public static void main(String[] args) {
		// 180730 4-26
		// 類別型態建立的陣列
		
		Integer[] a = new Integer[2];
		System.out.println(a[0]);
		
		System.out.println("-----");
		
		Integer[] b = new Integer[3];
		for (Integer bshow : b) {
			System.out.print(bshow+",");
		}
		
		System.out.println();
		System.out.println("-----");
		
		for (int i = 0; i < b.length; i++) {
			b[i] = (i+10);
			System.out.println(b[i]+";");
		}
		
		System.out.println("-----");
		
		Integer[] scores = {80,70,98,16};
		
		for (int i = 0; i < scores.length; i++) {
			System.out.println(scores[i]);
		}
		
		
	}

}
