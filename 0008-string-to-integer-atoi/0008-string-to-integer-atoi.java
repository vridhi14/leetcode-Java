class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length(), sign = 1;
        int result = 0;

        // 1️⃣ skip leading spaces
        while(i < n && s.charAt(i) == ' ') i++;

        // 2️⃣ check sign
        if(i < n) {
            if(s.charAt(i) == '+') {
                sign = 1; i++;
            } else if(s.charAt(i) == '-') {
                sign = -1; i++;
            }
        }

        // 3️⃣ process digits
        while(i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // 4️⃣ check overflow BEFORE multiplying by 10
            if(result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}
