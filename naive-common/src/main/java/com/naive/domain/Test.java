package com.naive.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

/**
 * @author YechenGu
 * @date 2021/6/28 10:38 上午
 */
public class Test {
    @TableId(type = IdType.AUTO)
    private int testNo;
    private String testName;
    private Date testTime;
    private String testType;
    private String testDif;
    private int testScore;

    public int getTestNo() {
        return testNo;
    }

    public void setTestNo(int testNo) {
        this.testNo = testNo;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Date getTestTime() {
        return testTime;
    }

    public void setTestTime(Date testTime) {
        this.testTime = testTime;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getTestDif() {
        return testDif;
    }

    public void setTestDif(String testDif) {
        this.testDif = testDif;
    }

    public int getTestScore() {
        return testScore;
    }

    public void setTestScore(int testScore) {
        this.testScore = testScore;
    }

    @Override
    public String toString() {
        return "Test{" +
                "testNo=" + testNo +
                ", testName='" + testName + '\'' +
                ", testTime=" + testTime +
                ", testType='" + testType + '\'' +
                ", testDif='" + testDif + '\'' +
                ", testScore=" + testScore +
                '}';
    }
}
