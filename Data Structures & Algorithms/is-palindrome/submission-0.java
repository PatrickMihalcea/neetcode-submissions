class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }

        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {
            while ((start < end) && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while ((start < end) && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            Character left = Character.toLowerCase(s.charAt(start));
            Character right = Character.toLowerCase(s.charAt(end));
            if (left.charValue() != right.charValue()) {
                return false;
            }
            start++;
            end--;
        }
        
        return true;
    }
}