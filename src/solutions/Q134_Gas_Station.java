package solutions;

/*
    在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
    你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。
    你从其中的一个加油站出发，开始时油箱为空。
    如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
    说明:
        如果题目有解，该答案即为唯一答案。
        输入数组均为非空数组，且长度相同。
        输入数组中的元素均为非负数。
*/

/**
 * @author Chand
 * @date 2019-04-17 14:20:19
 */
public class Q134_Gas_Station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] >= cost[i]) {
                int position = i + 1;
                int temp = gas[i] - cost[i];
                while (temp >= 0) {
                    if (position == i) {
                        return i;
                    }
                    if (position == gas.length) {
                        position = 0;
                    }
                    temp = temp + gas[position] - cost[position];
                    position++;
                }
            }
        }
        return -1;
    }
}
