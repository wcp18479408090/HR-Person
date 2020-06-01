import com.dao.DeptDao;
import com.dao.UserSDao;
import com.entity.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.*;
import com.service.impl.UserSServiceImpl;
import com.util.MyBatisConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-DataSource.xml","classpath:applicationContext-Bean.xml",})
public class MyText{
    @Autowired
    NoticeService noticeService;
    @Autowired
    EmpService empService;
    @Autowired
    DeptService deptService;
    @Autowired
    JobService jobService;
    @Test
    public  void selectAllEmp(){
        PageHelper.startPage(1, 5);
        List<Emp> deptList = this.empService.queryAll(new Emp());
        PageInfo<Emp> pageInfo = new PageInfo<Emp>(deptList);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("depts",deptService.queryAll(new Dept()));
        map.put("jobs", jobService.queryAll(new Job()));
        map.put("PageInfo",pageInfo);
        System.out.println("PageInfo"+map.get(("PageInfo")));
    }
    @Test
    public void deleteBatch() throws Exception {
        boolean b = empService.deleteById( Arrays.asList(1, 2, 3));
        System.out.println(b);
    }
   @Test
    public  void selectDept(){
      UserSDao userSDao = MyBatisConfig.getMapper(UserSDao.class);
      String loginName="admin";
       String pass="admin";
       Map <String,Object> map = new HashMap<String,Object>();
       map.put("loginName",loginName);
       map.put("pass",pass);
       UserS login = userSDao.login(map);
       System.out.println(login);
   }


   @Test
   public void  notice(){
       List<Notice> userS = noticeService.queryAll(new Notice());
       userS.forEach(user->{
           System.out.println(user);
       });
   }

    @Test
    public void  selectOne(){
        Notice notice  = noticeService.queryById(2);

            System.out.println(notice);

    }
    @Test
   public void selectAll(){
        UserSDao userSDao = MyBatisConfig.getMapper(UserSDao.class);
       Integer pageNum = 1;
       Integer pageSize =5;
       PageHelper.startPage(pageNum, pageSize);
       List<UserS> deptList = userSDao.queryAll();
       PageInfo<UserS> pageInfo = new PageInfo<UserS>(deptList);
       System.out.println(pageInfo);
       for (int i=0;i<=pageInfo.getPages();i++){
           System.out.println(i);
           System.out.println(pageInfo.getList().get(i));
       }
   }
}
