package com.naive.controller;

import com.naive.domain.Student;
import com.naive.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author YechenGu
 * @date 2021/6/28 10:52 上午
 */
@Api(tags = "学生管理")
@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * find student via id
     * */
    @ApiOperation("根据id查询学生")
    @GetMapping("find_by_id/{stuId}")
    public Object findById(@PathVariable("stuId") int stuId){
        return studentService.findById(stuId);
    }

    /**
     * add student
     * */
    @ApiOperation("添加学生")
    @PostMapping("add")
    public int add(@RequestBody Student student){
        System.out.println(student.toString());
        return studentService.add(student);
    }

    /**
     * update student via id
     * */
    @ApiOperation("根据id更新学生")
    @PostMapping("update_by_id")
    public int updateById(@RequestBody Student student){
        System.out.println(student.toString());
        return studentService.updateById(student);
    }

    /**
     * delete student via id
     * */
    @ApiOperation("根据id删除学生")
    @GetMapping("delete_by_id/{stu_id}")
    public int deleteById(@PathVariable("stuId") int stuId){
        return studentService.deleteById(stuId);
    }
}
