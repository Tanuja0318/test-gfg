class Solution {
    public ArrayList<String> generateBinary(int n) {
        ArrayList<String> res = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            res.add(Integer.toBinaryString(i));
        }
        return res;
    }
}
