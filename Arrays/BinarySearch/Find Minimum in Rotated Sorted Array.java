class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        //if(n == 2) return Math.min(nums[0],nums[1]);
        int low = 0;
        int high = n - 1;
        int min = Integer.MAX_VALUE;
        while(low < high){
            int mid = (low + high)/2;
            if(nums[mid] > nums[high]){
                 low = mid+1;
            }else if(nums[mid] < nums[high]){
                //min = nums[mid];
                high = mid;
            }
        }
        return nums[low];
    }
}