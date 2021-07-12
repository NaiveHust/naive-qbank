package com.naive.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.naive.dao.AdminMapper;
import com.naive.domain.Admin;
import com.naive.domain.Student;
import com.naive.service.AdminService;
import com.naive.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YechenGu
 * @date 2021/6/28 3:14 下午
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin findById(int adId) {
        return adminMapper.selectById(adId);
    }

    @Override
    public int updateById(Admin admin) {
        if (admin.getPwd() != null){
            String pwd = CommonUtils.MD5(admin.getPwd());
            admin.setPwd(pwd);
        }
        return adminMapper.updateById(admin);
    }

    @Override
    public int add(Admin admin) {
        String pwd = CommonUtils.MD5(admin.getPwd());
        admin.setPwd(pwd);
        return adminMapper.insert(admin);
    }

    @Override
    public int deleteById(int adId) {
        return adminMapper.deleteById(adId);
    }

    @Override
    public Admin checkPwd(int id, String pwd) {
        QueryWrapper<Admin> adminQueryWrapper = new QueryWrapper<>();
        adminQueryWrapper.eq("id",id);
        adminQueryWrapper.eq("pwd",CommonUtils.MD5(pwd));
        return adminMapper.selectOne(adminQueryWrapper);
    }
}
