package com.zzkk.crud.test;


import com.zzkk.crud.bean.Employee;
import com.zzkk.crud.dao.DepartmentMapper;
import com.zzkk.crud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * 测试dao层的工作
 * 推荐Spring的项目可以使用Spring的单元测试，可以自动注入我们需要的组件
 * 1、导入SpringTest模块
 * 2、@ContextConfiguration指定Spring配置文件的位置
 * ，@RunWith(SpringJUnit4ClassRunner.class)让测试运行于Spring测试环境
 * 3、直接autowired要使用的组件即可
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class MapperTest {
    @Autowired
    DepartmentMapper d;

    @Autowired
    EmployeeMapper e;

    @Autowired
    SqlSession sqlSession;

    @Test
    public void test() {
//      批量插入多个员工，批量插入可以执行批量操作的SqlSession
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 0; i < 1000; i++) {
            String uuid = UUID.randomUUID().toString().substring(0, 5) + i;
            mapper.insertSelective(new Employee(null, uuid, "M", uuid + "@163.com", 1));
        }
    }
}
