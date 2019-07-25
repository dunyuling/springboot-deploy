package com.imooc.classloader;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ManagerFactory
 * @Description 加载manager的工厂
 * @Author liux
 * @Date 19-7-26 上午12:21
 * @Version 1.0
 */
public class ManagerFactory {

    //记录热加载类的加载信息
    private static final Map<String, LoadInfo> loadTimeMap = new HashMap<>();

    //要加载的类的classpath
    public static final String CLASS_PATH = "/home/liux/下载/IdeaProjects/springboot_hotdeploy/target/classes/";

    //实现热加载的类的全名称(包名+类名)
    public static final String MY_MANAGER = "com.imooc.classloader.MyManager";

    public static BaseManager getManager(String className) {
        File loadFile
                = new File(CLASS_PATH + className.replaceAll("\\.", "/") + ".class");
        long lastModified = loadFile.lastModified();

        //loadTimeMap不包含className为key的LoadInfo信息.证明这个类没有被加载,那么需要加载这个类到JVM
        if (loadTimeMap.get(className) == null) {
            load(className, lastModified);

        } //加载类的时间戳变化了,同样需要重新加载这个类到JVM
        else if (loadTimeMap.get(className).getLoadTime() != lastModified) {
            load(className, lastModified);
        }
        return loadTimeMap.get(className).getBaseManager();
    }

    private static void load(String className, long lastModified) {

        MyClassLoader myClassLoader = new MyClassLoader(CLASS_PATH);
        Class<?> loadClass = null;
        try {
            loadClass = myClassLoader.loadClass(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        BaseManager manager = newInstance(loadClass);
        LoadInfo loadInfo = new LoadInfo(myClassLoader, lastModified);
        loadInfo.setBaseManager(manager);

        loadTimeMap.put(className, loadInfo);
    }

    /*
     * @Author liux
     * @Description 以反射的方式创建BaseManager 子类对象
     * @Date 19-7-26 上午12:39
     * @param loadClass
     * @return com.imooc.classloader.BaseManager
     **/
    private static BaseManager newInstance(Class<?> loadClass) {
        try {
            return (BaseManager) loadClass.getConstructor(new Class[]{}).newInstance(new Object[]{});
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
