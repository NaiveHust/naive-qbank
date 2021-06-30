package com.naive.service;

import com.naive.domain.Test;

/**
 * @author YechenGu
 * @date 2021/6/30 5:11 下午
 */
public interface TestService {
    int add(Test test);

    Test findStuAnswer(int stuNo,int paperNo);

    int update(Test test);
}
