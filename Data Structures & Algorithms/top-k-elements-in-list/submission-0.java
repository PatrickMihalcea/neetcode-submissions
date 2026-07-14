class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] solution = new int[k];
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int num : nums) {
            map.merge(num, 1, Integer::sum); // Increment frequency, adds if missing.
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = 
            new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }

        for (int i = 0; i < k; i++) {
            solution[i] = pq.poll().getKey();
        }

        return solution;
    }
}
