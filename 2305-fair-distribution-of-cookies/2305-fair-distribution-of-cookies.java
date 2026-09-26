class Solution {
    int answer = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k) {
        int[]children = new int[k]; 
        dfs(cookies , children , 0); 
        return answer ; 
    }
    private void dfs(int[]cookies,int[]children,int index){
         if (index == cookies.length){
            int unfairness = 0 ; 
            for(int amount : children){
                unfairness = Math.max(amount , unfairness); 
            }
            answer = Math.min(answer, unfairness);
            return;
        } 

        for(int i= 0 ; i<children.length ; i++){
            children[i] +=cookies[index]; 
            dfs(cookies , children , index +1 ); 
            children[i] -= cookies[index];
        }

    }
}