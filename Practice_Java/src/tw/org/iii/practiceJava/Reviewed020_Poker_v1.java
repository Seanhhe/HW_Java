package tw.org.iii.practiceJava;

public class Reviewed020_Poker_v1 {

	public static void main(String[] args) {
		/*	二維陣列練習_發牌&洗牌
		 *	請寫出一個程式, 將一副52張的撲克牌洗牌後發給四位玩家.
		 * 	四個玩家-->各自有13張牌 (二維陣列)	
		 * 	一副牌-->52張牌 (一維陣列)
		 * 
		 * 	設計想法:
		 * 	
		 * 	先解決洗牌
		 *	1. 建立牌的陣列
		 *	2. 產生亂數依序放入陣列中(使用for迴圈)
		 *	3. 發現好像會有重複的值
		 *	4. 建立檢查機制-->亂數是否有重複, 有重複就退回並重新產生亂數[boolean值?]
		 *	5. 印出洗好的數字
		 */
		
		int[] cards = new int[52];
		
		for (int i=0; i < 52; i++) {
			int k = (int)(Math.random()*52);
			cards[i]=k;
			System.out.println(cards[i]);
		}
		
	}

}
