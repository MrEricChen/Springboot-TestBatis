package com.batis.service;

import com.batis.mapper.TUserMapper;
import com.batis.pojo.TUser;
import com.batis.service.impl.IUserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public void saveUser(TUser user) throws Exception {
        tUserMapper.insert(user);
    }

    @Override
    public void updateUser(TUser user) {

    }

    @Override
    public TUser queryUserById(String userId) {
        TUser tUser = tUserMapper.selectByPrimaryKey(userId);
        return tUser;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteUser(String userId) {
        
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<TUser> queryUsers() {
        return tUserMapper.selectAll();
    }

    @Override
    public List<TUser> queryUserListPaged(TUser user, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        Example example = new Example(TUser.class);
        example.createCriteria();

        List<TUser> users = tUserMapper.selectByExample(example);
        return users;
    }

    @Override
    public TUser queryUserByCustom(String userName) {
//        TUser tUser = tUserMapper.queryUserByName(userName);
        return null;
    }

    @Override
    public void saveUserTransactional(TUser user) {

    }
}
