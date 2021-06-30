package com.naive.domain;

/**
 * @author YechenGu
 * @date 2021/6/30 5:04 下午
 */
public class Class {
    private int classNo;
    private String className;

    public int getClassNo() {
        return classNo;
    }

    public void setClassNo(int classNo) {
        this.classNo = classNo;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Class{" +
                "classNo=" + classNo +
                ", className='" + className + '\'' +
                '}';
    }
}
