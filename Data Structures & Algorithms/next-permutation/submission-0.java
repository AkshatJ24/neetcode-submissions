class Solution {

    private void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            ++start;
            --end;
        }
    }

    private void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;

        for(int i = n - 2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                idx = i;
                break;
            }
        }

        if(idx == -1){
            reverse(nums, 0, n - 1);
            return;
        }

        for(int i = n - 1; i >= idx; i--){
            if(nums[i] > nums[idx]){
                swap(nums, idx, i);
                break;
            }
        }

        reverse(nums, idx + 1, n - 1);
    
    }
}