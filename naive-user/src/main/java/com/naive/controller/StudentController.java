package com.naive.controller;

import com.naive.domain.Student;
import com.naive.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author YechenGu
 * @date 2021/6/28 10:52 上午
 */
@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * find student via id
     * */
    @RequestMapping("find_by_id")
    public Object findById(@RequestParam("stuId") int stuId){
        return studentService.findById(stuId);
    }

    /**
     * add student via id
     * */
    @PostMapping("add")
    public int add(@RequestBody Student student){
        System.out.println(student.toString());
        return studentService.add(student);
    }

    /**
     * update student via id
     * */
    @PostMapping("update_by_id")
    public int updateById(@RequestBody Student student){
        System.out.println(student.toString());
        return studentService.updateById(student);
    }

    /**
     * delete student via id
     * */
    @RequestMapping("delete_by_id")
    public int deleteById(@RequestParam("stuId") int stuId){
        return studentService.deleteById(stuId);
    }
}
