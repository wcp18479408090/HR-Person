package com.service;

import com.entity.Dept;
import java.util.List;

/**
 * (Dept)表服务接口
 *
 * @author makejava
 * @since 2020-05-15 07:41:08
 */
public interface DeptService {

    List<Dept> queryAll(Dept dept);

    /**
     * 通过ID查询单条数据
     *
     * @param dId 主键
     * @return 实例对象
     */
    Dept queryById(Integer dId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Dept> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param dept 实例对象
     * @return 实例对象
     */
    int insert(Dept dept);

    /**
     * 修改数据
     *
     * @param dept 实例对象
     * @return 实例对象
     */
    int update(Dept dept);

    /**
     * 通过主键删除数据
     *
     *
     * @return 是否成功
     */
    boolean deleteById(List<Integer> ids) throws Exception;

    List<Dept> queryByParam(Dept dept);

}