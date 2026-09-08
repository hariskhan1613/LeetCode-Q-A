class Solution {
    public int[] sortedSquares(int[] nums) {
        int l=0;
        int r=nums.length-1;
        int index=nums.length-1;
        int[] ans=new int[nums.length];
        while(l<=r){
             if (Math.abs(nums[l]) > Math.abs(nums[r])){
                ans[index]= nums[l]*nums[l];
                l++;
            }else{
                ans[index]=nums[r]*nums[r];
                r--;
            }
            index--;
        }
        return ans;
    }
}