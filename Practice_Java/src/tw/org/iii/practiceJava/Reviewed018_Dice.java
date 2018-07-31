package tw.org.iii.practiceJava;

public class Reviewed018_Dice {

	public static void main(String[] args) {
		/*
		 * 20180731 Brad17 擲骰子次數計算 擲一百次紀錄各點出現的次數
		 * 
		 */

		// Version1 先用一般變數
		int d1, d2, d3, d4, d5, d6, e;
		d1 = d2 = d3 = d4 = d5 = d6 = e = 0;

		for (int i = 0; i < 100; i++) {
			int dice = (int) (Math.random() * 6) + 1;
			switch (dice) {
			case 1:
				d1++;
				break;
			case 2:
				d2++;
				break;
			case 3:
				d3++;
				break;
			case 4:
				d4++;
				break;
			case 5:
				d5++;
				break;
			case 6:
				d6++;
				break;
			default:
				e++;
			}
		}
		if (e > 0) {
			System.out.println("Bug: " + e);
		} else {
			System.out.println("Dot1: " + d1 + "times");
			System.out.println("Dot2: " + d2 + "times");
			System.out.println("Dot3: " + d3 + "times");
			System.out.println("Dot4: " + d4 + "times");
			System.out.println("Dot5: " + d5 + "times");
			System.out.println("Dot6: " + d6 + "times");
		}

		System.out.println("------------");

		// Version2_Arrays (自己先寫的)
		int[] dots = new int[7];

		for (int i = 0; i < 100; i++) {
			int point = (int) (Math.random() * 6) + 1;
			switch (point) {
			case 1:
				dots[1]++;
				break;
			case 2:
				dots[2]++;
				break;
			case 3:
				dots[3]++;
				break;
			case 4:
				dots[4]++;
				break;
			case 5:
				dots[5]++;
				break;
			case 6:
				dots[6]++;
				break;
			default:
				dots[0]++;
			}
		}
		if (dots[0] == 0) {
			for (int j=1; j<dots.length;j++ ) {
				System.out.println("Dots"+j+":"+dots[j]+"times");
			}
		}else {
			System.out.println("BUG"+ dots[0]);
		}
		
		System.out.println("-----Ver.3 提高正確率-------");
		
		// Version3_Arrays + 提高正確機率 (擲10000次)
		int[] dice = new int[7];

		for (int i = 0; i < 100000; i++) {
			int point = (int) (Math.random() * 6) + 1;
			// 看完老師的, 原來這段可以改這樣啊~
			if (point >=1 && point <=6) { //	確保點數沒有錯
				dice[point]++;	//因為點數數字與Index位置數字一樣
			}else {
				dice[0]++; 	//bug次數記錄
			}
		}
		if (dice[0] == 0) {
			for (int j = 1; j < dice.length; j++) {
				System.out.println("Dots" + j + ":" + dice[j] + "times");
			}
		} else {
			System.out.println("BUG" + dice[0]);
		}
		
		System.out.println("----Ver.4 提高部分點數機率------");
		
//		// Version4_Arrays(提高4,5,6點機率)
//				int[] dice = new int[7];
//
//				for (int i = 0; i < 100; i++) {
//					int point = (int) (Math.random() * 6) + 1;
//					// 看完老師的, 原來這段可以改這樣啊~
//					if (point >=1 && point <=6) { //	確保點數沒有錯
//						dice[point]++;	//因為點數數字與Index位置數字一樣
//					}else {
//						dice[0]++; 	//bug次數記錄
//					}
//				}
//				if (dice[0] == 0) {
//					for (int j = 1; j < dice.length; j++) {
//						System.out.println("Dots" + j + ":" + dice[j] + "times");
//					}
//				} else {
//					System.out.println("BUG" + dice[0]);
//				}

	}

}
