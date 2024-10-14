package com.test.spring;

public class UserService {

    public User getUser(Long id) {
        User user = new User();
        user.setId(1L);
        user.setAge(18);
        user.setName("李四");
        return user;
    }
}
