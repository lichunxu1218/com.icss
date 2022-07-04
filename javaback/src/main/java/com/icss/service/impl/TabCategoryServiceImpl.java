package com.icss.service.impl;

import com.icss.bean.TabCategory;
import com.icss.mapper.TabCategoryMapper;
import com.icss.service.TabCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TabCategoryServiceImpl implements TabCategoryService{

    @Resource
    private TabCategoryMapper tabCategoryMapper;

    @Override
    public int deleteByPrimaryKey(Integer cid) {
        return tabCategoryMapper.deleteByPrimaryKey(cid);
    }

    @Override
    public int insert(TabCategory record) {
        return tabCategoryMapper.insert(record);
    }

    @Override
    public int insertSelective(TabCategory record) {
        return tabCategoryMapper.insertSelective(record);
    }

    @Override
    public TabCategory selectByPrimaryKey(Integer cid) {
        return tabCategoryMapper.selectByPrimaryKey(cid);
    }

    @Override
    public int updateByPrimaryKeySelective(TabCategory record) {
        return tabCategoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TabCategory record) {
        return tabCategoryMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<TabCategory> getAll() {
        return tabCategoryMapper.getAll();
    }

}
