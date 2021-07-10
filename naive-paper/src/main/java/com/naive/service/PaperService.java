package com.naive.service;

import com.naive.domain.Paper;

import java.util.List;
import java.util.Map;

/**
 * @author YechenGu
 * @date 2021/6/28 4:26 下午
 */
public interface PaperService {
    Paper findById(int paperId);

    int updateById(Paper paper);

    int add(Paper paper);

    int deleteById(int paperId);

    Map<String,Object> findByCla(String c, int index, int size);

    Map<String,Object> findByTea(int tid,int index,int size);

    Map<String,Object> findByClaAndTea(String c,int tid, int index, int size);

    int deleteByTea(int tid);

    Map<String,Object> findByPage(int index, int size);
}
