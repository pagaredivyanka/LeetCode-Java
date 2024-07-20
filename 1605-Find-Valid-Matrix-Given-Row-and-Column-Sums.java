class Solution {
    public int[][] restoreMatrix(int[] r, int[] c) {
        int m = r.length;
        int n = c.length;
        int[][] a = new int[m][n];
        int i = m-1;
        int j = n-1;
        while(i >= 0 && j >= 0){
            if(r[i] <= c[j]){
                a[i][j] = r[i];
                c[j] -= r[i];
                i--;
            }
            else {
                a[i][j] = c[j];
                r[i] -= c[j];
                j--;
            }
        }
        return a;
    }
}
