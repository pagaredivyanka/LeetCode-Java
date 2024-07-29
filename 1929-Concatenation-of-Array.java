class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] num = new int[nums.length * 2];

        // for (int i = 0; i < nums.length; i++) {
        //     num[i + nums.length] = num[i] = nums[i];
        // }
        
        System.arraycopy(nums,0,num,0,nums.length);
        System.arraycopy(nums,0,num,nums.length,nums.length);
 
        return num;
    }
}
