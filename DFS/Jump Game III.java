class Solution {
    public boolean canReach(int[] arr, int start) {
        

        int n = arr.length;
        boolean[] idx = new boolean[50000+1];
        return solve(arr,start,n,idx);
    }

    boolean solve(int[] arr,int index,int n,boolean[] idx){
        if(index < 0 || index >= n) return false;
        if(idx[index]){
            return false;
        }
        
        idx[index] = true;

        if(arr[index] == 0){
            return true;
        }
        
        int index1 = index + arr[index];
        int index2 = index - arr[index];

        return solve(arr,index1,n,idx) || solve(arr,index2,n,idx);
    }
}