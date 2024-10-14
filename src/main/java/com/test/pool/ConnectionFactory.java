package com.test.pool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.DestroyMode;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class ConnectionFactory extends BasePooledObjectFactory<Connection> {
    @Override
    public Connection create() throws Exception {
        return new Connection();
    }

    @Override
    public PooledObject<Connection> wrap(Connection connection) {
        return new DefaultPooledObject<>(connection);
    }

    @Override
    public void destroyObject(PooledObject<Connection> p, DestroyMode destroyMode) throws Exception {
        super.destroyObject(p, destroyMode);
    }
}
