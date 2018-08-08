package tw.org.iii.practiceJava;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
 * 	9. 按鈕可以抓到input值
 * 	10. 核心功能: 判斷幾A幾B
 * 	11. 調整字體顯示大小
 * 	12. 猜對時跳出對話框, 猜滿十次跳答案
 * 	13. 按下猜按鈕游標自動移到輸入框 (API 還沒找到)
 * 	14. 檢查輸入值是否符合規格
 * 	15. 玩完一局時自動重製開新局
 */

/*	版面配置: BorderLayout
 * 	分天地東西南北
 * 
 */

/*	程式設計重點: 確認整個程式的核心功能是甚麼, 那就先處理它.
 * 	例: 購物網站-->購物車 完成了再處理會員管理
 * 
 */

public class Reviewed_GuessNum extends JFrame{
	// fields (猜數字需要的原件)
	private JButton btnGuess;	// 啟動按鈕
	private JTextField input;	// 輸入框
	private JTextArea history; // 顯示猜的過程 幾A幾B
	private String answer = createAnswer();	// 儲存謎底
	private int counter; // 會被其他方法呼叫到所以放這裡 (基本型別預設就是0)
	
	// constructor
	public Reviewed_GuessNum() {
		// 操作父類別建構式(傳入視窗標題)
		super("Game: Guess Number");
		
		// 產生各元件的物件實體
		btnGuess = new JButton("Guess");
		input = new JTextField();
		history = new JTextArea();
		
		// 調整元件
		input.setFont(new Font("Default", Font.PLAIN, 25));
		history.setFont(new Font("Default", Font.BOLD, 30));
		
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
//				System.out.println("Clicked");
			}
		});
		
		// 偷印一下答案
		System.out.println("Answer: " + answer);
	}
	
	// methods
	void doGuess() { // 物件方法
		counter++; // 計算猜題次數
		String result = checkAB();
		
		// 顯示猜數字歷程
		if (result.equals("Wrong")) {
			// JOptionPane.showMessageDialog(null, "請輸入三位數數字");
			history.append(counter + ". " + "輸入錯誤: 請輸入三位數數字\n");
			input.setText("");
		}else {
			history.append(counter+ ". " + input.getText() + " >> " +result + "\n");	//  顯示猜數字過程
			input.setText(""); // 將輸入框抹去
		}
		
		
		// 猜對時跳出對話框
		if (result.equals("3A0B")) { // 字串用equals阿~
			// 對話框 
			// 其實還是沒有懂...(為什麼使用null-->對話框會與其所屬parent有關, null=>代表無關, 只是show出)
			// 如果parent是目前視窗可用this=>有所謂的互動回應!?
			JOptionPane.showMessageDialog(null,"恭喜老爺賀喜夫人~");
			history.setText(""); // 抹除
			answer = createAnswer(); // 重設謎底
			counter = 0;	// 重設計數
			System.out.println("Answer: "+answer);
		}else if (counter == 10) {
			JOptionPane.showMessageDialog(null, "Such a loser...The answer is " + answer);
			history.setText(""); // 抹除
			answer = createAnswer(); // 重設謎底
			counter = 0;	// 重設計數
			System.out.println("Answer: "+answer);
		}
		
		// 按下按鈕後自動把游標移到輸入框
		input.requestFocusInWindow();
		// System.out.println(input.requestFocusInWindow());
	}
	
	String checkAB() { // 確認使用者輸入是否有猜對
		String inputGuess = input.getText();	// 取得使用者輸入的內容
		int a = 0,b = 0;
		System.out.println("Input: " + inputGuess);
		//	檢查每一位數字是否與謎底相同(幾A幾B)
		//	A=>位置跟數字都對; B=>數字對位置錯
		
		if (inputGuess.matches("^[0-9]{3}$")) { // 利用正規表示法檢查輸入是否為三位數字
			for (int i=0; i < inputGuess.length();i++) {
				if (inputGuess.charAt(i) == answer.charAt(i)) {	// 這裡要小心,如果是使用字串比對要使用equals
					// 使用charAt會回傳基本型別char 所以用等於等於沒關係
					a++;
				}else {
					if (answer.indexOf(inputGuess.substring(i, i + 1)) >= 0) { // 如果inputGuess數字有在裡面
						b++;
					}				
				}
			}
		}else {	// 規格不符回傳"Wrong"
			return "Wrong";
		}
		return a+ "A" + b + "B";
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
