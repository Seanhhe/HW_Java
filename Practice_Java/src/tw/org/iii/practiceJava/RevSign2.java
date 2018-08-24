package tw.org.iii.practiceJava;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*	20180819AM1 13:00
 * 	Collection應用_簽名程式
 * 	1.	先設計程式視窗(Layout, button
 * 	2.	建立簽名板程式類別 => 之後完成再放在主程式
 * 	3.	設計簽名板程式類別 (RevSign先放一邊)
 * 
 */
public class RevSign2 extends JFrame{
	private JButton clear, undo, redo, saveObject, saveJPG, loadObject;
	private RevView2 myView;
	
	public RevSign2() {
		// 視窗建構的初始化
		super("簽名程式(複習版)2");
		
		setLayout(new BorderLayout());
		
		//	產生上半部
		JPanel top = new JPanel(new FlowLayout());
		//	產出按鈕
		clear = new JButton("清除畫面");
		undo = new JButton("上一步");
		redo = new JButton("重作");
		saveJPG = new JButton("存成JPG");
		saveObject = new JButton("存成物件");
		loadObject = new JButton("匯入物件");
		
		//	把按鈕加入上半部
		top.add(clear);
		top.add(undo);
		top.add(redo);
		top.add(saveJPG);
		top.add(saveObject);
		top.add(loadObject);
		
		//	把top放到視窗的上半部
		add(top, BorderLayout.NORTH);
		
		//	產生簽名板物件
		myView = new RevView2();
		
		//	把myView放入視窗中
		add(myView, BorderLayout.CENTER);
		
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				myView.clear();
			}
		});
		
		undo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				myView.undo();
			}
		});
		
		redo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				myView.redo();
			}
		});
		
		saveJPG.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				saveJPEG();
				myView.saveJPEG1();
			}
		});
		
		saveObject.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				saveObject();
			}
		});
		
		loadObject.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadObject();
			}
		});
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	// 儲存JPEG
	private void saveJPEG() {
		// 第一招
		// https://stackoverflow.com/questions/19621105/save-image-from-jpanel-after-draw
		// 利用螢幕截圖的方法
		BufferedImage imagebuf = null;
		try {
			imagebuf = new Robot().createScreenCapture(myView.bounds());
		} catch (AWTException e) {
			System.out.println(e);
		}
		
		Graphics2D graphics2D = imagebuf.createGraphics();
		myView.paint(graphics2D);	// 為什麼要再畫一次? => 儲存繪圖的部分, 沒有的話是擷取視窗截圖
		try {
			ImageIO.write(imagebuf, "jpeg", new File("dir2/save2.jpeg"));
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	// 將簽名物件序列化輸出
	private void saveObject() {
		// 取得LL物件
		LinkedList<LinkedList<HashMap<String,Integer>>> lines = myView.getLines();
		
		// 輸出
		try {
			ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream("dir2/sign2.obj"));
			oout.writeObject(lines);
			oout.flush();
			oout.close();
			JOptionPane.showMessageDialog(this, "儲存成功");
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}
	
	// 將已經序列化的簽名物件讀入
	private void loadObject() {
		try {
			ObjectInputStream oin = new ObjectInputStream(new FileInputStream("dir2/sign2.obj"));
			
			//	 把收到的東西轉回來
			LinkedList<LinkedList<HashMap<String,Integer>>> input = (LinkedList<LinkedList<HashMap<String,Integer>>>)oin.readObject();
			
			oin.close();
			
			// 把讀出的內容放回myView
			myView.setLines(input); 
			myView.repaint();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public static void main(String[] args) {
		new RevSign2();
	}
}
