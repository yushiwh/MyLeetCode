/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: PrintReverse
 * Author:   nick
 * Date:     2019/10/18 8:48
 * Description: 以相反的顺序打印字符串。
 * History:
 */
package com.ys.recursive;


/**
 * 〈以相反的顺序打印字符串。〉
 * <p>
 * 解题思路：用递归的方法进行每次+1的取值，注意越界问题的判断
 *
 * @author nick
 * @create 2019/10/18
 * @since 1.0.0
 */
public class PrintReverse {
    public static void main(String[] args) {
        char[] str = new char[]{'y', 'u', 's', 'h', 'i'};
        reverseString(str);
    }

    /**
     * 反转打印字符串
     *
     * @param s 字符数组
     */
    public static void reverseString(char[] s) {
        help(0, s);
    }

    /**
     * 具体的方法
     *
     * @param s
     */
    public static void help(int index, char[] s) {
        //进行判断,字符串为空或者下标到了最后，就要退出，否则死循环了
        if (null == s || index >= s.length) {
            return;
        }
        help(index + 1, s);
        System.out.print(s[index]+",");
    }
}