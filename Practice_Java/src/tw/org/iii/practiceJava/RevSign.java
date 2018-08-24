package tw.org.iii.practiceJava;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*	20180819AM1 13:00
 * 	Collection應用_簽名程式
 * 	1.	先設計程式視窗(Layout, button
 * 	2.	建立簽名板程式類別 => 之後完成再放在主程式
 * 	3.	設計簽名板程式類別 (RevSign先放一邊)
 * 
 */
public class RevSign extends JFrame{
	private JButton clear, undo;
	private RevView myView;
	
	public RevSign() {
		// 視窗建構的初始化
		super("簽名程式(複習版)");
		
		setLayout(new BorderLayout());
		
		//	產生上半部
		JPanel top = new JPanel(new FlowLayout());
		//	產出按鈕
		clear = new JButton("清除畫面");
		undo = new JButton("上一步");
		//	把按鈕加入上半部
		top.add(clear);
		top.add(undo);
		
		//	把top放到視窗的上半部
		add(top, BorderLayout.NORTH);
		
		//	產生簽名板物件
		myView = new RevView();
		
		//	把myView放入視窗中
		add(myView, BorderLayout.CENTER);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		new RevSign();
	}
}
