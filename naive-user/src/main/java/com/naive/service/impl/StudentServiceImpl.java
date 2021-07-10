package com.naive.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.naive.dao.StudentMapper;
import com.naive.domain.Student;
import com.naive.service.StudentService;
import com.naive.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author YechenGu
 * @date 2021/6/28 10:50 上午
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    /**
     * find student via id
     * */
    @Override
    public Student findById(int stuId) {
        return studentMapper.selectById(stuId);
    }

    /**
     * update student via id
     * */
    @Override
    public int updateById(Student student) {
        if (student.getPwd() != null){
            String pwd = CommonUtils.MD5(student.getPwd());
            student.setPwd(pwd);
        }
        return studentMapper.updateById(student);
    }

    /**
     * add student via id
     * */
    @Override
    public int add(Student student) {
        String pwd = CommonUtils.MD5(student.getPwd());
        student.setPwd(pwd);
        return studentMapper.insert(student);
    }

    /**
     * delete student via id
     * */
    @Override
    public int deleteById(int stuId) {
        return studentMapper.deleteById(stuId);
    }

    /**
     *
     * @param id
     * @param pwd
     * @return
     */
    @Override
    public Student checkPwd(int id, String pwd) {
        QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
        studentQueryWrapper.eq("id",id);
        studentQueryWrapper.eq("pwd",CommonUtils.MD5(pwd));
        return studentMapper.selectOne(studentQueryWrapper);
    }

    @Override
    public Map<String,Object> findByPage(int index, int size) {
        Page<Student> page = new Page<>(index,size);
        IPage<Student> iPage = studentMapper.selectPage(page,null);
        Integer count = studentMapper.selectCount(null);
        List<Student> list = iPage.getRecords();
        Map<String,Object> map = new HashMap<>(2);
        map.put("totalCount",count);
        map.put("list",list);
        return map;
    }

}
