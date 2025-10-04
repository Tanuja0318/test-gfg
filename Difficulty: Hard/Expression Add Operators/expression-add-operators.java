class Solution {
    public ArrayList<String> findExpr(String s, int target) {
        ArrayList<String> res = new ArrayList<>();
        backtrack(res, "", s, target, 0, 0, 0);
        Collections.sort(res); 
        return res;
    }
    private void backtrack(ArrayList<String> res, String path, String num, int target,
                           int pos, long eval, long multed) {
        if (pos == num.length()) {
            if (eval == target) {
                res.add(path);
            }
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') break;
            String part = num.substring(pos, i + 1);
            long curr = Long.parseLong(part);
            if (pos == 0) {
                backtrack(res, path + part, num, target, i + 1, curr, curr);
            } else {
                backtrack(res, path + "+" + part, num, target, i + 1, eval + curr, curr);
                backtrack(res, path + "-" + part, num, target, i + 1, eval - curr, -curr);
                backtrack(res, path + "*" + part, num, target, i + 1,
                          eval - multed + multed * curr, multed * curr);
            }
        }
    }
}