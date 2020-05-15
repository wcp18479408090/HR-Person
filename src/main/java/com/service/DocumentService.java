package com.service;

import com.entity.Document;
import java.util.List;

/**
 * (Document)表服务接口
 *
 * @author makejava
 * @since 2020-05-15 07:41:37
 */
public interface DocumentService {

    /**
     * 通过ID查询单条数据
     *
     * @param dId 主键
     * @return 实例对象
     */
    Document queryById(Integer dId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Document> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param document 实例对象
     * @return 实例对象
     */
    Document insert(Document document);

    /**
     * 修改数据
     *
     * @param document 实例对象
     * @return 实例对象
     */
    Document update(Document document);

    /**
     * 通过主键删除数据
     *
     * @param dId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer dId);

}