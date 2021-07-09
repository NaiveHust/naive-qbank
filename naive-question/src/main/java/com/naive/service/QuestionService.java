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

    Map<String,Object> findBySimple(String simple,int tid,int index,int size);

    Map<String,Object> findByDif(String difficulty,int tid,int index,int size);

    Map<String,Object> findByCla(String c,int tid,int index,int size);

    Map<String,Object> findByTea(int tid, int index, int size);

    int deleteByTea(int teaId);

    Map<String,Object> findByPage(int index, int size);
}
