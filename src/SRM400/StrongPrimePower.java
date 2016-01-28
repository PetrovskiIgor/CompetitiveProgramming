package SRM400;

public class StrongPrimePower {
	
	
	
	public boolean isPrime(long num) { 
		
		if(num == 2) {
			return false;
		}
		
		if(num % 2 == 0) { 
			
			return false;
		}
		
		
		for(int i=3; i<=Math.sqrt(num); i+=2) { 
			if(num % i == 0) { 
				return false;
			}
		}
		
		return true;
	}
	
	public int[] basAndExponent(String n) { 
		long num = Long.parseLong(n);
		
		int rootNum = -1;
		for(int i=60; i>=2; i--) { 
			
			double b = Math.pow(num, 1.0/(1.0*i));
			
			if(i == 3) { 
				System.out.println(b);
			}
			
			if(Math.abs(Math.round(b) - b) <= 0.0000000001) {
				long base = Math.round(b);
				System.out.println("i: " + i + " base: " + base);
				if(isPrime(base)) { 
					rootNum = i;
				}
				break;
			}
		}
		
		if(-1 == rootNum) { 
			return new int[]{};
		}
		
		int base = (int)Math.round(Math.pow(num, 1.0/(1.0*rootNum)));
		return new int[]{base, rootNum};
	}
	
	public static void main(String [] args)  {
		
		/*StrongPrimePower spp = new StrongPrimePower();
		
		
		int [] arr = spp.basAndExponent("26293188972239280");
		
		if(arr.length == 0) {
			System.out.println("No strongness in this one!");
		}else { 
			System.out.println(arr[0] + "^" + arr[1]);
		}*/
		long m = (long)1000000*(long)10000000;
		
		System.out.println(m);
		
		
		
		
	}

}
