package org.sprintdragon.algorithm.tiku50;

/**
 * Created by wangdi on 17-4-25.
 */
public class T24Shz {

    public static void main(String[] args) {
        test(34389);
    }

    public static void test(int n) {
        if (n > 99999) {
            return;
        }
        int ws = 0;
        String str = String.valueOf(n);
        char[] chars = str.toCharArray();
        ws = chars.length;
        String ret = "";
        for (int i = chars.length - 1; i >= 0; i--) {
            ret += chars[i];
        }
        System.out.println("位数：" + ws + ",逆序：" + Integer.valueOf(ret));
    }

}
