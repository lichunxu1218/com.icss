package com.icss.service;

import com.icss.bean.TabSeller;
public interface TabSellerService{


    int deleteByPrimaryKey(Integer sid);

    int insert(TabSeller record);

    int insertSelective(TabSeller record);

    TabSeller selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(TabSeller record);

    int updateByPrimaryKey(TabSeller record);

}
