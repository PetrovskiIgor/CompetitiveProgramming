package SRM672;


import java.util.HashMap;
import java.util.Map;


public class SubstitutionCipher {
	
	int m = Integer.MAX_VALUE;
	
	public String decode(String a, String b, String y) {
		
		Map<Character, Character> fromTo = new HashMap<Character, Character>();
		Map<Character, Character> toFrom = new HashMap<Character, Character>();
		
		
		boolean [] fromUsed = new boolean[26];
		boolean [] toUsed = new boolean[26];
		
		
		for(int i=0; i<a.length(); i++) {
			fromTo.put(a.charAt(i), b.charAt(i));
			toFrom.put(b.charAt(i), a.charAt(i));
			
			fromUsed[a.charAt(i) - 'A'] = true;
			toUsed[b.charAt(i) - 'B'] = true;
		}
		
		
		if(fromTo.size() == 25) {
			
			char from = 'r';
			char to = 'r';
			
			for(int i=0; i<26; i++) {
				if(!fromUsed[i]) {
					from = (char)('A' + i);
				}
				
				if(!toUsed[i]) {
					to = (char)('A' + i);
				}
			}
			
			fromTo.put(from, to);
		}
	
		
		StringBuilder sol = new StringBuilder();
		
		
		boolean hasSol = true;
		for(int i=0; i<y.length(); i++) {
			
			
			
			if(!toFrom.containsKey(y.charAt(i))) {
				hasSol = false;
				break;
			}
			
			sol.append(toFrom.get(y.charAt(i)));
		}
		
		
		if(!hasSol)
			return "";
		
		
		return sol.toString();
		
		
	}
	
	
	public static void main(String [] args) {
		
		SubstitutionCipher subs = new SubstitutionCipher();
		
		
		System.out.println(subs.decode("CAT", "DOG", "GOD"));
	}

}
