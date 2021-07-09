package com.naive.service;

import com.naive.domain.Class;
import com.naive.domain.Relation;

import java.util.List;
import java.util.Map;

/**
 * @author YechenGu
 * @date 2021/7/7 11:33 上午
 */
public interface ClassService {
    int addClass(Class c);

    List<Class> findByName(String cname);

    int addRelation(Relation relation);

    Map<String,Object> findStu(int cid,int tid);

    Map<String,Object> findClaByStu(int sid);

    Map<String,Object> findClaByTea(int tid);

    Map<String,Object> findByPage(int index, int size);
}
