package tw.org.iii.practiceJava;

public class Reviewed020_Poker_v5 {

	public static void main(String[] args) {
		/*	二維陣列練習_發牌&洗牌
		 *	請寫出一個程式, 將一副52張的撲克牌洗牌後發給四位玩家.
		 * 	四個玩家-->各自有13張牌 (二維陣列)	
		 * 	一副牌-->52張牌 (一維陣列)
		 * 
		 * 	version5: 發牌&理牌
		 */
		
		//	產生新撲克牌的陣列
		int[] cards = new int[52];
		for (int i=0; i < cards.length; i++) {
			cards[i]=i;
			System.out.print(i + ";");
		}
		
		System.out.println();
		System.out.println("--------");
		
		//	交換
		
		for (int n = cards.length-1; n >= 0; n--) {	//	為什麼要-1, 因為最後一張牌的index
			int middleMan;	//暫存被選到的牌的值
			int k = (int)(Math.random()*52);	//亂數取要交換的牌位置
			//	交換中
			middleMan = cards[k];
			cards[k] = cards[n];
			cards[n] = middleMan;
		}
		
		// 印出
		for (int finalCard : cards) {
			System.out.print(finalCard+ ",");
		}
				
	}

}
