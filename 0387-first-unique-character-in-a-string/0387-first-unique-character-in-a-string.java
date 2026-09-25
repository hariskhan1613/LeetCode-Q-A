class Solution {
    public int firstUniqChar(String s) {
        int n=s.length();
        HashMap<Character, Integer> hash=new HashMap<>();

        for(int i=0;i<n;i++){
            hash.put(s.charAt(i), hash.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0;i<n;i++){
            if(hash.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
}