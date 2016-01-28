package SRM356;



import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class AverageProblem {
	public int minPeople(double [] avgGrades) { 
		int MAX = 1000;
		
		int [] TABLE = new int[1+MAX];

		for(int i=0; i<avgGrades.length; i++) { 
			for(int j=MAX; j>=1; j--) { 
				double x = j * avgGrades[i];
				int x1 = (int)Math.ceil(x);
				int x2 = (int)Math.floor(x);
				
				
				if(isGood(x1, j, avgGrades[i], j) && x1 <= j*10) TABLE[j]++;
				else if(isGood(x2,j, avgGrades[i], j) && x2 <= j*10) TABLE[j]++;
					
				
				
			}
		}

		int min = -1;

		for(int i=1; i<=MAX; i++) { 
			if(TABLE[i] == avgGrades.length) { 
				min = i;
				break;
			}
		}
		return min;
	}

	public boolean isGood(int n, int d, double val, int j) { 
		DecimalFormat df = new DecimalFormat("0.000");
		df.setRoundingMode(RoundingMode.DOWN);
		double newVal = (1.0*n)/(1.0*d);
		
		
		String f = df.format(newVal);
		String s = df.format(val);

		return f.equals(s);
		
	}
	
	public int numberOfParticipants(String[] marks) { 
		
		List<Double> m = new ArrayList<Double>();
		
		for(int i=0; i<marks.length; i++) {
			String [] strs = marks[i].split(" ");
			
			for(String str : strs) { 
				m.add(Double.parseDouble(str));
			}
		}
		
		double [] marksD =  new double[m.size()];
		int i=0;
		for(Double d : m) { 
			marksD[i] = d;
			i++;
		}
		
		return minPeople(marksD);
	}
	
	
	public static void main(String [] args) { 
		AverageProblem ap = new AverageProblem();
		
		int sol = ap.numberOfParticipants(new String[]{"0.500","0.301"});
		System.out.println(sol);
	}
	

}

