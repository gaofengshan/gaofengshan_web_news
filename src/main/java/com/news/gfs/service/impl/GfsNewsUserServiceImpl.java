package com.news.gfs.service.impl;

import com.news.gfs.dao.GfsNewsUserDao;
import com.news.gfs.pojo.GfsNewsUser;
import com.news.gfs.service.GfsNewsUserService;
import com.news.gfs.util.Constants;
import com.news.gfs.util.Funcs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GfsNewsUserServiceImpl  implements GfsNewsUserService{
    @Autowired
    GfsNewsUserDao gfsNewsUserDao;
    @Override
    public void doRegist(GfsNewsUser gfsNewsUser) {
        String password = gfsNewsUser.getPassword() + Constants.PASSWORD_SALT_KEY;
        gfsNewsUser.setPassword(Funcs.MD5(password));
        gfsNewsUserDao.addUser(gfsNewsUser);
    }

    @Override
    public GfsNewsUser getUserByName(String name) {
        GfsNewsUser gfsNewsUser = gfsNewsUserDao.getUserByName(name);
        return gfsNewsUser;
    }

    @Override
    public GfsNewsUser doLogin(String name, String password) throws Exception{
        GfsNewsUser gfsNewsUser = gfsNewsUserDao.getUserByName(name);
        if (gfsNewsUser != null && Funcs.MD5(password + Constants.PASSWORD_SALT_KEY).equals(gfsNewsUser.getPassword())) {
            return gfsNewsUser;
        }
        return null;
    }

    @Override
    public void changeUser(GfsNewsUser gfsNewsUser) {
        gfsNewsUserDao.updateUserInfo(gfsNewsUser);
    }

    @Override
    public GfsNewsUser getUserById(Integer id) {
        GfsNewsUser gfsNewsUser = gfsNewsUserDao.getUserById(id);
        return gfsNewsUser;
    }
}
