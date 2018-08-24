package tw.org.iii.practiceJava;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import java.util.LinkedList;

import javax.swing.JPanel;

/*	20180819AM1 Review
 * 	簽名程式RevSign中的簽名區域(簽名板)
 * 	=> 自訂類別(物件)
 * 	=> 功能要能夠畫線 => 畫筆(滑鼠)
 * 
 * 	任何時候的畫面是由paintCommponet決定
 * 
 * 	畫線: 每一筆的點擊都是一個座標 (有順序性但不知道有幾點)
 * 	利用資料結構list儲存每個座標點
 * 	各點連成線
 * 
 * 	利用LinkedList儲存各點
 * 	再利用LinkedList儲存各條線LinkedList<MyPoint>(筆畫)
 * 
 * 	1.	初始化: 簽名板背景
 * 	2.	paintComponent設定(畫筆)
 * 	3.	加入滑鼠偵測
 * 	4.	自訂座標類別
 * 	5.	建立資料結構儲存滑鼠收集的座標
 * 	6.	將座標類別物件放入滑鼠方法中收集
 * 	7.	滑鼠移動=>repaint
 * 	8.	利用for迴圈重複畫每個小線段
 * 
 * 	
 */
public class RevView extends JPanel{
	private MyMouseListener mouseListener = new MyMouseListener();
	private LinkedList<RevPoint> line = new LinkedList<>(); // 一線段
	
	// 把蒐集回來的點放到LL, 再放到LL中儲存成線段
	//private LinkedList<LinkedList<RevPoint>> lines = new LinkedList<>();	
	
	
	public RevView() {
		setBackground(Color.YELLOW);	// 簽名板背景色
		
		/*	兩個整合成一個mouseListener
		 * 	原本會需要兩個實作MouseListener & MouseMotionListener
		 * 	但透過MouseAdapter讓程式精簡化
		 * 	實作MouseAdapter內部類別 listen 兩個功能
		 */
		addMouseListener(mouseListener);	// for click
		addMouseMotionListener(mouseListener); // for movement
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		/*	透過別的方法觸發此方法
		 * 	而非直接呼叫	=> 一個元素的生命週期
		 * 	使用者隨時看到的畫面
		 * 
		 * 	> 為了效能: 盡量在這方法只做讓畫面異動的動作
		 * 
		 * 	setStroke抽象方法 => 已由paintCompoonent實作
		 */
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		
		g2d.setColor(Color.BLUE);	// 畫筆顏色
		g2d.setStroke(new BasicStroke(4)); // 產生畫筆
		// g2d.drawLine(0, 0,100,100);	// 顯示線
		
		// 畫單一一條線 (線都會連在一起)
		for (int i = 1; i < line.size(); i++) {
			RevPoint p0 = line.get(i-1); // 線段起始點
			RevPoint p1 = line.get(i);	// 下一個點
			g2d.drawLine(p0.x, p0.y, p1.x, p1.y);
		}
		
	}
	
	// 滑鼠偵測的內部類別
	private class MyMouseListener extends MouseAdapter {
		
		@Override
		public void mousePressed(MouseEvent e) {
			//	super.mousePressed(arg0);
			//	滑鼠偵測=>收集座標點=>座標點交給paint畫出線段
			RevPoint point = new RevPoint(e.getX(), e.getY());
			// 線段
			//LinkedList<RevPoint> line = new LinkedList<>();
			line.add(point); // 將點放入line中
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			//	super.mouseDragged(arg0);
			RevPoint point = new RevPoint(e.getX(), e.getY());
			line.add(point);
			repaint();
		}
	}
	
	private class RevPoint implements Serializable {
		//	儲存座標位置
		int x, y;
		public RevPoint(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
}
