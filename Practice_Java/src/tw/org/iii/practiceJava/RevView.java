package tw.org.iii.practiceJava;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;

import javax.imageio.ImageIO;
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
 * 	8.	利用for迴圈重複畫每個小線段 (實測後發現都會連成一條線, 無法有筆畫)
 * 	9.	LinkedList<LinkedList<RevPoint>> (點-->線段-->筆畫)
 * 	10.	點下去跟按著不放的差異 => 點下去是新線段/按著放開後事線段的最後一點
 * 	11.	點下去或按著不放都要不斷的把座標傳到LL中, 再交給repaint中的迴圈印出.
 * 	12.	單一迴圈只有線段, 筆畫需要再一層迴圈
 * 	13.	基本功能完成 => 再寫 clear 清除畫面功能
 * 	14.	在RevSign按鈕綁定clear功能 [核心功能到位延伸的就好寫]
 * 	15.	undo
 * 	16.	redo
 * 	17. save功能
 * 	
 */
public class RevView extends JPanel{
	private MyMouseListener mouseListener = new MyMouseListener();
	//private LinkedList<RevPoint> line = new LinkedList<>(); // 一線段
	
	// 把蒐集回來的點放到LL成線段, 再放到LL中儲存成很多線段(筆畫)
	// 泛型 => <線段> 線段裡面是RevPoint泛型
	private LinkedList<LinkedList<RevPoint>> lines = new LinkedList<>();
	// 存放被刪除的線段(資源回收桶)
	private LinkedList<LinkedList<RevPoint>> recycle = new LinkedList<>();	
	
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
		
		
		//	畫多條線
		for (LinkedList<RevPoint> line : lines) {
			// 畫單一一條線 (對使用者而言是畫一整條)
			for (int i = 1; i < line.size(); i++) {
				RevPoint p0 = line.get(i-1); // 線段起始點
				RevPoint p1 = line.get(i);	// 下一個點
				g2d.drawLine(p0.x, p0.y, p1.x, p1.y);
			}
		}
		
		
		
	}
	
	public void clear() {
		lines.clear(); // 清除資料結構內的資料
		repaint();	// 重繪
	}
	
	public void undo() {
		// 上一步==> 拿掉最後一條線段
		if (lines.size() > 0) {
			// 先確認有最後一條再移除
			//lines.removeLast();
			/*	由於remove後會回傳被移除的那個最後一個LL
			 * 	所以先把回傳的放到recycle中, 若使用者需要可再提取
			 * 	=> 供redo使用
			 */
			recycle.add(lines.removeLast());
		}
		repaint();
	}
	
	public void redo() {
		if (recycle.size() > 0) {
			lines.add(recycle.removeLast());
			/*	把recycle最後的那個拋回給lines	
			 * 	=> 就會是使用者最後清除的那條線段
			 */
		}
		repaint();
	}
	
	public void saveJPEG1() {
		//	第二招
		BufferedImage paintImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D graphics2D = paintImage.createGraphics();
		paint(graphics2D);
		try {
			ImageIO.write(paintImage, "jpg", new File("dir2/save2.jpg"));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	// 滑鼠偵測的內部類別
	private class MyMouseListener extends MouseAdapter {
		
		@Override
		public void mousePressed(MouseEvent e) {
			//	super.mousePressed(arg0);
			//	滑鼠偵測=>收集座標點=>座標點交給paint畫出線段
			RevPoint point = new RevPoint(e.getX(), e.getY());
			// 點下去是產生新線段
			LinkedList<RevPoint> line = new LinkedList<>();
			line.add(point); // 將點放入線段line中
			lines.add(line); // 把線段放入筆畫集合裡
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			//	super.mouseDragged(arg0);
			RevPoint point = new RevPoint(e.getX(), e.getY());
			lines.getLast().add(point);	// 該點是放在該筆畫的最後一個點
			repaint();
		}
	}
	
	public LinkedList<LinkedList<RevPoint>> getLines() {
		// 傳到外部讓RevSign儲存物件
		return lines;
	}
	
	
}


class RevPoint implements Serializable {
	/*	為了儲存物件的方法, 將RevPoint從原本的內部類別改成外部類別
	 * 	並實作可序列化
	 */
	
	//	儲存座標位置
	int x, y;
	public RevPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
