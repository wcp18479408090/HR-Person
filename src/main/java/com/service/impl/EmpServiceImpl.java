package com.service.impl;

import com.entity.Emp;
import com.dao.EmpDao;
import com.service.EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Emp)表服务实现类
 *
 * @author makejava
 * @since 2020-05-15 07:41:49
 */
@Service("empService")
public class EmpServiceImpl implements EmpService {
    @Resource
    private EmpDao empDao;

    @Override
    public List<Emp> queryAll(Emp emp) {
        return empDao.queryAll(emp);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param eId 主键
     * @return 实例对象
     */
    @Override
    public Emp queryById(Integer eId) {
        return this.empDao.queryById(eId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Emp> queryAllByLimit(int offset, int limit) {
        return this.empDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param emp 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Emp emp) {
        return this.empDao.insert(emp);
       // return emp;
    }

    /**
     * 修改数据
     *
     * @param emp 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Emp emp) {
        return   this.empDao.update(emp);
        //return this.queryById(emp.getEId());
    }

    /**
     * 通过主键删除数据
     *
     *
     * @return 是否成功
     */
    @Override
    public boolean deleteById( List<Integer> ids) throws Exception{
        int count = 0;
      for (Integer id:ids){
          int i = this.empDao.deleteById(id);
          count += i;
      }
      if (count<ids.size()){
          throw new Exception("删除错误");
      }
      return true;
    }

    @Override
    public List<Emp> queryByParam(Emp emp) {
        return empDao.queryByParam(emp);
    }
}