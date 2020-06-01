package com.controller;

import com.entity.Dept;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.DeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
/**
 * (Dept)表控制层
 *
 * @author makejava
 * @since 2020-05-15 07:41:11
 */
@RestController
@RequestMapping("dept")
public class DeptController {
    /**
     * 服务对象
     */
    @Resource
    private DeptService deptService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequiresPermissions("dept:selectAll")
    @RequestMapping("selectOne")
    public Dept selectOne(Integer id){
        return this.deptService.queryById(id);
    }
    @RequiresPermissions("dept:selectAll")
    @RequestMapping("selectAll")
    public  PageInfo selectAll(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                               @RequestParam(value = "pageSize",required = false,defaultValue = "5")Integer pageSize,Dept dept){
        PageHelper.startPage(pageNum, pageSize);
        List<Dept> deptList = this.deptService.queryAll(dept);
        PageInfo<Dept> pageInfo = new PageInfo<Dept>(deptList);
        System.out.println(pageInfo);
        return  pageInfo;
    }
    @RequiresPermissions("dept:add")
    @RequestMapping("add")
    public void insert(Dept dept, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        if(deptService.insert(dept)>0){
            response.getWriter().println("<script>alert('新增成功!');window.history.go(-1)</script>");
            return;
        } response.getWriter().println("<script>alert('新增失败!');window.history.go(-1)</script>");
        return;
    }
    @RequiresPermissions("dept:selectAll")
    @RequestMapping("selectById")
    public Dept queryById(@RequestParam("id") Integer dId){
        System.out.println("idsadadsadass："+dId);
        Dept dept = this.deptService.queryById(dId);
        System.out.println(dept);
        return dept;
    }
    @RequiresPermissions("dept:update")
    @RequestMapping("update")
    public void update(Dept dept, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        if(deptService.update(dept)>0){
            response.getWriter().println("<script>alert('修改成功!');window.history.go(-1)</script>");
            return;
        } response.getWriter().println("<script>alert('修改失败!');window.history.go(-1)</script>");
        return;

    }
    @RequiresPermissions("dept:delete")
    @RequestMapping("delete")
    public void  deleteById(@RequestParam List<Integer> ids, HttpServletResponse response,HttpServletRequest request) throws UnsupportedEncodingException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        System.out.println(ids);
        boolean flag = false;
        try {
            flag = this.deptService.deleteById(ids);
            System.out.println(flag);
            if (flag) {
                response.getWriter().print("<script>alert('删除成功!');window.history.go(-1)</script>");
                return;
            }
            response.getWriter().print("<script>alert(删除失败!');window.history.go(-1)</script>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}