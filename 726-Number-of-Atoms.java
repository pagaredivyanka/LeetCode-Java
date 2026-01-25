class Solution {
    private boolean isNum(int i, String s) {
        return s.charAt(i) >= '0' && s.charAt(i) <= '9';
    }

    private boolean isLower(int i, String s) {
        return s.charAt(i) >= 'a' && s.charAt(i) <='z';
    }

    public String countOfAtoms(String formula) {
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < formula.length(); i++) {
            if(formula.charAt(i) >= 'A' && formula.charAt(i) <= 'Z') {
                int j = i + 1;
                while(j < formula.length() && isLower(j, formula)) {
                    j++;
                }
                String curr = formula.substring(i, j);
                stack.push(curr);
                i=j;
                while(j < formula.length() && isNum(j, formula)) {
                    j++;
                }
                String num = formula.substring(i, j);
                if(num.length() > 0) {
                    stack.push(num);
                } else {
                    stack.push("1");
                }
                i = j-1;
            }

            else if(formula.charAt(i)=='(') {
                stack.push(String.valueOf(formula.charAt(i)));

            } else {
                int j = i+1;
                while(j < formula.length() && isNum(j, formula)) {
                    j++;
                }
                String num = formula.substring(i+1, j);
                int number = 1;
                if(num.length() > 0) {
                    number = Integer.parseInt(num);

                } 
                Stack<String> temp = new Stack<>();
                while(!stack.peek().equals("(")) {
                    temp.add(stack.pop());
                }
                stack.pop();
                while(!temp.isEmpty()) {
                    String atom = temp.pop();
                    stack.push(atom);
                    int currNum = Integer.parseInt(temp.pop());
                    stack.push(String.valueOf(number*currNum));
                }
                i = j-1;
            }
        }    

        TreeMap<String, Integer> map = new TreeMap<>();
        while(!stack.isEmpty()) {
            int num = 1;
            if(isNum(0, stack.peek())) {
                num = Integer.parseInt(stack.pop());
            }
            String atom = stack.pop();
            map.put(atom, map.getOrDefault(atom, 0) + num);
        }

        StringBuilder ans = new StringBuilder();
        for(String key: map.keySet()) {
            ans.append(key);
            if(map.get(key)!=1)
                ans.append(String.valueOf(map.get(key)));
        }
        return ans.toString();
    }
}
