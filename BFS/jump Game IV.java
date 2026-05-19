class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        HashMap<Integer,List<Integer>> hmap = new HashMap<>();

        for(int i = 0;i < n;i++){
            hmap.putIfAbsent(arr[i],new ArrayList<>());
            hmap.get(arr[i]).add(i);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        int step = 0;

        while(!queue.isEmpty()){
            int size = queue.size();

            while(size-->0){
                int currIdx = queue.poll();
                if(currIdx == n-1){
                    return step;
                }

                int leftIdx = currIdx - 1;
                if(leftIdx >= 0 && !visited[leftIdx]){
                    queue.add(leftIdx);
                    visited[leftIdx] = true;
                }
                int rightIdx = currIdx + 1;
                if(rightIdx < n && !visited[rightIdx]){
                    queue.add(rightIdx);
                    visited[rightIdx] = true;
                }
                
                if(!hmap.containsKey(arr[currIdx])) continue;
                for(int idx : hmap.get(arr[currIdx])){
                    if(idx == currIdx) continue;
                    if(!visited[idx]){
                        queue.add(idx);
                        visited[idx] = true;
                    }
                }
                hmap.remove(arr[currIdx]);
            }
            step++;
        }
        return 0;
    