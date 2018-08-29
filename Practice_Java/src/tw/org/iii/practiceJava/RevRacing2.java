package tw.org.iii.practiceJava;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*	20180825PM2 Racing2
 * 	追加時鐘
 */

public class RevRacing2 extends JFrame{
	private JButton start;
	private JLabel[] lanes = new JLabel[8];
	private Horse[] horses = new Horse[8];
	private int rank;
	private Web_Clock clock;
	
	public RevRacing2() {
		super("RevRacing");
		setLayout(new GridLayout(9,0));
		
		JPanel top = new JPanel(new BorderLayout());
		start = new JButton("Start");
		clock = new Web_Clock();
		clock.setSize(60, 60);
		// add button
		
		top.add(start, BorderLayout.CENTER);
		top.add(clock, BorderLayout.WEST);
		
		add(top);
		
		//　add lanes
		for (int i = 0; i < lanes.length; i++) {
			lanes[i] = new JLabel((i+1)+".");
			add(lanes[i]);
		}
		
		start.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				newRound();
				start.setEnabled(false); // disable the button when the game start
			}
		});
		
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void newRound() {
		rank = 1;
		// every round => new every horse
		for (int i=0; i < horses.length; i++) {
			lanes[i].setText((i+1)+"."); // clear the lanes
			horses[i] = new Horse(i); // create new horses
			horses[i].start(); // place horses thread into run pool
		}
	}
	
	private void stopGame() {
		for (int i=0;i<horses.length; i++) {
			// 通知所有馬匹執行緒停止 => 利用interrupt=>產生例外 在例外處理 break
			horses[i].interrupt();
			start.setEnabled(true); // enable the button
		}
	}
	
	private class Horse extends Thread {
		// a living horse XD
		int lane; // which lanes should the horse run on
		
		public Horse(int lane) {
			this.lane = lane;
		}
		
		@Override
		public void run() {
			// 生命表現在run方法 (跑起來)
			for (int i = 0; i < 100; i++) {
				lanes[lane].setText(lanes[lane].getText()+">");
				if (i == 99) {
					// show the ranks
					lanes[lane].setText(lanes[lane].getText()+rank++);
					stopGame(); // 第一名跑到了就會停止
				}
				try {
					// makes them run in different speed
					Thread.sleep(50 + (int)(Math.random()*200));
				} catch (InterruptedException e) {
					//	System.out.println(e);
					break;  // 提早結束
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		new RevRacing2();

	}

}
