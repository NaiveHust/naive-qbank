package com.naive.controller;

import com.naive.domain.Class;
import com.naive.domain.Relation;
import com.naive.service.ClassService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author YechenGu
 * @date 2021/7/7 11:45 上午
 */
@Api(tags = "课程管理")
@RestController
@CrossOrigin
@RequestMapping("api/v1/class")
public class ClassController {
    @Autowired
    ClassService classService;

    @ApiOperation("添加课程")
    @PostMapping("addClass")
    public int addClass(@RequestBody Class c){
        return classService.addClass(c);
    }

    @ApiOperation("根据课程名查找课程")
    @GetMapping("findByName/{name}")
    public List<Class> findByName(@PathVariable("name") String name){
        return classService.findByName(name);
    }

    @ApiOperation("学生选课")
    @PostMapping("choose_lesson")
    public int chooseClass(@RequestBody Relation relation){
        return classService.addRelation(relation);
    }

    @ApiOperation("查找学生")
    @GetMapping("findStu/{cid}/{tid}")
    public List<Integer> findStu(@PathVariable("cid") int cid,@PathVariable("tid") int tid){
        return classService.findStu(cid,tid);
    }

    @ApiOperation("查找课程")
    @GetMapping("findClass/{sid}")
    public List<Relation> findClass(@PathVariable("sid") int sid){
        return classService.findClass(sid);
    }
    
}
