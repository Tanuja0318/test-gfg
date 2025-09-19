class Solution {
    public int minParentheses(String s) {
        int openCount = 0;  
        int insertions = 0;  
        for (char c : s.toCharArray()) {
            if (c == '(') {
                openCount++;
            } else {
                if (openCount > 0) {
                    openCount--; 
                } else {
                    insertions++; 
                }
            }
        }
        return insertions + openCount; 
    }
}
