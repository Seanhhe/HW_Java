package tw.org.iii.practiceJava;

import java.util.Collections;
import java.util.LinkedList;

public class Reviewed020_Poker_v4 {

	public static void main(String[] args) {
		/*	二維陣列練習_發牌&洗牌
		 *	請寫出一個程式, 將一副52張的撲克牌洗牌後發給四位玩家.
		 * 	四個玩家-->各自有13張牌 (二維陣列)	
		 * 	一副牌-->52張牌 (一維陣列)
		 * 
		 * 	version4: 使用shuffle API
		 */
		
		LinkedList<Integer> poker = new LinkedList<>();
		for (int i=0; i<52; i++) {
			poker.add(i);
		}
		Collections.shuffle(poker);
		
		for (Integer i:poker) {
			System.out.println(i);
		}
		
				
	}

}
