package com.test.pool;

public class Connection {

    private String id;

    private String code;

    public String getId() {
        return id;
    }

    public Connection setId(String id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Connection setCode(String code) {
        this.code = code;
        return this;
    }
}
