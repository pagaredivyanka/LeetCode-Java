class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int numsLen = nums.length;
        int newOldNumMp[][] = new int[numsLen][2];
        for(int indx = 0; indx < numsLen; indx++) {
            int oldNum = nums[indx];
            int newNum = getNewNum(oldNum, mapping);
            newOldNumMp[indx] = new int[] {
                newNum, oldNum
            };
        }
        Arrays.sort(newOldNumMp,(a,b) -> (a[0] - b[0]));
        for(int indx = 0; indx <numsLen; indx++) {
            nums[indx] = newOldNumMp[indx][1];
        }
        return nums;
    }
    private int getNewNum(int oldNum, int mapping[]) {
        if(oldNum == 0) return mapping[0];
        int newNum = 0, mul = 1;
        while(oldNum > 0) {
            int dig = oldNum % 10;
            newNum = newNum + mapping[dig] * mul;
            mul *= 10;
            oldNum /= 10;
        }
        return newNum;
    }
}
