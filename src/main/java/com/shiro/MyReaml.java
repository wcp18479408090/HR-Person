package com.shiro;

import com.dao.UserSDao;
import com.entity.UserS;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class MyReaml extends AuthorizingRealm {
  @Autowired
    UserSDao userSDao;

   //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {

        //自定义认证
        SimpleAuthorizationInfo  authorizationInfo = new SimpleAuthorizationInfo();
        //当用户操作某些特殊的请求时（对用户的增删改查...），为了安全，需要绑定某个角色才能访问时，就需要绑定一个角色给用户。
        //认证角色(superAmind||Personnol)，返回的是一个set<String> 角色集合，一个用户可以对应多个角色
         authorizationInfo.setRoles(userSDao.queryRoles(principal.toString()));
         //赋值具体权限 例如员工表的增删改：(emp:add,emp:update,emp:delete)
        // 当用户操作员工管理时，如果没有对应权限则报错
        //返回的是一个set<String> 权限集合，如上
         authorizationInfo.setStringPermissions(userSDao.queryPower(principal.toString()));
        return authorizationInfo;
    }
//认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken Token) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken)Token;
        //根据用户名取数据库查询有没有改用户
        UserS login = userSDao.queryByName(token.getPrincipal().toString());
        if(login == null){
            //如果账号密码不对，抛出异常
            throw  new UnknownAccountException();
        }
        //如果查询成功把他存入session，公告与文件上传需要用到
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("user",login);
        //认证用户是否正确的工作交给shiro,我们提供正确的用户名和密码
        return new SimpleAuthenticationInfo(login.getULoginname(),login.getUPass(),this.getName());
    }
}
