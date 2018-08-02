package tw.org.iii.practiceJava;

import java.util.Arrays;

public class Reviewed020_Poker_v5 {

	public static void main(String[] args) {
		/*	二維陣列練習_發牌&洗牌
		 *	請寫出一個程式, 將一副52張的撲克牌洗牌後發給四位玩家.
		 * 	四個玩家-->各自有13張牌 (二維陣列)	
		 * 	一副牌-->52張牌 (一維陣列)
		 * 
		 * 	version5: 發牌&理牌
		 * 	發牌->發給四個玩家,每人13張牌 =>二維陣列
		 * 	
		 * 	i%4 (x軸: 玩家)  i/4 (y軸:玩家牌的順序)
		 * 	0 1 2 3    0 0 0 0
		 * 	4 5 6 7    1 1 1 1
		 * 	8 9 10 11  2 2 2 2
		 * 	........
		 * 	
		 * 
		 * 	加上花色->加上花色與大小
		 * 
		 * 	黑桃1 黑桃2 紅心2 方塊5 梅花1 梅花3
		 * 
		 * 	0~12 黑桃   [ /13 0...0,1,2,3 ]  
			13~25 紅心 [ /13 1...0,1,2,3 ]
		 	26~38 方塊 [ /13 1...0,1,2,3 ]
			39~51 梅花 [ /13 1...0,1,2,3 ]
			原始編號除以13的商 代表花色; 餘數代表牌數
		 * 	
		 * 	理牌->由大到小排順序
		 * 	利用Arrays.sort API
		 * 
		 */
		
		//	產生新撲克牌的陣列
		int[] cards = new int[52];
		for (int i=0; i < cards.length; i++) {
			cards[i]=i;
			System.out.print(i + ";");
		}
		
		System.out.println();
		System.out.println("----洗牌----");
		
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
		
		System.out.println();
		System.out.println("--------發牌---------");
		
		// 發牌
		int[][] players = new int [4][13];
		
		for(int i = 0; i < cards.length;i++) {	// for 迴圈存取每一張洗好的牌
			//	i%4->確認i張牌是給哪一個玩家
			//	i/4->確認i張牌是給在該玩家的哪一個位置
			players[i%4][i/4] = cards[i];
		}
		
		//	用for each 檢查每個人的牌
		for (int[] player: players) {
			for(int eachCards : player) {
				System.out.print(eachCards+"\t");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("--------加上花色&理牌---------");
		
		//	加上花色&理牌
				
		String[] title = new String[] {"黑桃","紅心","方塊","梅花"};
		String[] numStr = new String[] {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		
		for (int[] player: players) {
			Arrays.sort(player);
			for(int eachCards : player) {
				System.out.print(title[eachCards/13]+numStr[eachCards%13] +"\t");
			}
			System.out.println();
		}
		
	}

}
