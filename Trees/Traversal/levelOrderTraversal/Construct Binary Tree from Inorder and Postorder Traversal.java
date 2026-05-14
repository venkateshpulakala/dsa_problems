class Solution {
    int postIdx;
    HashMap<Integer,Integer> hmap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIdx = postorder.length-1;
        for(int i = 0;i < inorder.length;i++){
            hmap.put(inorder[i],i);
        }

        return construct(postorder,0,postorder.length-1);
    }

    TreeNode construct(int[] postorder,int start,int end){
        if(start > end){
            return null;
        }

        int rootVal = postorder[postIdx--];
        TreeNode root = new TreeNode(rootVal);
        int mid = hmap.get(rootVal);
        
        root.right = construct(postorder,mid+1,end);
        root.left = construct(postorder,start,mid-1);
        

        return root;
    }
}