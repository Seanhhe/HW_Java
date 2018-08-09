package tw.org.iii.practiceJava;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class RevMyPanel extends JPanel{
	int ballx = (int)(Math.random()*640);
	int bally = (int)(Math.random()*480);
	
	// 建構式
	public RevMyPanel() {
		System.out.println("RevMyPanel();");
	}
	
	// component的生命週期 (沒有呼叫卻自動執行)
	// component有被呼叫並傳遞Graphics物件
	// 為甚麼component會自動產生???
	// 傳入的 Graphics 已產生物件實體 (Graphic抽象類別的子類別Graphic2D中的Inner class所產生)
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		System.out.println("Paint");
		Graphics2D g2d = (Graphics2D)g; // 強制轉型回Graphic2D [骨子裡是Graphic2D 不清楚可用instanceof]
		// g2d.drawOval(10, 50, 50, 50); // drawOval 畫橢圓
		
		g2d.fillOval(ballx, bally, 50, 50);
		g2d.setColor(Color.ORANGE);
	}
}

/*
 * 	TODO HW: 滑鼠點到的地方是圓心
 */

//滑鼠事件
class MyClicker extends MouseAdapter {
	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		System.out.println(e.getX());
		System.out.println(e.getY());
		 
		
		
	}
}
