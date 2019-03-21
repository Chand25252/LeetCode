package solutions;

/*
    给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
    你的算法的时间复杂度应为O(n)，并且只能使用常数级别的空间。
*/
public class Q041_D_First_Missing_Positive {
//    public static int firstMissingPositive(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] > 0 && nums[i] <= nums.length) {
//                int temp = nums[i];
//                nums[i] = nums[temp - 1];
//                nums[temp - 1] = temp;
//            }
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != i + 1) {
//                return i + 1;
//            }
//        }
//        return nums.length + 1;
//    }
//
//    public static void main(String[] args) {
//        int[] arr = new int[]{-1, 4, 2, 1, 9, 10};
//        firstMissingPositive(arr);
//    }
}
