class Solution {
    public ArrayList<String> binstr(int n) {
        ArrayList<String> result = new ArrayList<>();
        int total = 1 << n;
        for (int i = 0; i < total; i++) {
            String bin = String.format("%" + n + "s", Integer.toBinaryString(i)).replace(' ', '0');
            result.add(bin);
        }
        return result;
    }
}
