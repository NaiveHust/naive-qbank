package com.naive.service;

import com.naive.domain.Problem;

import java.util.List;

/**
 * @author YechenGu
 * @date 2021/6/28 3:43 下午
 */
public interface QuestionService {
    Problem findById(int proId);

    int updateById(Problem problem);

    int add(Problem problem);

    int deleteById(int proId);

    List<Problem> findByCha(String chapter,int index,int size);

    List<Problem> findByKeyw(String keyword,int index,int size);

    List<Problem> findByDif(String difficulty,int index,int size);
}
