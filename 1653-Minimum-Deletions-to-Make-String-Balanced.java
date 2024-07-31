class Solution {
    public int minimumDeletions(String s) {
        char[] l = s.toCharArray();
        int a = 0;
        int b = 0;
        int op = Integer.MAX_VALUE;
        for (int i = 0; i < l.length; i++)
            a += ('b' - l[i]);

        for (int i = 0; i < s.length(); i++) {
            op = Math.min(op, a + b);
            a -= ('b' - l[i]);
            b += (l[i] - 'a');
        }
        op = Math.min(op, a + b);
        return op;
    }
}
