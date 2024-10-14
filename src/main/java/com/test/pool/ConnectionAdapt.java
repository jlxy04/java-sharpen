package com.test.pool;

import org.apache.commons.pool2.impl.GenericObjectPool;

import java.io.Closeable;
import java.io.IOException;

public class ConnectionAdapt implements Closeable {

    private Connection connection;

    private GenericObjectPool genericObjectPool;

    @Override
    public void close() throws IOException {
        genericObjectPool.returnObject(this);
    }
}
