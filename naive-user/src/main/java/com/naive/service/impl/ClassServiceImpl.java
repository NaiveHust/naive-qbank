package com.naive.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.naive.dao.ClassMapper;
import com.naive.dao.RelationMapper;
import com.naive.dao.StudentMapper;
import com.naive.domain.Class;
import com.naive.domain.Relation;
import com.naive.domain.Student;
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

    @Autowired
    private StudentMapper studentMapper;

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
    public Map<String,Object> findStu(int cid, int tid) {
        QueryWrapper<Relation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("cid",cid);
        queryWrapper.eq("tid",tid);
        // find suitable relation
        List<Relation> relations = relationMapper.selectList(queryWrapper);
        List<Integer> list = new ArrayList<>();
        // get needed sid
        for (Relation r:relations){
            list.add(r.getSid());
        }
        Set<Integer> set = new HashSet<>();
        // remove duplicated ones
        set.addAll(list);
        Integer count = set.size();
        // find students
        List<Student> list1 = studentMapper.selectBatchIds(set);
        Map<String,Object> map = new HashMap<>(2);
        map.put("totalCount",count);
        map.put("list",list1);
        return map;
    }

    @Override
    public Map<String,Object> findClaByStu(int sid) {
        QueryWrapper<Relation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sid",sid);
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        // find suitable relation
        List<Relation> relations =  relationMapper.selectList(queryWrapper);
        // get needed cid
        for (Relation r:relations){
            list.add(r.getCid());
        }
        // remove duplicated ones
        set.addAll(list);
        Integer count = set.size();
        // find classes
        List<Class> list1 = classMapper.selectBatchIds(set);
        Map<String,Object> map = new HashMap<>(2);
        map.put("totalCount",count);
        map.put("list",list1);
        return map;
    }

    @Override
    public Map<String,Object> findClaByTea(int tid) {
        QueryWrapper<Class> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tid",tid);
        Set<Integer> set = new HashSet<>();
        List<Class> classes = classMapper.selectList(queryWrapper);
        List<Integer> list = new ArrayList<>();
        for (Class c:classes){
            list.add(c.getId());
        }
        set.addAll(list);
        Integer count = set.size();
        List<Class> list1 = classMapper.selectBatchIds(set);
        Map<String,Object> map = new HashMap<>(2);
        map.put("totalCount",count);
        map.put("list",list1);
        return map;
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
