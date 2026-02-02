class Solution {
    static long mod = 1000000007;

    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2;
        long odd = n / 2;

        long part1 = fastPow(5, even);
        long part2 = fastPow(4, odd);

        return (int)((part1 * part2) % mod);
    }

    long fastPow(long base, long exp) {
        long result = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }

        return result;
    }
}
