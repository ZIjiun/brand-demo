package com.Kent.service;

import com.Kent.mapper.UserMapper;
import com.Kent.pojo.User;
import com.Kent.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 使用者登入*
     * @return
     */
    public User login(String username, String password) {
        // 2. 取得 SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 取得 BrandMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 4. 調用方法
        User user = mapper.select(username, password);

        // 釋放資源
        sqlSession.close();

        return user;
    }

    /**
     * 使用者註冊
     *
     * @param user
     * @return
     */
    public boolean register(User user) {
        // 2. 取得 SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 取得 BrandMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 4. 判斷使用者是否存在
        User u = mapper.selectByUsername(user.getUsername());

        if (u == null) {
            // 使用者不存在，可以註冊
            mapper.add(user);
            sqlSession.commit();
        }

        // 釋放資源
        sqlSession.close();

        return u == null;
    }
}
