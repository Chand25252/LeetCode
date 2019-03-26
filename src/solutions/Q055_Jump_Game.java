package solutions;


/*
    给定一个非负整数数组，你最初位于数组的第一个位置。
    数组中的每个元素代表你在该位置可以跳跃的最大长度。
    判断你是否能够到达最后一个位置。
*/

/**
 * @author Chand
 * @date 2019-03-26 09:55:09
 */
public class Q055_Jump_Game {
    public boolean canJump(int[] nums) {
        if(nums.length == 0) {
            return false;
        }
        int position = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] >= position - i) {
                if (i == 0) {
                    return true;
                }
                position = i;
                continue;
            }
        }
        return false;
    }
}
