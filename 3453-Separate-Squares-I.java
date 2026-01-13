class Solution {
    public double separateSquares(int[][] squares) {
        double low = Double.MAX_VALUE;
        double high = 0;
        double totalArea = 0;

        // Compute bounds and total area (FIXED)
        for (int[] sq : squares) {
            double y = sq[1];
            double l = sq[2];
            low = Math.min(low, y);
            high = Math.max(high, y + l);
            totalArea += l * l; // l is double here
        }

        double target = totalArea / 2.0;

        // Binary search on y
        for (int i = 0; i < 60; i++) {
            double mid = (low + high) / 2.0;
            double areaBelow = 0;

            for (int[] sq : squares) {
                double y = sq[1];
                double l = sq[2];

                double heightBelow = Math.min(Math.max(mid - y, 0), l);
                areaBelow += heightBelow * l;
            }

            if (areaBelow < target) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
