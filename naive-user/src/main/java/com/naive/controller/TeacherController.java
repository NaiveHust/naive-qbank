package com.naive.controller;

import com.naive.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YechenGu
 * @date 2021/6/28 3:16 下午
 */
@RestController
@RequestMapping("api/v1/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("find_by_id")
    public Object findById(@RequestParam("teaId") int teaId){
        return teacherService.findById(teaId);
    }

    // TODO: add,delete,update
}
