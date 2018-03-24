import java.util.Scanner;

public class Euclid {
	
	private static int gcd(int p, int q) {
		if(q==0) {
			return p;
		}
		int r = p%q;
		return gcd(q, r);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();		
		int q = sc.nextInt();
		System.out.println();
		System.out.println(gcd(p, q));
	}

}
