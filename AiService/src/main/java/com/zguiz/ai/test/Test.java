package com.zguiz.ai.test;

import org.springframework.util.ReflectionUtils;

public class Test {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();

        ReflectionUtils.doWithLocalMethods(myClass.getClass(), method -> {
            System.out.println("Method name: " + method.getName());
        });
    }

    static class MyClass {
        public void method1() {System.out.println("this is method1");}
        public void method2() {System.out.println("this is method2");}
        public void method3() {System.out.println("this is method3");}
    }

}
