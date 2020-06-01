package com.service;

import com.entity.Notice;
import com.entity.UserS;
import java.util.List;
import java.util.Map;

/**
 * (UserS)表服务接口
 *
 * @author makejava
 * @since 2020-05-15 07:42:23
 */
public interface UserSService {

    UserS login(Map<String,Object> map);
//根据用户传递的参数查询
    List<UserS> queryByParam(UserS userS);

    List<UserS> queryAll();
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
    int insert(UserS userS);

    /**
     * 修改数据
     *
     * @param userS 实例对象
     * @return 实例对象
     */
    int update(UserS userS);

    /**
     * 通过主键删除数据
     *
     *
     * @return 是否成功
     */
    boolean deleteById(List<Integer> ids) throws Exception;

}