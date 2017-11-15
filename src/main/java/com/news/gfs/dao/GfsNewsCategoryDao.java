package com.news.gfs.dao;

import com.news.gfs.pojo.GfsNewsCategory;

import java.util.List;

public interface GfsNewsCategoryDao {
    GfsNewsCategory getTypeByName(String typeName);

    void addType(GfsNewsCategory gfsNewsCategory);

    List<GfsNewsCategory> getTypeAll();

    GfsNewsCategory getTypeById(Integer id);

    void updateTypeInfo(GfsNewsCategory gfsNewsCategory);

    void deleteTypeById(Integer id);

    List<GfsNewsCategory> getAllType();
}
