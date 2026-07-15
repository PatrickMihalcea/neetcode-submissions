class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> map = new HashMap<>();
        for (String str : strs) {
            HashMap<Character, Integer> stringMap = new HashMap<>();
            for (char c : str.toCharArray()) {
                stringMap.put(c, stringMap.getOrDefault(c, 0) + 1);
            }
            if (map.containsKey(stringMap)) {
                map.get(stringMap).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(stringMap, list);
            }
        }

        List<List<String>> sol = new ArrayList<>();
        for (List<String> list : map.values()) {
            sol.add(list);
        }

        return sol;
    }
}