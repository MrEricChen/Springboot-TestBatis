package com.batis.controller;

import com.batis.pojo.BaseJsonResult;
import com.batis.pojo.TUser;
import com.batis.service.UserService;
import com.github.pagehelper.util.StringUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("user")
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/login")
    public BaseJsonResult userLogin(String username, String password) {
        BaseJsonResult result = null;
        TUser tUser = userService.queryUserByCustom(username);
        if (tUser != null) {
            if (tUser.getPassword().equals(password)) {
                result = BaseJsonResult.ok("登录成功");
            } else {
                result = BaseJsonResult.errorMsg("账户名或密码有误,请检查重新输入");
            }
        } else {
            result = BaseJsonResult.errorMsg("此用户不存在,请先注册用户");
        }
        return result;
    }
}
