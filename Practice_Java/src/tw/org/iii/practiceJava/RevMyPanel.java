package tw.org.iii.practiceJava;
/*	20180811AM1 
 * 	追加點選畫面, 圖案出現在滑鼠位置, 且滑鼠點擊位置為該圖案中心.
 * 
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class RevMyPanel extends JPanel implements MouseListener{
	private int ballx; // 0811AM1 更新
	private int bally; 
	Color color;
	
	// 建構式
	public RevMyPanel() {
		//System.out.println("RevMyPanel(); 無傳參數");	
		//addMouseListener(this);
	}
	
	public RevMyPanel(int ballx, int bally) {
		// 建構式2 0811AM1 V2版改
		this.ballx = ballx;
		this.bally = bally;
		color = Color.RED;
		
		addMouseListener(this);
		// this-->MyPanel本人聽
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// component的生命週期 (沒有呼叫卻自動執行)
		// component有被呼叫並傳遞Graphics物件
		// 為甚麼component會自動產生???
		// 傳入的 Graphics 已產生物件實體 (Graphic抽象類別的子類別Graphic2D中的Inner class所產生)
		
		/*	該物件具有生命週期 20180811AM1
		 * 	當生命週期到了, 其呼叫的方法非開發者所建立
		 * 	開發者呼叫某方法導致觸發它, 而那些方法才被呼叫
		 * 
		 */
		super.paintComponent(g);
		System.out.println("Paint");
		Graphics2D g2d = (Graphics2D)g; // 強制轉型回Graphic2D [骨子裡是Graphic2D 不清楚可用instanceof]
		// g2d.drawOval(10, 50, 50, 50); // drawOval 畫橢圓
		
		g2d.fillOval(ballx, bally, 50, 50);
		g2d.setColor(Color.ORANGE);
	}
	// MouseListener 並沒有重新implement成另一個類別
	// 而是直接實作在同一類別內, 方便後續修改與存取類別內的屬性


	@Override
	public void mouseClicked(MouseEvent e) {
		// 新增mouseListener的實作方法
		System.out.println("V1 click");
		ballx = e.getX()-25; // 減去半徑
		bally = e.getY()-25;
		repaint();  // 父類別的repaint與子類別的repaint執行順序為何? 之後設計類似的程式要注意
		// repaint 類似會被Push到旁邊等color做完? 註解repaint試試看
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// 新增mouseListener的實作方法
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// 新增mouseListener的實作方法
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// 新增mouseListener的實作方法
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// 新增mouseListener的實作方法
		
	}
}

/*
 * 	TODO HW: 滑鼠點到的地方是圓心
 */

////滑鼠事件
//class MyClicker extends MouseAdapter {
//	@Override
//	public void mouseClicked(MouseEvent e) {
//		super.mouseClicked(e);
//		System.out.println(e.getX());
//		System.out.println(e.getY());
//	}
//}
