// User function Template for Java

class Solution {
    public int getSingle(int[] arr) {
        int a=0,b=0;
        for(int n:arr){
            a^=(n& ~b);
            b^=(n& ~a);
        }
        return a;
    }
}