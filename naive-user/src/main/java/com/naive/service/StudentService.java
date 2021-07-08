package com.naive.service;

import com.naive.domain.Student;

import java.util.List;

/**
 * @author YechenGu
 * @date 2021/6/28 10:49 上午
 */
public interface StudentService {
    Student findById(int stuId);

    int updateById(Student student);

    int add(Student student);

    int deleteById(int stuId);

    Student checkPwd(int id,String pwd);
}
