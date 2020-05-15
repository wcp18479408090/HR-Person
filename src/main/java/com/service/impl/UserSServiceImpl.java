package com.service.impl;

import com.entity.UserS;
import com.dao.UserSDao;
import com.service.UserSService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UserS)表服务实现类
 *
 * @author makejava
 * @since 2020-05-15 07:42:23
 */
@Service("userSService")
public class UserSServiceImpl implements UserSService {
    @Resource
    private UserSDao userSDao;

    /**
     * 通过ID查询单条数据
     *
     * @param uId 主键
     * @return 实例对象
     */
    @Override
    public UserS queryById(Integer uId) {
        return this.userSDao.queryById(uId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<UserS> queryAllByLimit(int offset, int limit) {
        return this.userSDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param userS 实例对象
     * @return 实例对象
     */
    @Override
    public UserS insert(UserS userS) {
        this.userSDao.insert(userS);
        return userS;
    }

    /**
     * 修改数据
     *
     * @param userS 实例对象
     * @return 实例对象
     */
    @Override
    public UserS update(UserS userS) {
        this.userSDao.update(userS);
        return this.queryById(userS.getUId());
    }

    /**
     * 通过主键删除数据
     *
     * @param uId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer uId) {
        return this.userSDao.deleteById(uId) > 0;
    }
}