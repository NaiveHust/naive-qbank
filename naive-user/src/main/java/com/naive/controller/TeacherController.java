package com.naive.controller;

import com.naive.domain.Teacher;
import com.naive.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author YechenGu
 * @date 2021/6/28 3:16 下午
 */
@Api(tags = "教师管理")
@RestController
@RequestMapping("api/v1/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    /**
     * find admin via id
     * */
    @ApiOperation("根据id查询教师")
    @GetMapping("find_by_id/{teaId}")
    public Object findById(@PathVariable("teaId") int teaId){
        return teacherService.findById(teaId);
    }

    /**
     * add teacher
     * */
    @ApiOperation("添加教师")
    @PostMapping("add")
    public int add(@RequestBody Teacher teacher){
        System.out.println(teacher.toString());
        return teacherService.add(teacher);
    }

    /**
     * update teacher via id
     * */
    @ApiOperation("根据id更新教师")
    @PostMapping("update_by_id")
    public int updateById(@RequestBody Teacher teacher){
        System.out.println(teacher.toString());
        return teacherService.updateById(teacher);
    }

    /**
     * delete teacher via id
     * */
    @ApiOperation("根据id删除教师")
    @GetMapping("delete_by_id/{teaId}")
    public int deleteById(@PathVariable("teaId") int teaId){
        return teacherService.deleteById(teaId);
    }

}
