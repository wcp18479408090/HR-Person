//import com.entity.Dept;
//import com.github.pagehelper.PageHelper;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.List;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations="classpath:applicationContext.xml")
//public class MyText {
//    @Autowired
//    DeptDao deptDao;
//
//   @Test
//    public  void selectDept(){
//       //ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//
//       PageHelper.startPage(1,3);
//       List <Dept> deptAll = deptDao.getDeptAll();
//       deptAll.forEach(e->{
//           System.out.println(e);
//       });
//   }
//}
