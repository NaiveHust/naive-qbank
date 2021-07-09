package com.naive.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.naive.dao.ClassMapper;
import com.naive.dao.RelationMapper;
import com.naive.domain.Class;
import com.naive.domain.Relation;
import com.naive.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
        List<Integer> list1 = new ArrayList<>();
        for (Relation r:relations){
            list.add(r.getSid());
        }
        Set<Integer> set = new HashSet<>();
        set.addAll(list);
        for (Integer i:set){
            list1.add(i);
        }
        return list1;
    }

    @Override
    public List<Integer> findClaByStu(int sid) {
        QueryWrapper<Relation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sid",sid);
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        List<Relation> relations =  relationMapper.selectList(queryWrapper);
        for (Relation r:relations){
            list.add(r.getCid());
        }
        set.addAll(list);
        for (Integer i:set){
            list1.add(i);
        }
        return list1;
    }

    @Override
    public List<Integer> findClaByTea(int tid) {
        QueryWrapper<Relation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tid",tid);
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        List<Relation> relations = relationMapper.selectList(queryWrapper);
        for (Relation r:relations){
            list.add(r.getCid());
        }
        set.addAll(list);
        for (Integer i:set){
            list1.add(i);
        }
        return list1;
    }

    @Override
    public Map<String,Object> findByPage(int index, int size) {
        Page<Class> page = new Page<>(index,size);
        IPage<Class> iPage = classMapper.selectPage(page,null);
        Integer count = classMapper.selectCount(null);
        List<Class> list = iPage.getRecords();
        Map<String,Object> map = new HashMap<>(2);
        map.put("totalCount",count);
        map.put("list",list);
        return map;
    }
}
