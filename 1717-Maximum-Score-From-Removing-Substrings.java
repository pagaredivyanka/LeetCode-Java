import java.util.Stack;
class Solution {

    public String removeSubstring(String s, String str, int points, int[] ans) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if ((s.charAt(i) == str.charAt(1)) && (!st.isEmpty()) && (st.peek() == str.charAt(0))) {
                st.pop();
                ans[0] += points;
            } else {
                st.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }

    public int maximumGain(String s, int x, int y) {
    int[] ans = new int[1];
        if(x<y) {
            s = removeSubstring(s, "ba", y, ans);
            s = removeSubstring(s, "ab", x, ans);
        } else {
            s = removeSubstring(s, "ab", x, ans);
            s = removeSubstring(s, "ba", y, ans);
        }
        return ans[0];
    }
}

