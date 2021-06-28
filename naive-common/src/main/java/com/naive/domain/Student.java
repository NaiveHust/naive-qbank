package com.naive.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @author YechenGu
 * @date 2021/6/28 10:26 上午
 */
public class Student {
    @TableId(type = IdType.AUTO)
    private int stuNo;
    private String stuName;
    private String stuPwd;
    private String stuDiscipline;
    private String stuGrade;

    public int getStuNo() {
        return stuNo;
    }

    public void setStuNo(int stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuPwd() {
        return stuPwd;
    }

    public void setStuPwd(String stuPwd) {
        this.stuPwd = stuPwd;
    }

    public String getStuDiscipline() {
        return stuDiscipline;
    }

    public void setStuDiscipline(String stuDiscipline) {
        this.stuDiscipline = stuDiscipline;
    }

    public String getStuGrade() {
        return stuGrade;
    }

    public void setStuGrade(String stuGrade) {
        this.stuGrade = stuGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNo=" + stuNo +
                ", stuName='" + stuName + '\'' +
                ", stuPwd='" + stuPwd + '\'' +
                ", stuDiscipline='" + stuDiscipline + '\'' +
                ", stuGrade='" + stuGrade + '\'' +
                '}';
    }
}
