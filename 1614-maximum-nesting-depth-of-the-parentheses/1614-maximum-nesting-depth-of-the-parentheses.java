class Solution {
    public int maxDepth(String s) {
        int n=s.length();
        int res=0;
        int count=0;
        for(int i=0;i<n;i++){
            
            if(s.charAt(i)=='('){
                count++;
                res=Math.max(res, count);
            }else if(s.charAt(i)==')'){
                count--;
            }
        }
        return res;
    }
}