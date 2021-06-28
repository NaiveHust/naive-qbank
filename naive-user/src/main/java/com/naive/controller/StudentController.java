package com.naive.controller;

import com.naive.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YechenGu
 * @date 2021/6/28 10:52 上午
 */
@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("find_by_id")
    public Object findById(@RequestParam("stuId") int stuId){
        return studentService.findById(stuId);
    }

    // TODO: add,delete,update
}
