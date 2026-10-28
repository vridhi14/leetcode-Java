class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();

        int[] result = new int[m + n];

        for(int i = m-1 ; i>= 0 ; i--){
            for(int j = n-1 ; j >= 0 ; j--){
                int d1= num1.charAt(i) - '0'; 
                int d2= num2.charAt(j) - '0'; 

                int mul = d1*d2 ; 
                int sum = mul + result[i+j+1];
                
                result[i+j+1] = sum % 10 ; // last digit
                result[i + j] += sum / 10; // carry
            }
        }

        StringBuilder ans  = new StringBuilder(); 

        for(int digit : result){
            if(!(ans.length() == 0 && digit == 0)){
                ans.append(digit);
            }
        }
        return ans.length() == 0 ? "0" : ans.toString(); 
    }
}