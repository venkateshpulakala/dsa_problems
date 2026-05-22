class Solution {
    public int minDepth(TreeNode root) {

        //Breadth First Search
        if(root == null) return 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int depth = 1;

        while(!q.isEmpty()){
            int n = q.size();
            while(n-->0){
                TreeNode node = q.poll();

                if(node.left == null && node.right == null){
                    return depth;
                }
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }  
            }
            depth++;
        }
        return -1;
    }
}