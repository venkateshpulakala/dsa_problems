class Solution {
    public int minDepth(TreeNode root) {

        //Depth First Search
        if(root == null) return 0;
        

        if(root.left == null && root.right == null){
            return 1;
        }

        int l = root.left != null ? minDepth(root.left):Integer.MAX_VALUE;
        int r = root.right != null ? minDepth(root.right):Integer.MAX_VALUE;

        return 1 + Math.min(l,r);
    }
}