package tw.org.iii.practiceJava;

public class Reviewed001 {

	public static void main(String[] args) {
		// Java 屬於強型別語言 (PHP/JavaScript屬於弱型別)
		// 強型別多屬於編譯語言
		// 任何變數皆須宣告才能使用, 宣告完後型態不會/不能改變.
		
		// 整數部分型態 (基本型別)
		// 紅字保留字
		
		//byte -128~127=> 256 => 2^8 
		byte b1;
		b1 = 12;
		System.out.println(b1);
		
		//	超出範圍, 編譯失敗.
		//	byte b2 = 128;
		//	byte b3 = -129;
		
		//	變數命名規則 [第一位][第二位]
		//	[a~z/A~Z/$/_][a~z/A~Z/0~9/$/_]* (*字號代表變數可能只有一位)
		//	**變數命名不可為保留字/關鍵字
		
		byte $$$ = 12;
		System.out.println($$$);
		
		byte aZ0 = 123;
		System.out.println(aZ0);
		
		byte _$ = 127;
		System.out.println(_$);
		
		// 支援unicode 所以變數可設中文
		// **建議專案一建立就將編碼改為UTF-8
		// **換列符號delimitor要不要改?
		// **Windows預設換列\r\n  Unix預設換列\n
		// **Unix->Windows 不會換列
		// **Windows-->Unix 可以換列 (建議選擇保留預設windows)
		
		byte 變數一 = 13;
		System.out.println(變數一);
		
		//	Big5 2^16
		//	一個中文字占兩個byte (6萬多個字)
		//	微軟使用常用字方法/其他字則留一段區間造字
		
		//	UTF-8 2^24 (選他就對了XD)
		//	容量較大
		
		//	short 2^16
		short s1 = 32767;
		short s2 = -32768;
		System.out.println(s1);
		System.out.println(s2);
		
		// int 2^32 (最常用)
		int i1 = 256;
		int i2 = 12887;
		System.out.println(i1);
		System.out.println(i2);
		
		//	long 2^64
		long l1 = 12345678;
		System.out.println(l1);

	}

}
