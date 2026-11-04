// Divide without using *, /, or % operators.
// Find the sign of the result using XOR logic or sign conditions.
// Convert dividend and divisor to positive long using Math.abs((long) value).
// Handle Integer.MIN_VALUE / -1 separately (return Integer.MAX_VALUE).
// Use while (n >= d) to repeatedly subtract divisor multiples.
// Find the largest power of 2 such that d << (count + 1) <= n.
// Add 1L << count to the answer.
// Subtract d << count from the remaining dividend.
// Apply the original sign to the final answer.
// TC: \(O(\log^2 N)\) | SC: \(O(1)\).



class Solution {
    public int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        long ans = 0;
        boolean sign = true;

        if ((dividend < 0 && divisor > 0) ||
                (dividend > 0 && divisor < 0)) {
            sign = false;
        }

        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        while (d <= n) {
            int count = 0;
            while (n >= (d << (count + 1))) {
                count++;
            }
            ans += (1L << count);
            n = n - (d << count);
        }
        return sign ? (int) ans : (int) (-ans);
    }
}
