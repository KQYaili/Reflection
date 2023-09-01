package com.lgd;

import org.junit.Test;

import java.lang.reflect.*;

public class ReflectionDemo {
    @Test
    public void test4() {
        Dog dog=new Dog("wang",3,"白色");
        Class<Dog> dogClass=Dog.class;
        Field[] fields = dogClass.getFields();
        System.out.println(fields.length);
        Field[] declaredFields = dogClass.getDeclaredFields();
        System.out.println(declaredFields.length);
        for (int i = 0; i < declaredFields.length; i++) {
            System.out.println(Modifier.toString(declaredFields[i].getModifiers())+" "+declaredFields[i].getName());
        }
        Package aPackage = dogClass.getPackage();
        System.out.println(aPackage.getName());
        Method[] methods = dogClass.getMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i]);
            if(methods[i].getName().equals("toString")){
                try {
                    String s = (String) methods[i].invoke(dog);
                    System.out.println(s);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        Method[] declaredMethods = dogClass.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            System.out.println(declaredMethods[i]);
            if(declaredMethods[i].getName().equals("get")){
                declaredMethods[i].setAccessible(true);
                try {
                    String invoke = (String) declaredMethods[i].invoke(dog);
                    System.out.println(invoke);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    @Test
    public void test3() {
        Class<Dog> dogClass=Dog.class;
        Constructor<?>[] constructors = dogClass.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            System.out.println(constructors[i].getName());
            System.out.println(constructors[i].getParameterCount());
        }
        try {
            Constructor<Dog> constructor = dogClass.getConstructor(String.class, int.class, String.class);
            Dog dog = constructor.newInstance("小白", 5, "白");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test1(){
        Dog dog=new Dog("wnag",1,"白");
        Class aClass = dog.getClass();
        Class<Dog> dogClass = Dog.class;
        try {
            Class<?> aClass1 = Class.forName("com.lgd.Dog");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test2() {
        Class<Dog> dogClass = Dog.class;
        try {
            Dog dog = (Dog) dogClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
