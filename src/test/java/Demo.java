//import com.util.MyBatisConfig;
//import org.apache.ibatis.session.SqlSession;
//import org.junit.Test;
//
//import java.util.List;
//
//public class Demo {
//    @Test
//    public  void text(){
//        SqlSession sqlsession = MyBatisConfig.getSqlsession();
//        DeptDao mapper = sqlsession.getMapper(DeptDao.class);
//        List <Dept> list = mapper.queryAll();
//      for(Dept dept : list){
//          System.out.println(dept);
//        }
//      sqlsession.close();
//    }
//    @Test
//    public  void selectUserByLimit(){
//        SqlSession sqlsession = MyBatisConfig.getSqlsession();
//        DeptDao mapper = sqlsession.getMapper(DeptDao.class);
//        List <Dept> list = mapper.queryAllByLimit(0,3);
//        for(Dept dept : list){
//            System.out.println(dept);
//        }
//        sqlsession.close();
//    }
//}
