package p2;
/*	0811AM2 Package 10:41
 * 
 */
public class Rev03 extends p1.Rev01{
	/*	相同Package可以直接繼承
	 * 	若要繼承不同Package內的類別
	 * 	--> import or p1.Rev01
	 */
	int m1() { // 可以改寫成不同回傳型別-->更證明不是override
		/*	這裡不是override p1.Rev01裡的m1();
		 * 	因為: 被繼承的方法沒有存取修飾字(不提供給不同package使用)
		 * 	==>只能存取相同package
		 * 	存取修飾字影響是否看的到該方法-->影響是否能夠使用
		 */
		return 1;
	}
	
	@Override
	protected void m2() {
		/*	protected = 相同package || 繼承的子類別 可以存取
		 * 	通常API裡面的protected方法 基本上就是要"繼承"才能使用 
		 * 	--> 因為不可能跟API相同Package阿~
		 */
		super.m2();
	}
}
