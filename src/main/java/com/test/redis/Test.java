package com.test.redis;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

public class Test {

    @Autowired
    RedissonClient redisson;

    public String hello(){
        // 1、获取一把锁，只要锁的名字一样，既是同一把锁
        RLock lock = redisson.getLock ("my-lock");

        // 2、加锁
        lock.lock ();// 阻塞式等待

        try {
            System.out.println ("加锁成功，执行业务..."+Thread.currentThread ().getId () );
            // 模拟超长等待
            Thread.sleep (20000);
        } catch (Exception e) {
            e.printStackTrace ( );
        }finally {
            // 3、解锁
            System.out.println ("释放锁..."+Thread.currentThread ().getId () );
            lock.unlock ();
        }
        return "hello";
    }
}
