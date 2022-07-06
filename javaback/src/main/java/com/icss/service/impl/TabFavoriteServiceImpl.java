package com.icss.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.icss.bean.TabFavorite;
import com.icss.bean.TabRoute;
import com.icss.mapper.TabFavoriteMapper;
import com.icss.mapper.TabRouteMapper;
import com.icss.service.TabFavoriteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class TabFavoriteServiceImpl implements TabFavoriteService {

    @Resource
    private TabFavoriteMapper tabFavoriteMapper;
    @Resource
    private TabRouteMapper tabRouteMapper;

    @Override
    public int deleteByPrimaryKey(Integer rid, Integer uid) {
        return tabFavoriteMapper.deleteByPrimaryKey(rid, uid);
    }

    @Override
    public int insert(TabFavorite record) {
        return tabFavoriteMapper.insert(record);
    }

    @Override
    public int insertSelective(TabFavorite record) {
        return tabFavoriteMapper.insertSelective(record);
    }

    @Override
    public TabFavorite selectByPrimaryKey(Integer rid, Integer uid) {
        return tabFavoriteMapper.selectByPrimaryKey(rid, uid);
    }

    @Override
    public int updateByPrimaryKeySelective(TabFavorite record) {
        return tabFavoriteMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TabFavorite record) {
        return tabFavoriteMapper.updateByPrimaryKey(record);
    }

    /**
     * 取消收藏的，同时修改收藏的count
     *
     * @param rid    收藏的
     * @param uid
     * @param rcount 次数
     * @return
     */
    @Override
    public int deleteForUser(Integer rid, Integer uid, Integer rcount) {
        TabRoute route = new TabRoute();
        route.setRid(rid);
        route.setCount(rcount - 1);
        int i = tabRouteMapper.updateByPrimaryKeySelective(route);
        //删除收藏表内的数据
        i += tabFavoriteMapper.deleteByPrimaryKey(rid, uid);
        return i;
    }

    /**
     * @param rid
     * @param uid
     * @param rcount
     * @return
     */
    @Override
    public int insertForUser(Integer rid, Integer uid, Integer rcount) {

        TabFavorite favorite = new TabFavorite(rid, uid, new Date());
        System.out.println("新增收藏" + favorite);
        TabRoute route = new TabRoute();
        route.setRid(rid);
        route.setCount(rcount + 1);
        int i = tabRouteMapper.updateByPrimaryKeySelective(route);
        //新增收藏表内数据
        i += tabFavoriteMapper.insert(favorite);

        System.out.println(i);
        return i;
    }

    /**
     * 我的收藏 返回收藏到的线路的信息
     *
     * @param uid
     * @return
     */
    @Override
    public PageInfo myfavorite(Integer uid ,Integer page) {

        Integer[] rids = tabFavoriteMapper.myfavorite(uid);
        PageHelper.startPage(page, 12);
        PageInfo pageInfo = new PageInfo(tabRouteMapper.getAllByRids(rids), 10);
        return pageInfo;
    }
}
