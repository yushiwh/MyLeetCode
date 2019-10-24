/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: StrStr
 * Author:   nick
 * Date:     2019/10/21 11:47
 * Description:
 * History:
 */
package com.ys.myleetcode;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author nick
 * @create 2019/10/21
 * @since 1.0.0
 */
public class StrStr_28 {

    public static void main(String[] args) {
        StrStr_28.Solution solution = new StrStr_28().new Solution();
        String haystack1 = "hello";
        String needle1 = "ll";
        String haystack2 = "aaaaa";
        String needle2 = "bba";
        System.out.println(haystack1 + "中" + needle1 + "出现的下标:" + solution.strStr(haystack1, needle1));
        System.out.println(haystack2 + "中" + needle2 + "出现的下标:" + solution.strStr(haystack2, needle2));
    }

    /**
     * 就用双指针的包里破解的方法把
     * KMP的算法，理解好难哦
     * <p>
     * <p>
     * 1、设置两个指针i和j，分别用于指向主串(haystack)和模式串(needle)
     * 2、从左到右开始一个个字符匹配
     * 如果主串和模式串的两字符相等，则i和j同时后移比较下一个字符
     * 如果主串和模式串的两字符不相等，就跳回去，即模式串向右移动，同时模式串指针归零(i = 1; j = 0)
     * 3、所有字符匹配结束后，如果模式串指针指到串尾(j = needle.length)，说明完全匹配，此时模式串出现的第一个第一个位置为：i - j
     */
    class Solution {
        public int strStr(String haystack, String needle) {
            if ("".equals(needle)) {
                return 0;
            }
            //将两个字符串都转换成数组，便于每一个字符进行匹配
            char[] haystacks = haystack.toCharArray();
            char[] needles = needle.toCharArray();
            //定义两个指针，都是从0开始
            int j = 0;
            int i = 0;
            //循环，源字符串没有匹配完并且目标字符串也没有匹配完
            while ( i < haystacks.length && j < needles.length ) {
                if (haystacks[i] == needles[j]) { // 当两个字符相等则比较下一个
                    i++;
                    j++;
                } else {
                    i = i - j + 1; // 一旦不匹配，i后退匹配的长度后，准备下一次的遍历
                    j = 0; // j归零
                }
            }
            if (j == needles.length) {
                //待匹配的已经完成
                return i - j;
            } else {
                return -1;
            }

        }
    }
}