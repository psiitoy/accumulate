package org.sprintdragon.algorithm.lc;

import java.util.HashMap;
import java.util.Map;

public class Title166 {

    public static void main(String[] args) {
        Title166 test = new Title166();
        System.out.println(test.fractionToDecimal(4, 333));
    }

    public String fractionToDecimal(int numerator, int denominator) {
        // 0 除以任何数都是 0
        if (numerator == 0) {
            return "0";
        }
        // 转成 long, 绕开整形溢出陷阱
        long num = numerator, dec = denominator;
        boolean negitive = false;
        // 判断符号, 同正同负才是正, 否则是负
        if (numerator >= 0 ^ denominator >= 0) {
            negitive = true;
        }
        // 转为正数运算
        num = Math.abs(num);
        dec = Math.abs(dec);
        // 计算整数部分
        long integer = num / dec;
        // 计算当前余数
        num = num % dec;
        int idx = -1, curPos = 0;
        Map<Long, Integer> map = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        while (num != 0) {
            // 余数 * 10 即为当前被除数
            num *= 10;
            // 如果当前被除数之前已经出现过了, 那么代表循环开始
            if (map.containsKey(num)) {
                // 获得循环节的位置
                idx = map.get(num);
                break;
            }
            // 更新 map
            map.put(num, curPos);
            // 记录当前结果
            builder.append(num / dec);
            // 计算当前余数
            num %= dec;
            // 更新小数指针位置
            curPos++;
        }
        StringBuilder ans = new StringBuilder();
        String decmical = builder.toString();
        // 负数
        if (negitive) {
            ans.append("-");
        }
        // 加入整数部分
        ans.append(Long.toString(integer));
        // 如果 map 中没有元素, 代表没有小数部分
        if (map.size() != 0) {
            ans.append(".");
        }
        // 存在循环节就加入括号, 否则直接加入小数部分
        if (idx != -1) {
            ans.append(decmical.substring(0, idx));
            ans.append("(");
            ans.append(decmical.substring(idx));
            ans.append(")");
        } else {
            ans.append(decmical);
        }
        return ans.toString();
    }

}
