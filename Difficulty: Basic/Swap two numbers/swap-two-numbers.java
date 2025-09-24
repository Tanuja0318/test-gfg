class Solution {
    static List<Integer> get(int a, int b) {
        List<Integer> res= new ArrayList<>();
        a=(a^b);
        b=(a^b);
        a=(a^b);
        res.add(a);
        res.add(b);
        return res;
    }
}