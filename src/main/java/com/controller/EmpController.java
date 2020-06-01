package com.controller;

import com.entity.Dept;
import com.entity.Emp;
import com.entity.Job;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.DeptService;
import com.service.EmpService;
import com.service.JobService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Emp)表控制层
 *
 * @author makejava
 * @since 2020-05-15 07:41:49
 */
@RestController
@RequestMapping("emp")
//当前登陆用户需要人事这个角色
@RequiresRoles(value = {"personnel","superAdmin"},logical = Logical.OR)
public class EmpController {
    @Resource
    private EmpService empService;
    @Autowired
    DeptService deptService;
    @Autowired
    JobService jobService;
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */

    @RequestMapping("selectOne")
    @RequiresPermissions("emp:selectAll")
    public Emp selectOne(Integer id) {
        return this.empService.queryById(id);
    }

    @RequestMapping("selectAll")
    @RequiresPermissions("emp:selectAll")
    public Map selectAll(Emp emp, @RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                         @RequestParam(value = "pageSize",required = false,defaultValue = "5")Integer pageSize, HttpSession session,HttpServletRequest request){
        System.out.println("emp:"+emp);
        System.out.println(request.getParameter("eName"));
        if(emp!=null){
            emp.setJob(new Job());
            emp.setDept(new Dept());
             String did = request.getParameter("dept.dId");
            String jid  = request.getParameter("job.jId");
          if (jid!=null&&did!=null&&!"".equals(jid)&&!"".equals(did)){
              emp.getDept().setDId(Integer.parseInt(did));
              emp.getJob().setJId(Integer.parseInt(jid));
              System.out.println("emp.getJob().getJId():"+emp.getJob().getJId());
              System.out.println("emp.getJob().getJId():"+emp.getDept().getDId());
          }
        }
        PageHelper.startPage(pageNum, pageSize);
        List<Emp> deptList = this.empService.queryAll(emp);
        PageInfo<Emp> pageInfo = new PageInfo<Emp>(deptList);
        Map<String,Object> map = new HashMap<>();
        map.put("depts",deptService.queryAll(new Dept()));
        map.put("jobs",jobService.queryAll(new Job()));
        map.put("pageInfo",pageInfo);
        return  map;
    }
    @RequiresPermissions("emp:add")
    @RequestMapping("add")
    public void insert(Emp emp,HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        System.out.println("emp.getJob().getJId():"+emp.getJob().getJId());
        System.out.println("emp.getJob().getJId():"+emp.getDept().getDId());
        if(empService.insert(emp)>0){
            response.getWriter().println("<script>alert('添加成功!');window.history.go(-1)</script>");
            return;
        } response.getWriter().println("<script>alert('添加失败!');window.history.go(-1)</script>");
        return;

    }
    @RequiresPermissions("emp:selectAll")
    @RequestMapping("selectById")
    public Emp queryById(@RequestParam("id") Integer dId){
        return this.empService.queryById(dId);
    }
    @RequiresPermissions("emp:update")
    @RequestMapping("update")
    public void update(Emp emp, HttpServletResponse response, HttpServletRequest request) throws IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        System.out.println("emp.getJob().getJId():"+emp.getJob().getJId());
        System.out.println("emp.getJob().getJId():"+emp.getDept().getDId());
        if(empService.update(emp)>0){
            response.getWriter().println("<script>alert('修改成功!');window.history.go(-1)</script>");
            return;
        } response.getWriter().println("<script>alert('修改失败!');window.history.go(-1)</script>");
        return;
    }
    @RequiresPermissions("emp:delete")
    @RequestMapping("delete")
    public void  deleteById(@RequestParam List<Integer> ids, HttpServletResponse response,HttpServletRequest request) throws UnsupportedEncodingException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        System.out.println(ids);
        boolean flag = false;
        try {
            flag  = this.empService.deleteById(ids);
            System.out.println(flag);
           if(flag){
               response.getWriter().print("<script>alert('删除成功!');window.history.go(-1)</script>");
               return;
           }  response.getWriter().print("<script>alert(删除失败!');window.history.go(-1)</script>");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}