class Solution {
    public int trap(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int lmax = 0, rmax = 0;
        int res = 0;
        while(l <= r){
            if(nums[l] < nums[r]){
                if(nums[l] > lmax){
                    lmax = nums[l];
                } else {
                    res += lmax - nums[l];
                }
                l++;
            } else {
                if(nums[r] > rmax){
                    rmax = nums[r];
                } else {
                    res += rmax - nums[r];
                }
                r--;
            }
        }
        return res;
    }
}
