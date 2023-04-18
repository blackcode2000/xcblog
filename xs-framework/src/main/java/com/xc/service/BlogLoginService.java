package com.xc.service;

import com.xc.domain.ResponseResult;
import com.xc.domain.entity.User;

public interface BlogLoginService {
    ResponseResult login(User user);

    ResponseResult logout();
}