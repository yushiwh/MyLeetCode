/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: removeDuplicates
 * Author:   nick
 * Date:     2019/10/17 15:38
 * Description:
 * History:
 */
package com.ys.myleetcode;

import java.util.Arrays;

/**
 * //给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * //
 * // 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * //
 * // 示例 1:
 * //
 * // 给定数组 nums = [1,1,2],
 * //
 * //函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * //
 * //你不需要考虑数组中超出新长度后面的元素。
 * //
 * // 示例 2:
 * //
 * // 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * //
 * //函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * //
 * //你不需要考虑数组中超出新长度后面的元素。
 * //
 * //
 * // 说明:
 * //
 * // 为什么返回数值是整数，但输出的答案是数组呢?
 * //
 * // 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * //
 * // 你可以想象内部操作如下:
 * //
 * // // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * //int len = removeDuplicates(nums);
 * //
 * //// 在函数里修改输入数组对于调用者是可见的。
 * //// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * //for (int i = 0; i < len; i++) {
 * //    print(nums[i]);
 * //}
 * //
 *
 * @author nick
 * @create 2019/10/17
 * @since 1.0.0
 */
public class RemoveDuplicates_26 {
    public static void main(String[] args) {
        RemoveDuplicates_26.Solution solution = new RemoveDuplicates_26().new Solution();
        //Test
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2};
        int result = solution.removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < result; i++) {
            System.out.print(nums[i] + ",");
        }
    }


    class Solution {
        public int removeDuplicates(int[] nums) {
            int length = nums.length;
            int i = 1;
            int j = 1;
            while ( j < length ) {
                if (nums[j] == nums[i - 1]) {
                    j++;
                } else {
                    nums[i] = nums[j];
                    i++;
                    j++;
                }
            }
            //返回数组的长度
            return i;

        }
    }

}