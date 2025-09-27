class Solution {
    public int kBitFlips(int[] arr, int k) {
        int n = arr.length;
        int flips = 0;       
        int flipCount = 0;  
        int[] isFlipped = new int[n]; 
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                flipCount -= isFlipped[i - k];
            }
            if ((arr[i] + flipCount) % 2 == 0) {
                if (i + k > n) return -1; 
                flips++;
                flipCount++;
                isFlipped[i] = 1; 
            }
        }
        return flips;
    }
}
