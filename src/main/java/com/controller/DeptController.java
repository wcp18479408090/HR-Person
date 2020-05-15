package com.controller;

import com.entity.Dept;
import com.service.DeptService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    @GetMapping("selectOne")
    public Dept selectOne(Integer id) {

        return this.deptService.queryById(id);
    }
    @GetMapping("hello")
    public String hello() {

       return "hello world";
    }
}