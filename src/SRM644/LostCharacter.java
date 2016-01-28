package SRM644;

public class LostCharacter { 


	public int[] getmins(String [] str) { 
		
		int N = str.length;
		int [] toRet = new int[N];
		
		for(int i=0; i<N; i++) { 
	
			int pos = 0;
	
			for(int j=0; j<N; j++) { 
				if(i==j) continue;
				int mL = Math.min(str[i].length(), str[j].length());
				int  isSmaller = -1;
				// -1 - equal until mL
				// 0 - i is smaller
				// 1 - j is smaller
				for(int k=0; k<mL; k++) { 
						char f = str[i].charAt(k);
					if(f == '?') f = 'a';
	
					char s = str[j].charAt(k);
	
					if(s == '?') s = 'z';
	
					if(f == s) continue;
					
					if(f < s) { 
						isSmaller = 0;
						break;
					}
					isSmaller = 1;
					break;
				}
	
					if(isSmaller == 1 || (isSmaller == -1 && str[i].length() > str[j].length())) pos++;
			}
	
			toRet[i] = pos;
		}
	
		return toRet;
	}

}



