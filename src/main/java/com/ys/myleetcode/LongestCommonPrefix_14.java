/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: LongestCommonPrefix
 * Author:   nick
 * Date:     2019/10/21 9:15
 * Description:
 * History:
 */
package com.ys.myleetcode;

import java.util.Arrays;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 *
 * @author nick
 * @create 2019/10/21
 * @since 1.0.0
 */
public class LongestCommonPrefix_14 {
    public static void main(String[] args) {
        LongestCommonPrefix_14.Solution solution = new LongestCommonPrefix_14().new Solution();
        String[] str1 = {"flower", "flow", "flight"};
        String[] str2 = {"dog", "racecar", "car"};
        System.out.println(Arrays.toString(str1) + "的公共前缀-->" + solution.longestCommonPrefix(str1));
        System.out.println(Arrays.toString(str2) + "的公共前缀-->" + solution.longestCommonPrefix(str2));
    }

    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (null == strs || strs.length == 0) {
                //没有字符串
                return "";
            }
            //开始循环
            //1、循环传递的字符串数组中第一个字符串，取出后循环每一个字符。
            //2、和后面的每个字符串进行比较
            for (int i = 0; i < strs[0].length(); i++) {
                //取出第一个字符串的每一个字符
                char c = strs[0].charAt(i);
                //取出从第二个开始的字符串，和第一个字符串开始的每一个字符进行比较，
                // 一旦截取找到不同就返回，每个字符串进行取出（注意strs[j].charAt(i) != c），比较巧妙
                for (int j = 1; j < strs.length; j++) {
                    if (i == strs[j].length() || strs[j].charAt(i) != c) {
                        //第一个是防止溢出
                        //第二个是如果找到不一样的字符了
                        //进行返回
                        return strs[0].substring(0, i);
                    }
                }
            }
            //全部一样，进行返回
            return strs[0];
        }
    }
}