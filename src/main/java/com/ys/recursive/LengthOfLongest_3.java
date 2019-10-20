/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: LengthOfLongest
 * Author:   nick
 * Date:     2019/10/18 16:22
 * Description:
 * History:
 */
package com.ys.recursive;

import java.util.HashMap;
import java.util.Map;

/**
 * //给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * //
 * // 示例 1:
 * //
 * // 输入: "abcabcbb"
 * //输出: 3
 * //解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * //
 * //
 * // 示例 2:
 * //
 * // 输入: "bbbbb"
 * //输出: 1
 * //解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * //
 * //
 * // 示例 3:
 * //
 * // 输入: "pwwkew"
 * //输出: 3
 * //解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * //     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @author nick
 * @create 2019/10/18
 * @since 1.0.0
 */
public class LengthOfLongest_3 {
    public static void main(String[] args) {
        LengthOfLongest_3.Solution solution = new LengthOfLongest_3().new Solution();
        String str = "pwwkew";//3
//        String str = "bbbbb";//1
        //       String str = "abcabcbb";//3
//        String str = "aab"; //2
//        String str = "ddabcdvdf";//3

        System.out.println("无重复的最长字符串长度：" + solution.lengthOfLongestSubstring(str));
    }

    /**
     * 滑动窗口，神奇
     */
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length(), ans = 0;
            Map<Character, Integer> map = new HashMap<>();
            //定义两个指针。end是遍历，start是记录哪个字符重复
            for (int end = 0, start = 0; end < n; end++) {
                char alpha = s.charAt(end);
                if (map.containsKey(alpha)) {
                    start = Math.max(map.get(alpha), start);
                }
                //比较两个数哪个大
                ans = Math.max(ans, end - start + 1);
                map.put(s.charAt(end), end + 1);
            }
            return ans;

        }
    }

}


















