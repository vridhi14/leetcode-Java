class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>(); 
        int index = 0 ; 
        for(int num = 1 ; num <= n ; num++){
            if(num == target[index]){
                ans.add("Push"); 
                index++ ;

                if(index == target.length) break ; 
            }
            else{
                ans.add("Push"); 
                ans.add("Pop"); 
            }
        }
        return ans ; 
    }
}