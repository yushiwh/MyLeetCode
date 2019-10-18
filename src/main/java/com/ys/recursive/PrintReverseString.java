/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: PrintReverse
 * Author:   nick
 * Date:     2019/10/18 8:48
 * Description: 以相反的顺序打印字符串。
 * History:
 */
package com.ys.recursive;


import com.ys.myleetcode.RemoveDuplicates;

import java.util.Arrays;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * <p>
 *
 * @author nick
 * @create 2019/10/18
 * @since 1.0.0
 */
public class PrintReverseString {
    public static void main(String[] args) {
        String str = "yushi";
        PrintReverseString.Solution solution = new PrintReverseString().new Solution();
        //Test
        str = solution.reverseString(str.toCharArray());
        System.out.println(str);
    }

    /**
     * 方法都写在这里
     */
    class Solution {
        /**
         * 具体的方法,需要原地修改数组
         * 方法就是对半进行前后对换
         *
         * @param chars
         */

        public String reverseString(char[] chars) {
            char temp;
            int length = chars.length;
            for (int i = 0, j = length - 1; i < length / 2; i++, j--) {
                temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
            }
            return new String(chars);
        }
    }

}