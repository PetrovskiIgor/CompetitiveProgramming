package SRM677;

import java.util.HashMap;

public class DoubleOrOneEasy { 
	
	HashMap<String, Integer> map;
	
	public int solve(long a, long b, long newA, long newB) {
		
		//System.out.println(a + " " + b + " " + newA + " " + newB);
		if(a > newA || b > newB) 
			return -1;

		String key = newA + " " + newB;
		Integer res = map.get(key);
		
		if(res != null) { 
			return res;
		}
		
		res = Integer.MAX_VALUE;
		int pot = -1;
		if(newA%2 == 0 && newB%2 ==0) { 
			
			pot = 1 + solve(a,b, newA/2, newB/2);
			
			if(pot != -1) { 
				res = Math.min(res, pot);
			}
		}

		pot = 1 + solve(a,b, newA - 1, newB - 1);
		
		if(pot != -1)
			res = Math.min(res, pot);
		
		
		if(res != Integer.MAX_VALUE) 
			map.put(key, res);
		else
			map.put(key, -1);

		return map.get(key);
		
	}
	
	public int minimalSteps(int a, int b, int newA, int newB) { 
		map = new HashMap<String, Integer>();

		map.put(a + " " + b, 0);
		int sol = solve(a,b,newA,newB);


		return sol;

	}
	
	public static void main(String [] arr) { 
		
		DoubleOrOneEasy d = new DoubleOrOneEasy();
		
		int a = 1;			
		int b = 2;
		int newA = 10000;
		int newB = 10000;
		
		System.out.println(d.minimalSteps(a, b, newA, newB));
	}


}
