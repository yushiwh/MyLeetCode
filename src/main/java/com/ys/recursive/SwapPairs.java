/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: SwapPairs
 * Author:   nick
 * Date:     2019/10/18 10:55
 * Description:
 * History:
 */
package com.ys.recursive;


/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * @author nick
 * @create 2019/10/18
 * @since 1.0.0
 */
public class SwapPairs {
    public static void main(String[] args) {
        SwapPairs.Solution solution = new SwapPairs().new Solution();

    }

    /**
     * 实际上就是搞一个中间节点，进行交换赋值
     */
    class Solution {
        public ListNode swapPairs(ListNode head) {
            //如果节点没有了，就把这个节点返回
            if (null == head || null == head.next) {
                return head;
            }
            //定义开始的节点
            ListNode temp = new ListNode(-1);
            //进行赋值
            ListNode l1 = temp;
            ListNode l2 = head;
            //定义中间节点
            ListNode nextStart;
            while ( null != l2 && null != l2.next ) {
                //  进行交换
                nextStart = l2.next.next;
                l1.next = l2.next;
                l2.next.next = l2;
                l2.next = nextStart;
                l1 = l2;
                l2 = l2.next;
            }
            return temp.next;
        }
    }

    /**
     * 定义节点
     */
    static class ListNode {
        int val;
        //下一个节点
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}