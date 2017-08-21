package org.sprintdragon.algorithm.tiku50;

/**
 * Created by wangdi on 17-4-24.
 */
public class T10ZiYouLuoTi {

    public static void main(String[] args) {
        double dist = 0;
        double hi = 100;
        for (int i = 0; i < 10; i++) {
            dist += hi;
            hi = hi * 0.5;
            dist += hi;
        }
        System.out.println(dist + "," + hi);
    }

}
