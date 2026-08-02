class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        return x == reverse(x, 0);
    }
    private int reverse(int num, int rev) {
        if (num == 0) {
            return rev;
        }
        return reverse(num / 10, rev * 10 + num % 10);
    }
}
