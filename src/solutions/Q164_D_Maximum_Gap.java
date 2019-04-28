package solutions;

/*
    给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
    如果数组元素个数小于 2，则返回 0。
    说明:
        你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
        请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。 // TODO
*/
public class Q164_D_Maximum_Gap {
    public int maximumGap(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int result = 0;
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            length = nums[i] > length ? nums[i] : length;
        }
        int[] arr = new int[length + 1];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] = 1;
        }
        int index = -1;
        for (int i = 0; i <= length; i++) {
            if (arr[i] == 1) {
                if (index != -1) {
                    result = result > (i - index) ? result : (i - index);
                }
                index = i;
            }
        }
        return result;
    }
}
