package com.fonix.colab.shiro;

import cn.hutool.core.bean.BeanUtil;
import com.fonix.colab.entity.AccountProfile;
import com.fonix.colab.entity.User;
import com.fonix.colab.service.UserService;
import com.fonix.colab.utils.JwtUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountRealm extends AuthorizingRealm {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //权限校验
        return null;
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        //为了让realm支持jwt的凭证校验
        return token instanceof JwtToken;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //通过token身份验证
        JwtToken jwtToken = (JwtToken) token;

        String userId = jwtUtils.getClaimByToken((String) jwtToken.getPrincipal()).getSubject();

        User user = userService.getById(Long.valueOf(userId));
        if (user == null) {
            throw new UnknownAccountException("账户不存在");
        }


        AccountProfile profile = new AccountProfile();
        BeanUtil.copyProperties(user, profile);

        return new SimpleAuthenticationInfo(profile, jwtToken.getCredentials(), getName());
    }
}
