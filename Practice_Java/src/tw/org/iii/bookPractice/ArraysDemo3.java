package tw.org.iii.bookPractice;

public class ArraysDemo3 {

	public static void main(String[] args) {
		// 180730 4-23
		
		int[] newA = new int[2];
		System.out.println(newA[0]+","+newA[1]);
		
		int[] scores = {1,2,3,5,6,43,32,31};
		int[] a = scores;
		
		System.out.println(scores[0]);
		System.out.println(a[0]);
		
		System.out.println("-----");
		
		int[][] b = new int[2][3];
		
		for(int[] layer1 : b) {
			for(int layer2 : layer1) {
				System.out.print(layer2+",");
			}
			System.out.println();
		}
		System.out.println(b.length);
		System.out.println(b[1].length);
		
		
	}

}
