class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n= s.length() ;
        int ones = 0 ; 

    //count num of 1 
        for(char ch : s.toCharArray()){
        if(ch == '1'){
            ones++;
        }
    }
    // Store lengths of consecutive zero groups
      List<Integer> zeroGrp = new ArrayList<>(); 

      int i = 0  ; 
      while(i<n){
        if(s.charAt(i) == '0'){
            int j = i; 
            while(j<n && s.charAt(j) == '0'){
                j++ ; 
            }
            zeroGrp.add(j-i); 
            i = j ; 
        } else {
            i++ ; 
        }
      }

      int gain = 0 ; 
      for(int k = 0 ; k < zeroGrp.size()-1 ; k++){
        gain = Math.max(gain , zeroGrp.get(k) + zeroGrp.get(k+1) );
      }
      return ones+gain ; 
  }
}