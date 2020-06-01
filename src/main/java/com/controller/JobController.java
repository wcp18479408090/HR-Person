package com.controller;

import com.entity.Dept;
import com.entity.Job;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.JobService;
import org.apache.ibatis.annotations.Delete;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * (Job)表控制层
 *
 * @author makejava
 * @since 2020-05-15 07:41:58
 */
@RestController
@RequestMapping("job")
public class JobController {
    /**
     * 服务对象
     */
    @Resource
    private JobService jobService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequiresPermissions("job:selectAll")
    @RequestMapping("selectOne")
    public Job selectOne(Integer id) {
        return this.jobService.queryById(id);
    }
    @RequiresPermissions("job:selectAll")
    @RequestMapping("selectAll")
    public PageInfo selectAll(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                               @RequestParam(value = "pageSize",required = false,defaultValue = "2")Integer pageSize,Job job){
        PageHelper.startPage(pageNum,pageSize);
        List<Job> jobs = this.jobService.queryAll(job);
        PageInfo pageInfo = new PageInfo(jobs);
        return pageInfo;
    }
    @RequiresPermissions("job:add")
    @RequestMapping("add")
    public void add(Job job, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        if(jobService.insert(job)>0){
            response.getWriter().println("<script>alert('新增成功!');window.history.go(-1)</script>");
            return;
        } response.getWriter().println("<script>alert('新增失败!');window.history.go(-1)</script>");
        return;

    }
    @RequiresPermissions("job:update")
    @RequestMapping("update")
    public void update(Job job ,HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        if(jobService.update(job)>0){
            response.getWriter().println("<script>alert('修改成功!');window.history.go(-1)</script>");
            return;
        } response.getWriter().println("<script>alert('修改失败!');window.history.go(-1)</script>");
    }
    @RequiresPermissions("job:delete")
    @RequestMapping("delete")
    public boolean delete(@RequestParam List<Integer> ids, HttpServletResponse response,HttpServletRequest request) throws UnsupportedEncodingException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        System.out.println("进入delete");
        System.out.println(ids);
        boolean flag = false;
        try {
            flag = this.jobService.deleteById(ids);
            System.out.println(flag);
            if (flag) {
               return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    @RequiresPermissions("job:selectAll")
    @RequestMapping("selectById")
    public Job queryById(@RequestParam("id") Integer dId){
        Job job = this.jobService.queryById(dId);
        System.out.println(job);
        return job;
    }
}