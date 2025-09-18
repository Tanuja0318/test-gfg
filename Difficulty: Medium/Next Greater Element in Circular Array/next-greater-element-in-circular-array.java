class Solution {
    public ArrayList<Integer> nextGreater(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            int idx = i % n;
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[idx]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                res[idx] = arr[stack.peek()];
            }
            stack.push(idx);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int val : res) {
            ans.add(val);
        }
        return ans;
    }
}