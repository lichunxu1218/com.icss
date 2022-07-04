package com.icss.controller;

import com.icss.bean.TabCategory;
import com.icss.util.ResResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TabCategoryController {
    @RequestMapping("/")
    public ResResult<TabCategory> getlist() {
        return null;
    }

}
