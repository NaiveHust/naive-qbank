package com.naive.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.naive.dao.TeacherMapper;
import com.naive.domain.Teacher;
import com.naive.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Teacher checkPwd(int id, String pwd) {
        QueryWrapper<Teacher> teacherQueryWrapper = new QueryWrapper<>();
        teacherQueryWrapper.eq("id",id);
        teacherQueryWrapper.eq("pwd",pwd);
        return teacherMapper.selectOne(teacherQueryWrapper);
    }

    @Override
    public Map<String,Object> findByPage(int index, int size) {
        Page<Teacher> page = new Page<>(index,size);
        IPage<Teacher> iPage = teacherMapper.selectPage(page,null);
        Integer count = teacherMapper.selectCount(null);
        List<Teacher> list = iPage.getRecords();
        Map<String,Object> map = new HashMap<>(2);
        map.put("totalCount",count);
        map.put("list",list);
        return map;
    }

}
