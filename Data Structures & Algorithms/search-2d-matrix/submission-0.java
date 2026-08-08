public class Solution {
    public boolean searchMatrix(int[][] nums, int target) {
        if(nums.length == 0 || nums[0].length == 0) return false;
        int m = nums.length;
        int n = nums[0].length;
        int low = 0;
        int high = m*n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int row = mid / n;
            int col = mid % n;

            if (nums[row][col] == target) {
                return true;
            } else if (nums[row][col] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;

    }
}