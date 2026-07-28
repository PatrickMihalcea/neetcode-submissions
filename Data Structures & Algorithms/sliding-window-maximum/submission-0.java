class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        int[] sol = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            int[] entry = new int[2];
            entry[0] = nums[i];
            entry[1] = i;
            maxHeap.offer(entry);

            if (i >= (k-1)) {
                while (maxHeap.peek()[1] <= (i - k)) {
                    maxHeap.poll();
                }
                sol[i-k+1] = maxHeap.peek()[0];
            }
        }

        return sol;
    }
}