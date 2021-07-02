package com.naive.controller;

import com.naive.domain.Admin;
import com.naive.service.AdminService;
import com.naive.utils.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author YechenGu
 * @date 2021/6/28 3:17 下午
 */
@Api(tags = "管理员管理")
@RestController
@RequestMapping("api/v1/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private RedisUtils redisUtils;

    /**
     * find admin via id
     * */
    @ApiOperation("根据id查询管理员")
    @GetMapping("find_by_id/{adId}")
    public Object findById(@PathVariable("adId") int adId){
        if (redisUtils.exists("adId"+adId)){
            Object admin = redisUtils.get("adId"+adId);
            System.out.println("find from cache \n"+admin.toString());
            return admin;
        }else {
            System.out.println("find from database");
            Object admin = adminService.findById(adId);
            redisUtils.set("adId"+adId,admin);
            return admin;
        }
    }

    /**
     * add admin
     * */
    @ApiOperation("添加管理员")
    @PostMapping("add")
    public int add(@RequestBody Admin admin){
        return adminService.add(admin);
    }

    /**
     * update admin via id
     * */
    @ApiOperation("根据id更新管理员")
    @PostMapping("update_by_id")
    public int updateById(@RequestBody Admin admin){
        redisUtils.remove("adId"+admin.getAdNo());
        return adminService.updateById(admin);
    }

    /**
     * delete admin via id
     * */
    @ApiOperation("根据id删除管理员")
    @GetMapping("delete_by_id/{adId}")
    public int deleteById(@PathVariable("adId") int adId){
        redisUtils.remove("adId"+adId);
        return adminService.deleteById(adId);
    }
}
