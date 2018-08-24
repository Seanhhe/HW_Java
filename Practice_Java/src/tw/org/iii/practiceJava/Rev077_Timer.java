package tw.org.iii.practiceJava;

import java.util.Timer;
import java.util.TimerTask;


/*	20180819PM1 Brad75
 * 	週期/預約任務
 * 	java.util.Timer
 * 		timer.shedule --> 依參數不同有延遲(週期)與預約
 * 	
 * 	java.util.TimerTask
 * 		implements Runnable
 */
public class Rev077_Timer {

	public static void main(String[] args) {
//		Timer timer = new Timer();
//		MyTask myTask = new MyTask();
//		StopTimer stopTimer = new StopTimer(timer);
//		
//		//timer.schedule(myTask, 3*1000); // 三秒鐘後做
//		//timer.cancel(); // 關閉timer--整個程式也結束
//		timer.schedule(myTask, 1*1000, 1*1000); // 每一秒鐘做一次 (週期任務)
//		timer.schedule(stopTimer, 10*1000); // cancel the timer after 10 secs
//		System.out.println("here"); // 執行後紅燈亮著 --> Timer
		
		
		/*	測試isDaemon 是否在背景執行
		 * 	Timer(boolean isDaemon)
		 * 	Timer(String name, boolean isDaemon)
		 * 	Daemon: 背景常駐程式 (伺服器的程式通常稱為Daemon)
		 * 	=> 相依於前景程式
		 * 	=> false 不是Daemon是前景; true 是背景程式, 前景結束Daemon就結束. 
		 * 	=> 預設是false
		 * 	
		 */
		Timer timer = new Timer(true); // 設為true後直接結束
		MyTask myTask = new MyTask();
		timer.schedule(myTask, 1*1000,1*1000); // 每一秒執行一次
		System.out.println("here"); // 執行後紅燈亮著 --> Timer
	}

	//	複習: 若寫成內部類別, 必須先擁有外部類別的物件實體; 或將該內部類別宣告為static
}

class MyTask extends TimerTask {
	// 設計一個時間到要做的事 (原本寫成內部類別但是...請看上面的複習)
	@Override
	public void run() {
		System.out.println("OK");
	}
}

class StopTimer extends TimerTask {
	Timer timer;
	
	public StopTimer(Timer timer) {
		this.timer = timer;
	}
	@Override
	public void run() {
		timer.cancel(); // 利用timer的方法, 停止Timer&程式
		//System.exit(0);
	}
}
