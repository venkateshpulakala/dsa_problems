/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int height(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(height(root.left),height(root.right)) + 1;
    }

    void leftLevel(TreeNode root,int l,List<Integer> currList){
        if(root == null){
            return;
        }
        if(l == 0){
            currList.add(root.val);
        }else{
            leftLevel(root.left,l-1,currList);
            leftLevel(root.right,l-1,currList);
        }
    }

    void rightLevel(TreeNode root,int l,List<Integer> currList){
        if(root == null){
            return;
        }

        if(l == 0){
            currList.add(root.val);
        }else{
            rightLevel(root.right,l-1,currList);
            rightLevel(root.left,l-1,currList);
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int h = height(root);
        
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0;i < h;i++){
            List<Integer> currList = new ArrayList<>();
            if(i%2 == 0){
                leftLevel(root,i,currList);
            }else{
                rightLevel(root,i,currList);
            }
            result.add(currList);
        }
        return result;
    }
}