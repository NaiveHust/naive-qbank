package com.naive.controller;

import com.naive.domain.Student;
import com.naive.domain.Teacher;
import com.naive.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author YechenGu
 * @date 2021/6/28 3:16 下午
 */
@RestController
@RequestMapping("api/v1/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    /**
     * find admin via id
     * */
    @RequestMapping("find_by_id")
    public Object findById(@RequestParam("teaId") int teaId){
        return teacherService.findById(teaId);
    }

    /**
     * add teacher via id
     * */
    @PostMapping("add")
    public int add(@RequestBody Teacher teacher){
        System.out.println(teacher.toString());
        return teacherService.add(teacher);
    }

    /**
     * update teacher via id
     * */
    @PostMapping("update_by_id")
    public int updateById(@RequestBody Teacher teacher){
        System.out.println(teacher.toString());
        return teacherService.updateById(teacher);
    }

    /**
     * delete teacher via id
     * */
    @RequestMapping("delete_by_id")
    public int deleteById(@RequestParam("teaId") int teaId){
        return teacherService.deleteById(teaId);
    }
}
