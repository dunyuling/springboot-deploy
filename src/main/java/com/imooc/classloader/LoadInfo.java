package com.imooc.classloader;

/**
 * @ClassName LoadInfo
 * @Description 封装加载类的信息
 * @Author liux
 * @Date 19-7-26 上午12:15
 * @Version 1.0
 */
public class LoadInfo {

    //自定义类加载器
    private MyClassLoader myLoader;

    //记录要加载的类的时间戳: 加载的时间
    private long loadTime;

    private BaseManager baseManager;

    public LoadInfo(MyClassLoader myLoader, long loadTime) {
        this.myLoader = myLoader;
        this.loadTime = loadTime;
    }

    public MyClassLoader getMyLoader() {
        return myLoader;
    }

    public void setMyLoader(MyClassLoader myLoader) {
        this.myLoader = myLoader;
    }

    public long getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(long loadTime) {
        this.loadTime = loadTime;
    }

    public BaseManager getBaseManager() {
        return baseManager;
    }

    public void setBaseManager(BaseManager baseManager) {
        this.baseManager = baseManager;
    }
}