package com.naive.service;

import com.naive.domain.Paper;

import java.util.List;

/**
 * @author YechenGu
 * @date 2021/6/28 4:26 下午
 */
public interface PaperService {
    Paper findById(int paperId);

    int updateById(Paper paper);

    int add(Paper paper);

    int deleteById(int paperId);
}
