package com.icss.service;

import com.icss.bean.TabSeller;

import java.util.List;

public interface TabSellerService{


    int deleteByPrimaryKey(Integer sid);

    int insert(TabSeller record);

    int insertSelective(TabSeller record);

    TabSeller selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(TabSeller record);

    int updateByPrimaryKey(TabSeller record);

    List<TabSeller> selectSellerBySid(int sid);

}
