package tw.org.iii.bookPractice;

public class ArraysDemo2 {

	public static void main(String[] args) {
		// 180730 4-21
		
		int[][] cords = {
				{1,2,3},
				{4,5,6}
		};
		
		for (int x = 0; x < cords.length; x++) {
			for(int y = 0; y < cords[x].length; y++) {
				System.out.print(cords[x][y]+ ";");
			}
			System.out.println();
		}
		System.out.println();

		
		for (int[] cords1 : cords) {	//第一層
			for (int cords2 : cords1) {		//第二層
				System.out.print(cords2 + ";");
			}
			System.out.println();
		}
	}

}
