package SRM355;

import java.text.DecimalFormat;
import java.util.Arrays;

class Bottle implements Comparable<Bottle> { 

	int per;
	int am;

	public Bottle(int per, int am) { 	
		this.per = per;
		this.am = am;
	}


	public double getRat(boolean isSubstance) { 

		if(isSubstance)
			return per*1.0/100;


		return (100 - per)*1.0/100;
	}


	@Override
	public int compareTo(Bottle other) { 
		if(per < other.per) return -1;	
		if(per > other.per) return 1;
		return 0;
	}
}


public class MixingLiquids { 

	public static double tolerance = 1e-8;

	public double howMuch(int [] percent, int [] amount, int need) { 
		
		double percentageReq = (need*1.0)/100;
		
		double totalSubstance = 0;
		double totalLiters = 0;
		
		int N = percent.length;
		Bottle [] bottles = new Bottle[N];
		
		for(int i=0; i<N; i++) { 
			
			bottles[i] = new Bottle(percent[i], amount[i]);
			totalLiters += amount[i];
			
			totalSubstance += amount[i]*((percent[i]*1.0)/100); 
			
		}

		Arrays.sort(bottles);

		int s_ind = N-1;
		int w_ind = 0;

		while(s_ind >= 0 && w_ind < N && Math.abs(totalSubstance/totalLiters - percentageReq) > tolerance) { 
			
			System.out.println("totalSubstance: " + totalSubstance);
			System.out.println("totalLiters: " + totalLiters);
			
			double ratio = totalSubstance/totalLiters;
			if(ratio > percentageReq) { 

				double am = bottles[s_ind].am;
				double bRat = bottles[s_ind].getRat(true);
				if((totalSubstance-am*bRat)/(totalLiters - am) > percentageReq) { 
					totalSubstance -= am*bRat;
					totalLiters -= am;
				} else { 
					am = (totalSubstance - percentageReq*totalLiters)/(bRat - percentageReq);
					totalSubstance -= am*bottles[s_ind].getRat(true);
					totalLiters -= am;
					break;
				}
	
				s_ind--;
				
			} else { 
				double am = bottles[w_ind].am;
				double bRat = bottles[w_ind].getRat(true);
				if((totalSubstance-am*bRat)/(totalLiters - am) < percentageReq) { 
					totalSubstance -= am*bRat;
					totalLiters -= am;
				} else { 
					am = (totalSubstance - percentageReq*totalLiters)/(bRat - percentageReq);
				
					totalSubstance -= am*bRat;
					totalLiters -= am;
					break;
				}
				w_ind++;
			}

		}
		
		
		double val = Math.abs(totalSubstance/totalLiters - percentageReq);
		System.out.println("val: " + val);
		if( val > tolerance) 
			return 0;
		
		return totalLiters;		
		
	}
	
	public static void main(String [] args) { 
		
		
		MixingLiquids ml = new MixingLiquids();
		
		int [] percent = {30, 80, 60}
		
		;
		int [] amount = {40, 10, 15};
		int need = 		57;
		double d = ml.howMuch(percent, amount, need);
		System.out.println(new DecimalFormat("0.0000000000000").format(d));
	}

}


