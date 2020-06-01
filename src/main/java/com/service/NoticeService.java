package com.service;

import com.entity.Job;
import com.entity.Notice;
import java.util.List;

/**
 * (Notice)表服务接口
 *
 * @author makejava
 * @since 2020-05-15 07:42:07
 */
public interface NoticeService {

    List<Notice> queryAll(Notice notice);
    /**
     * 通过ID查询单条数据
     *
     * @param nId 主键
     * @return 实例对象
     */
    Notice queryById(Integer nId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Notice> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
   int insert(Notice notice);

    /**
     * @return 实例对象
     */
    int update(Notice notice);

    /**
     * 通过主键删除数据
     *
     *
     * @return 是否成功
     */
    boolean deleteById(List<Integer> ids) throws Exception;

    List<Notice> queryByParam(Notice notice);
}