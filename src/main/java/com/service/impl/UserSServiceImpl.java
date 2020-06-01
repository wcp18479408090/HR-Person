package com.service.impl;

import com.entity.UserS;
import com.dao.UserSDao;
import com.service.UserSService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    @Override
    public UserS login(Map<String,Object> map) {

        return userSDao.login(map);
}
//根据用户传递的参数查询
    @Override
    public List<UserS> queryByParam(UserS userS) {
        return userSDao.queryByParam(userS);
    }

    @Override
    public List<UserS> queryAll() {
        return userSDao.queryAll();
    }

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
    public int  insert(UserS userS) {
       return this.userSDao.insert(userS);

    }

    /**
     * 修改数据
     *
     * @param userS 实例对象
     * @return 实例对象
     */
    @Override
    public int update(UserS userS) {
      return   this.userSDao.update(userS);
       // return this.queryById(userS.getUId());
    }

    /**
     * 通过主键删除数据
     *

     * @return 是否成功
     */
    @Override
    public boolean deleteById(List<Integer> ids) throws Exception{
        int count = 0;
        for (Integer id :ids){
          int  num = this.userSDao.deleteById(id);
            count += num;
        }
        if (count<ids.size()){
            throw new Exception("删除出错");
        }
        return true;
    }
}