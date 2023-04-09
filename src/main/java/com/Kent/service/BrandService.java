package com.Kent.service;

import com.Kent.mapper.BrandMapper;
import com.Kent.pojo.Brand;
import com.Kent.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandService {

    // Factory 只要初始化一次就行了，不用每次被調用時都初始化
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 查詢所有
     * @return
     */
    public List<Brand> selectAll(){
        // 調用 BrandMapper.selectAll()
        // 2. 取得 SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 取得 BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        // 4. 調用方法
        List<Brand> brands = mapper.selectAll();

        sqlSession.close();

        return brands;
    }
}