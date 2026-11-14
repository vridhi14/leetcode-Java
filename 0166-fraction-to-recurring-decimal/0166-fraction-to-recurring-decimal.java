
import java.util.*;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {

        if (numerator == 0) return "0";

        StringBuilder ans = new StringBuilder();

        // Handle negative sign
        if ((numerator < 0) ^ (denominator < 0)) {
            ans.append("-");
        }

        // Convert to long to avoid integer overflow
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Integer part
        ans.append(num / den);

        long remainder = num % den;

        if (remainder == 0) {
            return ans.toString();
        }

        ans.append(".");

        // Store remainder and its position
        HashMap<Long, Integer> map = new HashMap<>();

        while (remainder != 0) {

            // Repeating remainder found
            if (map.containsKey(remainder)) {
                int position = map.get(remainder);
                ans.insert(position, "(");
                ans.append(")");
                break;
            }

            map.put(remainder, ans.length());

            remainder *= 10;

            ans.append(remainder / den);

            remainder %= den;
        }

        return ans.toString();
    }
}
