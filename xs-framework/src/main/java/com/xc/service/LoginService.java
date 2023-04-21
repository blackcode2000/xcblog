package com.xc.service;

import com.xc.domain.ResponseResult;
import com.xc.domain.entity.User;

public interface LoginService {
    ResponseResult login(User user);

}