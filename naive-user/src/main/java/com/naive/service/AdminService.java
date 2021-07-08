package com.naive.service;

import com.naive.domain.Admin;

/**
 * @author YechenGu
 * @date 2021/6/28 3:11 下午
 */
public interface AdminService {
    Admin findById(int adId);

    int updateById(Admin admin);

    int add(Admin admin);

    int deleteById(int adId);

    Admin checkPwd(int id,String pwd);
}
