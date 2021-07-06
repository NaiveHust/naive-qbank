package com.naive.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.naive.dao.ClassMapper;
import com.naive.domain.Class;
import com.naive.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YechenGu
 * @date 2021/7/1 9:12 上午
 */
@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassMapper classMapper;

    @Override
    public int add(Class cla) {
        return classMapper.insert(cla);
    }

    @Override
    public List<Class> findByTea(int teaId) {
        QueryWrapper<Class> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tea_no",teaId);
        return classMapper.selectList(queryWrapper);
    }

    @Override
    public List<Class> findByStu(int stuId) {
        QueryWrapper<Class> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("stu_no",stuId);
        return classMapper.selectList(queryWrapper);
    }

    @Override
    public List<Integer> findStu(int classId) {
        QueryWrapper<Class> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("class_no",classId);
        List<Class> list = classMapper.selectList(queryWrapper);
        List<Integer> list1 = new ArrayList<>();
        for (Class c:list){
            list1.add(c.getStuNo());
        }
        return list1;
    }

    @Override
    public List<Integer> findTea(int classId) {
        QueryWrapper<Class> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("class_no",classId);
        List<Class> list = classMapper.selectList(queryWrapper);
        List<Integer> list1 = new ArrayList<>();
        for (Class c:list){
            list1.add(c.getTeaNo());
        }
        return list1;
    }
}
