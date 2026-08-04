import java.util.*;
class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min=nums[0];
        int max=nums[0];
        for(int i=0;i<nums.length;i++){
            if(min>nums[i]){
                min=nums[i];
            }
            if(max<nums[i]){
                max=nums[i];
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=min; i<=max;i++){
            boolean found=false;
            for(int j=0;j<nums.length;j++){
                
                if(i==nums[j]){
                    found=true;
                    break;
                }
            }
            if(!found){
                    ans.add(i);
                }
        }
        return ans;
    }
}