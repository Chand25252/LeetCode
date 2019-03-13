package solutions;

/*
    给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
    在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
    找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
    说明：你不能倾斜容器，且 n 的值至少为 2。
*/


/**
 * @author Chand
 * @date 2019-03-09 13:44:54
 */
public class Q011_Container_With_Most_Water {

    public int maxArea(int[] height) {
        int head = 0;
        int tail = height.length - 1;
        int area = tail * Math.min(height[tail], height[head]);
        while(tail > head) {
            if(height[tail] >= height[head]) {
                head++;
            } else {
                tail--;
            }
            int area_tmp = (tail - head) * Math.min(height[tail], height[head]);
            area = area_tmp > area ? area_tmp : area;
        }
        return area;
    }

}
