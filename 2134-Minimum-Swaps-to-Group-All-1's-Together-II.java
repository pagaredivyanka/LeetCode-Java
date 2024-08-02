// class Solution {
//     public int minSwaps(int[] nums) {
//         int c = 0;
//         for(int vl : nums) {
//             if(vl == 1) {
//                 c++;
//             }
//         }

//         int ans = 0, cz = 0;
//         for(int i = 0; i < c; i++) {
//             if(nums[i] == 0) {
//                 cz++;
//             }
//         }

//         ans = cz;
//         int n = nums.length;
//         for(int i = c; i < 2*n; i++) {
//             if(nums[i%n] == 0) {
//                 cz++;
//             }
//             if(nums[(i-c)%n] == 0) {
//                 cz--;
//             }
//             ans = Math.min(ans,cz);
//         }
//         return ans;
//     }
// }


class Solution {
    public int minSwaps(int[] nums) {
        int k=0;
        for(int i=0;i<nums.length;i++){
            k+=nums[i];
        }
        int sum=0; int min=nums.length;
        for(int j=0;j<nums.length;j++){
            sum+=nums[j];
            if(j>=k){sum-=nums[j-k];}
            if(j>=k-1)min=Math.min(min,k-sum);
        }
        for(int i=0;i<=k-2;i++){
            sum=sum+nums[i]-nums[nums.length-k+i];
            min=Math.min(min,k-sum);
        }
        return min;
    }
}
