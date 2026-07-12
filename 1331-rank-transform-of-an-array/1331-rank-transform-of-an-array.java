class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length ; 
        int[] sorted = arr.clone(); 
        Arrays.sort(sorted); 

        HashMap<Integer , Integer> rankMap = new HashMap<>(); 
        int rank = 1  ;

        for(int num : sorted){
            if(!rankMap.containsKey(num)){
                rankMap.put(num , rank++); 
            }
        }
        for(int i = 0 ; i<n ; i ++){
            arr[i] = rankMap.get(arr[i]);
        }
        return arr; 
    }
}