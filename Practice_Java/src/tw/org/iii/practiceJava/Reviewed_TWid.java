package tw.org.iii.practiceJava;

public class Reviewed_TWid {
	/*	20180729PM
	 * 	身份證字號產生器&驗證器
	 * 	身份證字號物件
	 * 	屬性:id
	 * 
	 */
	
	/*	從使用者觀點下手, 需要甚麼樣的功能/方法
	 * 	目標: 1. 產生合法的ID 2. 是存在的值
	 */
	
	/*	static 關鍵字
	 * 	1. 不屬於任何一個物件, 是該類別所擁有的. (書上的講法)
	 * 	2. 是屬於這個類別(級別)可以呼叫的 [只是為了分類的要求]
	 * 	3. 是個功能性的東西, 與物件無關.
	 * 	4. static 裡面不會有該類別所在的物件存在
	 * 	5. 物件可以呼叫static方法
	 * 	6. static方法只能呼叫static方法
	 */
	
	/*	設計方向
	 * 	1. 確認使用者輸入的格式正確
	 * 		1. 長度 .length()
	 * 		2. 第一碼為英文字.charAt(0), .substring(), .matches
	 * 		3. 第二碼為1/2
	 * 		4. 第三碼後全為數字
	 * 	2. 進入身分證檢查公式
	 * 
	 */
	
	/*	正規表示法 [各大系統都支援,很重要]
	 * 	^開始
	 * 	$結尾
	 * 	[A-Z]字元集合範圍內取一個 e.g.[0-9], [12]
	 * 	{重複次數}
	 * 	. 代表該字元任何字都可以
	 */
	
	// 屬性
	private String id;
	static final String letters = "ABCDEFGHJKLMNPQRSTUVXYWZIO";
	
	// 建構式
	//	只有這四招可以產生身分證(自動產生)
	//	但若讓使用者直接存取 TWid(String id) {this.id = id;}
	//	已完成初始化, 所以無法驗證.
	//	所以改成private並利用新建的static方法存取他
	//	不管使用者怎麼操作, TWid產生的物件實體都會是正確的ID號碼;
	Reviewed_TWid(){
		//	隨機產生男女(true/false), 交給isMale去做
		this((int)(Math.random()*2)==0);
	}
	
	Reviewed_TWid(boolean isMale){
		// 兩個參數(使用者輸入, 亂數產生地區碼0~25)
		this(isMale, (int)(Math.random()*26));
	}
	
	Reviewed_TWid(int area){
		// 兩個參數(隨機產生true/false, 使用者輸入地區)
		this((int)(Math.random()*2)==0, area);
	}
	
	Reviewed_TWid(boolean isMale, int area) {
		String i1 = letters.substring(area,area+1);
		String i2 = isMale?"1":"2";
		
/*		// 寫法一
 * 		String newId = i1 + i2 +
				(int)(Math.random()*10) +
				(int)(Math.random()*10) +
				(int)(Math.random()*10) +
				(int)(Math.random()*10) +
				(int)(Math.random()*10) +
				(int)(Math.random()*10) +
				(int)(Math.random()*10); // 字串加整數=字串
*/		
		
		/*
		 * 	// 寫法二_newId2 物件導向寫法-->組合第一碼到第九碼
		 * 	使用concat (會包含舊字串回傳新字串)
		 * 	valueOf (Returns the string representation of the int argument.)
		 */		
		
		String newId2 = i1.concat(i2)
				.concat(String.valueOf((int)(Math.random()*10)))
				.concat(String.valueOf((int)(Math.random()*10)))
				.concat(String.valueOf((int)(Math.random()*10)))
				.concat(String.valueOf((int)(Math.random()*10)))
				.concat(String.valueOf((int)(Math.random()*10)))
				.concat(String.valueOf((int)(Math.random()*10)))
				.concat(String.valueOf((int)(Math.random()*10)));
		
		//	最後一碼檢查碼 (正確就產生正式id回傳)
		for (int i=0; i <=9; i++) {
			if (checkId(newId2+i)) {	//	字串加整數還是字串
				this.id = newId2+i;
				break;
			}
		}
		// 因為是建構式--> 沒有傳回
	}
	
	
	
