package com.naive.controller;

import com.naive.domain.Admin;
import com.naive.domain.Student;
import com.naive.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author YechenGu
 * @date 2021/6/28 3:17 下午
 */
@RestController
@RequestMapping("api/v1/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * find admin via id
     * */
    @RequestMapping("find_by_id")
    public Object findById(@RequestParam("adId") int adId){
        return adminService.findById(adId);
    }

    /**
     * add admin via id
     * */
    @PostMapping("add")
    public int add(@RequestBody Admin admin){
        System.out.println(admin.toString());
        return adminService.add(admin);
    }

    /**
     * update admin via id
     * */
    @PostMapping("update_by_id")
    public int updateById(@RequestBody Admin admin){
        System.out.println(admin.toString());
        return adminService.updateById(admin);
    }

    /**
     * delete admin via id
     * */
    @RequestMapping("delete_by_id")
    public int deleteById(@RequestParam("adId") int adId){
        return adminService.deleteById(adId);
    }
}
