package com.naive.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.naive.dao.StudentMapper;
import com.naive.domain.Student;
import com.naive.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return studentMapper.updateById(student);
    }

    /**
     * add student via id
     * */
    @Override
    public int add(Student student) {
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
        studentQueryWrapper.eq("stu_no",id);
        studentQueryWrapper.eq("stu_pwd",pwd);
        return studentMapper.selectOne(studentQueryWrapper);
    }

}
