class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> solution = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedString = new String(chars);
            map.merge(sortedString, new ArrayList<>(List.of(str)), (existingList, newList) -> {
                existingList.addAll(newList);
                return existingList;
            });
        }

        for (List<String> sublist : map.values()) {
            solution.add(sublist);
        }

        return solution;
    }
}
