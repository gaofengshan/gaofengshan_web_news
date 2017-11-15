package com.news.gfs.dao;

import com.news.gfs.pojo.GfsNewsUser;

public interface GfsNewsUserDao {
    void addUser(GfsNewsUser gfsNewsUser);

    GfsNewsUser getUserByName(String name);

    void updateUserInfo(GfsNewsUser gfsNewsUser);

    GfsNewsUser getUserById(Integer id);
}
