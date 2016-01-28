package SRM665;

import java.util.List;
import java.util.ArrayList;

class Edge { 
	int from;
	int to;
	int weight;

	public Edge(int from, int to, int weight) { 
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

}

class Tree { 
	List<List<Edge> > structure;

	int N;

	boolean [] visited;

	public Tree(int N, int [] from, int [] to, int [] w) { 
		this.N = N;

		visited = new boolean[N];
		structure = new ArrayList<List<Edge>>();

		for(int i=0; i<N; i++) { 
			structure.add(new ArrayList<Edge>());
		}

		for(int i=0; i<N-1; i++) { 
			from[i]--;
			to[i]--;
			Edge e1 = new Edge(from[i], to[i], w[i]);
			Edge e2 = new Edge(to[i], from[i], w[i]);
			
			structure.get(from[i]).add(e1);
			structure.get(to[i]).add(e2);
		}
	}


	public int[] travelTree(int source, int traveler, int counter4, int counter7) { 

		visited[traveler] = true;
		if(Math.abs(counter4 - counter7) == 1 && (counter4 > 1 || counter7 > 1)) { 
			if(counter4 < counter7) {
				return new int[]{1 + source, 1 + traveler,4};
			} else { 
				return new int[]{1 + source, 1 + traveler, 7};
			}
		}

		int [] sol = null;

		for(Edge e : structure.get(traveler)) { 
			if(visited[e.to])
				continue;
			if(e.weight == 4) { 
				sol = travelTree(source, e.to, 1 + counter4, counter7);
			} else { 

				sol = travelTree(source, e.to, counter4, 1 + counter7);
			}
			if(null != sol) { 
				return sol;
			}
		}

		return sol;
	}
	
	public int [] solve() { 

		for(int i=0; i<N; i++) { 

			int traveler = i;
			for(int j=0; j<N; j++) 
				visited[j] = false;
			
			int [] counterPart = travelTree(traveler, traveler, 0,0);

			if(counterPart != null) { 
				return counterPart;
			}
		}

		return new int[]{};
	}

}

public class LuckyCycle { 

	public int[] getEdge(int [] from, int [] to, int [] w) { 
		Tree tree = new Tree(from.length + 1, from, to,w);
		
		int [] sol = tree.solve();
	
		return sol;
	}
	
	/*public static void main(String [] args)  { 
		
		int [] f = {1, 2, 3, 5, 6};
		int [] t = {2, 3, 4, 3, 5};
		int [] w = {4, 7, 7, 7, 7};
		LuckyCycle lc = new LuckyCycle();
		
		int [] sol = lc.getEdge(f, t, w);
		
		if(sol.length > 0) { 
			for(int i=0; i<sol.length; i++) {
				System.out.print(sol[i] + " ");
			}
		} else {
			System.out.println("EMPTY");
		}
	}*/

}

