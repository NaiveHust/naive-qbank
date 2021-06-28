package com.naive.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @author YechenGu
 * @date 2021/6/28 10:31 上午
 */
public class Admin {
    @TableId(type = IdType.AUTO)
    private int adNo;
    private String adName;
    private String adPwd;

    public int getAdNo() {
        return adNo;
    }

    public void setAdNo(int adNo) {
        this.adNo = adNo;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public String getAdPwd() {
        return adPwd;
    }

    public void setAdPwd(String adPwd) {
        this.adPwd = adPwd;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adNo=" + adNo +
                ", adName='" + adName + '\'' +
                ", adPwd='" + adPwd + '\'' +
                '}';
    }
}
