package com.service.impl;

import com.entity.Job;
import com.dao.JobDao;
import com.service.JobService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Job)表服务实现类
 *
 * @author makejava
 * @since 2020-05-15 07:41:58
 */
@Service("jobService")
public class JobServiceImpl implements JobService {
    @Resource
    private JobDao jobDao;

    @Override
    public List<Job> queryAll(Job job) {
        return jobDao.queryAll(job);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param jId 主键
     * @return 实例对象
     */
    @Override
    public Job queryById(Integer jId) {
        return this.jobDao.queryById(jId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Job> queryAllByLimit(int offset, int limit) {
        return this.jobDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param job 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Job job) {
        return this.jobDao.insert(job);

    }

    /**
     * 修改数据
     *
     * @param job 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Job job) {
        return  this.jobDao.update(job);

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
        for (Integer id :ids){
            int  num = this.jobDao.deleteById(id);
            count += num;
        }
        if (count<ids.size()){
            throw new Exception("删除出错");
        }
        return true;

    }

    @Override
    public List<Job> queryByParam(Job job) {
        return jobDao.queryByParam(job);
    }
}