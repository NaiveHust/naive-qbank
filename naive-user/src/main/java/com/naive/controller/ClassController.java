package com.naive.controller;

import com.naive.domain.Class;
import com.naive.service.ClassService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author YechenGu
 * @date 2021/7/1 9:23 上午
 */
@Api(tags = "课程管理")
@RestController
@RequestMapping("api/v1/class")
public class ClassController {
    @Autowired
    private ClassService classService;

    @ApiOperation("添加学生到课程")
    @PostMapping("addStuToCla")
    public int addStudentToClass(@RequestBody Class cla){
        return classService.add(cla);
    }

    @ApiOperation("根据教师id查询课程")
    @GetMapping("tea_class/{teaId}")
    public Object findClaByTea(@PathVariable("teaId") int teaId){
        return classService.findByTea(teaId);
    }

    @ApiOperation("根据学生id查询课程")
    @GetMapping("stu_class/{stuId}")
    public Object findClaByStu(@PathVariable("stuId") int stuId){
        return classService.findByStu(stuId);
    }
}
