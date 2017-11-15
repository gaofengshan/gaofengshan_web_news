package com.news.gfs.service;

import com.github.pagehelper.PageInfo;
import com.news.gfs.pojo.GfsNewsCategory;

import java.util.List;

public interface GfsNewsCategoryService {
    GfsNewsCategory getTypeByName(String typeName);

    void doadd(GfsNewsCategory gfsNewsCategory);

    PageInfo<GfsNewsCategory> gettypeList(Integer pageNo);

    GfsNewsCategory selectById(Integer id);

    void updateTypeInfo(GfsNewsCategory gfsNewsCategory);

    void deleteType(Integer id);

    List<GfsNewsCategory> getAllType();
}
