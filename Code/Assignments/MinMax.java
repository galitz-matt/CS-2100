import java.util.Scanner;

public class MinMax {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int[] arr = new int[size];
		
		for (int i = 0 ; i < size ; i++) {
			arr[i] = in.nextInt();
			
		}	
		System.out.println(secondMax(arr));
		System.out.println(secondMin(arr));
		in.close();
	}
	
	public static int secondMax(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		return sortAsc(nums)[nums.length - 2];
	}
	
	public static int secondMin(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		return sortAsc(nums)[1];
	}
	
	public static int[] sortAsc(int[] nums) {
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
		return nums;
	}
}

	


