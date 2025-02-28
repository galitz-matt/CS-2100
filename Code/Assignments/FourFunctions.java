import java.lang.Math;
import java.util.Scanner;

public class FourFunctions {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int valid = in.nextInt();
		if (1 > valid || valid > 4) {
			System.exit(0);
		}
		
		int[] nums = new int[5];
		
		for (int i = 0 ; i < nums.length ; i++) {
			nums[i] = in.nextInt();
		}
		if (valid == 1) {
			System.out.printf("%.2f\n", average(nums));
		}
		else if (valid == 2) {
		System.out.println(median(nums));
		}
		else if (valid == 3) {
		System.out.printf("%.2f\n", stddev(nums));
		}
		else if (valid == 4) {
		System.out.println(mode(nums));
		}
		in.close();
		
	}
	
	public static double average(int[] nums) {
		double total = 0; 
		for (int num : nums) {
			total += (num);
		}
		return (double) (total / nums.length);
	}
	
	public static double median(int[] nums) {
		int placeholder;

		for (int i1 = 0 ; i1 < nums.length ; i1++) {
			for (int i2 = i1 + 1 ; i2 < nums.length ; i2++) {
				if (nums[i1] > nums[i2]) {
					placeholder = nums[i1];
					nums[i1] = nums[i2];
					nums[i2] = placeholder;
				}
			}	
		}		
		return (double) nums[2];
	}
	
	public static double stddev(int[] nums) {
		double avg = average(nums);
		double total = 0;
		
		for (int num : nums) {
			total += Math.pow(num - avg, 2);
		}
		return (double) Math.sqrt(total / (nums.length - 1));
	}
	
	public static int mode(int[] nums) {
		int mode = nums[0];
		int max_count = 0;
		
		for (int num1: nums) {
			int count = 0;
			for (int num2 : nums) {
				if (num1 == num2) {
					count += 1;
				}
			}
			if (count > max_count) {
				max_count = count;
				mode = num1;
			}
		}
		return mode;
	}
				
}