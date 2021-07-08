package com.naive.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.naive.dao.PaperMapper;
import com.naive.domain.Paper;
import com.naive.domain.Problem;
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

    @Override
    public List<Paper> findByCla(String c, int index, int size) {
        QueryWrapper<Paper> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("paper_class",c);
        Page<Paper> page = new Page<>(index,size);
        IPage<Paper> iPage = paperMapper.selectPage(page,queryWrapper);
        return iPage.getRecords();
    }

    @Override
    public List<Paper> findByTea(int tid, int index, int size) {
        QueryWrapper<Paper> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("paper_tea",tid);
        Page<Paper> page = new Page<>(index,size);
        IPage<Paper> iPage = paperMapper.selectPage(page,queryWrapper);
        return iPage.getRecords();
    }

    @Override
    public int deleteByTea(int tid) {
        QueryWrapper<Paper> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("paper_tea",tid);
        return paperMapper.delete(queryWrapper);
    }

}
