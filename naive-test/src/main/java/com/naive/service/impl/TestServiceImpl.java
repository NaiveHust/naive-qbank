package com.naive.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.naive.dao.TestMapper;
import com.naive.domain.Test;
import com.naive.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YechenGu
 * @date 2021/6/30 5:12 下午
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;

    @Override
    public int add(Test test) {
        return testMapper.insert(test);
    }

    @Override
    public Test findStuAnswer(int stuNo, int paperNo) {
        QueryWrapper<Test> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("stu_no",stuNo);
        queryWrapper.eq("paper_no",paperNo);
        return testMapper.selectOne(queryWrapper);
    }

    @Override
    public int update(Test test) {
        return testMapper.updateById(test);
    }

    @Override
    public int deleteByStu(int stuId) {
        QueryWrapper<Test> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("stu_no",stuId);
        return testMapper.delete(queryWrapper);
    }

    @Override
    public int deleteByPaper(int pid) {
        QueryWrapper<Test> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("paper_no",pid);
        return testMapper.delete(queryWrapper);
    }
}
