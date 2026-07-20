class Solution {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        
        int[][] map = new int[height.length][2];
        int left = 1;
        int right = height.length - 2;
        int maxLeft = 0;
        int maxRight = 0;

        int totalTrappedWater = 0;

        while (left < height.length) {
            maxLeft = Math.max(maxLeft, height[left-1]);
            maxRight = Math.max(maxRight, height[right+1]);

            map[left][0] = maxLeft;
            map[right][1] = maxRight;
            left++;
            right--;
        }

        for (int i = 0; i < height.length; i++) {
            totalTrappedWater += Math.max(Math.min(map[i][0], map[i][1]) - height[i], 0);
        }

        return totalTrappedWater;
    }
}