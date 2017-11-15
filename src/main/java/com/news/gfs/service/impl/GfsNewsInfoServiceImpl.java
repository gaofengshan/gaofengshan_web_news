package com.news.gfs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.news.gfs.dao.GfsNewsInfoDao;
import com.news.gfs.pojo.GfsNewsInfo;
import com.news.gfs.service.GfsNewsInfoService;
import com.news.gfs.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GfsNewsInfoServiceImpl implements GfsNewsInfoService{
    @Autowired
    private GfsNewsInfoDao gfsNewsInfoDao;

    @Override
    public GfsNewsInfo selectById(Integer id) {
        GfsNewsInfo gfsNewsInfo = gfsNewsInfoDao.selectById(id);
        return gfsNewsInfo;
    }

    @Override
    public void addNewsInfo(GfsNewsInfo gfsNewsInfo) { gfsNewsInfoDao.addNewsInfo(gfsNewsInfo);
    }

    @Override
    public PageInfo<GfsNewsInfo> getInfoList(GfsNewsInfo gfsNewsInfo, Integer pageNo) {
        PageHelper.startPage(pageNo, Constants.DIARY_PAGE_SIZE, "id desc");
        List<GfsNewsInfo> infoList = gfsNewsInfoDao.getInfoList(gfsNewsInfo);
        PageInfo<GfsNewsInfo> page = new PageInfo<>(infoList,3);
        return page;
    }

    @Override
    public GfsNewsInfo getInfoById(Integer id) {
        GfsNewsInfo gfsNewsInfo = gfsNewsInfoDao.getInfoById(id);
        return gfsNewsInfo;
    }

    @Override
    public void deleteInfo(Integer id) {
        gfsNewsInfoDao.deleteInfo(id);
    }
}
