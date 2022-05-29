package com.fonix.colab.shiro;

import com.fonix.colab.entity.User;
import com.fonix.colab.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {


    @Autowired
    UserService userService;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权 =》 doGetAuthorizationInfo");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermission("lab:addLab");
        return info;
    }


    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了认证 =》 doGetAuthenticationInfo");
        //执行用户名 密码 认证

        UsernamePasswordToken  token = (UsernamePasswordToken) authenticationToken;
        User user = userService.queryUserByName(token.getUsername());

        if(user==null){
            return null;  //抛出异常   UnknownAccountException
        }

        //密码验证由 shiro 实现
        return new SimpleAuthenticationInfo("",user.getPassword(),"");
    }
}
