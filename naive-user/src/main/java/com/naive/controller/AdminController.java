package com.naive.controller;

import com.naive.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YechenGu
 * @date 2021/6/28 3:17 下午
 */
@RestController
@RequestMapping("api/v1/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("find_by_id")
    public Object findById(@RequestParam("adId") int adId){
        return adminService.findById(adId);
    }

    // TODO: add,delete,update
}
