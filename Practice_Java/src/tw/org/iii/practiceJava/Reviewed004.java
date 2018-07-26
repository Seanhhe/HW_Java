package tw.org.iii.practiceJava;

import javax.swing.JOptionPane;

public class Reviewed004 {

	public static void main(String[] args) {
		// JOptionPane.showInputDialog (jdk 10.0.2會有問題...)
		String a1 = JOptionPane.showInputDialog("Input your Number_1");
		String a2 = JOptionPane.showInputDialog("Input your Number_2");
		
		int r1 = Integer.parseInt(a1);
		int r2 = Integer.parseInt(a2);
//		int r3 = r1 + r2;
//		System.out.println(r3);
		
		int r4 = r1 / r2;
		int r5 = r1 % r2;
		System.out.println( r1 + "/" + r2 + "=" + r4 + "......" + r5);
		
		
	}

}
