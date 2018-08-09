package tw.org.iii.practiceJava;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
/**	20180805PM2 Brad38 Interface應用_視窗
 * 	
 * 	>API中參數為l 通常為interface
 *	>EventListener-->API中僅為分類的功能裡面沒有任何方法定義
 *
 */
public class Rev040 extends JFrame {

	
	
	public Rev040() {
		
		
		
		
		setSize(640, 480);
		setVisible(true);
		// setDefaultCloseOperation(EXIT_ON_CLOSE);
		addWindowListener(new MyListener());	// 關閉視窗
	}
	
	public static void main(String[] args) {
		// 程式的執行點
		new Rev040();
	}

}

/**
 *	不用setDefaultCloseOperation(EXIT_ON_CLOSE);方法關閉視窗
 *	改用下面的方法: WindowListener
 *	但僅需要其中的closin方法
 *	改用 class WindowAdapter (implement WindowListener 的抽象類別)
 */

//class MyWindowListener implements WindowListener {
//	// 建立MWL 實現WL 建立MWL物件實體
//	// 接收視窗活動的訊息
//	@Override
//	public void windowActivated(WindowEvent arg0) {
//		System.out.println("Actived");
//	}
//	@Override
//	public void windowClosed(WindowEvent arg0) {
//		System.out.println("Closed");
//	}
//	@Override
//	public void windowClosing(WindowEvent arg0) {
//		System.out.println("Closing");
//		System.exit(0); //	<--關閉程式
//		//	參數 0 --> command line return value 
//		//	回傳給系統上一道指令完成的return值; 
//		//	通常return 0 代表normal/ 非0代表error
//	}
//	@Override
//	public void windowDeactivated(WindowEvent arg0) {
//		System.out.println("Deacctive");
//	}
//	@Override
//	public void windowDeiconified(WindowEvent arg0) {
//		System.out.println("Deicon");
//	}
//	@Override
//	public void windowIconified(WindowEvent arg0) {
//		System.out.println("Iconified");
//	}
//	@Override
//	public void windowOpened(WindowEvent arg0) {
//		System.out.println("Opened");
//	}
//	
//}

class MyListener extends WindowAdapter { // 關閉視窗第二招
	// 繼承抽象類別 WindowAdapter並加以實作
	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);
	}
}