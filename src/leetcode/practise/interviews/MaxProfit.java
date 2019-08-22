package leetcode.practise.interviews;
public class MaxProfit {
    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        System.out.println(maxProfit(nums));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int soFarMin = prices[0];
        for (int i =1; i < prices.length; i++) {
            if (prices[i] > soFarMin) {
                profit = Integer.max(profit, prices[i] - soFarMin);
            } else {
                soFarMin = prices[i];
            }
        }
        return profit;
    }
}
