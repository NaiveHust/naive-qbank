package com.naive.service;

import com.naive.domain.Problem;

import java.util.List;
import java.util.Map;

/**
 * @author YechenGu
 * @date 2021/6/28 3:43 下午
 */
public interface QuestionService {
    Problem findById(int proId);

    int updateById(Problem problem);

    int add(Problem problem);

    int deleteById(int proId);

    List<Problem> findBySimple(String simple,int index,int size);

    List<Problem> findByDif(String difficulty,int index,int size);

    List<Problem> findByCla(String c,int index,int size);

    Map<String,Object> findByTea(int tid, int index, int size);

    int deleteByTea(int teaId);
}
