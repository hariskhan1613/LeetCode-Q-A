class Solution {
    public int minAddToMakeValid(String s) {
        int st=0;
        int end=0;
        for(int i=0;i<s.length();i++){
           if(s.charAt(i)=='('){
            st++;
           }else if(st>0){
            st--;
           }else{
            end++;
           }
        }
        return st+end;
    }
}