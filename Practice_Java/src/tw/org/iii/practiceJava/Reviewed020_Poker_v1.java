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
		
		// 撲克牌的陣列
		int[] cards = new int[52];
		
		// 產生亂數依序放入陣列中
		for (int i=0; i < 52; i++) {
			int k = (int)(Math.random()*52);	// 產生亂數
					
			
			// 檢查機制
			boolean isRepeat = false; 	// 為什麼擺外面-->讓後面的if...else可以判斷
			for (int j=0; j < i; j++) {
				if (cards[j] == k) {	// 依序向目前已經在陣列內的值比對是否有重複
					// 抓到了
					isRepeat = true;
					break;
				}
			}
			if (isRepeat) {
				i--;	// 退回上一動
			}else {
				cards[i]=k;		// 把產生的亂數放入位置
				System.out.println(cards[i]);
			}
		}
		
	}

}
