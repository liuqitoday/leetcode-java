import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20.有效括号
 *
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 */
public class Problem20 {

    public static boolean isValid(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        Map<Character, Character> validMap = new HashMap<Character, Character>();
        validMap.put(')', '(');
        validMap.put('}', '{');
        validMap.put(']', '[');
        if (s.length() % 2 != 0) {
            return false;
        }
        int strLength = s.length();
        Stack<Character> charStack = new Stack<Character>();
        for (int i = 0; i < strLength; i++) {
            char currentChar = s.charAt(i);
            if (validMap.containsKey(currentChar)) {
                if (charStack.isEmpty()) {
                    return false;
                }
                Character topChar = charStack.pop();
                if (!validMap.get(currentChar).equals(topChar)) {
                    return false;
                }
            } else {
                charStack.push(currentChar);
            }
        }
        return charStack.isEmpty();
    }

    public static void main(String[] args) {
        boolean valid = isValid("{{([])}}");
        System.out.println(valid);
    }

}
