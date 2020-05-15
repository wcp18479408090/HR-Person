package com.util;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisConfig<T>{
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            String resource = "MyBatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
    public static synchronized SqlSession getSqlsession(){
        /**
         * 返回SqlSession 类似Connection 但SqlSession比较强大，他还具有prepareStatement功能
         * 就是praperStatement 与Connection的结合
         */
        SqlSession sqlSession = threadLocal.get();
        if(sqlSession == null){
           sqlSession = sqlSessionFactory.openSession();
           threadLocal.set(sqlSession);
        }
        return  sqlSession;

    }
    public static synchronized <T> T getMapper(Class clazz){
        return (T) getSqlsession().getMapper(clazz);
    }

    public static synchronized void commit(){
        SqlSession sqlSession = threadLocal.get();
        if(sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
            threadLocal.remove();
        }

    }
}
