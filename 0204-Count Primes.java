class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;

        boolean[] isPrime = new boolean[n];

        for (int i = 3; i < n; i += 2) {
            isPrime[i] = true;
        }

        for (int i = 3; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = 3; i * j < n; j += 2) {
                    isPrime[i * j] = false;
                }
            }
        }

        int count = 1;
        for (int i = 3; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }
}
