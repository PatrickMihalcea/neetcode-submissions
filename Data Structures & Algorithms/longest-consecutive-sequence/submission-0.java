class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int longestConsecutive = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                continue;
            }
            else if ((map.containsKey(num + 1)) && (map.containsKey(num - 1))) {
                int low = map.get(num-1);
                int high = map.get(num+1);
                map.put(low, high);
                map.put(high, low);
                longestConsecutive = Math.max(longestConsecutive, high - low + 1);
                map.put(num, -1);
            }
            else if (map.containsKey(num - 1)) {
                int low = map.get(num-1);
                map.put(num, low);
                map.put(low, num);
                longestConsecutive = Math.max(longestConsecutive, num - low + 1);
            }
            else if (map.containsKey(num + 1)) {
                int high = map.get(num+1);
                map.put(num, high);
                map.put(high, num);
                longestConsecutive = Math.max(longestConsecutive, high - num + 1);
            }
            else {
                map.put(num, num);
                longestConsecutive = Math.max(longestConsecutive, 1);
            }      
        }

        return longestConsecutive;
    }
}