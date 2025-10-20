class Solution {
    public ArrayList<Integer> countBSTs(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> left = new ArrayList<>();
            List<Integer> right = new ArrayList<>();
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] < arr[i]) left.add(arr[j]);
                else if (arr[j] > arr[i]) right.add(arr[j]);
            }
            int leftCount = countBST(left);
            int rightCount = countBST(right);
            res.add(leftCount * rightCount);
        }
        return res;
    }
    private int countBST(List<Integer> nums) {
        int n = nums.size();
        if (n <= 1) return 1;
        int total = 0;
        for (int i = 0; i < n; i++) {
            int root = nums.get(i);
            List<Integer> left = new ArrayList<>();
            List<Integer> right = new ArrayList<>();
            for (int val : nums) {
                if (val < root) left.add(val);
                else if (val > root) right.add(val);
            }
            total += countBST(left) * countBST(right);
        }
        return total;
    }
}