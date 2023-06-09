package com.xc.service.impl;

import com.xc.domain.LoginUser;
import com.xc.domain.ResponseResult;
import com.xc.domain.entity.User;
import com.xc.domain.vo.BlogUserLoginVo;
import com.xc.domain.vo.UserInfoVo;
import com.xc.service.LoginService;
import com.xc.utils.BeanCopyUtils;
import com.xc.utils.JwtUtil;
import com.xc.utils.RedisCache;
import com.xc.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @title: LoginServiceImpl
 * @Author zxwyhzy
 * @Date: 2023/2/24 21:08
 * @Version 1.0
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken
                authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        // authenticate() 认证方法
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        //获取userid 生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        //把用户信息存入redis
        redisCache.setCacheObject("login:"+userId,loginUser);

        //把token和userinfo封装 返回
        //把User转换成UserInfoVo
        /*UserInfoVo userInfoVo = BeanCopyUtils.copyBean(loginUser.getUser(), UserInfoVo.class);
        BlogUserLoginVo vo = new BlogUserLoginVo(jwt,userInfoVo);*/

        //把token封装 返回
        Map<String,String> map = new HashMap<>();
        map.put("token",jwt);
        return ResponseResult.okResult(map);
    }

    @Override
    public ResponseResult logout() {
        //获取当前登录的用户id
        Long userId = SecurityUtils.getUserId();
        //删除redis中对应的值
        redisCache.deleteObject("login:"+userId);
        return ResponseResult.okResult();
    }
}
