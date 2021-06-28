package com.naive.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @author YechenGu
 * @date 2021/6/28 10:29 上午
 */
public class Teacher {
    @TableId(type = IdType.AUTO)
    private int teaNo;
    private String teaName;
    private String teaPwd;
    private String teaDiscipline;
    private String teaMail;

    public int getTeaNo() {
        return teaNo;
    }

    public void setTeaNo(int teaNo) {
        this.teaNo = teaNo;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public String getTeaPwd() {
        return teaPwd;
    }

    public void setTeaPwd(String teaPwd) {
        this.teaPwd = teaPwd;
    }

    public String getTeaDiscipline() {
        return teaDiscipline;
    }

    public void setTeaDiscipline(String teaDiscipline) {
        this.teaDiscipline = teaDiscipline;
    }

    public String getTeaMail() {
        return teaMail;
    }

    public void setTeaMail(String teaMail) {
        this.teaMail = teaMail;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teaNo=" + teaNo +
                ", teaName='" + teaName + '\'' +
                ", teaPwd='" + teaPwd + '\'' +
                ", teaDiscipline='" + teaDiscipline + '\'' +
                ", teaMail='" + teaMail + '\'' +
                '}';
    }
}
