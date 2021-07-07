package com.naive.service;

import com.naive.domain.Teacher;

import java.util.List;

/**
 * @author YechenGu
 * @date 2021/6/28 3:10 下午
 */
public interface TeacherService {
    Teacher findById(int teaId);

    int updateById(Teacher teacher);

    int add(Teacher teacher);

    int deleteById(int teaId);

    Teacher checkPwd(int id, String pwd);
}
