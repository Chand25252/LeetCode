package solutions;

/*
    给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
    设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
    注意:
        你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
*/
public class Q123_Best_Time_to_Buy_and_Sell_Stock_III {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int result = 0;
        int[] dp = new int[prices.length];
        int min = prices[0];
        dp[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                dp[i] = prices[i] - min;
            } else {
                dp[i] = 0;
                min = prices[i];
            }
        }
        for (int i = 0; i < dp.length; i++) {
            min = prices[i];
            int profile = 0;
            for (int j = i; j < prices.length; j++) {
                if (prices[j] > min) {
                    profile = profile > (prices[j] - min) ? profile : (prices[j] - min);
                } else {
                    min = prices[j];
                }
            }
            result = result > profile + dp[i] ? result : profile + dp[i];
        }
        return result;
    }
}
