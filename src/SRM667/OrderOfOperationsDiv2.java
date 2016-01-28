package SRM667;

public class OrderOfOperationsDiv2 {
	
	
	public static int numOnes(int num) { 
		
		int counter = 0;
		
		
		int one = 1;
		
		while(one <= num) { 
			
			if((one & num) != 0)
				counter++;
			
			one<<=1;
		}
		
		
		return counter;
		
	}
	
	public static String retBinary(int num) { 
		
		if(num == 1 || num == 0) {
			return String.valueOf(num);
		}
		
		int one = 1;
		
		StringBuilder sb = new StringBuilder();
		while(num >= one) {
			
			if((one & num) != 0) { // it means that num has 1 on the same position
				sb.append('1');
			}else { 
				sb.append('0');
			}
			one <<=1;
			
			
		}
		
		return sb.reverse().toString();
	}
	public static int retDecimal(String str) { 
		
		int num = 0;
		
		for(int i=0; i<str.length(); i++) { 
			
			if(str.charAt(i) == '0')
				continue;
			
			num |= (1 << str.length() - i - 1);
		}
		
		return num;
	}
	
	public static void main(String [] args) { 
		
		
		
		String binaryRepresentation = retBinary(0);
		
		
		System.out.println(binaryRepresentation);
		
		
		
		
	}
}
