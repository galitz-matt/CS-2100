import java.util.Scanner;

public class Power {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int base = in.nextInt();
		int exp = in.nextInt();
		in.close();
		
		System.out.println(power(base, exp));
	}
	
	public static long power(int base, int exp) {
		int res = 1;
		
		for (int i = 0; i < exp; i++) {
			res *= base;	
		}
		return res;
		
	}
}
