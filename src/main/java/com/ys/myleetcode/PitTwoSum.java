/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: PitTwoSum
 * Author:   nick
 * Date:     2019/10/17 10:41
 * Description: 两数之和
 * History:
 */
package com.ys.myleetcode;

import java.util.Arrays;

/**
 * //给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * //
 * // 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * //
 * // 示例:
 * //
 * // 给定 nums = [2, 7, 11, 15], target = 9
 * //
 * //因为 nums[0] + nums[1] = 2 + 7 = 9
 * //所以返回 [0, 1]
 * //
 * // Related Topics 数组 哈希表
 *
 * @author nick
 * @create 2019/10/17
 * @since 1.0.0
 */
public class PitTwoSum {
    public static void main(String[] args) {
        Solution solution = new PitTwoSum().new Solution();
        //Test
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(result));


    }


    class Solution {
        /**
         * @param nums   传入的数组
         * @param target 要找到和的数组
         * @return 具体是哪两个编号的数组
         */
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == target - nums[i]) {
                        return new int[]{i, j};
                    }
                }
            }
            throw new IllegalArgumentException("No two sum solution");
        }
    }
}