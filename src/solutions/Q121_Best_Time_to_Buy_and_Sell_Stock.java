package solutions;


/*
    给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
    如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
    注意你不能在买入股票前卖出股票。
*/

/**
 * @author Chand
 * @date 2019-04-15 11:52:25
 */
public class Q121_Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profile = prices[j] - prices[i];
                result = result > profile ? result : profile;
            }
        }
        return result;
    }
}
