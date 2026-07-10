class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }

        int longestSeq = 1;
        for(int i : nums){
            if(!set.contains(i - 1)){
                int cnt = 1;
                int currentNum = i;

                while(set.contains(currentNum + 1)){
                    currentNum += 1;
                    cnt++;
                }

                longestSeq = Math.max(longestSeq, cnt);
            }
        }

        return longestSeq;
    }
}
