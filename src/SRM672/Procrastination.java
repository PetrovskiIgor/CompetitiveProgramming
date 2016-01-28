package SRM672;

public class Procrastination { 

long findFinalAssignee(long n)
{
    long i = 2;
    // until i > sqrt(n):
    for (i = 2; i*i <= n; i++) {
        if (n % i == 0) {
            n++;
        } else if (n % i == 1) {
            n--;
        }
    }
    // from n / i downwards:
    for (i = n / i; i > 1; i--) {
        if (n % i == 0) {
            n++;
        } else if (n % i == 1) {
            n--;
        }
    }
    return n;
}
	
	public static void main(String [] args) { 
		Procrastination p = new Procrastination();
		
		long num = 20l;
		System.out.println(p.findFinalAssignee(num));
	}


}
