import java.util.Arrays;

public class Exp {
	public static void main(String[] args) {
		System.out.println(pivotIndex(new int[] {1,7,3,6,5,6, 2}));
	}
	
	public static int pivotIndex(int[] nums) {
        int total = 0;
        int lsum = 0;
        
        for (int n : nums) {
            total += n;
        }
        
        int rsum = total - nums[0];

        
        for (int i = 0; i < nums.length; i++) {
            if (lsum == rsum) {
                return i;
            }
            lsum += nums[i];
            rsum -= nums[i + 1];
            System.out.print("i: " + i); System.out.print(" lsum: " + lsum); System.out.print(" rsum: " + rsum);
            System.out.println();
        }
        
        return -1;
    }
}