package tw.org.iii.practiceJava;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/*	20180804AM2 Brad26 單一視窗程式(JFrame) Reviewed
 * 	https://docs.oracle.com/javase/7/docs/api/
 * 	
 * 	如何找尋合適的API類別來使用?
 * 	1. 人類的知識判斷(關鍵字)
 * 	2. 經驗累積
 * 	3. 善用google
 * 
 * 	>所有的視窗元件都是Component
 * 	>容器可以在裝容器
 * 
 * 	>重點: 物件導向的方式寫程式!
 */


public class Reviewed028_window extends JFrame{
	// fields
	private JButton b1;
	private JButton b2;
	private JButton b3;
	
	// constructor
	public Reviewed028_window() {	// 自訂建構式
		super("my first window");	// 指定呼叫父類別有傳參數建構式 (傳入視窗標題)
		
		// 加入按鈕 (視窗擁有按鈕)
		b1 = new JButton("Button1");
		b2 = new JButton("Button2");
		b3 = new JButton("Button3");
		
		// 顯示按鈕1--> 變成滿版的大按鈕, 不是預期的效果 =>改用setLayout
		// b1.setLocation(100, 100);
		// add(b1);	// 視覺上的加入到容器中
		// 下面兩個沒效果...
		// setSize(20,20);
		// setVisible(true);
		
		/*	上面那招不好用, 改找個室內設計師-->setLayout
		 * 	
		 * 	add可以多個, set只能有一個.
		 * 	
		 * 	Interface (介面) : 比較像是一種規格
		 * 
		 * 	LayoutManager-->FlowLayout
		 * 	
		 * 	flowlayout建構式 FlowLayout(int align, int hgap, int vgap)
		 */
		
		// 自動版面配置
		setLayout(new FlowLayout(FlowLayout.LEFT,50,100));
		add(b1); add(b2); add(b3); 
		
		// 按下按鈕要做甚麼事(觸發動作)
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("OK");
				
			}
		});
		
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("OK2");
				
			}
		});
		
		
		/*	善用繼承關係 & API文件
		 *	當繼承的類別方法沒有所需的方法時, 可向上找尋父類別的父類別是否有合適的方法
		 */
		//	System.out.println("Hello");
		setSize(640,480);	// inherited from java.awt.Window
		setVisible(true);	// show the window
		setDefaultCloseOperation(EXIT_ON_CLOSE);	// exit the app while close the window
	}
	// methods
	
	
	
	
	
	public static void main(String[] args) {
		// 程式執行點
		// Reviewed028_window a1 = new Reviewed028_window(); // 給變數只是為了呼叫方便
		
		new Reviewed028_window(); // 沒有要呼叫的話 直接new物件就可以了
	
	}

}
