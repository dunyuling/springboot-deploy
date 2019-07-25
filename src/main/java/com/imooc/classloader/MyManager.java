package com.imooc.classloader;

/**
 * @ClassName MyManager
 * @Description BaseManager 子类, 此类需要实现java类的热加载功能
 * @Author liux
 * @Date 19-7-26 上午12:13
 * @Version 1.0
 */
public class MyManager implements BaseManager {

    private String name = "myManager";

    @Override
    public void logic() {
        System.out.println("=====看我实现了热加载");
        System.out.println("-----确实实现了热加载111");
        System.out.println("--------------");
    }
}
