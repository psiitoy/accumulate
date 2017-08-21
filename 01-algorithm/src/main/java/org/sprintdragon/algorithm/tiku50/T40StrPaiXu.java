package org.sprintdragon.algorithm.tiku50;

/**
 * Created by wangdi on 17-4-25.
 */
public class T40StrPaiXu {
    public static void main(String[] args) {
        String[] str = {"010102", "010103", "010101"};
        strSort(str);
        System.out.println("字符串排序后：");
        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i] + " ");
        }
    }

    public static void strSort(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (compare(arr[i], arr[j]) == false) {
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    static boolean compare(String s1, String s2) {
        boolean result = true;
        for (int i = 0; i < s1.length() && i < s2.length(); i++) {
            if (s1.charAt(i) > s2.charAt(i)) {
                result = false;
                break;
            } else if (s1.charAt(i) < s2.charAt(i)) {
                result = true;
                break;
            } else {
                if (s1.length() < s2.length()) {
                    result = true;
                } else {
                    result = false;
                }
            }
        }
        return result;
    }
}
