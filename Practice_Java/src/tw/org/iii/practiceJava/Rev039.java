package tw.org.iii.practiceJava;

public class Rev039 {
	/**	NOTE 20180805PM1 多重介面的實作
	 *	
	 * 	介面可以多重繼承其他介面 (複合式的證照: 先考A再考B=AB都要通過)
	 * 	-->但是介面沒有辦法再宣告implement, 因為介面沒有實作
	 * 	
	 * 	類別只能單一繼承
	 * 	但是可以實現多重介面 (人可以考很多張證照)
	 */
	public static void main(String[] args) {

	}

}

interface Rev0391 {
	void m1();
}

interface Rev0392 {
	void m2();
}

interface Rev0393 extends Rev0391, Rev0392 { // 繼承391,392
	void m3();
}

class Rev0394 implements Rev0393 { // 多重介面的實作
	@Override
	public void m1() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void m2() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void m3() {
		// TODO Auto-generated method stub
		
	}
}