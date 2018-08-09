package tw.org.iii.practiceJava;

import java.awt.Graphics;

import javax.swing.JPanel;

public class RevMyPanel extends JPanel{
	// 建構式
	public RevMyPanel() {
		System.out.println("RevMyPanel();");
	}
	
	
	// component的生命週期 (沒有呼叫卻自動執行)
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	}
}
