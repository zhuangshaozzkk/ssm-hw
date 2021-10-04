package com.zzkk.crud.service;

import com.zzkk.crud.bean.Department;
import com.zzkk.crud.dao.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zzkk
 * @ClassName DepartmentService
 * @Description Todo
 **/
@Service
public class DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> getDepts() {
//        查询所有部门，不用加条件
        List<Department> list = departmentMapper.selectByExample(null);
        return list;
    }
}
