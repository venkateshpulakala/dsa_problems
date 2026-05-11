class Solution {
    public int[] separateDigits(int[] nums) {
        int n = nums.length;

        ArrayList<Integer> result = new ArrayList<>();

        for(int i = n-1;i >= 0;i--){
            int num = nums[i];

            while(num > 0){
                int ld = num%10;
                result.add(0,ld);
                num = num / 10;
            }
        }
        int[] array = new int[result.size()];
        for(int i = 0;i < result.size();i++){
            array[i] = result.get(i);
        }
        return array;
    }
}

//Time Complexity : O(d^2); d = digits
//Space Complexity: O(n);