package solutions;

import java.util.Arrays;

/*
    给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
    说明:
        初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
        你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
*/

/**
 * @author Chand
 * @date 2019-04-03 18:08:23
 */
public class Q088_Merge_Sorted_Array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = Arrays.copyOf(nums1, m);
        int i = 0;
        int j = 0;
        while (i < m || j < n) {
            if (j == n || (i != m && nums3[i] <= nums2[j])) {
                nums1[i + j] = nums3[i];
                i++;
            } else {
                nums1[i + j] = nums2[j];
                j++;
            }
        }
    }
}
