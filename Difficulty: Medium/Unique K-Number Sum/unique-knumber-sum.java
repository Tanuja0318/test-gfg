class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), res);
        return res;
    }
    private void backtrack(int start, int target, int k,
                           ArrayList<Integer> path,
                           ArrayList<ArrayList<Integer>> res) {
        if (path.size() == k && target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (path.size() > k || target < 0) return;
        for (int i = start; i <= 9; i++) {
            path.add(i);  // choose
            backtrack(i + 1, target - i, k, path, res); // explore
            path.remove(path.size() - 1); // un-choose
        }
    }
}