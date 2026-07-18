class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Build HashMap of pairs.
        HashMap<Integer, List<Set<Integer>>> map = new HashMap<>();
        Set<List<Integer>> solution = new HashSet<>();

        for (int i = 0; i < nums.length - 1; i++) {
            int val = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int sum = val + nums[j];
                List<Set<Integer>> list = map.getOrDefault(sum, new ArrayList<>());
                Set<Integer> newEntry = new HashSet<>();
                newEntry.add(i);
                newEntry.add(j);
                list.add(newEntry);
                map.put(sum, list);
            }
        }

        // Find triplets and return.
        for (int i = 0; i < nums.length; i++) {
            int val = -nums[i];
            if (map.containsKey(val)) {
                List<Set<Integer>> results = map.get(val);
                for (Set<Integer> set : results) {
                    if (!set.contains(i)) {  
                        List<Integer> newSolutionEntry = new ArrayList<>();
                        newSolutionEntry.add(-val);
                        for (int numsIndex : set) {
                            newSolutionEntry.add(nums[numsIndex]);
                        }
                        Collections.sort(newSolutionEntry);
                        solution.add(newSolutionEntry);
                    }
                }
                map.remove(val);
            }
        }
        List<List<Integer>> solutionList = new ArrayList<>(solution);
        return solutionList;
        
    }
}