class Solution {
    public int fib(int n) {
        int sum = 0, a = 0, b = 1;
        if (n <= 1) {
            return n;
        }

        for (int i = 1; i < n; i++) {
            sum = a + b;
            a = b; 
            b = sum;
        }
        return sum;
    }
}
