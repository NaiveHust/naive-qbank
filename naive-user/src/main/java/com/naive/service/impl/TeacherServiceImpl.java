package com.naive.service.impl;

import com.naive.dao.TeacherMapper;
import com.naive.domain.Teacher;
import com.naive.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YechenGu
 * @date 2021/6/28 3:12 下午
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Teacher findById(int teaId) {
        return teacherMapper.selectById(teaId);
    }

    @Override
    public int updateById(Teacher teacher) {
        return teacherMapper.updateById(teacher);
    }

    @Override
    public int add(Teacher teacher) {
        return teacherMapper.insert(teacher);
    }

    @Override
    public int deleteById(int teaId) {
        return teacherMapper.deleteById(teaId);
    }
}
