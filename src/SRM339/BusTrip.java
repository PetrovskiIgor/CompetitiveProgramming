package SRM339;

import java.util.HashMap;

class BusRoute { 
	int [] a; 
	int c;
	int N;
	public BusRoute(String s) { 
		String [] p = s.split(" ");
		N = p.length;
		a = new int[N];
		c  = 0;
		for(int i=0; i<N; i++) { 
			a[i] = Integer.parseInt(p[i]);
			
		}
		
		for(int i=0; i<N; i++) { 
			c += Math.abs(a[(i+1)%N] - a[i]);
		}
	}
}

public class BusTrip { 
	
	public int getActiveStation(int [] arr, int t) { 
		
		int currTime = 0;
		
		if(currTime == t) return 0;
		
		for(int i=1; i<arr.length; i++) { 
			currTime += Math.abs(arr[i] - arr[i-1]);
			
			if(currTime == t) return i;
			
		}
		return -1;
	}
	
	public int returnTime(int N, String [] buses) { 
		int K = buses.length;
		HashMap<Integer, Integer> [] map = new HashMap[K];

		BusRoute [] br = new BusRoute[K];

		for(int i=0; i<K; i++) { 
			br[i] = new BusRoute(buses[i]);
			map[i] = new HashMap<Integer, Integer>();
			
			for(int j=0; j<br[i].a.length; j++) { 
				map[i].put(br[i].a[j], j);
			}
		}
		
		// currStat: 1 

		int t = 0;
		int currStat = 0;
		boolean cycle = false;
		while(t<=1000) { 
			
			for(int i=0; i<K; i++) { 
				
				int newT = t % br[i].c;
				
				int statInd = getActiveStation(br[i].a, newT);
				
				//System.out.println("i: " + i + " statInd: " + statInd);
				
				if(-1 != statInd &&  br[i].a[statInd] == currStat) { 
					int nextStat = br[i].a[(statInd+1)%br[i].N];
					
				//	System.out.println("currStat: " + currStat + " t: " + t + " nextStat: " + nextStat + " c: " + br[i].c);
				//	System.out.println("Using " + i + " -th bus road..");
					t += Math.abs(nextStat - currStat);
					currStat = nextStat;
					if(nextStat == 0) cycle = true;
					
					break;
				}
			}
			if(cycle) break;
			t += 1;	

		}

		return t <= 1000 ? t : -1;

	}
	
	public static void main(String [] args) { 
		BusTrip bt = new BusTrip();
		
		int sol = bt.returnTime(100, new String[]
				{"0 10 30 45 60 46 39 31 20", "9 20 0 86"});
		
		
		System.out.println(sol);
	}

}

