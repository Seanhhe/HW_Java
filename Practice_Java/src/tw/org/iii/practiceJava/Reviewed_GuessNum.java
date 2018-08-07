package tw.org.iii.practiceJava;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/*	20180804PM1 猜數字遊戲 (視窗&物件導向實作)
 * 	
 * 	1. 確認設計想法(版面配置/所需元件/功能)
 * 	2. 設定視窗
 * 	3. 建立各元件的物件實體
 * 	4-1. 版面設計: 區分成上下部分, 上半部為輸入框與按鈕, 下半部為顯示區域
 * 	4-2. 先處理下半部
 * 	4-3. 再處理上半部(JPANEL), 有點像是把兩個元件放進這個隔間裡, 再把這個完成的隔間放到上半部
 * 	5. 把上半部放進視窗
 * 	6. 版面完成了, 如何讓按鈕觸發事件[addActionListener]
 * 	7. 觸發事件建立並呼叫方法(doGuess) [建構式暫時完成]
 * 	8. 產生謎底的方法
 */

/*	版面配置: BorderLayout
 * 	分天地東西南北
 * 
 */

public class Reviewed_GuessNum extends JFrame{
	// fields (猜數字需要的原件)
	private JButton btnGuess;	// 啟動按鈕
	private JTextField input;	// 輸入框
	private JTextArea history; // 顯示猜的過程 幾A幾B
	private String answer;	// 儲存謎底
	
	// constructor
	public Reviewed_GuessNum() {
		// 操作父類別建構式(傳入視窗標題)
		super("Game: Guess Number");
		
		// 產生各元件的物件實體
		btnGuess = new JButton("Guess");
		input = new JTextField();
		history = new JTextArea();
		
		// 下半部/版面配置 [使用邊界法]
		setLayout(new BorderLayout());
		add(history, BorderLayout.CENTER);
		
		// 上半部 [利用JPANEL, 並把按鈕與輸入框的元素放進去]
		JPanel top = new JPanel(new BorderLayout());	// 僅在初始化時表現其功能-->當區域變數就好
		top.add(input,BorderLayout.CENTER);
		top.add(btnGuess,BorderLayout.EAST);
		
		// 把組裝完的上半部加到視窗裡
		add(top,BorderLayout.NORTH);
		
		// 視窗大小/顯示/關閉時同步關閉程式
		setSize(640,480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		/*	觸發事件 (delegate 委託機制)
		 * 	addActionListener(); [javax.swing.AbstractButton]
		 * 	-->Interface ActionListener
		 */
		
		// 按鈕的觸發事件
		btnGuess.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 觸發的內容, 呼叫doGuess方法
				doGuess();
				System.out.println("Clicked");
			}
		});
	}
	
	// methods
	void doGuess() { // 物件方法
		
	}
	
	String checkAB() { // 確認使用者輸入是否有猜對
		return "";
	}
	
	String createAnswer() { // 亂數產生謎底
		int[] randomNum = new int[10];
		for (int i=0; i<randomNum.length; i++) {
			boolean isRepeat;
			int temp;
			
			do {
				temp = (int)(Math.random()*10);
				
				// 檢查避免重複
				isRepeat = false;
				for (int j = 0; j < i; j++) {
					if (randomNum[j] == temp) {
						isRepeat = true;
						break;
					}
				}
			}while(isRepeat == true);
			randomNum[i] = temp;
		}
		return "" + randomNum[0] + randomNum[1] + randomNum[2]; //	字串+整數=>字串
	}
	
	public static void main(String[] args) {// 程式的執行點
		// 產生視窗
		new Reviewed_GuessNum();
		
	}

}
