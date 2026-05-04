class Solution {
    public boolean isBinaryPalindrome(int n) {
        // code here
        String binaryString = "";
        
        boolean oneFound = false;
        for(int i = 31;i >= 0;i--){
            
            if(!oneFound && (((n >> i)&1) == 1)){
                oneFound = true;
            }
            
            if(oneFound){
                binaryString += ((n >> i) & 1);
            }
        }
        
        int l = binaryString.length();
        
        int p1 = 0;
        int p2 = binaryString.length()-1;
        
        while(p1 < p2){
            if(binaryString.charAt(p1) != binaryString.charAt(p2)){
                return false;
            }
            p1++;
            p2--;
        }
        
        return true;
    }
};


//Time Complexity: O(1)
//Space Complexity: O(1)