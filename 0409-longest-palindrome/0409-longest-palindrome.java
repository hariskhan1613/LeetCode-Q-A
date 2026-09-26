 class Solution {
    public int longestPalindrome(String s) {
        int n=s.length();
        HashMap<Character, Integer> hash=new HashMap<>();
        for(int i=0;i<n;i++){
            hash.put(s.charAt(i), hash.getOrDefault(s.charAt(i),0)+1);
        }
        boolean odd=false;
        int res=0;
        for(char c: hash.keySet()){
            if(hash.get(c)%2==0){
                res=res+hash.get(c);
            }else{
                odd=true;
                res=res+(hash.get(c)-1);
            }
        }
        if(odd==false){
            return res;
        }else{
            return res+1;
        }
        
    }
}