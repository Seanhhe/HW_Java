package tw.org.iii.practiceJava;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/*	20180819AM2 Brad74
 * 	Interface_Map
 * 	=> Key 不會重複 (如果重複設定是會覆蓋前面的)
 * 	=> 沒有順序性, 在意的是Key&Value的對應
 * 
 * 	實作=> HashMap
 * 	
 * 	可應用=>稍早做過的簽名程式 (座標的x,y)
 */

public class Rev076_HashMap {

	public static void main(String[] args) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("name", "John");
		map.put("stage", 2);
		map.put("sound", false);
		map.put("other", 2);
		map.put("other", 2); // 有一個被覆蓋了
		map.put("other", 4);
		System.out.println(map);
		System.out.println(map.get("name"));
		System.out.println(map.get("stage"));
		
		System.out.println("-----尋訪各Key值-----");
		
		Set<String> keys = map.keySet();
		for (String key : keys ) {
			System.out.println(map.get(key));
		}
		
		System.out.println("---value 方法---");
		//	Returns a Collection view of the values contained in this map.
		
		Collection<Object> v1 = map.values();
		for (Object obj: v1) {
			System.out.println(obj);
		}
	}

}
