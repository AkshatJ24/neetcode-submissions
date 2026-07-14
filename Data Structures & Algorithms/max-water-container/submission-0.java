class Solution {
    public int maxArea(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int res = 0;
        while(l <= r){
            res = Math.max(res, Math.min(nums[l], nums[r]) * (r - l));
            if(nums[l] < nums[r]){
                l++;
            } else{ 
                r--;
            }
        }
        return res;
    }
}
