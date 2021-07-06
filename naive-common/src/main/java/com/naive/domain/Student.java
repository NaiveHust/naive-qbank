package com.naive.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @author YechenGu
 * @date 2021/6/28 10:26 上午
 */
public class Student extends User{
    private String discipline;
    private String grade;

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "discipline='" + discipline + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
