package com.imooc.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @ClassName MyClassLoader
 * @Description 自定义java类加载器, 来实现java类的热加载
 * @Author liux
 * @Date 19-7-26 上午12:01
 * @Version 1.0
 */
public class MyClassLoader extends ClassLoader {

    //要加载的java类的classpath路径
    private String classpath;

    public MyClassLoader(String classpath) {
        super(ClassLoader.getSystemClassLoader());
        this.classpath = classpath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = this.loadClassData(name);

        return this.defineClass(name, data, 0, data.length);
    }

    /*
     * @Author liux
     * @Description 加载class文件中的内容
     * @Date 19-7-26 上午12:07
     * @param name
     * @return byte[]
     **/
    private byte[] loadClassData(String name) {
        try {
            name = name.replace(".", File.separator);
            System.out.println("name: " + name);
            FileInputStream fis = new FileInputStream(new File(classpath + name + ".class"));

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = 0;
            byte[] buff = new byte[1024];

            while ((b = fis.read(buff)) != -1) {
                baos.write(buff, 0, b);
            }
            fis.close();
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
