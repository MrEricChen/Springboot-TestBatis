package com.batis.service.impl;


import com.batis.pojo.TUser;

import java.util.List;

public interface IUserService {
    public void saveUser(TUser user) throws Exception;

    public void updateUser(TUser user);

    public TUser queryUserById(String userId);

    public void deleteUser(String userId);

    public List<TUser> queryUsers();

    public List<TUser> queryUserListPaged(TUser user, Integer page, Integer pageSize);

    public TUser queryUserByCustom(String name);

    public void saveUserTransactional(TUser user);
}
