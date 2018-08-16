package p2;
/*	20180811AM2 Package
 * 	Package
 * 	目的: 為了分類-->比較好管理
 * 
 */
public class Rev01 {
	void m1() {
		
	}
}

class Rev02 {
	// 這個類別不可設為public 一個原始碼僅有一個
	public void m1() {
		/*	這裡的pulic=>無聊! 
		 *	因為只有相同package才能看到Rev02, 才能存取m1(); 
		 *	既然外面都看不到,何來m1()!
		 *
		 *	外面要看得到才看得到裡面的東西或方法
		 */
	}
}