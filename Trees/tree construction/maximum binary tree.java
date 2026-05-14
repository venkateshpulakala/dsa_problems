class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums,0,nums.length-1);
    }

    TreeNode construct(int[] nums,int start,int end){
        if(start > end){
            return null;
        }

        int maxVal = nums[start];
        int maxValIdx = start;

        for(int i = start;i <= end;i++){
            if(nums[i] > maxVal){
                maxVal = nums[i];
                maxValIdx = i;
            }
        }

        TreeNode root = new TreeNode(maxVal);
        root.left = construct(nums,start,maxValIdx-1);
        root.right = construct(nums,maxValIdx+1,end);

        return root;
    }
}