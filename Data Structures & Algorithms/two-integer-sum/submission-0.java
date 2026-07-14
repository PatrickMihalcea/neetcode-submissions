class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] sol = new int[2];
        Map<Integer, Integer> set = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int remainder = target - nums[i];
            if (set.containsKey(remainder)) {
                sol[0] = set.get(remainder);
                sol[1] = i;
                return sol;
            }
            set.put(nums[i], i);
        }
        
        return sol;
    }
}
