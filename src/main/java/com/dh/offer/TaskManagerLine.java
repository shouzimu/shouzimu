package com.dh.offer;


import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 任务管理器画波浪线
 */
public class TaskManagerLine {


    public static void main(String[] args) {

        Unsafe U = null;
        try {
            Class<?> clazz = Unsafe.class;
            Field f = clazz.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            U = (Unsafe) f.get(clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }

        while (true) {
            //内层循环500ms执行 500ms休眠
            long now = System.currentTimeMillis();
            while (System.currentTimeMillis() < now + 2000) {
                System.out.println(System.currentTimeMillis());
            }
            try {
                U.park(false, 1000000 * 1000);
                System.out.println("---------------------");
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }
}
