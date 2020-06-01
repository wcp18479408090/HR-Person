package com.controller;

import com.entity.Dept;
import com.entity.Notice;
import com.entity.UserS;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.NoticeService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * (Notice)表控制层
 *
 * @author makejava
 * @since 2020-05-15 07:42:07
 */
@RestController
@RequestMapping("notice")
public class NoticeController {
    /**
     * 服务对象
     */
    @Resource
    private NoticeService noticeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequiresPermissions("notice:selectAll")
    @RequestMapping("selectOne")
    public Notice selectOne(Integer id) {
        return this.noticeService.queryById(id);
    }
    @RequiresPermissions("notice:selectAll")
    @RequestMapping("selectAll")
    public PageInfo selectAll(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                              @RequestParam(value = "pageSize",required = false,defaultValue = "5")Integer pageSize,Notice notice){
        System.out.println("notice:"+notice);
        PageHelper.startPage(pageNum, pageSize);
        List<Notice> deptList = this.noticeService.queryAll(notice);
        PageInfo<Notice> pageInfo = new PageInfo<Notice>(deptList);
        System.out.println(pageInfo);
        return  pageInfo;

    }
    @RequiresPermissions("notice:add")
    @RequestMapping("add")
    public void insert(Notice notice, HttpServletRequest request, HttpServletResponse response, HttpSession httpSession) throws IOException {
        UserS user = (UserS) SecurityUtils.getSubject().getSession().getAttribute("user");
        if(user != null){
            notice.setUserS(user);
        }
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        if(noticeService.insert(notice)>0){
            response.getWriter().println("<script>alert('新增成功!');window.history.go(-1)</script>");
            return;
        } response.getWriter().println("<script>alert('新增失败!');window.history.go(-1)</script>");
        return;

    }
    @RequiresPermissions("notice:selectAll")
    @RequestMapping("selectById")
    public Notice queryById(@RequestParam("id") Integer dId){
        return this.noticeService.queryById(dId);
    }
    @RequestMapping("update")
    public void update(Notice notice, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println(notice.getNId());
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        if(noticeService.update(notice)>0){
            response.getWriter().println("<script>alert('修改成功!');window.history.go(-1)</script>");
            return;
        } response.getWriter().println("<script>alert('修改失败!');window.history.go(-1)</script>");
        return;
    }
    @RequiresPermissions("notice:delete")
    @RequestMapping("delete")
    public void  deleteById(@RequestParam List<Integer> ids, HttpServletResponse response,HttpServletRequest request) throws UnsupportedEncodingException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        System.out.println(ids);
        boolean flag = false;
        try {
            flag = this.noticeService.deleteById(ids);
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