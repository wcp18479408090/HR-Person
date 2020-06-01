package com.service.impl;

import com.entity.Dept;
import com.dao.DeptDao;
import com.service.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Dept)表服务实现类
 *
 * @author makejava
 * @since 2020-05-15 07:41:10
 */
@Service("deptService")
public class DeptServiceImpl implements DeptService {
    @Resource
    private DeptDao deptDao;

    @Override
    public List<Dept> queryAll(Dept dept) {
        return deptDao.queryAll(dept);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param dId 主键
     * @return 实例对象
     */
    @Override
    public Dept queryById(Integer dId) {
        return this.deptDao.queryById(dId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Dept> queryAllByLimit(int offset, int limit) {
        return this.deptDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param dept 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Dept dept) {
        return  this.deptDao.insert(dept);

    }

    /**
     * 修改数据
     *
     * @param dept 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Dept dept) {
       return this.deptDao.update(dept);

    }

    /**
     * 通过主键删除数据
     *
     *
     * @return 是否成功
     */
    @Override
    public boolean deleteById(List<Integer> ids)throws Exception {
        int count = 0;
        for (Integer id :ids){
          int i = this.deptDao.deleteById(id);
          count +=i;
        }
        if(count<ids.size()){
            throw  new Exception("删除出错");
        }
      return true;
    }

    @Override
    public List<Dept> queryByParam(Dept dept) {
        return deptDao.queryByParam(dept);
    }
}