class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int maxOccurence = 0;

        while (right < s.length()) {
            Character r = s.charAt(right);
            int occurence = map.getOrDefault(r, 0) + 1;

            map.put(r, occurence);
            maxOccurence = Math.max(maxOccurence, occurence);

            while ((right - left + 1 - maxOccurence) > k) {
                Character l = s.charAt(left);
                occurence = map.get(l);
                map.put(l, occurence - 1);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}