package com.service;

import com.entity.UserS;
import java.util.List;

/**
 * (UserS)表服务接口
 *
 * @author makejava
 * @since 2020-05-15 07:42:23
 */
public interface UserSService {

    /**
     * 通过ID查询单条数据
     *
     * @param uId 主键
     * @return 实例对象
     */
    UserS queryById(Integer uId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserS> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param userS 实例对象
     * @return 实例对象
     */
    UserS insert(UserS userS);

    /**
     * 修改数据
     *
     * @param userS 实例对象
     * @return 实例对象
     */
    UserS update(UserS userS);

    /**
     * 通过主键删除数据
     *
     * @param uId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer uId);

}