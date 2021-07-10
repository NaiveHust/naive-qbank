package com.naive.service;

import com.naive.domain.Student;

import java.util.List;
import java.util.Map;

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

    Map<String,Object> findByDis(String dis,int index, int size);

    Map<String,Object> findByGra(String gra,int index, int size);

    Map<String,Object> findByPage(int index, int size);
}
