class Solution {
    public double myPow(double x, int n) {

        long N = n;   // avoid overflow for n = -2147483648

        // if exponent is negative, flip the base
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        double result = 1.0;

        while (N > 0) {

            // if N is odd
            if (N % 2 == 1) {     
                result = result * x;
            }

            // square the base every step
            x = x * x;

            // divide N by 2 (integer division)
            N = N / 2;           
        }

        return result;
    }
}
