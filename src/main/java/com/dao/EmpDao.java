package com.dao;

import com.entity.Document;
import com.entity.Emp;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Emp)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-15 07:41:49
 */
public interface EmpDao {

    List <Emp> selectEmpAll();


    List<Emp> queryByParam(Emp emp);

    /**
     * 通过ID查询单条数据
     *
     * @param eId 主键
     * @return 实例对象
     */
    Emp queryById(@Param("eId")Integer eId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Emp> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *

     * @return 对象列表
     */
    List<Emp> queryAll(Emp emp);

    /**
     * 新增数据
     *
     * @param emp 实例对象
     * @return 影响行数
     */
    int insert(Emp emp);

    /**
     * 修改数据
     *
     * @param emp 实例对象
     * @return 影响行数
     */
    int update(Emp emp);

    /**
     * 通过主键删除数据
     *
     * @param eId 主键
     * @return 影响行数
     */
    int deleteById(@Param("eId") Integer eId);

}