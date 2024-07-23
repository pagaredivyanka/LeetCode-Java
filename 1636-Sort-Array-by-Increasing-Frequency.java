// class Solution {
//     public int[] frequencySort(int[] nums) {
//         HashMap<Integer, Integer> map = new HashMap();
//         for(int num: nums) {
//             map.put(num, map.getOrDefault(num, 0) + 1);
//         }
//         PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (map.get(a) == map.get(b)? b-a: map.get(a) - map.get(b)));
//         pq.addAll(map.keySet());
//         int[] res = new int[nums.length];
//         int i = 0;
//         while(!pq.isEmpty()) {
//             int val = pq.poll(),
//                 freq = map.get(val);
//             for(int j =0; j < freq; j++) {
//                 res[i++] = val;
//             }
//         }

//         return res;

//     }
// }

class Solution {
    public int[] frequencySort(int[] nums) {
        int count[] = new int[201];
        for (int n : nums)  count[n + 100]++;
        int k = 0;
        for (int i = nums.length - 1; i >= 0;) {
            int m = 0, ind = -1;
            for (int j = 0; j < 201; j++) {
                if (count[j] > m) {
                    m = count[j];
                    ind = j;
                }
            }
            for (int j = 0; j < m; j++)  nums[i--] = ind - 100;
            count[ind] = 0;
        }
        return nums;
    }
}
