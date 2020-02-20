package com.service.impl;

import com.dao.ProductDao;
import com.entity.ProductEntity;
import com.service.ProductService;
import com.util.Druids;
import com.util.QueryRunnerWrapper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author SherWin
 * @date 2019/12/3 9:34
 */


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private QueryRunnerWrapper queryRunnerWrapper=new QueryRunnerWrapper();

    public String getSqlByCondition(String initSql, Map<String, Object> conditions) {
        StringBuilder builder = new StringBuilder(initSql);
        for (String fieldName : conditions.keySet()) {
            builder.append(" and ");
            builder.append(fieldName);
            builder.append(" like ?");// TODO: 2019/12/22 有？
        }
        return builder.toString();
    }

    @Override
    public List<ProductEntity> getProductsByCondition(Map<String, Object> conditions, int start, int end) {
        // TODO: 2019/12/9  limit 需要加一？
        List<Object> list=new ArrayList<>();
        String sql=getSqlByCondition("select * from Product where  1=1",conditions);
        sql+=" limit ?,?" ;
        BeanListHandler<ProductEntity> handler=new BeanListHandler<>(ProductEntity.class);
        for (Object j:conditions.values().toArray()){
            list.add(j);
        }
        list.add(start);
        list.add(end);
        try {
            return queryRunnerWrapper.query(sql,handler,list.toArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        /*RowMapper<ProductEntity> rowMapper=new BeanPropertyRowMapper(ProductEntity.class);
        return jdbcTemplate.query(sql, rowMapper,list.toArray());*/
    }

    @Override
    public int getProductsCountByCondition(Map<String, Object> conditions) {
        String sql = getSqlByCondition("select count(*) from product where  1=1 ", conditions);

       ScalarHandler<Integer> handler = new ScalarHandler<>();

        Number number=queryRunnerWrapper.query(sql, handler,conditions.values().toArray());

        return  number.intValue();

    }



    @Override
    public List<ProductEntity> getPagedRecords(int start ,int end){
        String sql = "select * from product where pid limit ?,?";
        BeanListHandler<ProductEntity> handler = new BeanListHandler<>(ProductEntity.class);
        return  queryRunnerWrapper.query(sql, handler,start,end);
    }

    @Override
    public  int getRecordCount(){
        String sql = "select count(*) from product";
        ScalarHandler<Integer> handler = new ScalarHandler<>();
        Number number =queryRunnerWrapper.query(sql, handler);
        return  number.intValue();
        /*RowMapper<ProductEntity> rowMapper = new BeanPropertyRowMapper(ProductEntity.class);
        return Integer.valueOf(jdbcTemplate.query(sql,rowMapper).toString());*/
    }



    @Override
    public void insert(ProductEntity productEntity) {
        productDao.insert(productEntity);
    }

    @Override
    public void deleteById(int pid) {
        productDao.deleteById(pid);
    }

    @Override
    public void update(ProductEntity productEntity) {
        productDao.update(productEntity);
    }

    @Override
    public List<ProductEntity> getAll() {
        return productDao.getAll();
    }

    @Override
    public ProductEntity getById(int pid) {
        return productDao.getById(pid);
    }
}
