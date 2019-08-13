package com.lh.mapper;

import com.lh.bz.UserBz;
import com.lh.po.UserEx;

import java.util.List;

public interface UserMapper {

    public List<UserEx> queryUserByZH(UserBz userBz) throws Exception;
}
