class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        int left = 0;
        int countOnes = 0;

        String best = "";

        for (int right = 0; right < s.length(); right++) {

            if (s.charAt(right) == '1') {
                countOnes++;
            }
            while (countOnes > k) {

                if (s.charAt(left) == '1') {
                    countOnes--;
                }

                left++;
            }
            if (countOnes == k) {
                while (s.charAt(left) == '0') {
                    left++;
                }

                String candidate = s.substring(left, right + 1);

                if (best.isEmpty()) {
                    best = candidate;
                }
                else if (candidate.length() < best.length()) {
                    best = candidate;
                }
                else if (candidate.length() == best.length()
                        && candidate.compareTo(best) < 0) {
                    best = candidate;
                }
            }
        }

        return best;
    }
}