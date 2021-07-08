package com.naive.controller;

import com.naive.config.RabbitMQConfig;
import com.naive.domain.Student;
import com.naive.service.StudentService;
import com.naive.utils.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author YechenGu
 * @date 2021/6/28 10:52 上午
 */
@Api(tags = "学生管理")
@RestController
@CrossOrigin
@RequestMapping("api/v1/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * find student via id
     * */
    @ApiOperation("根据id查询学生")
    @GetMapping("find_by_id/{stuId}")
    public Object findById(@PathVariable("stuId") int stuId){
        if (redisUtils.exists("stuId"+stuId)){
            Object student = redisUtils.get("stuId"+stuId);
            System.out.println("find from cache \n"+student.toString());
            return student;
        }else {
            System.out.println("find from database");
            Object student = studentService.findById(stuId);
            redisUtils.set("stuId"+stuId,student);
            return student;
        }
    }

    /**
     * add student
     * */
    @ApiOperation("添加学生")
    @PostMapping("add")
    public int add(@RequestBody Student student){
        return studentService.add(student);
    }

    /**
     * update student via id
     * */
    @ApiOperation("根据id更新学生")
    @PostMapping("update_by_id")
    public int updateById(@RequestBody Student student){
        redisUtils.remove("stuId"+student.getId());
        return studentService.updateById(student);
    }

    /**
     * delete student via id
     * */
    @ApiOperation("根据id删除学生")
    @GetMapping("delete_by_id/{stuId}")
    public int deleteById(@PathVariable("stuId") int stuId){
        redisUtils.remove("stuId"+stuId);
        rabbitTemplate.convertAndSend(RabbitMQConfig.ITEM_TOPIC_EXCHANGE,"stu.delete",String.valueOf(stuId));
        System.out.println("学生生产者生产消息: "+String.valueOf(stuId));
        return studentService.deleteById(stuId);
    }

    /**
     *
     * @param id
     * @param pwd
     * @return
     */
    @ApiOperation("学生登录校验")
    @GetMapping("check/{id}/{pwd}")
    public Object checkPwd(@PathVariable("id") int id, @PathVariable("pwd") String pwd){
        return studentService.checkPwd(id,pwd);
    }

}
