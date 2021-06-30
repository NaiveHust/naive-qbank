package com.naive.service;

import com.naive.domain.Paper;

import java.util.List;

/**
 * @author YechenGu
 * @date 2021/6/28 4:26 下午
 */
public interface PaperService {
    Paper findBaicInfo(int paperId);

    int updateBasicInfo(Paper paper);

    int addBasic(Paper paper);

    int deleteById(int paperId);

    List<Integer> findQuestions(int paperId);

    int addQuestion(int paperId,int proId);

    int deleteQuestion(int paperId,int proId);
}
