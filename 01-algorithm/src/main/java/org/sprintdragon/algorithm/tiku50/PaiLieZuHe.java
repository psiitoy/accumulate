package org.sprintdragon.algorithm.tiku50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangdi on 17-4-24.
 */
public class PaiLieZuHe {

    /**
     * 输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc，则输出由字符a、b、c所能排列出来的所有字符串abc、acb、bac、bca、cab和cba。
     * 可以这样想：固定第一个字符a，求后面两个字符bc的排列。当两个字符bc的排列求好之后，我们把第一个字符a和后面的b交换，得到bac，
     * 接着我们固定第一个字符b，求后面两个字符ac的排列。现在是把c放到第一位置的时候了。记住前面我们已经把原先的第一个字符a和后面的b做了交换，
     * 为了保证这次c仍然是和原先处在第一位置的a交换，我们在拿c和第一个字符交换之前，先要把b和a交换回来。在交换b和a之后，再拿c和处在第一位置的a进行交换，
     * 得到cba。我们再次固定第一个字符c，求后面两个字符b、a的排列。这样写成递归程序如下：
     *
     * @param ss
     * @param i
     */
    public static void permutation(char[] ss, int i) {
        if (ss == null || i < 0 || i > ss.length) {
            return;
        }
        if (i == ss.length) {
            System.out.println(new String(ss));
        } else {
            for (int j = i; j < ss.length; j++) {
                char temp = ss[j];//交换前缀,使之产生下一个前缀
                ss[j] = ss[i];
                ss[i] = temp;
                permutation(ss, i + 1);
                temp = ss[j]; //将前缀换回来,继续做上一个的前缀排列.
                ss[j] = ss[i];
                ss[i] = temp;
            }
        }
    }

//    public static void main(String args[]) {
//        char[] ss = {'a', 'c', 'b', 'd'};
//        permutation(ss, 0);
//    }



    /**
     *
     */

    public static void combiantion(char chs[]) {
        if (chs == null || chs.length == 0) {
            return;
        }
        List<Character> list = new ArrayList();
        for (int i = 1; i <= chs.length; i++) {
            combine(chs, 0, i, list);
        }
    }

    //从字符数组中第begin个字符开始挑选number个字符加入list中
    public static void combine(char[] cs, int begin, int number, List<Character> list) {
        if (number == 0) {
            System.out.println(list.toString());
            return;
        }
        if (begin == cs.length) {
            return;
        }
        list.add(cs[begin]);
        combine(cs, begin + 1, number - 1, list);
        list.remove((Character) cs[begin]);
        combine(cs, begin + 1, number, list);
    }

    public static void main(String args[]) {
        char chs[] = {'a', 'b', 'c'};
        combiantion(chs);
    }

}
