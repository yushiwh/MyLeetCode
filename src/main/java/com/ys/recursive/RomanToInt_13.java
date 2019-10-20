/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: RomanToInt_13
 * Author:   nick
 * Date:     2019/10/20 10:52
 * Description:
 * History:
 */
package com.ys.recursive;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，
 * 例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9
 * 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "III"
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: "IV"
 * 输出: 4
 * 示例 3:
 * <p>
 * 输入: "IX"
 * 输出: 9
 * 示例 4:
 * <p>
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author nick
 * @create 2019/10/20
 * @since 1.0.0
 */
public class RomanToInt_13 {
    public static void main(String[] args) {
        RomanToInt_13.Solution solution = new RomanToInt_13().new Solution();
        //3
        String str1 = "III";
        //4
        String str2 = "IV";
        //9
        String str3 = "IX";
        //58   L = 50, V= 5, III = 3.
        String str4 = "LVIII";
        //1994  M = 1000, CM = 900, XC = 90, IV = 4.
        String str5 = "MCMXCIV";

        int sum1 = solution.romanToInt(str1);
        int sum2 = solution.romanToInt(str2);
        int sum3 = solution.romanToInt(str3);
        int sum4 = solution.romanToInt(str4);
        int sum5 = solution.romanToInt(str5);

        System.out.println(str1 + "--->" + sum1);
        System.out.println(str2 + "--->" + sum2);
        System.out.println(str3 + "--->" + sum3);
        System.out.println(str4 + "--->" + sum4);
        System.out.println(str5 + "--->" + sum5);

    }


    /**
     *
     */
    class Solution {
        Map<Character, Integer> romaMap = new HashMap<>();
        Map<String, Integer> specialMap = new HashMap<>();


        public int romanToInt(String s) {
            int sum = 0;
            //常规的map集合
            romaMap.put('I', 1);
            romaMap.put('V', 5);
            romaMap.put('X', 10);
            romaMap.put('L', 50);
            romaMap.put('C', 100);
            romaMap.put('D', 500);
            romaMap.put('M', 1000);

            //特殊的map集合
            specialMap.put("IV", 4);
            specialMap.put("IX", 9);
            specialMap.put("XL", 40);
            specialMap.put("XC", 90);
            specialMap.put("CD", 400);
            specialMap.put("CM", 900);


            //遍历字符串
            if (null == s || "".equals(s)) {
                return 0;
            }
            //转换成字符串数组
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == 'I' && i < chars.length - 1) {
                    if (chars[i + 1] == 'V') {
                        sum = sum + specialMap.get("IV");
                        i++;
                        continue;
                    }
                    if (chars[i + 1] == 'X') {
                        sum = sum + specialMap.get("IX");
                        i++;
                        continue;
                    }
                }
                if (chars[i] == 'X' && i < chars.length - 1) {
                    if (chars[i + 1] == 'L') {
                        sum = sum + specialMap.get("XL");
                        i++;
                        continue;
                    }
                    if (chars[i + 1] == 'C') {
                        sum = sum + specialMap.get("XC");
                        i++;
                        continue;
                    }

                }
                if (chars[i] == 'C' && i < chars.length - 1) {
                    if (chars[i + 1] == 'D') {
                        sum = sum + specialMap.get("CD");
                        i++;
                        continue;
                    }
                    if (chars[i + 1] == 'M') {
                        sum = sum + specialMap.get("CM");
                        i++;
                        continue;
                    }
                }
                //不是特殊情况
                sum = sum + romaMap.get(chars[i]);
            }
            return sum;
        }
    }


}