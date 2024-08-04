class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] sums = new int[n*(n+1)/2];
        int idx = 0;
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += nums[j];
                sums[idx++] = sum;
            }
        }
        Arrays.sort(sums);
        int mod = (int)1e9 + 7;
        int ans = 0;
        for(int i = left - 1; i < right; i++) ans = ans % mod + sums[i];
        return ans % mod;
    }
}
