class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[4];
        dp[0] = - prices[0];
        for(int i = 1; i < prices.length; i++){
            int temp = dp[0];
            int temp1 = dp[2];
            dp[0] = Math.max(dp[0],Math.max(dp[1] - prices[i], dp[3] - prices[i]));
            dp[1] = Math.max(dp[1], dp[3]);
            dp[2] = temp + prices[i];
            dp[3] = temp1;
        }
        return Math.max(dp[1], Math.max(dp[2], dp[3]));
    }
}
/**
分为四种状态来讨论
1.今天持有股票，可以是前面买入的也可以是今天买入。如果是今天买入，那么分为昨天是不持有股票状态或者昨天是冷冻期状态
2.今天不持有股票状态，前一天也可能是不持有股票状态，前一个也可能是冷冻期
3.今天卖出，那前一天一定持有股票，减去今天的股票价格即可。
4。冷冻期状态，那么前一天一定是卖出股票。

最后返回出了持有股票以外的所有状态的最大值。

O(N), O(1)
 */
