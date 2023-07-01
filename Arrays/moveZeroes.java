class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int ind = 0;
        
        for(int i=0;i<n;i++){
            if(nums[i] != 0)
                nums[ind++] = nums[i];
        }

        for(int i=ind;i<n;i++){
            nums[i] = 0;
        }
    }
}

// Snow ball technique
class Solution {
     public void moveZeroes(int[] nums) {
        int snowBallSize = 0; 
        for (int i=0;i<nums.length;i++){
	        if (nums[i]==0){
                snowBallSize++; 
            }
            else if (snowBallSize > 0) {
	            int t = nums[i];
	            nums[i]=0;
	            nums[i-snowBallSize]=t;
            }
        }
    }
}