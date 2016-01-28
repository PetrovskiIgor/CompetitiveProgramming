package SRM357;

class City { 
	int customers;
	int cost;

	public City(int customers, int cost) { 
		this.customers = customers;
		this.cost = cost;
	}

}

public class Hotel { 
	public static final int INF = Integer.MAX_VALUE;
	public int marketCost(int minCust, int [] cust, int [] cost) { 
		
		int N = cust.length; 
		City [] city = new City[N];

		for(int i=0; i<N; i++) { 
			city[i] = new City(cust[i], cost[i]);
		}

		int [] TABLE = new int[1 + minCust];
		for(int i=1; i<=minCust; i++) { 
			TABLE[i] = INF;
			
			for(int j=0; j<N; j++) { 
				if(city[j].customers > i) { 
					TABLE[i] = Math.min(TABLE[i], city[j].cost);
				} else { 
					TABLE[i] = Math.min(TABLE[i-city[j].customers] + city[j].cost, TABLE[i]);
				}
			}
		
		}

		return TABLE[minCust];
		
	}

}

