class Solution {
    int minCost(int[] height) {
        int prev = 0;        
        int prev2 = 0;       
        for (int i = 1; i < height.length; i++) {
            int jumpOne = prev + Math.abs(height[i] - height[i - 1]);
            int jumpTwo = Integer.MAX_VALUE;
            if (i > 1) {
                jumpTwo = prev2 + Math.abs(height[i] - height[i - 2]);
            }
            int curr = Math.min(jumpOne, jumpTwo);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}