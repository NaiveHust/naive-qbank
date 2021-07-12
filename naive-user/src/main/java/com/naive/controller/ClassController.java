package com.naive.controller;

import com.naive.domain.Class;
import com.naive.domain.Relation;
import com.naive.service.ClassService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @ApiOperation("分页查找学生")
    @GetMapping("findStu/{cid}/{tid}/{index}/{size}")
    public Map<String,Object> findStu(@PathVariable("cid") int cid,
                                      @PathVariable("tid") int tid,
                                      @PathVariable("index") int index,
                                      @PathVariable("size") int size){
        return classService.findStu(cid,tid,index,size);
    }

    @ApiOperation("根据学生分页查找课程")
    @GetMapping("findClaByStu/{sid}/{index}/{size}")
    public Map<String,Object> findClaByStu(@PathVariable("sid") int sid,
                                           @PathVariable("index") int index,
                                           @PathVariable("size") int size){
        return classService.findClaByStu(sid,index,size);
    }

    @ApiOperation("根据教师分页查找课程")
    @GetMapping("findClaByTea/{tid}/{index}/{size}")
    public Map<String,Object> findClaByTea(@PathVariable("tid") int tid,
                                           @PathVariable("index") int index,
                                           @PathVariable("size") int size){
        return classService.findClaByTea(tid,index,size);
    }

    @ApiOperation("管理员分页查找课程")
    @GetMapping("findByPage/{index}/{size}")
    public Map<String,Object> findByPage(@PathVariable("index") int index,
                                         @PathVariable("size") int size){
        return classService.findByPage(index,size);
    }
}
