package com.news.gfs.service;

import com.news.gfs.pojo.GfsNewsUser;

public interface GfsNewsUserService {
    void doRegist(GfsNewsUser gfsNewsUser);

    GfsNewsUser getUserByName(String name);

    GfsNewsUser doLogin(String name, String password) throws Exception;

    void changeUser(GfsNewsUser gfsNewsUser);

    GfsNewsUser getUserById(Integer id);
}
