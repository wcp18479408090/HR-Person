package com.controller;

import com.entity.UserS;
import com.service.UserSService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (UserS)表控制层
 *
 * @author makejava
 * @since 2020-05-15 07:42:23
 */
@RestController
@RequestMapping("userS")
public class UserSController {
    /**
     * 服务对象
     */
    @Resource
    private UserSService userSService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UserS selectOne(Integer id) {
        return this.userSService.queryById(id);
    }

}