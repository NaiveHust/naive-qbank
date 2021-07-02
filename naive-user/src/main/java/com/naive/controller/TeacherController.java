package com.naive.controller;

import com.naive.domain.Teacher;
import com.naive.service.TeacherService;
import com.naive.utils.RedisUtils;
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

    @Autowired
    private RedisUtils redisUtils;

    /**
     * find teacher via id
     * */
    @ApiOperation("根据id查询教师")
    @GetMapping("find_by_id/{teaId}")
    public Object findById(@PathVariable("teaId") int teaId){
        if (redisUtils.exists("teaId"+teaId)){
            Object teacher = redisUtils.get("teaId"+teaId);
            System.out.println("find from cache \n"+teacher.toString());
            return teacher;
        }else {
            System.out.println("find from database");
            Object teacher = teacherService.findById(teaId);
            redisUtils.set("teaId"+teaId,teacher);
            return teacher;
        }
    }

    /**
     * add teacher
     * */
    @ApiOperation("添加教师")
    @PostMapping("add")
    public int add(@RequestBody Teacher teacher){
        return teacherService.add(teacher);
    }

    /**
     * update teacher via id
     * */
    @ApiOperation("根据id更新教师")
    @PostMapping("update_by_id")
    public int updateById(@RequestBody Teacher teacher){
        redisUtils.remove("teaId"+teacher.getTeaNo());
        return teacherService.updateById(teacher);
    }

    /**
     * delete teacher via id
     * */
    @ApiOperation("根据id删除教师")
    @GetMapping("delete_by_id/{teaId}")
    public int deleteById(@PathVariable("teaId") int teaId){
        redisUtils.remove("teaId"+teaId);
        return teacherService.deleteById(teaId);
    }

    /**
     *
     * @param id
     * @param pwd
     * @return
     */
    @ApiOperation("教师登录校验")
    @GetMapping("check/{id}/{pwd}")
    public Object checkPwd(@PathVariable("id") int id, @PathVariable("pwd") String pwd){
        return teacherService.checkPwd(id,pwd);
    }

}
