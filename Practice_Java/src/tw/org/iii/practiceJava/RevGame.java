package tw.org.iii.practiceJava;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*	20180819PM1 週期任務應用_Ball Game
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
public class RevGame extends JFrame{
	private GamePanel gPanel;
	
	public RevGame() {
		super("Ball Game (Review)");
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
		private int ballH, ballW, viewH, viewW, ballX, ballY, dx, dy;
		private Timer timer;
		
		public GamePanel() {
			timer = new Timer();
			dx = dy = 5; // 球的位移量
			// 建構球
			try {
				ball = ImageIO.read(new File("dir1/ball.png"));
				ballH = ball.getHeight();
				ballW = ball.getWidth();
			} catch (IOException e) {
				System.out.println(e);
			}
			
			//	把畫面repaint的動作獨立出來 (FPS的觀念)
			timer.schedule(new BallTask(), 0, 33);
			timer.schedule(new ViewTask(), 0, 33);
		}
		
		@Override
		protected void paintComponent(Graphics e) {
			super.paintComponent(e);
			Graphics2D g2d = (Graphics2D)e;
			viewH = getHeight();
			viewW = getWidth();
			
			g2d.drawImage(ball, ballX, ballY, null);
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
			@Override
			public void run() {
				if (ballX < 0 || ballX+ballW > viewW) {
					dx *= -1;
				}
				if (ballY < 0 || ballY+ballH > viewH) {
					dy *= -1;
				}
				
				ballX += dx;
				ballY += dy;
				// repaint(); 
				// 球每一動一次就repaint, 當球很多顆的時候就不合理
				// 將更新畫面的動作獨立出來
				// 讓balltask只負責更新位置
			}
		}
	}
	
	
	public static void main(String[] args) {
		new RevGame();
	}

}
