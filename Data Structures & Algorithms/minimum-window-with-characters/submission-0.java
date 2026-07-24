class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> t_map = new HashMap<>();

        for (Character c : t.toCharArray()) {
            t_map.put(c, t_map.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> t_map_temp = new HashMap<>(t_map);
        HashMap<Character, Integer> bank = new HashMap<>();
        int left = 0, right = 0, minLength = 1000;
        String sol = "";

        while (left < s.length()) {
            while (!t_map_temp.isEmpty() && (right < s.length())) {
                Character c = s.charAt(right);
                if (t_map.containsKey(c)) {
                    int remainingInSearch = t_map_temp.getOrDefault(c, 0);
                    if (remainingInSearch == 0) {
                        bank.put(c, bank.getOrDefault(c, 0) + 1);
                    }
                    else if (remainingInSearch == 1) {
                        t_map_temp.remove(c);
                    }
                    else {
                        t_map_temp.put(c, remainingInSearch - 1);
                    }
                }
                right++;
            }

            if (t_map_temp.isEmpty()) {
                int windowLength = right - 1 - left;
            
                if (windowLength < minLength) {
                    minLength = windowLength;
                    sol = s.substring(left, right);
                }
            }

            Character leftChar = s.charAt(left);
            
            if (t_map.containsKey(leftChar)) {
                int banked = bank.getOrDefault(leftChar, 0);
                if (banked == 0) {
                    t_map_temp.put(leftChar, t_map_temp.getOrDefault(leftChar, 0) + 1);
                }
                else if (banked == 1) {
                    bank.remove(leftChar);
                }
                else {
                    bank.put(leftChar, banked - 1);
                }
            }

            left++;

        }

        return sol;

    }
}