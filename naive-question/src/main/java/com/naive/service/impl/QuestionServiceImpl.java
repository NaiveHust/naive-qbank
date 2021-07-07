package com.naive.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.naive.dao.QuestionMapper;
import com.naive.domain.Problem;
import com.naive.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YechenGu
 * @date 2021/6/28 3:45 下午
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public Problem findById(int proId) {
        return questionMapper.selectById(proId);
    }

    @Override
    public int updateById(Problem problem) {
        return questionMapper.updateById(problem);
    }

    @Override
    public int add(Problem problem) {
        return questionMapper.insert(problem);
    }

    @Override
    public int deleteById(int proId) {
        return questionMapper.deleteById(proId);
    }

    @Override
    public List<Problem> findByCha(String chapter,int index,int size) {
        QueryWrapper<Problem> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("pro_cha",chapter);
        Page<Problem> page = new Page<>(index,size);
        IPage<Problem> iPage = questionMapper.selectPage(page,queryWrapper);
        return iPage.getRecords();
    }

    @Override
    public List<Problem> findBySimple(String simple,int index,int size) {
        QueryWrapper<Problem> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("pro_simple",simple);
        Page<Problem> page = new Page<>(index,size);
        IPage<Problem> iPage = questionMapper.selectPage(page,queryWrapper);
        return iPage.getRecords();
    }

    @Override
    public List<Problem> findByDif(String difficulty,int index,int size) {
        QueryWrapper<Problem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pro_dif",difficulty);
        Page<Problem> page = new Page<>(index,size);
        IPage<Problem> iPage = questionMapper.selectPage(page,queryWrapper);
        return iPage.getRecords();
    }

    @Override
    public List<Problem> findByCla(String c, int index, int size) {
        QueryWrapper<Problem> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("pro_class",c);
        Page<Problem> page = new Page<>(index,size);
        IPage<Problem> iPage = questionMapper.selectPage(page,queryWrapper);
        return iPage.getRecords();
    }

    @Override
    public List<Problem> findByTea(int tid, int index, int size) {
        QueryWrapper<Problem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pro_tea",tid);
        Page<Problem> page = new Page<>(index,size);
        IPage<Problem> iPage = questionMapper.selectPage(page,queryWrapper);
        return iPage.getRecords();
    }
}
