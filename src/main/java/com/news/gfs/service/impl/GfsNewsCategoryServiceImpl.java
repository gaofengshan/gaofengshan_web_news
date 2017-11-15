package com.news.gfs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.news.gfs.dao.GfsNewsCategoryDao;
import com.news.gfs.pojo.GfsNewsCategory;
import com.news.gfs.service.GfsNewsCategoryService;
import com.news.gfs.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GfsNewsCategoryServiceImpl implements GfsNewsCategoryService{
    @Autowired
    GfsNewsCategoryDao gfsNewsCategoryDao;
    @Override
    public GfsNewsCategory getTypeByName(String typeName) {
        GfsNewsCategory gfsNewsCategory = gfsNewsCategoryDao.getTypeByName(typeName);
        return gfsNewsCategory;
    }

    @Override
    public void doadd(GfsNewsCategory gfsNewsCategory) {
        gfsNewsCategoryDao.addType(gfsNewsCategory);
    }

    @Override
    public PageInfo<GfsNewsCategory> gettypeList(Integer pageNo) {
        PageHelper.startPage(pageNo, Constants.DIARY_PAGE_SIZE, "id asc");
        List<GfsNewsCategory> typeList = gfsNewsCategoryDao.getTypeAll();
        PageInfo<GfsNewsCategory> page = new PageInfo<>(typeList,4);
        return page;
    }

    @Override
    public GfsNewsCategory selectById(Integer id) {
        GfsNewsCategory gfsNewsCategory = gfsNewsCategoryDao.getTypeById(id);
        return gfsNewsCategory;
    }

    @Override
    public void updateTypeInfo(GfsNewsCategory gfsNewsCategory) {
        gfsNewsCategoryDao.updateTypeInfo(gfsNewsCategory);
    }

    @Override
    public void deleteType(Integer id) {
        gfsNewsCategoryDao.deleteTypeById(id);
    }

    @Override
    public List<GfsNewsCategory> getAllType() {
        List<GfsNewsCategory> gfsNewsCategories = gfsNewsCategoryDao.getAllType();
        return gfsNewsCategories;
    }
}
