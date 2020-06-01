import com.dao.EmpDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.util.MyBatisConfig;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class EmpText {
    EmpDao empDao = MyBatisConfig.getMapper(EmpDao.class);

    @Test
    public void getEmp(){
      empDao.selectEmpAll().forEach(emp -> {
          System.out.println(emp);
          System.out.println(emp.getDept().getDName());
      });
    }
    @Test
    public void getEmpByLimit(){
//        开启分页查询
        PageHelper.startPage(2,5);

        PageInfo page = new PageInfo();
        System.out.println(page);
//        page.getList().forEach(e->{
//            System.out.println(e);
//        });
        System.out.println("总条数:"+page.getTotal()+"当前页码"+page.getPageNum()+"每页显示条数"+page.getPageSize());

    }

    @Test
    public void getEmpAll(){
        SqlSession sqlsession = MyBatisConfig.getSqlsession();
        EmpDao mapper = sqlsession.getMapper(EmpDao.class);
//        List <Emp> empAll =mapper.queryAll(null);
//        for (Emp emp:empAll){
//            System.out.println(emp);
//        }
        sqlsession.close();
    }
//    @Test
//    public void text(){
//        Map <String,Object> map  = new HashMap<String,Object>();
//        List <Emp> emplist = empDao.selectEmpChoose(map);
//        for (Emp emp : emplist){
//            System.out.println(emp);
//        }
//        MyBatisConfig.commit();
//    }

//    @Test
//    public void text1(){
//        Map <String,Object> map  = new HashMap<String,Object>();
//        map.put("e_Sex","男");
//        map.put("e_Addres","%湖北%");
//        List <Emp> emplist = empDao.selectEmpChoose(map);
//        for (Emp emp : emplist){
//            System.out.println(emp);
//        }
//        MyBatisConfig.commit();
//    }
}
