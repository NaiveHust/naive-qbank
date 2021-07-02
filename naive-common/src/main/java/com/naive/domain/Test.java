package com.naive.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @author YechenGu
 * @date 2021/6/30 5:07 下午
 */
public class Test {
    @TableId(type = IdType.AUTO)
    private Integer testNo;
    private Integer stuNo;
    private Integer paperNo;
    private String stuAnswer;
    private Integer isRead;

    public Integer getTestNo() {
        return testNo;
    }

    public void setTestNo(Integer testNo) {
        this.testNo = testNo;
    }

    public Integer getStuNo() {
        return stuNo;
    }

    public void setStuNo(Integer stuNo) {
        this.stuNo = stuNo;
    }

    public Integer getPaperNo() {
        return paperNo;
    }

    public void setPaperNo(Integer paperNo) {
        this.paperNo = paperNo;
    }

    public String getStuAnswer() {
        return stuAnswer;
    }

    public void setStuAnswer(String stuAnswer) {
        this.stuAnswer = stuAnswer;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    @Override
    public String toString() {
        return "Test{" +
                "testNo=" + testNo +
                ", stuNo=" + stuNo +
                ", paperNo=" + paperNo +
                ", stuAnswer='" + stuAnswer + '\'' +
                ", isRead=" + isRead +
                '}';
    }
}
