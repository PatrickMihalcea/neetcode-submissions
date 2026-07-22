class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> counts = new HashMap<>(map);
        int left = 0;
        for (int right = 0; right < s2.length(); right++) {
            Character c = s2.charAt(right);

            int count = counts.getOrDefault(c, 0);

            if (count == 0) {
                if (c == s2.charAt(left)) {
                    left++;
                    continue;
                }
                counts = (HashMap<Character, Integer>) map.clone();
                left = right;

            }
            else if (count == 1) {

                counts.remove(c);

            }
            else {

                counts.put(c, count - 1);

            }

            if (counts.isEmpty()) {

                return true;

            }
        }

        return counts.isEmpty();
    }
}