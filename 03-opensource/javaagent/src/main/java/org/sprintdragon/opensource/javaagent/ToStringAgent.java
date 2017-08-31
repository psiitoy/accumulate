package org.sprintdragon.opensource.javaagent;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType.Builder;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

/**
 * Created by wangdi on 17-8-24.
 */
public class ToStringAgent {

    public static void premain(String args, Instrumentation instrumentation) {
        System.out.println("print pre main");
        new AgentBuilder.Default()
                .type(ElementMatchers.isAnnotatedWith(ToString.class))
                .transform(new AgentBuilder.Transformer() {

                    @Override
                    public Builder<?> transform(Builder<?> builder, TypeDescription typeDescription) {
                        return builder.method(ElementMatchers.named("toString"))
                                .intercept(FixedValue.value("test"));
                    }
                }).installOn(instrumentation);
    }

}
