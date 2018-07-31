package tw.org.iii.practiceJava;

public class Reviewed010 {

	public static void main(String[] args) {
		// 20180731AM 
		// 流程控制
		
		/*
		 * Switch (只會有一個值) {
		 * 	case ___ : //case值只能有一個, 不能使用or/and
		 * 	statement
		 * 	break;	// 遇到break跳離區塊, 若沒有break則直接執行到switch區塊結束
		 * 	default:
		 * 	statement
		 * 	break;
		 * 	}
		 * 
		 * 	// 若編譯失敗會在過程中拋出意外
		 */
		
		int a = 10;
		
		switch (a) {
		case 1:
			System.out.println("A");
			break;
//		case 10: --> 相同條件重複
//			System.out.println("B");
//			break;
		case 10:
			System.out.println("B");
//			break; // --> break 被移除程式會繼續執行
		case 100:
			System.out.println("C");
			break;
		default:
			System.out.println("default");
//			break; //	於switch程式區塊最後一行 故可省略
		}
		
		System.out.println("------範例二--------");
		
		//	範例二_寫個月份判斷天數的程式
		
		int month = (int)(Math.random()*12)+1;
		System.out.println("月份: "+ month + " 月");
		
		switch (month) {
		case 1:
			System.out.println("天數: 31 天");
			break;
		case 2:
			System.out.println("天數: 28 天");
			break;
		case 3:
			System.out.println("天數: 31 天");
			break;
		case 4:
			System.out.println("天數: 30 天");
			break;
		case 5:
			System.out.println("天數: 31 天");
			break;
		case 6:
			System.out.println("天數: 30 天");
			break;
		case 7:
			System.out.println("天數: 31 天");
			break;
		case 8:
			System.out.println("天數: 31 天");
			break;
		case 9:
			System.out.println("天數: 30 天");
			break;
		case 10:
			System.out.println("天數: 31 天");
			break;
		case 11:
			System.out.println("天數: 30 天");
			break;
		case 12:
			System.out.println("天數: 31 天");
			break;
		default:
			System.out.println("BUG!!!");	
		}
		
//		範例二之二_寫個月份判斷天數的程式
		
		// switch 屬於結果論_可改寫成下方
		// 試問要設計的結構會有幾種結果
		System.out.println("------範例二改寫--------");
		
		switch (month) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			System.out.println("天數 ver.2: 31 天");
			break;
		case 2:
			System.out.println("天數 ver.2: 28 天");
			break;
		case 4: case 6: case 9: case 11:
			System.out.println("天數 ver.2: 30 天");
			break;
		default:
			System.out.println("BUG!!!");
			break;
		}
		
	}

}
