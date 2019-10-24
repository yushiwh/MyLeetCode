/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: CountAndSay_38
 * Author:   nick
 * Date:     2019/10/24 10:50
 * Description:
 * History:
 */
package com.ys.myleetcode;

/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 6.     312211
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * <p>
 * 注意：整数顺序将表示为一个字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-and-say
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author nick
 * @create 2019/10/24
 * @since 1.0.0
 */
public class CountAndSay_38 {
    public static void main(String[] args) {
        CountAndSay_38.Solution solution = new CountAndSay_38().new Solution();
        for (int i = 1; i <= 6; i++) {
            System.out.println(i + "----->" + solution.countAndSay(i));
        }
    }

    class Solution {
        public String countAndSay(int n) {
            String str = "1";
            // 开始循环输入的次数,从第二次开始，第一次默认是1
            for (int i = 2; i <= n; i++) {
                //定义字符串拼接
                StringBuilder sb = new StringBuilder();
                //取出第一个字字符
                char ch = str.charAt(0);
                //定义数量
                int count = 1;
                //开始循环字符串
                for (int j = 1; j < str.length(); j++) {
                    char c = str.charAt(j);
                    if (c == ch) {
                        //数量增加
                        count++;
                    } else {
                        sb.append(count).append(ch);//先是个数，后面+字符
                        ch = c;//将不一样的数进行赋值
                        count = 1;//个数从1开始
                    }
                }
                sb.append(count).append(ch);//先是个数，后面+字符
                str = sb.toString();
            }
            return str;
        }
    }
}