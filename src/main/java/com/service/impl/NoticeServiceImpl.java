package com.service.impl;

import com.entity.Notice;
import com.dao.NoticeDao;
import com.service.NoticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Notice)表服务实现类
 *
 * @author makejava
 * @since 2020-05-15 07:42:07
 */
@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
    @Resource
    private NoticeDao noticeDao;

    @Override
    public List<Notice> queryAll(Notice notice) {
        return noticeDao.queryAll(notice);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param nId 主键
     * @return 实例对象
     */
    @Override
    public Notice queryById(Integer nId) {
        return this.noticeDao.queryById(nId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Notice> queryAllByLimit(int offset, int limit) {
        return this.noticeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Notice notice) {
        return this.noticeDao.insert(notice);

    }

    /**
     * 修改数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Notice notice) {
        return  this.noticeDao.update(notice);

    }

    /**
     * 通过主键删除数据
     *

     * @return 是否成功
     */
    @Override
    public boolean deleteById(List<Integer> ids)throws Exception {
        int count = 0;
        for (Integer id:ids){
            int num = this.noticeDao.deleteById(id);
            count += num;
        }
      if (count<ids.size()){
          throw  new Exception("删除失败");
      }
      return true;
    }

    @Override
    public List<Notice> queryByParam(Notice notice) {
        return noticeDao.queryByParam(notice);
    }
}