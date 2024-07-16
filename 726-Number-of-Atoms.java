from collections import defaultdict
from collections import deque
import re

class Solution:
    def isNum(self, i, s):
        return '0' <= s[i] <= '9'

    def isLower(self, i, s):
        return 'a' <= s[i] <= 'z'

    def countOfAtoms(self, formula: str) -> str:
        stack = deque()
        i = 0
        while i < len(formula):
            if 'A' <= formula[i] <= 'Z':
                j = i + 1
                while j < len(formula) and self.isLower(j, formula):
                    j += 1
                curr = formula[i:j]
                stack.append(curr)
                i = j
                while j < len(formula) and self.isNum(j, formula):
                    j += 1
                num = formula[i:j]
                if len(num) > 0:
                    stack.append(num)
                else:
                    stack.append("1")
                i = j - 1
            elif formula[i] == '(':
                stack.append(formula[i])
            else:
                j = i + 1
                while j < len(formula) and self.isNum(j, formula):
                    j += 1
                num = formula[i+1:j]
                number = 1
                if len(num) > 0:
                    number = int(num)
                temp = deque()
                while stack[-1] != '(':
                    temp.append(stack.pop())
                stack.pop()
                while temp:
                    atom = temp.pop()
                    stack.append(atom)
                    curr_num = int(temp.pop())
                    stack.append(str(number * curr_num))
                i = j - 1
            i += 1
        
        atom_counts = defaultdict(int)
        while stack:
            num = 1
            if stack[-1].isdigit():
                num = int(stack.pop())
            atom = stack.pop()
            atom_counts[atom] += num
        
        result = []
        for atom in sorted(atom_counts.keys()):
            result.append(atom)
            if atom_counts[atom] != 1:
                result.append(str(atom_counts[atom]))
        
        return ''.join(result)

# Example usage
sol = Solution()
print(sol.countOfAtoms("H2O"))  # Output: "H2O"
print(sol.countOfAtoms("Mg(OH)2"))  # Output: "H2MgO2"