	// 方法_身分證驗證法1
	static boolean checkId(String id) { 
		boolean isCorrect = false;
		if (id.matches("^[A-Z][12][0-9]{8}$")) {
			//	基本格式驗證成功 , 依據公式驗證
			int n12 = letters.indexOf(id.charAt(0))+10; //轉換字元
			int n1 = n12 / 10;
			int n2 = n12 % 10;
			//	把字串變整數
			int n3 = Integer.parseInt(id.substring(1,2));
			int n4 = Integer.parseInt(id.substring(2,3));
			int n5 = Integer.parseInt(id.substring(3,4));
			int n6 = Integer.parseInt(id.substring(4,5));
			int n7 = Integer.parseInt(id.substring(5,6));
			int n8 = Integer.parseInt(id.substring(6,7));
			int n9 = Integer.parseInt(id.substring(7,8));
			int n10 = Integer.parseInt(id.substring(8,9));
			int n11 = Integer.parseInt(id.substring(9,10));
			int sum = n1*1+n2*9+n3*8+n4*7+n5*6+n6*5+n7*4+n8*3+n9*2+n10*1+n11*1; 
			isCorrect = sum % 10 == 0; // 當運算式成立時為true
//			int a = 20/2;
//			isCorrect = a / 5 == 2;	// 設boolean為true
		}
		return isCorrect;	// 回傳判斷後的boolean值
	}
	
	// 方法_身分證驗證法2
	static boolean checkId2(String id) {
		// 不用.matches的方法
		boolean isRight = false;
		if (id.length() == 10) {
			if ( letters.indexOf(id.charAt(0)) >= 0) {	// 比對字串,是否有在裡面 (沒有會回傳-1)
				System.out.println("OK1");	
			}
 		}else {	
			System.out.println("False");
		}
		
		return isRight;
	}
	
	// 方法_回傳該物件的身分證字號
	String getId() {
		return this.id;
	}
	
	// 建立供內部呼叫的方法 [新的id]
	private Reviewed_TWid(String id) {
		this.id = id;
	}
	
	// 方法_回傳新身分證字號 (因為建構式本身沒有回傳, 所以要透過static方法才能回傳新的id字串)
	static Reviewed_TWid createTWid(String id) {	// 型別是物件型別?
		if (checkId(id)) { 	//	確認產生的id合格
			return new Reviewed_TWid(id); // 回傳新的id
		}else {
			return null;
		}
	}
	
	//	方法_讓使用者可以輸入id判斷男女 (字串版)
	String gender() {
		if (this.id.charAt(1)=='1') {
			return "男性";
		}
		return "女性";
	}
	
	//	方法_顯示男女(true/false版)
	boolean gender2() {
		boolean gender2 = false;
		if (this.id.charAt(1)=='1') {
			gender2 = true;
		}
		return gender2;
	}
	
	// 方法_查詢地區
	String showArea() {
		String[] areaName = {
				"台北市","台中市","基隆市", "台南市", "高雄市", "新北市",
				"宜蘭縣","桃園市", "新竹縣", "苗栗縣","台中縣","南投縣","彰化縣","雲林縣","嘉義縣","台南縣","高雄縣"
				,"屏東縣","花蓮縣","台東縣","澎湖縣","陽明山管理局","金門縣"
				,"連江縣","嘉義市","新竹市"
		};
		int i=0;
		for (; i < 26; i++) {
			if (this.id.charAt(0) == letters.charAt(i)) {
				// 找到了
				break;
			}
		}
		return areaName[i];
	}
	
	/*
	 * boolean m1(String id) { // static 使用體驗 
	 * 	System.out.println("KK");
	 * 	return true; 
	 * }
	 * 
	 */
	
	
}
