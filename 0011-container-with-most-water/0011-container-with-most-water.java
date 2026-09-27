class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int l=0;
        int r=n-1;

        int res=0;
        while(l<r){
            if(height[l]<height[r]){
                res=Math.max(res, (r-l)*height[l]);
                l++;
            }else if(height[l]>height[r]){
                res=Math.max(res, (r-l)*height[r]);
                r--;
            }else{
                res=Math.max(res, (r-l)*height[l]);
                l++;
                r--;
            }
        }
        return res;
    }
}