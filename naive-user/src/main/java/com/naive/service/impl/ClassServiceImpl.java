package com.naive.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.naive.dao.ClassMapper;
import com.naive.dao.RelationMapper;
import com.naive.domain.Class;
import com.naive.domain.Relation;
import com.naive.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YechenGu
 * @date 2021/7/7 11:38 上午
 */
@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassMapper classMapper;

    @Autowired
    private RelationMapper relationMapper;

    @Override
    public int addClass(Class c) {
        return classMapper.insert(c);
    }

    @Override
    public List<Class> findByName(String cname) {
        QueryWrapper<Class> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name",cname);
        return classMapper.selectList(queryWrapper);
    }

    @Override
    public int addRelation(Relation relation) {
        return relationMapper.insert(relation);
    }

    @Override
    public List<Integer> findStu(int cid, int tid) {
        QueryWrapper<Relation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("cid",cid);
        queryWrapper.eq("tid",tid);
        List<Relation> relations = relationMapper.selectList(queryWrapper);
        List<Integer> list = new ArrayList<>();
        for (Relation r:relations){
            list.add(r.getSid());
        }
        return list;
    }

    @Override
    public List<Relation> findClass(int sid) {
        QueryWrapper<Relation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sid",sid);
        return relationMapper.selectList(queryWrapper);
    }
}
