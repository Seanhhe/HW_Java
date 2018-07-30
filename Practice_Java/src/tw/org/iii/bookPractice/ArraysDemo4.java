package tw.org.iii.bookPractice;

public class ArraysDemo4 {

	public static void main(String[] args) {
		// 180730 4-26
		// 不規則陣列
		
		int[][] test = new int[2][];
		
		test[0] = new int[] {7,8,5,6};
		test[1] = new int[]	{1,2};
		
		for(int[] test1 : test) {
			for (int test2 : test1) {
				System.out.print(test2+ ",");
			}
			System.out.println();
		}
	}

}
