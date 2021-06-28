package com.naive.service.impl;

import com.naive.dao.PaperMapper;
import com.naive.domain.Test;
import com.naive.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YechenGu
 * @date 2021/6/28 4:28 下午
 */
@Service
public class PaperServiceImpl implements PaperService {
    @Autowired
    private PaperMapper paperMapper;

    @Override
    public Test findById(int testId) {
        return null;
    }

    @Override
    public int updateById(Test test) {
        return 0;
    }

    @Override
    public int add(Test test) {
        return 0;
    }

    @Override
    public int deleteById(int stuId) {
        return 0;
    }
}
