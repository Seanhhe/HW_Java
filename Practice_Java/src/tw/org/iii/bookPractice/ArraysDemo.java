package tw.org.iii.bookPractice;

public class ArraysDemo {

	public static void main(String[] args) {
		// 20180730 4-19
		
		int[] score = {60,100,120,30,50};
		int[] a = new int[] {1, 2, 4};
		
		int[] b = new int[4];
		
		score[0] = 10;
		
		for (int i=0; i < score.length; i++) {
			System.out.print(score[i] + "\t");
		}
		System.out.println();
		System.out.println("--for each 方法--");
		
		for (int NumOut : score) {
			System.out.print(NumOut + "\t");
		}

	}

}
