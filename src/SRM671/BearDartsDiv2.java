package SRM671;


import java.util.HashMap;
import java.util.Map;

public class BearDartsDiv2 {
	
	
	
	public static void printMap(Map<String, Integer> map)   {
		
		StringBuilder sb;
		
		
		for(Map.Entry<String, Integer> e : map.entrySet()) {
			
		}
		
		
		for( String key : map.keySet()) { 
			System.out.println("key: " + key + " value: " + map.get(key));
		}
		
		System.out.println("------------");
	}
	
	
	public static void main(String [] args) { 
		
		
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		HashMap<String, Integer> map2 = new HashMap<String, Integer>(map);
		
		
		map.put("Igor", 1);
		map.put("Petrovski", 2);
		
		printMap(map);
	
		
		map2.put("Igor", 32636);
		
		printMap(map);
		printMap(map2);
		
	}

}
