package com.controller;

import com.alibaba.druid.util.StringUtils;
import com.entity.Notice;
import com.entity.UserS;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.UserSService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.print.attribute.standard.Severity;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (UserS)表控制层
 *
 * @author makejava
 * @since 2020-05-15 07:42:23
 */
@RestController
@RequestMapping("userS")
//当前登陆用户只有superAdmin可以访问

public class UserSController {
    /**
     * 服务对象
     */
    @Resource
    private UserSService userSService;


    //登陆  @RequestParam("remebeme") String remeberme,
    @RequestMapping("login")
    public void login(@RequestParam("username") String username,@RequestParam("password")String password,
                     HttpSession httpSession,
                      HttpServletResponse response,HttpServletRequest request) throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        //接受客户端发起的登陆请求
        //把用户名存入UsernamePasswordToken，方便自定义realm获取
        // Realm：域，Realm 充当了 Shiro 与应用安全数据间的“桥梁”或者“连接器”。
        //也就是说，当对用户执行认证（登录）和授权（访问控制）验证时，
       // Shiro 会从应用配置的 Realm 中查找用户及其权限信息
        UsernamePasswordToken token  = new UsernamePasswordToken(username,password);

        //Subject：主体
        //访问系统的用户，主体可以是用户、程序等，进行认证的都称为主体；
        Subject subject = SecurityUtils.getSubject();

        try {
            //调用登陆方法，他会自动调用我们自定义realm类
            //第二步他会自动调用我们已经实现的两个方法|doGetAuthenticationInfo...
            //第三步，给当前登陆的用户赋权限(authorizationInfo.setRoles(userSDao.queryRoles(principal.toString()))，方便我们对数据进行操作
            //详情请看 我们自定义的reaml
            subject.login(token);
            response.getWriter().print("<script>alert('登陆成功');window.location.href='/index.html'</script>");
        }catch (UnknownAccountException e)
        {
            response.getWriter().print("<script>alert('账号或密码错误');window.location.href='/login.html'</script>");
            return;
        }

    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
    */
    //  @RequestParam(value = "pageNum",required = true,defaultValue = "1")Integer pageNum
    @RequiresPermissions("userS:selectAll")
    @RequestMapping("selectOne")
    public UserS selectOne(Integer id) {
        return this.userSService.queryById(id);
    }
//    @RequestMapping("selectAll/{pageNum}")
      @RequestMapping("selectAll")
    public PageInfo selectAll(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                              @RequestParam(value = "pageSize",required = false,defaultValue = "5")Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<UserS> deptList = this.userSService.queryAll();
        PageInfo<UserS> pageInfo = new PageInfo<UserS>(deptList);
        return  pageInfo;
    }
    //根据参数查询
    @RequiresPermissions("userS:selectAll")
    @RequestMapping("query")
    public PageInfo query(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum, @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize,UserS userS){

        PageHelper.startPage(pageNum, pageSize);
        List<UserS> deptList = this.userSService.queryByParam(userS);
        PageInfo<UserS> pageInfo = new PageInfo<UserS>(deptList);
        return  pageInfo;
    }
    @RequiresPermissions("userS:add")
    @RequestMapping("add")
    public void insert(UserS userS,HttpServletResponse response,HttpServletRequest request) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        System.out.println(request.getCharacterEncoding());
        System.out.println(userS);
        if(userSService.insert(userS)>0){
            response.getWriter().println("<script>alert('新增成功!');window.history.go(-1)</script>");
            return;
        } response.getWriter().println("<script>alert('新增失败!');window.history.go(-1)</script>");
        return;
    }
    @RequiresPermissions("userS:selectAll")
    @RequestMapping("selectById")
    public UserS queryById(@RequestParam("id") Integer dId){
        System.out.println(dId);
        return this.userSService.queryById(dId);
    }
    @RequiresPermissions("userS:update")
    @RequestMapping("update")
    public void update(UserS userS,HttpServletResponse response,HttpServletRequest request) throws IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        System.out.println(request.getCharacterEncoding());
        System.out.println(userS);
        if(userSService.update(userS)>0){
            response.getWriter().println("<script>alert('修改成功!');window.history.go(-1)</script>");
            return;
        } response.getWriter().println("<script>alert('修改失败!');window.history.go(-1)</script>");
        return;

    }
    @RequiresPermissions("userS:delete")
    @RequestMapping("delete")
    public void  deleteById(@RequestParam List<Integer> ids, HttpServletResponse response,HttpServletRequest request) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        System.out.println("进入delete");
       //判断是否删除了超级用户
        if(deleteId(ids)){
            response.getWriter().print("<script>alert(不能删除超级用户!');window.history.go(-1)</script>");
            return;
        }
        boolean flag = false;
        try {
            flag = this.userSService.deleteById(ids);
            System.out.println(flag);
            if (flag) {
                response.getWriter().print("true");
                return;
            }
            response.getWriter().print("false");
        } catch (Exception e) {
            e.printStackTrace();
         }
        }
    public boolean deleteId(List<Integer> ids){
        for (Integer id:ids){
            if(id==1){
                return true;
            }
        }
       return false;
     }
    }
