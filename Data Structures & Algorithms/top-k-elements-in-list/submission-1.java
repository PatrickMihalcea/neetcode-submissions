class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] sol = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for (int i : map.keySet()) {
            int freq = map.get(i);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }   
            buckets[freq].add(i);
        }

        int i = 0;
        int j = nums.length;
        while (i < k) {
            if (buckets[j] != null) {
                for (int a : buckets[j]) {
                    sol[i] = a;
                    i++;
                }
            }
            j--;
        }

        return sol;
    }
}