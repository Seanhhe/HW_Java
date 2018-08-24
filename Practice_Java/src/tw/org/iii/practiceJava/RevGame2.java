package tw.org.iii.practiceJava;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*	20180819PM1 週期任務應用_Ball Game (進階版)
 * 	
 * 	1. 	建立版面 (球移動的區域)
 * 	2.	建立球體
 * 	3. 	加入Timer
 * 	4.	加入FPS的觀念
 * 	
 * 	進階: 多顆球/每顆球都是獨立的
 * 	
 * 	結合LinkedList/MouseAdapter/
 * 	
 */
public class RevGame2 extends JFrame{
	private GamePanel gPanel;
	
	public RevGame2() {
		super("Ball Game Improved (Review)");
		setLayout(new BorderLayout());
		
		gPanel = new GamePanel();
		add(gPanel, BorderLayout.CENTER);
		
		setVisible(true);
		setSize(640, 480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	// 球在這裡面跑
	private class GamePanel extends JPanel {
		private BufferedImage ball;
		private int ballH, ballW, viewH, viewW;
		private Timer timer;
		private LinkedList<BallTask> balls = new LinkedList<>();
		
		public GamePanel() {
			timer = new Timer();
			// 建構球
			try {
				ball = ImageIO.read(new File("dir1/ball.png"));
				ballH = ball.getHeight();
				ballW = ball.getWidth();
			} catch (IOException e) {
				System.out.println(e);
			}
			
			addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent q) {
					// 每點一次新增一顆球
					addBall(q.getX()-(int)(ballW/2f), q.getY()-(int)(ballH/2f));
				}
			});
			
			
			//	把畫面repaint的動作獨立出來 (FPS的觀念)
			//timer.schedule(new BallTask(), 0, 33);
			timer.schedule(new ViewTask(), 0, 33);
		}
		
		// 加球方法
		private void addBall(int x, int y) {
			// 建立新的球
			BallTask ballTask = new BallTask(x, y);
			// 多久做一次
			timer.schedule(ballTask, 500, 60);
			// 新做的球放到資料結構中
			balls.add(ballTask);
		}
		
		@Override
		protected void paintComponent(Graphics e) {
			super.paintComponent(e);
			Graphics2D g2d = (Graphics2D)e;
			viewH = getHeight();
			viewW = getWidth();
			
			for (BallTask ball:balls) {
				g2d.drawImage(this.ball, ball.x, ball.y, null);
			}
			
		}
		
		private class ViewTask extends TimerTask {
			// 內部類別中的類別
			@Override
			public void run() {
				repaint();
				// 負責更新畫面
			}
		}
		
		private class BallTask extends TimerTask {
			//	設計球搬到這裡
			int x, y, dx, dy;
			
			public BallTask(int x, int y) {
				this.x = x;
				this.y = y;
				dx = dy = 6;
			}
			
			@Override
			public void run() {
				if (x < 0 || x+ballW > viewW) {
					dx *= -1;
				}
				if (y < 0 || y+ballH > viewH) {
					dy *= -1;
				}
				
				x += dx;
				y += dy;
				// repaint(); 
				// 球每一動一次就repaint, 當球很多顆的時候就不合理
				// 將更新畫面的動作獨立出來
				// 讓balltask只負責更新位置
			}
		}
	}
	
	
	public static void main(String[] args) {
		new RevGame2();
	}

}
