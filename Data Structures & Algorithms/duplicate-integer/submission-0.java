class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> table = new HashSet<Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (table.contains(nums[i])) {
                return true;
            } else {
                table.add(nums[i]);
            }
        }
        return false;
    }
}
