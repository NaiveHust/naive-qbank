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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<String,Object> findBySimple(String simple,int tid,int index,int size) {
        QueryWrapper<Problem> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("pro_simple",simple);
        queryWrapper.eq("pro_tea",tid);
        Page<Problem> page = new Page<>(index,size);
        IPage<Problem> iPage = questionMapper.selectPage(page,queryWrapper);
        Integer count = questionMapper.selectCount(queryWrapper);
        List<Problem> list = iPage.getRecords();
        Map<String,Object> map = new HashMap<>(2);
        map.put("totalCount",count);
        map.put("list",list);
        return map;
    }

    @Override
    public Map<String,Object> findByDif(String difficulty,int tid,int index,int size) {
        QueryWrapper<Problem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pro_dif",difficulty);
        queryWrapper.eq("pro_tea",tid);
        Page<Problem> page = new Page<>(index,size);
        IPage<Problem> iPage = questionMapper.selectPage(page,queryWrapper);
        Integer count = questionMapper.selectCount(queryWrapper);
        List<Problem> list = iPage.getRecords();
        Map<String,Object> map = new HashMap<>(2);
        map.put("totalCount",count);
        map.put("list",list);
        return map;
    }

    @Override
    public Map<String,Object> findByCla(String c,int tid, int index, int size) {
        QueryWrapper<Problem> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("pro_class",c);
        queryWrapper.eq("pro_tea",tid);
        Page<Problem> page = new Page<>(index,size);
        IPage<Problem> iPage = questionMapper.selectPage(page,queryWrapper);
        Integer count = questionMapper.selectCount(queryWrapper);
        List<Problem> list = iPage.getRecords();
        Map<String,Object> map = new HashMap<>(2);
        map.put("totalCount",count);
        map.put("list",list);
        return map;
    }

    @Override
    public Map<String,Object> findByTea(int tid, int index, int size) {
        QueryWrapper<Problem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pro_tea",tid);
        Page<Problem> page = new Page<>(index,size);
        IPage<Problem> iPage = questionMapper.selectPage(page,queryWrapper);
        Integer count = questionMapper.selectCount(queryWrapper);
        List<Problem> list = iPage.getRecords();
        Map<String,Object> map = new HashMap<>(2);
        map.put("totalCount",count);
        map.put("list",list);
        return map;
    }

    @Override
    public int deleteByTea(int teaId) {
        QueryWrapper<Problem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("pro_tea",teaId);
        questionMapper.delete(queryWrapper);
        return 0;
    }
}
