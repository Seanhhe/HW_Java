package tw.org.iii.practiceJava;

public class Reviewed024_TWid2 {
	public static void main(String[] args) {
		/*
		 * for Reviewed_TWid2 Test
		 */
		
		Reviewed_TWid2 id1 = new Reviewed_TWid2();
		System.out.println(id1.getId());
		
		// a valid id number?
		String a1 = "A123456789";
		
		if (a1.length()==10) {
			System.out.println("OK");
		}else {
			System.out.println("NO");
		}
		
		System.out.println(Reviewed_TWid2.checkId("A123456780"));
		
		
		
		
	}
}
