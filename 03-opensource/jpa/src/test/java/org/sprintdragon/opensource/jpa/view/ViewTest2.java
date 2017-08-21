package org.sprintdragon.opensource.jpa.view;

/**
 * Created by wangdi on 16-9-8.
 */
public class ViewTest2 {

    private int a=10;
    int b=20;
    static int c=1;
    public static void main(String arg[])
    {
        ViewTest2 t = new ViewTest2();
        int x = t.b;
        x = t.a;
    }
}

class Test {
    private int data;
    int result = 0;

    public void m() {
        result += 2;
        data += 2;
        System.out.println(result + "  " + data);
    }
}

class ThreadExample extends Thread {
    private Test mv;

    public ThreadExample(Test mv) {
        this.mv = mv;
    }

    public void run() {
        synchronized (mv) {
            mv.m();
        }
    }
}