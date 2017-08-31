package org.sprintdragon.opensource.javaagent;

/**
 * 启动参数  -javaagent:/home/wangdi/IdeaWorkspace/psiitoy/accumulate/03-opensource/javaagent/target/javaagent-1.0-SNAPSHOT.jar
 * Created by wangdi on 17-8-24.
 */
public class Main {

    public static void main(String[] args) {
        Foo foo = new Foo();
        System.out.println(foo.toString());
    }

}
