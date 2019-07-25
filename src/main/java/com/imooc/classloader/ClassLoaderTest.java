package com.imooc.classloader;

/**
 * @ClassName ClassLoaderTest
 * @Description 测试java类的热加载
 * @Author liux
 * @Date 19-7-26 上午12:48
 * @Version 1.0
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        new Thread(new MsgHandler()).start();
    }
}
