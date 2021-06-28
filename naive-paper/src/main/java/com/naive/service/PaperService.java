package com.naive.service;

import com.naive.domain.Test;

/**
 * @author YechenGu
 * @date 2021/6/28 4:26 下午
 */
public interface PaperService {
    Test findById(int testId);

    int updateById(Test test);

    int add(Test test);

    int deleteById(int stuId);
}
