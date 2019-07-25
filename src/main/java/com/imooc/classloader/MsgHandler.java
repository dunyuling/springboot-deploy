package com.imooc.classloader;

/**
 * @ClassName MsgHandler
 * @Description 后台启动一条线程, 不断刷新重新加载实现了热加载的类
 * @Author liux
 * @Date 19-7-26 上午12:45
 * @Version 1.0
 */
public class MsgHandler implements Runnable {
    @Override
    public void run() {
        while (true) {
            BaseManager manager = ManagerFactory.getManager(ManagerFactory.MY_MANAGER);
            manager.logic();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
