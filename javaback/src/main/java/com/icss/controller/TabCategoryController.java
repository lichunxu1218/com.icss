package com.icss.controller;

import com.icss.bean.TabCategory;
import com.icss.service.TabCategoryService;
import com.icss.util.ResResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 导航栏控制层
 */
@RestController
@RequestMapping("/category")
public class TabCategoryController {
    @Autowired
    private TabCategoryService tabCategoryService;

    @RequestMapping("/getAll")
    public ResResult<TabCategory> getAll() {
        List<TabCategory> list = tabCategoryService.getAll();
        list.forEach(x-> System.out.println(x));
        ResResult rr = null;
        if (list != null) {
            rr = new ResResult(1, "ok", list);
        } else {
            rr = new ResResult(0, "erro");
        }
        return rr;
    }

}
