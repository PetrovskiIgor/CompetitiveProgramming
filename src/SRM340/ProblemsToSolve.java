package SRM340;

public class ProblemsToSolve {
	
	
	public int minNumber(int [] p, int v) { 
		int minEven = p[0], maxEven = p[0], min = p[0], max = p[0];

		for(int i=1; i<p.length; i++) { 
			if(i%2 == 0) { 
				minEven = Math.min(minEven, p[i]);
				maxEven = Math.max(maxEven,p[i]);
				
				if(maxEven - minEven >= v) { 
					return i/2 + 1;
				}
			} 

			min = Math.min(min, p[i]);
			max = Math.max(max, p[i]);

			if(max - min >= v) 
				return i/2 + 2;
		}

		return p.length;
	}

}
