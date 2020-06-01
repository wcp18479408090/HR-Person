import com.dao.DeptDao;
import com.entity.Dept;
import com.util.MyBatisConfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-DataSource.xml")
public class DeptText {
    @Autowired
    DeptDao deptDao;




    @Test
    public void text() {

//       List<Dept> deptList =deptDao.queryDeptAndEmp(2);
//            System.out.println(deptList);

    }

//    @Test
//    public void text1() {
////        int i = deptDao.update(new Dept(1, "技术部", "技术部"));
//        List<Dept> deptAll = deptDao.queryAll();
//        for (Dept dept : deptAll) {
//            System.out.println(dept);
//        }
//        MyBatisConfig.commit();
//    }

    @Test
    public void addDept() {
        Dept dept = new Dept();
        dept.setDDesc("好好");
        dept.setDName("好好");
        deptDao.insert(dept);
        System.out.println(dept.getDId());
        MyBatisConfig.commit();
    }

    @Test
    public void deleteDept() {
        Dept dept = new Dept();
        deptDao.deleteById(8);
        MyBatisConfig.commit();
    }



    @Test
    public void batchDept() {
        Dept dept = new Dept();
        Dept dept1 = new Dept();
        dept.setDName("俊哥");
        dept.setDName("俊哥");

        dept1.setDName("俊哥as");
        dept1.setDName("俊哥as");
       List <Dept> deptList = new ArrayList<Dept>();
       deptList.add(dept);
        deptList.add(dept1);

    }
}