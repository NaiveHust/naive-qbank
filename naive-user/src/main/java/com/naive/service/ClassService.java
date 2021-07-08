package com.naive.service;

import com.naive.domain.Class;
import com.naive.domain.Relation;

import java.util.List;

/**
 * @author YechenGu
 * @date 2021/7/7 11:33 上午
 */
public interface ClassService {
    int addClass(Class c);

    List<Class> findByName(String cname);

    int addRelation(Relation relation);

    List<Integer> findStu(int cid,int tid);

    List<Relation> findClass(int sid);
}
