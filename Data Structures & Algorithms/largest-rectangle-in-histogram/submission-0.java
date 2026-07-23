class Solution {
    public int largestRectangleArea(int[] nums) {
        Stack <Integer> st = new Stack<>();
        int n = nums.length;
        int maxA = 0;
        for(int i = 0; i<=n ; i++){
            while(!st.empty() && (i==n || nums[st.peek()] >= nums[i])){
                int height = nums[st.peek()];
                st.pop();
                int width;
                if(st.empty()){
                    width = i;
                } else {
                    width = i - st.peek() - 1;
                }
                maxA = Math.max(maxA, width * height);
            }
            st.push(i);
        }
        return maxA;
    }
}