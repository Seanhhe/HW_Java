package tw.org.iii.practiceJava;

public class Reviewed_TWid2 {
	
	/*	台灣身份證字號驗證/產生器(Rewrite)
	 * 	
	 * 	目標: 
	 * 	1. 使用者可以輸入身分證字號檢驗是否正確
	 * 	2. 依使用者需求(地區/性別)亂數產生身分證字號
	 * 	
	 * 	
	 * 	
	 */
	
	//	Fields
	private String id;
	static final String letters = "ABCDEFGHJKLMNPQRSTUVXYWZIO";
	
	//	Constructor
	
	Reviewed_TWid2() {	// 1號
		// 隨機產生地區, 讓呼叫2-->4
		this((int)(Math.random()*26));
	}
	
	Reviewed_TWid2(int area) {	// 2--4
		this(area, (int)(Math.random()*2)==0);
	}
	
	Reviewed_TWid2(boolean isMale) {	// 3-->4
		// auto create id by gender
		this((int)(Math.random()*26),isMale);
	}
	
	Reviewed_TWid2(int area, boolean isMale) {	// 4
		// auto create id by area and gender
		//	真正產生id的引擎 (宣告物件的同時初始化-->產生合格新id)
		String a1 = letters.substring(area, area+1);
		String a2 = isMale?"1":"2";
		
		String newId = a1.concat(a2)
				.concat(String.valueOf((int)(Math.random()*10))) //	valueOf(int i) Returns the string representation of the int argument.
				.concat(String.valueOf((int)(Math.random()*10)))
				.concat(String.valueOf((int)(Math.random()*10)))
				.concat(String.valueOf((int)(Math.random()*10)))
				.concat(String.valueOf((int)(Math.random()*10)))
				.concat(String.valueOf((int)(Math.random()*10)))
				.concat(String.valueOf((int)(Math.random()*10)));
		//	檢查碼
		for (int i=0; i <=9;i++) {
			if (checkId(newId+i)) {
				this.id = newId+i;
				break;
			}
		}
	}
	
	//	Methods
	
	// 	驗證
	static boolean checkId(String id) {
		boolean isCorrect = false;
		if (id.matches("^[A-Z][12][0-9]{8}$")) {	// matches the format
			// formula test
			int a12 = letters.indexOf(id.charAt(0))+10;
			int a1 = a12 / 10;
			int a2 = a12 % 10;
			int a3 = Integer.parseInt(id.substring(1,2));
			int a4 = Integer.parseInt(id.substring(2,3));
			int a5 = Integer.parseInt(id.substring(3,4));
			int a6 = Integer.parseInt(id.substring(4,5));
			int a7 = Integer.parseInt(id.substring(5,6));
			int a8 = Integer.parseInt(id.substring(6,7));
			int a9 = Integer.parseInt(id.substring(7,8));
			int a10 = Integer.parseInt(id.substring(8,9));
			int a11 = Integer.parseInt(id.substring(9,10));
			int sum = a1*1 + a2*9 + a3*8 + a4*7 + a5*6 + a6*5 + 
					a7*4 + a8*3 + a9*2 + a10*1 + a11*1;
			isCorrect = sum % 10 == 0;
		}
		return isCorrect;
	}

	// 	使用者讀取
	String getId() {
		return this.id;
	}
	
	//	把產生的ID透過static方法回傳
	static Reviewed_TWid2 createId(String id) {
		if (checkId(id)) {
			return new Reviewed_TWid2(id);	// 呼叫下面的private
		}else {
			return null;
		}
	}
	
	// 建立Reviewed_TWid2方法給內部呼叫
	private Reviewed_TWid2(String id) {
		this.id = id;
	}
	
}
