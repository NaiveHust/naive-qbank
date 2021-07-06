package com.naive.service;

import com.naive.domain.Class;

import java.util.List;

/**
 * @author YechenGu
 * @date 2021/7/1 9:10 上午
 */
public interface ClassService {
    int add(Class cla);

    List<Class> findByTea(int teaId);

    List<Class> findByStu(int stuId);

    List<Integer> findStu(int classId);

    List<Integer> findTea(int classId);
}
