/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: LengthOfLastWord
 * Author:   nick
 * Date:     2019/10/24 14:19
 * Description:
 * History:
 */
package com.ys.myleetcode;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * <p>
 * 如果不存在最后一个单词，请返回 0 。
 * <p>
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello World"
 * 输出: 5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author nick
 * @create 2019/10/24
 * @since 1.0.0
 */
public class LengthOfLastWord_58 {

    public static void main(String[] args) {
        LengthOfLastWord_58.Solution solution = new LengthOfLastWord_58().new Solution();
        String str = " a";
        System.out.println(str + "--->" + solution.lengthOfLastWord(str));
    }


    class Solution {
        public int lengthOfLastWord(String s) {
            if ("".equals(s.trim())) {
                return 0;
            }

            return s.trim().substring(s.trim().lastIndexOf(" ")+1).length() ;
        }
    }

}












