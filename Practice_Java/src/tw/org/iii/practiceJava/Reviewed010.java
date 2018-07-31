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
		case 10:
			System.out.println("B");
//			break;
		case 100:
			System.out.println("C");
			break;
		default:
			System.out.println("default");
//			break; //	於switch程式區塊最後一行 故可省略
		}
		
		System.out.println("--------------");
		
		//	範例二
		
		
	}

}
