// User function Template for Java

class Solution {
    public List<String> AllPossibleStrings(String s) {
        List<String> res=new ArrayList<>();
        int n=s.length();
        for(int i=0;i<(1<<n);i++){
            StringBuilder sub=new StringBuilder();
            for(int j=0;j<n;j++){
                if((i&(1<<j))>0)
                    sub.append(s.charAt(j));
            }
            res.add(sub.toString());
        }
        Collections.sort(res);
        return res;
    }
}