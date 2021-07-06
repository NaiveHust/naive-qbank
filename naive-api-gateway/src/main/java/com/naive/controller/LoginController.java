//package com.naive.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author YechenGu
// * @date 2021/7/5 10:12 上午
// */
//@RestController
//@RequestMapping("api/v1/login")
//public class LoginController {
//    @Autowired
//    private LoginController loginController;
//
//    @GetMapping("student/{id}/{pwd}")
//    Object checkStu(@PathVariable("id") int id, @PathVariable("pwd") String pwd){
//        return loginController.checkStu(id,pwd);
//    }
//
//    @GetMapping("teacher/{id}/{pwd}")
//    Object checkTea(@PathVariable("id") int id, @PathVariable("pwd") String pwd){
//        return loginController.checkTea(id,pwd);
//    }
//
//    @GetMapping("admin/{id}/{pwd}")
//    Object checkAd(@PathVariable("id") int id, @PathVariable("pwd") String pwd){
//        return loginController.checkAd(id,pwd);
//    }
//}
