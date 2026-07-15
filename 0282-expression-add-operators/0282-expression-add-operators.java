class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> addOperators(String num, int target) {
        backtrack(num, target, 0, "", 0, 0); 
        return ans ; 
    }
    private void backtrack(String num, int target, int index, String exp, long currentValue, long prevOperand){
        if(index == num.length()){
            if(currentValue == target){
                ans.add(exp); 
            }
            return ; 
        }

        for(int i = index ; i < num.length(); i++){

            if(i != index && num.charAt(index) == '0'){
                break ; 
            }

            String part = num.substring(index , i+1); 
            long currNum = Long.parseLong(part); 

            if(index == 0){
                backtrack(num,target, i+1,part , currNum,currNum);
            }else{
                backtrack(num,target,i+1, exp+"+"+part , currentValue+currNum, currNum); 

                backtrack(num,target,i+1, exp+"-"+part , currentValue-currNum, -currNum); 

                backtrack(num,target,i + 1,exp + "*" + part,currentValue - prevOperand + prevOperand * currNum,prevOperand * currNum);


            }
        }
    }
}