import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class MyShiro {

    @Before
    public void before(){
        //实例化一个领域,可以获取到加密数据
        Realm realm = new IniRealm("classpath:shiro-config.ini");
        //创建SecurityManager
        SecurityManager securityManager = new DefaultSecurityManager(realm);
        //把SecurityManager作用与当前资源Application
         SecurityUtils.setSecurityManager(securityManager);
    }
    @Test
    public  void  text(){
       //获取用户信息NameAndPass
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan","123");
       //获取当前的主题(用户)
        Subject subject = SecurityUtils.getSubject();
        try {
            //提交验证NameAndPass是否正确
            subject.login(token);
            System.out.println("当前用户认证结果:"+subject.isAuthenticated());
            someThing();
        } catch (UnknownAccountException uae) {
        System.out.println("用户名错误");
    } catch (IncorrectCredentialsException ice) {
        System.out.println("错误的凭据（密码错误）");
    } catch (LockedAccountException lae) {
        System.out.println("账户被锁定");
    }
    }
    public void someThing(){
        //获取当前主题（用户）
       // subject.hasRole();判断是那个角色
        //subject.isPermitter();判断当前主题（用户）是否有这个权限
        Subject subject = SecurityUtils.getSubject();
        System.out.println("是否是管理员:"+subject.hasRole("manage"));
        System.out.println("是否是普通用户:"+subject.hasRole("normal"));
        System.out.println("是否拥有添加员工权限:"+subject.isPermitted("emp:add"));
        System.out.println("是否拥有对员工增删改查权限："+ Arrays.toString(subject.isPermitted("emp:add","emp:delete",
                "emp:update","emp:query")));
    }
}
