class Solution {
    public boolean canConstruct(String r, String m) {
        int n=r.length();
        int s=m.length();
        HashMap<Character, Integer> rans=new HashMap<>();
        HashMap<Character, Integer> magz=new HashMap<>();
        for(int i=0;i<n;i++){
            rans.put(r.charAt(i), rans.getOrDefault(r.charAt(i),0)+1);
        }
        for(int i=0;i<s;i++){
            magz.put(m.charAt(i), magz.getOrDefault(m.charAt(i),0)+1);
        }
        for (char c : rans.keySet()) {
            if (!magz.containsKey(c) || magz.get(c) < rans.get(c)) {
                return false;
            }
        }
        return true;
    }
}