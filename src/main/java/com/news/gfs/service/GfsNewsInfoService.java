package com.news.gfs.service;

import com.github.pagehelper.PageInfo;
import com.news.gfs.pojo.GfsNewsInfo;

public interface GfsNewsInfoService {
    GfsNewsInfo selectById(Integer id);

    void addNewsInfo(GfsNewsInfo newsInfo);

    PageInfo<GfsNewsInfo> getInfoList(GfsNewsInfo gfsNewsInfo, Integer pageNo);

    GfsNewsInfo getInfoById(Integer id);

    void deleteInfo(Integer id);
}
