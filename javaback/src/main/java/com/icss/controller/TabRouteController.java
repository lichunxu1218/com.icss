package com.icss.controller;

import com.github.pagehelper.PageInfo;
import com.icss.service.TabRouteService;
import com.icss.util.ResResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 导航栏内容控制层
 */
@RestController
@RequestMapping("/route")
public class TabRouteController {
    @Autowired
    private TabRouteService tabRouteService;
    //查询所有
    @RequestMapping("/select")
    public ResResult<PageInfo> getAll(int cid, int page,String value) {
        PageInfo pageInfo = tabRouteService.selectByCidAndValue(cid,page,value);
        ResResult rr = null;
        if (pageInfo.getSize() != 0) {
            rr = new ResResult(1, "ok", pageInfo);
        } else {
            rr = new ResResult(0, "erro");
        }
        return rr;
    }

}
