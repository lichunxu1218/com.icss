package com.icss.controller;

import com.github.pagehelper.PageInfo;
import com.icss.bean.TabRoute;
import com.icss.bean.vo.TabRouteVo;
import com.icss.service.TabRouteService;
import com.icss.util.ResResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 页面控制层（显示页面数据）
 */
@RestController
@RequestMapping("/route")
public class TabRouteController {
    @Autowired
    private TabRouteService tabRouteService;

    //查询所有信息，含模糊查询
    @RequestMapping("/select")
    public ResResult<PageInfo> getAll(int cid, int page, String value) {
        PageInfo pageInfo = tabRouteService.selectByCidAndValue(cid, page, value);
        ResResult rr = null;
        if (pageInfo.getSize() != 0) {
            rr = new ResResult(1, "ok", pageInfo);
        } else {
            rr = new ResResult(0, "erro");
        }
        return rr;
    }

    /**
     * 查询详细内容
     * @param rid
     * @return 数据
     */
    @RequestMapping("/detail")
    public ResResult<TabRouteVo> getRouteByrid(int rid) {

       TabRouteVo tabRouteVo = tabRouteService.selectByPrimaryKey(rid);
        ResResult rr = null;
        if (tabRouteVo != null) {
            rr = new ResResult(1, "ok", tabRouteVo);
        } else {
            rr = new ResResult(0, "erro");
        }
        return rr;
    }
}
