package SRM680;

import java.util.PriorityQueue;

public class BearChairs { 

	public int[] findPositions(int [] pos, int d) { 
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		pq.add(pos[0]);
		int [] sol = new int[pos.length];
		sol[0] = pos[0];
		for(int i=1; i<pos.length; i++) { 

			int [] tempArr = new int[pq.size()];
			int j = 0;
			while(!pq.isEmpty()) { 
				tempArr[j++] = pq.poll();
			}
			int potPos = pos[i];
				
			for(j=0; j<tempArr.length; j++) { 
				if(tempArr[j] <= potPos) { 
					if(tempArr[j] + d <= potPos) { 
						break;
					}
					potPos = tempArr[j] + d;
				} else {
					if(tempArr[j] - d >= potPos) { 
						break;
					}
					potPos = tempArr[j] + d;
				}
			}
			
			for(j=0; j<tempArr.length; j++) pq.add(tempArr[j]);
			pq.add(potPos);
			sol[i] = potPos;

		}
	

		return sol;

	}
	
	public static void main(String [] args) { 
		BearChairs bc = new BearChairs();
		
		int [] sol = bc.findPositions(new int[]{1,21,11,7},
		11);
		
		for(int i=0; i<sol.length; i++) {
			System.out.print(sol[i] + " ");
		}
	}
}