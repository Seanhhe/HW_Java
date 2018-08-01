package tw.org.iii.practiceJava;

public class Reviewed020_Poker_v3 {

	public static void main(String[] args) {
		/*	二維陣列練習_發牌&洗牌
		 *	請寫出一個程式, 將一副52張的撲克牌洗牌後發給四位玩家.
		 * 	四個玩家-->各自有13張牌 (二維陣列)	
		 * 	一副牌-->52張牌 (一維陣列)
		 * 
		 * 	version3: 運用洗牌演算法(交換原理)
		 * 	亂數選取某一張牌, 將其與最後一張牌交換, 最後一張牌就算洗完不動, 接者再重新選一張牌繼續換牌.
		 * 	
		 * 	先產生一組順序由小到大的牌
		 *	開始進行交換
		 *	用產生亂數為隨機index值, 選到後和當下的最後一張交換
		 *	最後一張假設為n, 每次交換完後-1.
		 *	交換前要確認有沒有重複嗎? 不用, 因為是一個陣列內的交換不是兩個陣列.
		 * 	怎麼交換? --> A->B->C->A 要有中間人, 因為值的指定是複製
		 * 	交換完後再依序印出 (這邊可以使用for each)
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
