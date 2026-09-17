class Solution {

    class Pair{
        String str;
        int count;

        Pair(String str, int count){
            this.str = str;
            this.count = count;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord,1));
        
        Set<String> st = new HashSet<>();
        for(String str : wordList){
            st.add(str);
        }
        st.remove(beginWord);

        while(!q.isEmpty()){
            String curr = q.peek().str;
            int steps = q.peek().count;
            q.remove();

            if(curr.equals(endWord)) return steps;

            for(int i = 0 ; i< curr.length();i++){
                for(char ch = 'a' ; ch <= 'z' ; ch++){
                    char[] arr = curr.toCharArray();
                    arr[i] = ch;
                    String str = new String(arr);
                    if(st.contains(str)){
                        q.add(new Pair(str,steps+1));
                        st.remove(str);
                    }
                }
            }
        }
        return 0;
    }
}