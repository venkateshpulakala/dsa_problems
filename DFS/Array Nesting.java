class Solution {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        int maxLen = 0;

        for(int i = 0;i < n;i++){
            int curr = nums[i];
            int count = 0;

            while(!visited[curr]){
                visited[curr] = true;
                int next = nums[curr];
                curr = next;
                count++;
            }
            maxLen = Math.max(maxLen,count);
        }

        return maxLen;
    }
}

// Time Complexity: O(n);
// Space Complexity: O(n);

/****************************************Space Optimized Version****************************************/

class Solution {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        for(int i = 0;i < n;i++){
            int curr = i;
            int count = 0;

            while(nums[curr] != -1){
                int next = nums[curr];
                nums[curr] = -1;
                curr = next;
                count++;
            }
            maxLen = Math.max(maxLen,count);
        }

        return maxLen;
    }
}

// Time Complexity: O(n);
// Space Complexity: O(1);
