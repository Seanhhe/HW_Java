package tw.org.iii.practiceJava;

import java.util.Calendar;
import java.util.Date;

/*	20180825PM2 Brad85 00:22:30
 * 	日期時間
 * 	
 * 	java.util.Date <官方不建議繼續使用>
 * 	java.util.Calendar <建議用這個>
 * 	
 * 	
 * 
 * 	文字處理API java.text
 * 	數字格式 > NumberFormat
 * 
 * 	日期格式> java.text.SimpleDateFormat
 * 	
 * 	小結論 =>盡量使用Calendar 顯示問題再轉換就好
 * 	
 * 
 */


public class Rev087_TimeDate {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		
		// Calendar 建構式 protected => 不是相同 package 不能用
		// getInstance()
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar); // 不易閱讀
		
		
	}

}
