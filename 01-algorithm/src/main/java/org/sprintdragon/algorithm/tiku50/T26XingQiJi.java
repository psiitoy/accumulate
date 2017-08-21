package org.sprintdragon.algorithm.tiku50;

/**
 * 题目：请输入星期几的第一个字母来判断一下是星期几，如果第一个字母一样，则继续判断第二个字母。
 * Created by wangdi on 17-4-25.
 */
public class T26XingQiJi {

    public static void main(String[] args) {
        System.out.println(getXqj("SA"));
    }

    public static String getXqj(String str) {
        String[] week_enums = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"};
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            String name = "";
            int count = 0;
            for (String s : week_enums) {
                if (s.indexOf(cs[i]) == i) {
                    count++;
                    name = s;
                }
            }
            if (count == 1) {
                return name;
            }
        }
        return null;
    }

}
