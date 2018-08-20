package tw.org.iii.practiceJava;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*	20180812AM2 Reader&Writer 應用_記事本 Review
 * 	
 * 	*將功能切割成小區塊-->增加程式維護的使用性
 * 	*挑核心/小功能先設計-->後續可呼叫
 * 	
 * 	1. 基礎功能確認
 * 	2. 視窗版面配置
 * 	3. 開始寫程式_設定建構式(排版)
 * 	*文字編輯超過頁面時不能捲動_JScrollPanel
 * 	4. 事件/功能設計: 按鈕功能綁定 (柿子先挑軟的吃 程式先挑會的寫)
 * 	4-1. Open功能
 * 	4-2. ReadFile
 * 
 */
public class RevMyEditor extends JFrame{
	private JButton newFile, open, saveAs, save;
	private JTextArea editor;
	private File nowFile; 
	/*	nowFile 為什麼要給null值 (參照Rev/Lab53)
	 * 	1.	因為第一次的給值=>初始化, 未初始化會導致編譯失敗.
	 * 	2.	另外是因為, 在這個類別中要開啟檔案時才會真的動到這個檔
	 * 		(如果前面沒先給值就會到這個時候才給,但是這樣會編譯失敗),
	 * 		因此要先在宣告時給null值.
	 * 	3.	雖然給null值(空), 但是不會因為沒有初始化造成編譯失敗
	 * 	
	 * 	nowFile的作用: 一次編輯一個檔案 (nowFile)
	 */
	
	public RevMyEditor() {
		super("My Editor Rev");
		
		setLayout(new BorderLayout());
		
		JPanel top = new JPanel(new FlowLayout());
		newFile = new JButton("開新檔案");
		open = new JButton("開啟舊檔");
		save = new JButton("儲存");
		saveAs = new JButton("另存新檔");
		top.add(newFile);
		top.add(open);
		top.add(save);
		top.add(saveAs);
		
		add(top, BorderLayout.NORTH);
		
		editor = new JTextArea();
		//editor.setFont(new Font("Default", 15));
		// add(editor,BorderLayout.CENTER);
		
		// 讓編輯區可以捲動
		JScrollPane jsp = new JScrollPane(editor);
		add(jsp, BorderLayout.CENTER);
		
		// Open 功能
		open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				openFile();
			}
		});
		
		// Save 功能
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				saveFile();
			}
		});
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void openFile() {
		JFileChooser jFileChooser = new JFileChooser("./dir1/");
		
		if (jFileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			// 抓取選擇的檔案
			nowFile = jFileChooser.getSelectedFile();
			// 確認是檔案而且可以讀
			if (nowFile.isFile() && nowFile.canRead()) {
				readFile();
			}
		} else {
			nowFile = null;
		}
		
	}
	
	
	private void readFile() {
		try {
			editor.setText(""); // 清空上一個檔案的文字
			FileReader reader = new FileReader(nowFile);
			int len = 0; // 儲存有多少個
			char[] buf = new char[4096]; // 字元陣列
			/*	read方法將nowFile的字元讀到buf陣列裡, 回傳讀進來的字元數[4096]
			 * 	如果字元數等於-1代表讀完了
			 */
			while((len=reader.read(buf)) != -1) {
				editor.append(new String(buf,0,len));
			}
			reader.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private void saveFile() {
		try {
			FileWriter writer = new FileWriter(nowFile);
			editor.write(writer); // 把fileWriter寫出
			JOptionPane.showMessageDialog(this, "儲存成功!");
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}
	
	public static void main(String[] args) {
		new RevMyEditor();
		
	}

}
