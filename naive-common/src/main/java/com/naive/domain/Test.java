package com.naive.domain;

/**
 * @author YechenGu
 * @date 2021/6/30 5:07 下午
 */
public class Test {
    private int testNo;
    private int stuNo;
    private int paperNo;
    private String stuAnswer;
    private int isRead;

    public int getTestNo() {
        return testNo;
    }

    public void setTestNo(int testNo) {
        this.testNo = testNo;
    }

    public int getStuNo() {
        return stuNo;
    }

    public void setStuNo(int stuNo) {
        this.stuNo = stuNo;
    }

    public int getPaperNo() {
        return paperNo;
    }

    public void setPaperNo(int paperNo) {
        this.paperNo = paperNo;
    }

    public String getStuAnswer() {
        return stuAnswer;
    }

    public void setStuAnswer(String stuAnswer) {
        this.stuAnswer = stuAnswer;
    }

    public int getIsRead() {
        return isRead;
    }

    public void setIsRead(int isRead) {
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
