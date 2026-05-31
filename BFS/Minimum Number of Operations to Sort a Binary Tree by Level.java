
class Solution {
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int answer = 0;

        while(!q.isEmpty()){
            int size = q.size();

            int[] level = new int[size];
            for(int i = 0;i < size;i++){
                TreeNode node = q.poll();

                level[i] = node.val;

                if(node.left != null){
                    q.offer(node.left);
                }

                if(node.right != null){
                    q.offer(node.right);
                }
            }

            answer += minSwapsToSort(level);
        }

        return answer;
    }

    private int minSwapsToSort(int[] arr){

        int n = arr.length;

        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        Map<Integer,Integer> pos = new HashMap<>();
        for(int i = 0;i < n;i++){
            pos.put(sorted[i],i);
        }

        int[] target = new int[n];

        for(int i = 0;i < n;i++){
            target[i] = pos.get(arr[i]);
        }

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for(int i = 0;i < n;i++){

            if(visited[i] || target[i] == i){
                continue;
            }
            int cycleSize = 0;
            int j = i;

            while(!visited[j]){
                visited[j] = true;
                j = target[j];
                cycleSize++; 
            }

            swaps += cycleSize-1;
        }

        return swaps;
    }
}