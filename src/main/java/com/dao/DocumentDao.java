package com.dao;

import com.entity.Document;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Document)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-15 07:41:37
 */
public interface DocumentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param dId 主键
     * @return 实例对象
     */
    Document queryById(Integer dId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Document> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param document 实例对象
     * @return 对象列表
     */
    List<Document> queryAll(Document document);

    /**
     * 新增数据
     *
     * @param document 实例对象
     * @return 影响行数
     */
    int insert(Document document);

    /**
     * 修改数据
     *
     * @param document 实例对象
     * @return 影响行数
     */
    int update(Document document);

    /**
     * 通过主键删除数据
     *
     * @param dId 主键
     * @return 影响行数
     */
    int deleteById(Integer dId);

}