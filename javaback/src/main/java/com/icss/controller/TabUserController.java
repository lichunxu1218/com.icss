package com.icss.controller;

import com.icss.bean.TabUser;
import com.icss.service.TabUserService;
import com.icss.util.ResResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TabUserController {

    @Autowired
    private TabUserService tabUserService;

    /**
     * 用户登陆时判断用户名是否存在
     *
     * @param username
     * @return 存在返回0 erro，不存在返回1 ok
     */
    @RequestMapping("/getUserByUserName")
    public ResResult getUserByUserName(String username) {
//        System.out.println(username);
        TabUser user = tabUserService.selectByUserName(username);
        ResResult rr = null;
        if (user == null) {
            rr = new ResResult(1, "ok");
        } else {
            rr = new ResResult(0, "erro");
        }
        return rr;
    }

    /**
     * 用户注册功能
     *
     * @param user
     * @return 注册结果成功1 失败0
     */
    @RequestMapping("/registerUser")
    public ResResult registerUser(TabUser user) {
        // System.out.println(user); 登陆信息传入成功
        int i = tabUserService.insert(user);
        ResResult rr = null;
        if (i > 0) {
            rr = new ResResult(1, "ok");
        } else {
            rr = new ResResult(0, "erro");
        }
        return rr;
    }

    /**
     * 用户登陆功能
     *
     * @param user
     * @return 登陆结果成功1 失败0
     */
    @RequestMapping("/loginUser")
    public ResResult loginUser(TabUser user) {
        System.out.println(user);
        TabUser tabUser = tabUserService.loginUser(user);
        ResResult rr = null;
        if (tabUser != null) {
            rr = new ResResult(1, "ok", tabUser);
        } else {
            rr = new ResResult(0, "erro");
        }
        return rr;
    }

    /**
     * 退出登陆功能
     *
     * @return 退出结果成功1 失败0
     */
    @RequestMapping("/exitLogin")
    public ResResult exit() {

        ResResult rr = new ResResult(1, "ok");

        return rr;
    }
}
