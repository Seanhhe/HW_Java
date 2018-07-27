package tw.org.iii.practiceJava;

import javax.swing.JOptionPane;

public class Reviewed008 {

	public static void main(String[] args) {
		//	if...else 應用 計算年份是否有閏年
		//	year % 4 =>閏年
		//	year % 100 --> 不閏年
		//	year % 400 => 閏年
		
		//	if...else 巢狀架構-->層層過濾分化
		//	if/else是一種二分法
		
		
		String a1 = JOptionPane.showInputDialog("請輸入西元年份(E.g. 2018)");
		int yearNum = Integer.parseInt(a1);
		
		if (yearNum % 4 == 0) {
			if (yearNum % 100 == 0) {
				if (yearNum % 400 == 0) {
					//	閏年
					System.out.println(yearNum);
					System.out.println("閏年");
				}else {
					//	非閏年
					System.out.println(yearNum);
					System.out.println("非閏年");
				}
			}else {
				// 閏年
				System.out.println(yearNum);
				System.out.println("閏年");
			}
		}else {
			//	非閏年
			System.out.println(yearNum);
			System.out.println("非閏年");
		}
		
		//	寫程式的重點: 有時候敘述短不見得是好事, 程式最主要的除了效率外, 更重要的是維護性與易讀性. 
		
		
		// 寫個萬年曆程式?

	}

}
