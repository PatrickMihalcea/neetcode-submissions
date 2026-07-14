class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Integer val = map.get(s.charAt(i));
            if (val == null) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), val+1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            Integer val = map.get(t.charAt(i));
            if (val == null) {
                return false;
            }
            if (val > 0) {
                map.put(t.charAt(i), val - 1);
            } else {
                return false;
            }
        }

        return true;
    }
}
