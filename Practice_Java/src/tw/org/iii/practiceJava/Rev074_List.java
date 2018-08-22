package tw.org.iii.practiceJava;

import java.util.LinkedList;

/*	20180818PM2 Brad72
 * 	Interface List<E> 介面
 * 	子實作: 
 * 	ArrayList, <= 資料不常異動的 建議使用
 * 	LinkedList	<= 執行階段資料/元素異動性大的 建議使用
 * 	兩者在應用面上沒有太大的差別
 * 		
 * 
 */
public class Rev074_List {

	public static void main(String[] args) {
		LinkedList<String> names = new LinkedList<>();
		names.add("Hello");
		names.add("Hi");
		names.add("Taiwan");
		names.add("Hello");
		names.add("Taiwan");
		System.out.println(names.size());	// 重複地仍有計算
		System.out.println(names);	// 按照順序
		System.out.println("-----------------");
		
		//	利用for each分別拿出
		for (String out : names) {
			System.out.println(out);
		}
		System.out.println("-----------------");
		
		//	拿出指定序號的資料
		System.out.println(names.get(4));
	}

}
