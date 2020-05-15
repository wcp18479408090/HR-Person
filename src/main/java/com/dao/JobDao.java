package com.dao;

import com.entity.Job;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Job)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-15 07:41:58
 */
public interface JobDao {

    /**
     * 通过ID查询单条数据
     *
     * @param jId 主键
     * @return 实例对象
     */
    Job queryById(Integer jId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Job> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param job 实例对象
     * @return 对象列表
     */
    List<Job> queryAll(Job job);

    /**
     * 新增数据
     *
     * @param job 实例对象
     * @return 影响行数
     */
    int insert(Job job);

    /**
     * 修改数据
     *
     * @param job 实例对象
     * @return 影响行数
     */
    int update(Job job);

    /**
     * 通过主键删除数据
     *
     * @param jId 主键
     * @return 影响行数
     */
    int deleteById(Integer jId);

}