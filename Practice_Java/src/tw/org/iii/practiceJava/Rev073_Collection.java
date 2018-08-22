package tw.org.iii.practiceJava;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/*	20180818PM2 Brad71 JAVA資料結構
 * 	Collection 介面	=> 規格
 * 	其子介面 (定義的更細節)
 * 		java.util.Set/ List 
 * 	
 * 	Set的特性
 * 	1.	沒有順序性
 * 	2.	裡面的元素不會重複
 * 	
 * 	=> 重點在於如何使用!
 * 		
 * 	>	例如其實作的類別 HashSet
 * 	HashSet的方法 iterator (迭代器) 
 * 		=> 將物件一個一個取出(取完後迭代器會自動銷毀)
 * 
 * 	<E> 泛型 E 代表元素
 * 	=> 確保邏輯內的資料格式一致
 * 
 * 	List: (相反)
 * 	特性	=>	有順序 可重複
 */

public class Rev073_Collection {

	public static void main(String[] args) {
//		HashSet set = new HashSet<>();
//		set.add(12); // 一定要丟物件(自動封箱)
//		set.add(34);
//		set.add("Hello");
//		set.add(new Reviewed_Bike());
//		set.add(12); // 元素不會重複, 所以數量還是只有上面四個
//		set.add(34);
		
//		// 裡面有幾個元素
//		System.out.println(set.size());
//		
//		// 印出內容, 會發現內容無順序性
//		System.out.println(set.toString());
		
		/*
		 * 	應用	=>樂透?
		 * 	選出的號碼不會重複, 不須順序性
		 * 
		 * 	選出的號碼做排序	=> 可是SET不是沒有順序性嗎?
		 * 	排序與順序不同
		 * 	=> 利用TreeSet
		 * 	
		 * 	洗牌程式也可以利用泛型來做
		 * 	
		 * 	Set 其他應用: 
		 * 	手機裝置藍芽搜尋	
		 * 		=>	發出封包後,其他裝置可能多次回應	
		 * 		=>	列表不可重複/不須順序性
		 * 	
		 */
		
		//	簡易樂透隨機選號
		//	運用泛型限定只有Integer
		HashSet<Integer> set = new HashSet<>();
		while (set.size() < 6) {
			//	隨機從1-49取號
			set.add((int)(Math.random()*49+1));
		}
		System.out.println(set);
		
		System.out.println("----------------");
		
		//	樂透隨機選號V2_TreeSet
		//	TreeSet 由小到大排序 (SortedSet介面的實作類別)
		TreeSet<Integer> set1 = new TreeSet<>();
		while (set1.size() < 6) {
			//	隨機從1-49取號
			set1.add((int)(Math.random()*49+1));
		}
		System.out.println(set1);
		
		//	取得樂透選出的數字
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			Integer num = it.next(); // 因為前面有先宣告泛型, 不然這裡會需要強制轉型
			System.out.println(num);
		}
		
		System.out.println("----------------");
		// 取得選出的數字: 第二招 (for...each)
		// 陣列, collection 都可以for each
		for (Integer num : set1) {
			System.out.println(num);
		}
		

	}

}
