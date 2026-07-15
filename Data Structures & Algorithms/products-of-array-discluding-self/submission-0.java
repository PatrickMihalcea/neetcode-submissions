class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[][] calculation = new int[nums.length][2];
        int prePointer = 0;
        int sufPointer = nums.length - 1;
        int preProduct = 1;
        int sufProduct = 1;

        for (int i = 0; i < nums.length; i++) {
            calculation[prePointer][0] = preProduct;
            preProduct = preProduct * nums[prePointer];
            prePointer++;

            calculation[sufPointer][1] = sufProduct;
            sufProduct = sufProduct * nums[sufPointer];
            sufPointer--;
        }

        int[] sol = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            sol[i] = calculation[i][0] * calculation[i][1];
        }

        return sol;

    }
}