/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: Operation
 * Author:   nick
 * Date:     2019/7/22 9:56
 * Description: 编写一个类 Operation 可以返回一个运算符 对应的优先级
 * History:
 */
package com.ys.service.stack;

/**
 * 〈编写一个类 Operation 可以返回一个运算符 对应的优先级〉
 *
 * @author nick
 * @create 2019/7/22
 * @since 1.0.0
 */
public class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    /**
     * 写一个方法，返回对应的优先级数字
     */
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符" + operation);
                break;
        }
        return result;
    }

}