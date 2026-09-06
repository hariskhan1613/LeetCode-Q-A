class Solution {
    public int[] shuffle(int[] nums, int n) {
        int len=nums.length;
        int[] num=new int[len];
        int c=0;
        for(int i=0;i<len;i+=2){
            num[i]=nums[c];
            num[i+1]=nums[n];
            c++;
            n++;
        }
        return num;
    }
}