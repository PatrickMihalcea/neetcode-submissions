class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int sol = 0;

        while (left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];
            sol = Math.max(Math.min(leftHeight, rightHeight) * (right - left), sol);
            if (leftHeight < rightHeight) {
                left++;
            }
            else {
                right--;
            }
        }

        return sol;
    }
}