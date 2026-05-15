/***************************************method - 1****************************************** */
class Solution {
    int idx;
    int n;
    public TreeNode bstFromPreorder(int[] preorder) {
        int minVal = Integer.MIN_VALUE;
        int maxVal = Integer.MAX_VALUE;
        idx = 0;
        n = preorder.length;
        return construct(preorder,minVal,maxVal);
    }

    TreeNode construct(int[] preorder,int minVal,int maxVal){
        if(idx >= n){
            return null;
        }

        int val = preorder[idx];
        if(val < minVal || val > maxVal){
            return null;
        }
        idx++;
        TreeNode root = new TreeNode(val);
        root.left = construct(preorder,minVal,val);
        root.right = construct(preorder,val,maxVal);

        return root;
    }
}

/***************************************method - 2****************************************** */
class Solution {
    int preIdx;
    HashMap<Integer,Integer> hmap;
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] inorder = new int[preorder.length];

        for(int i = 0;i < preorder.length;i++){
            inorder[i] = preorder[i];
        }
        Arrays.sort(inorder);
        preIdx = 0;
        hmap = new HashMap<Integer,Integer>();

        for(int i = 0;i < preorder.length;i++){
            hmap.put(inorder[i],i);
        }

        return construct(preorder,0,preorder.length-1);
    }

    TreeNode construct(int[] preorder,int start,int end){
        if(start > end){
            return null;
        }

        int rootVal = preorder[preIdx++];
        int mid = hmap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = construct(preorder,start,mid-1);
        root.right = construct(preorder,mid+1,end);
        return root;
    }
}