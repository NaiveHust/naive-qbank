package com.naive.service.impl;

import com.naive.dao.PaperMapper;
import com.naive.domain.Paper;
import com.naive.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YechenGu
 * @date 2021/6/28 4:28 下午
 */
@Service
public class PaperServiceImpl implements PaperService {
    @Autowired
    private PaperMapper paperMapper;

    @Override
    public Paper findBaicInfo(int paperId) {
        return paperMapper.selectById(paperId);
    }

    @Override
    public int updateBasicInfo(Paper paper) {
        return paperMapper.updateById(paper);
    }

    @Override
    public int addBasic(Paper paper) {
        return paperMapper.insert(paper);
    }

    @Override
    public int deleteById(int paperId) {
        int paperRes = paperMapper.deleteById(paperId);
        int relationRes = paperMapper.deleteQuestions(paperId);
        return paperRes & relationRes;
    }

    @Override
    public List<Integer> findQuestions(int paperId) {
        return paperMapper.findQuestions(paperId);
    }

    @Override
    public int addQuestion(int paperId, int proId) {
        return paperMapper.addQuestion(paperId,proId);
    }

    @Override
    public int deleteQuestion(int paperId, int proId) {
        return paperMapper.deleteQuestion(paperId,proId);
    }
}
