package com.batis.controller;

import com.batis.pojo.BaseJsonResult;
import com.batis.pojo.TUser;
import com.batis.service.impl.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("userinfo")
@Api(tags = {"用戶信息"})
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping(value = "/getUsers")
    public BaseJsonResult getAllUsers() {
        return BaseJsonResult.ok(userService.queryUsers());
    }

    @GetMapping(value = "/userByName")
    public BaseJsonResult getUserByName(String name) {
        TUser tUser = userService.queryUserByCustom(name);
        return BaseJsonResult.ok(tUser);
    }

    @GetMapping(value = "/usersPage")
    public BaseJsonResult getUserByPage(Integer page, Integer pageSize) {
        if (page == 0) {
            page = 1;
        }
        if (pageSize == 0){
            pageSize = 1;
        }
        TUser user = new TUser();
        List<TUser> tUsers = userService.queryUserListPaged(user, page, pageSize);
        return BaseJsonResult.ok(tUsers);
    }

    @PostMapping(value = "/saveUser")
    public BaseJsonResult addUser(@RequestParam("age") Integer age,
                                  @RequestParam("name") String name,
                                  @RequestParam("password") String password,
                                  @RequestParam("phone") String phone,
                                  @RequestParam("sex") String sex,
                                  @RequestParam("constellation") String constellation) {
        TUser tUser = new TUser();
        tUser.setId("7dyfvi7d8vudvdvkudvyduu7y3e273");
        tUser.setAge(age);
        tUser.setName(name);
        tUser.setPassword(password);
        tUser.setPhone(phone);
        tUser.setSex(sex);
        tUser.setConstellation(constellation);
        try {
            userService.saveUser(tUser);
        } catch (Exception e) {
            e.printStackTrace();
            return BaseJsonResult.errorMsg(e.getMessage().toUpperCase());
        }
        return BaseJsonResult.ok("添加成功");
    }


    @ApiImplicitParams({@ApiImplicitParam(name = "token", paramType = "header", required = true),
                        @ApiImplicitParam(name = "userId", paramType = "path", required = true)})
    @DeleteMapping(value = "/deleteUser/{userId}")
    public BaseJsonResult deleteUser(@RequestHeader String token,
                                     @PathVariable("userId") String userId) {
        userService.deleteUser(userId);
        return BaseJsonResult.ok("删除成功");
    }


}
