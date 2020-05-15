package com.dao;

import com.entity.UserS;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (UserS)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-15 07:42:23
 */
public interface UserSDao {

    /**
     * 通过ID查询单条数据
     *
     * @param uId 主键
     * @return 实例对象
     */
    UserS queryById(Integer uId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserS> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userS 实例对象
     * @return 对象列表
     */
    List<UserS> queryAll(UserS userS);

    /**
     * 新增数据
     *
     * @param userS 实例对象
     * @return 影响行数
     */
    int insert(UserS userS);

    /**
     * 修改数据
     *
     * @param userS 实例对象
     * @return 影响行数
     */
    int update(UserS userS);

    /**
     * 通过主键删除数据
     *
     * @param uId 主键
     * @return 影响行数
     */
    int deleteById(Integer uId);

}