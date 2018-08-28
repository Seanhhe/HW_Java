package tw.org.iii.practiceJava;

import tw.org.iii.bookPractice.chapter3homework;

/*	20180825PM2 Brad84
 * 	
 * 	enum 列舉
 * 	=> 方便, 程式易讀
 * 	=> 值的判斷卻使用物件來做
 * 	=> 缺點: 比較占記憶體, 載入後就會自動產生物件實體
 */


public class Rev086_Eunm {

	public static void main(String[] args) {
		Player p1 = new Player();
		p1.setDir(Direction.UP); // Direcition.UP => 物件實體已產生
		System.out.println(p1.getDir());
		
		//	switch 的判斷也可用enum (byte, short, int, char, String, Enum)
		switch (p1.getDir()) {
		case UP:
			System.out.println("A_UP");
			break;
		case DOWN:
			System.out.println("A_DOWN");
			break;
		case LEFT:
			System.out.println("A_LEFT");
			break;
		case RIGHT:
			System.out.println("A_RIGHT");
			break;
		default:
			System.out.println("ERROR");
		}
		
		//	if 條件判斷也可以
		if (p1.getDir() == Direction.DOWN) {
			System.out.println("DOWN");
		} else {
			System.out.println("Different");
		}
		
		System.out.println(p1.getDir2());
	}

}

enum Direction {
	// 列舉 出方向 共有五個物件實體, 不會有別的. (方向不會有第六個)
	// 列舉 就像類別可產生物件實體 =>但是該類別只有限定數量的物件實體
	LEFT, RIGHT, UP, DOWN;
}

class Player {
	//	第一種寫法: 用數字表示玩家方向 (0,1,2,3,4)
//	private int dir;
//	void setDir(int dir) {
//		this.dir = dir;
//	}
	
	//	改用列舉方式
	private Direction dir;
	void setDir(Direction dir) {
		this.dir = dir;
	}
	
	Direction getDir() {
		return dir;
	}
	
	//	實務上更多人使用的方式=> 用值來存放而非使用物件,以利提升效能
	private final static int STATE_UP = 1;
	private final static int STATE_DOWN = 2;
	private final static int STATE_BACK = 3;
	
	private int state = STATE_BACK;
	
	int getDir2() {
		return state;
	}
}
