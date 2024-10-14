package com.test.pool;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class Test {

    public static void main(String[] args) throws Exception {
       GenericObjectPoolConfig<Connection> config = new GenericObjectPoolConfig<>();
       config.setMinIdle(2);
       ConnectionFactory connectionFactory = new ConnectionFactory();

       GenericObjectPool<Connection> pool = new GenericObjectPool<Connection>(connectionFactory, config);

        for (int i = 0; i < 100; i++) {
            Connection connection = pool.borrowObject();
//            pool.returnObject(connection);
            System.out.println("第" + i + "次，" + connection.getId());
        }

        System.out.println("MaxIdle：" + pool.getMaxIdle());

        System.out.println("MinIdle：" + pool.getMinIdle());

        System.out.println("MaxTotal：" + pool.getMaxTotal());

        System.out.println("FactoryType：" + pool.getFactoryType());

        System.out.println("BorrowedCount：" + pool.getBorrowedCount());
    }
}
