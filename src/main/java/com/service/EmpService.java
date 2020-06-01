package com.service;

import com.entity.Document;
import com.entity.Emp;
import java.util.List;

/**
 * (Emp)表服务接口
 *
 * @author makejava
 * @since 2020-05-15 07:41:49
 */
public interface EmpService {

    List<Emp> queryAll(Emp emp);
    /**
     * 通过ID查询单条数据
     *
     * @param eId 主键
     * @return 实例对象
     */
    Emp queryById(Integer eId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Emp> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param emp 实例对象
     * @return 实例对象
     */
   int insert(Emp emp);

    /**
     * 修改数据
     *
     * @param emp 实例对象
     * @return 实例对象
     */
    int update(Emp emp);

    /**
     * 通过主键删除数据
     *
     *
     * @return 是否成功
     */
    boolean deleteById( List<Integer> ids) throws Exception;
    //根据参数分页查询
    List<Emp> queryByParam(Emp emp);
}