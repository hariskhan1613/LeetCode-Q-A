class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> one = new HashMap<>();
        HashMap<Character, Integer> two = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            one.put(s.charAt(i), one.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            two.put(t.charAt(i), two.getOrDefault(t.charAt(i), 0) + 1);
        }

        for (char c : one.keySet()) {
            if (!one.get(c).equals(two.get(c))) {
                return false;
            }
        }

        return true;
    }
}