/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: isValid
 * Author:   nick
 * Date:     2019/10/21 10:50
 * Description:
 * History:
 */
package com.ys.myleetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author nick
 * @create 2019/10/21
 * @since 1.0.0
 */
public class IsValid_20 {
    public static void main(String[] args) {
        IsValid_20.Solution solution = new IsValid_20().new Solution();
        //true
        String str1 = "()";
        //true
        String str2 = "()[]{}";
        //false
        String str3 = "(]";
        //false
        String str4 = "([)]";
        //true
        String str5 = "{[]}";

        System.out.println(str1 + "-->" + solution.isValid(str1));
        System.out.println(str2 + "-->" + solution.isValid(str2));
        System.out.println(str3 + "-->" + solution.isValid(str3));
        System.out.println(str4 + "-->" + solution.isValid(str4));
        System.out.println(str5 + "-->" + solution.isValid(str5));
    }

    /**
     * 用栈的方法进行处理
     * 1、初始化一个栈
     * 2、遇到开括号，就压入栈，比如:(、｛、【
     * 3、遇到闭括号就弹出。看弹出的是不是对应的开括号的值。一旦不是就返回false。
     * 4、最后看栈里面是否还有元素
     */
    class Solution {
        public boolean isValid(String s) {
            //定义对应成对出现的map,后面需要根据闭括号找到对应的开括号
            Map<Character, Character> map = new HashMap<>(3);
            map.put(')', '(');
            map.put(']', '[');
            map.put('}', '{');
            char c;
            //定一个栈
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                //取出每一个字符
                c = s.charAt(i);
                //兼容" ",如果是" ",就不用进行处理。这样能够节省2ms时间
                if (!"".equals(c)) {
                    //如果是开括号，就压入栈。如果是闭括号，就弹出栈顶数据。跟闭括号找到是否是对应的开括号。不是就返回false
                    if (map.containsKey(c)) {
                        //判断是否stack是否还有数据，没有,肯定是返回失败
                        //弹出一个字符进行比较,不是对应的开括号，就返回false.如果是就弹出继续
                        //连续判断能够节省1ms时间
                        if (stack.isEmpty() || !map.get(c).equals(stack.pop())) {
                            return false;
                        }
                    } else {
                        //开括号，压入栈
                        stack.push(c);
                    }
                }
            }
            //最后判断栈里面是否为空，不为空就是false，证明里面还有元素
            return stack.isEmpty();
        }
    }
}













