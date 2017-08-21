package org.sprintdragon.opensource.jpa.view;

import java.util.Scanner;

/**
 * Created by wangdi on 16-9-8.
 */
public class ViewTest1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int num[] = new int[2 * n];
            int i = 0;
            while (i < n) {
                num[i] = sc.nextInt();
                i++;
            }
            for (i = n; i < 2 * n; i++) {
                num[i] = num[i - n];
            }
            int count = n;
            for (i = 0; i < n; i++) {
                int first = num[i];
                int second = num[i + 1];
                if (first >= second) {
                    for (int j = i + 2; j <= i + n - 2; j++) {
                        int third = num[j];
                        if (second <= third) {
                            count++;
                            second = third;
                        }
                    }
                }
            }
            System.out.println(count);

        }
    }

}
