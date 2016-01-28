package SRM673;


public class BearCavalry {


	long MOD = 1000000007;

	public void swap(int i, int j, int [] arr) { 
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public int countAssignments(int [] warriors, int [] horses) { 
		int N = warriors.length;
		long totalAssignments = 0;

		for(int i=0, toSwap = 0; i<N; i++, toSwap++) { 
			swap(0, toSwap, horses);
			
			int alphaPower = warriors[0] * horses[0];
			


			

			int [][] matrix = new int[N][N];

			for(int j=1; j<warriors.length; j++)  {
				

				for(int k=1; k<horses.length; k++) { 
					if(warriors[j] * horses[k] >= alphaPower) { 
						matrix[j][k] = 1;
					} else { 
						matrix[j][k] = 0;
					}
				}
	
			}

			long totalWays = 1;
			
			for(int c = 1; c<N; c++) { 
				long numZeros = 0;
	for(int r = 1; r<N; r++) { 
					if(matrix[r][c] == 0) numZeros++;
				}
				totalWays = (totalWays * numZeros) % MOD;
				
			}

			totalAssignments = (totalAssignments + totalWays) % MOD;
		}

		return (int)totalAssignments;
	}
	
	public static void main(String [] args) { 
		
		BearCavalry bc = new BearCavalry();
		
		
		int [] warriors = {5,8,4,8};
		int [] horses = {19,40,25,20};
		System.out.println(bc.countAssignments(warriors, horses));
	}
}

