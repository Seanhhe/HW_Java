package tw.org.iii.practiceJava;

public class Reviewed020_Poker_v2 {

	public static void main(String[] args) {
		/*	二維陣列練習_發牌&洗牌
		 *	請寫出一個程式, 將一副52張的撲克牌洗牌後發給四位玩家.
		 * 	四個玩家-->各自有13張牌 (二維陣列)	
		 * 	一副牌-->52張牌 (一維陣列)
		 * 
		 * 	設計想法:
		 * 	
		 * 	目前已經解決洗牌的問題, 但是還有改善空間.
		 * 	試用do...while迴圈 
		 * 	[觀察:do while迴圈是否與for迴圈概念類似? 哪些事情是每次必須要做的? 亂數, 檢查]
		 *	
		 * 	
		 */
		
		// 撲克牌的陣列
		int[] cards = new int[52];
		
		
		// 產生亂數依序放入陣列中
		for (int i=0; i < 52; i++) {
			boolean isRepeat; 	// 為什麼設在這邊<--讓while迴圈可使用
			int k;
			
			do {
				k = (int)(Math.random()*52);	// 產生亂數
				
				// 檢查機制
				isRepeat = false; // 確保每次進入檢查機制時都假定該數字沒有重複
				for (int j=0; j < i; j++) {
					if (cards[j] == k) {	// 依序向目前已經在陣列內的值比對是否有重複
						// 抓到了
						isRepeat = true;
						break;
					}
				}
			}while(isRepeat);
			cards[i]=k;		// 把產生的亂數放入位置
			System.out.println(cards[i]);
		}
		
	}

}
