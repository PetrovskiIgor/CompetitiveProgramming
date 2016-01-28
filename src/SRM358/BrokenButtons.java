package SRM358;


// page_left … page … page_right

public class BrokenButtons {
	static int sz = 10;
	boolean [] isBroken = new boolean[sz];

	public boolean isValid(int num) { 
		if(num < 10) { 
			return !isBroken[num];
		}
		
		if(isBroken[num%10]) return false;
		return isValid(num/10);
		
	}

	public int numDig(int num) { 
		if(num < 10) return 1;
		return 1 + numDig(num/10);
	}
	public int minPresses(int page, int[] broken) {
		int best = (int)Math.abs(page - 100);
		
		if(broken.length == 10) 
			return best;
		
		
		
		for(int i=0; i<broken.length; i++) isBroken[broken[i]] = true;
		int l = page;
		
		while(l>=0) { 	
if(isValid(l)) { 
	int d = numDig(l);
	if(d + Math.abs(l - page) < best) 
		best = d + Math.abs(l - page);
	break;
}			
			l--;
		}
		if(broken.length == 9 && isBroken[0] == false) { 
			return best;
		}
		
		int r = page + 1;
		while(true) { 
			if(isValid(r)) { 
				System.out.println("r: " + r);
				int d = numDig(r);
				if(d + Math.abs(r - page) < best) 
					best = d + Math.abs(r - page);
				
				
				break;
			}
			
			r += 1;
		}

		return best;
	}
	
	
	public static void main(String [] args) { 
		BrokenButtons bb = new BrokenButtons();
		
		int sol = bb.minPresses(99999, new int[]{0, 2, 3, 4, 5, 6, 7, 8, 9});
		
		System.out.println(sol);
	}

		

}

