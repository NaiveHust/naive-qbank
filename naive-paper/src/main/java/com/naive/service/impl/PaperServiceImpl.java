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
    public Paper findById(int paperId) {
        return paperMapper.selectById(paperId);
    }

    @Override
    public int updateById(Paper paper) {
        return paperMapper.updateById(paper);
    }

    @Override
    public int add(Paper paper) {
        return paperMapper.insert(paper);
    }

    @Override
    public int deleteById(int paperId) {
        return paperMapper.deleteById(paperId);
    }

}
