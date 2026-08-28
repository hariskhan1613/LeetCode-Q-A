class Solution {

    public String lexPalindromicPermutation(String s, String target) {

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int oddCount = 0;
        int mid = -1;

        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) == 1) {
                oddCount++;
                mid = i;
            }
        }

        if (oddCount > 1) {
            return "";
        }

        for (int i = 0; i < 26; i++) {
            freq[i] /= 2;
        }

        int n = s.length();
        int half = n / 2;

        char[] ans = new char[n];
        char[] tgt = target.toCharArray();

        int pos = 0;

        // Match target as much as possible
        while (pos < half) {

            int ch = tgt[pos] - 'a';

            if (freq[ch] == 0) {
                break;
            }

            ans[pos] = tgt[pos];
            freq[ch]--;
            pos++;
        }

        // Exact left half matched
        if (pos == half) {

            buildPalindrome(ans, half, mid);

            String candidate = new String(ans);

            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        // Backtrack
        while (true) {

            if (pos < half) {

                int start = tgt[pos] - 'a' + 1;

                // Find smallest available character
                // greater than target[pos]
                for (int ch = start; ch < 26; ch++) {

                    if (freq[ch] == 0) {
                        continue;
                    }

                    ans[pos] = (char) ('a' + ch);
                    freq[ch]--;

                    // Fill rest of left half with smallest chars
                    int dst = pos + 1;

                    for (int c = 0; c < 26; c++) {

                        for (int count = 0; count < freq[c]; count++) {
                            ans[dst++] = (char) ('a' + c);
                        }
                    }

                    buildPalindrome(ans, half, mid);

                    return new String(ans);
                }
            }

            // No larger character possible
            if (pos == 0) {
                return "";
            }

            // Backtrack and restore target[pos]
            pos--;
            freq[tgt[pos] - 'a']++;
        }
    }

    private void buildPalindrome(char[] ans, int half, int mid) {

        int n = ans.length;

        if (mid != -1) {
            ans[half] = (char) ('a' + mid);
        }

        for (int i = 0; i < half; i++) {
            ans[n - 1 - i] = ans[i];
        }
    }
}