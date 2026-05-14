class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        int[] count = new int[101];

        int maxNum = 1;

        for(int i = 0;i < n;i++){
            
            if(nums[i] >= 100) return false;
            maxNum = Math.max(maxNum,nums[i]);

            count[nums[i]]++;
        }

        for(int i = 1;i < maxNum;i++){
            if(count[i] != 1) return false;
        }

        return count[maxNum] == 2;
    }
}