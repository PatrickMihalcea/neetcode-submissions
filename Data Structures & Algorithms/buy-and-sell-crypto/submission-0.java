class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int[][] minMax = new int[prices.length][2];
        int left = 0;
        int right = prices.length - 1;
        int low = 1000;
        int high = 0;

        int maxProfit = 0;

        while (left < prices.length) {
            low = Math.min(low, prices[left]);
            high = Math.max(high, prices[right]);

            minMax[left][0] = low;
            minMax[right][1] = high;

            left++;
            right--;
        }

        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, (minMax[i][1] - minMax[i][0]));
        }

        return maxProfit;
    }
}