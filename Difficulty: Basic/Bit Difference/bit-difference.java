class Solution {
    public static int countBitsFlip(int a, int b) {
        int count=0;
        int n=a^b;
        while(n!=0){
            n=(n&(n-1));
            count++;
        }
        return count;
    }
}
