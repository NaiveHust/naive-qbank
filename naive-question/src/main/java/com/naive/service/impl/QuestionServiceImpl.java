package com.naive.service.impl;

import com.naive.dao.QuestionMapper;
import com.naive.domain.Problem;
import com.naive.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
