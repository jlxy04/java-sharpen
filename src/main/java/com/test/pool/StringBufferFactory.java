package com.test.pool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class StringBufferFactory extends BasePooledObjectFactory<StringBuffer> {

    @Override
    public StringBuffer create() throws Exception {
        return new StringBuffer();
    }

    @Override
    public PooledObject<StringBuffer> wrap(StringBuffer buffer) {
        return new DefaultPooledObject<>(buffer);
    }

    /**
     * 使用完返还对象时将 StringBuffer 清空
     * @param p
     * @throws Exception
     */
    @Override
    public void passivateObject(PooledObject<StringBuffer> p) throws Exception {
        p.getObject().setLength(0);
    }
}
