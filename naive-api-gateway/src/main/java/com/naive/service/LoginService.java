//package com.naive.service;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
///**
// * @author YechenGu
// * @date 2021/7/5 10:13 上午
// */
//@FeignClient("naive-user")
//public interface LoginService {
//    @GetMapping("api/v1/student/check/{id}/{pwd}")
//    Object checkStu(@PathVariable("id") int id, @PathVariable("pwd") String pwd);
//
//    @GetMapping("api/v1/teacher/check/{id}/{pwd}")
//    Object checkTea(@PathVariable("id") int id, @PathVariable("pwd") String pwd);
//
//    @GetMapping("api/v1/admin/check/{id}/{pwd}")
//    Object checkAd(@PathVariable("id") int id, @PathVariable("pwd") String pwd);
//}
