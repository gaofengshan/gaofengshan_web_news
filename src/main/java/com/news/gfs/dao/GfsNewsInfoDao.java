package com.news.gfs.dao;

import com.news.gfs.pojo.GfsNewsInfo;

import java.util.List;

public interface GfsNewsInfoDao {
    void addNewsInfo(GfsNewsInfo gfsNewsInfo);

    GfsNewsInfo selectById(Integer id);

    List<GfsNewsInfo> getInfoList(GfsNewsInfo gfsNewsInfo);

    GfsNewsInfo getInfoById(Integer id);

    void deleteInfo(Integer id);
}
