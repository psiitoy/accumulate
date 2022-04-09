package org.sprintdragon.algorithm.lc;

import java.util.Deque;
import java.util.LinkedList;

public class Title227 {

    public static void main(String[] args) {
        Title227 test = new Title227();
        System.out.println(test.calculate("1+2+3*3 "));
    }

    /**
     * 单栈 即 Deque(LinkedList)
     * 将+ -转化成+ -数字入数字栈，先处理 * /
     * 最后就是ans+= 栈里面的数字迭代处理即可
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int len = s.length();
        int num = 0;
        char preOps = '+';
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if ((!Character.isDigit(c) && c != ' ') || i == len - 1) {
                switch (preOps) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.poll() * num);
                        break;
                    case '/':
                        stack.push(stack.poll() / num);
                        break;
                }
                num = 0;
                preOps = c;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

}
