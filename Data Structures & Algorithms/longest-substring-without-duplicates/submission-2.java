class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int sol = 0;
        int leftP = 0;

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                leftP = Math.max(leftP, map.get(c));
            }
 
            map.put(c, i + 1); 
            sol = Math.max(sol, (i - leftP + 1));
        }

        return sol;
    }
}