package com.naive.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;


/**
 * @author YechenGu
 * @date 2021/6/28 10:38 上午
 */
public class Paper {
    @TableId(type = IdType.AUTO)
    private int paperNo;
    private String paperName;
    private Integer paperTime;
    private String paperType;
    private String paperDif;
    private Integer paperScore;
    private Integer paperTea;
    private String paperClass;
    private String paperInfo;

    public int getPaperNo() {
        return paperNo;
    }

    public void setPaperNo(int paperNo) {
        this.paperNo = paperNo;
    }

    public String getPaperName() {
        return paperName;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public Integer getPaperTime() {
        return paperTime;
    }

    public void setPaperTime(Integer paperTime) {
        this.paperTime = paperTime;
    }

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }

    public String getPaperDif() {
        return paperDif;
    }

    public void setPaperDif(String paperDif) {
        this.paperDif = paperDif;
    }

    public Integer getPaperScore() {
        return paperScore;
    }

    public void setPaperScore(Integer paperScore) {
        this.paperScore = paperScore;
    }

    public Integer getPaperTea() {
        return paperTea;
    }

    public void setPaperTea(Integer paperTea) {
        this.paperTea = paperTea;
    }

    public String getPaperClass() {
        return paperClass;
    }

    public void setPaperClass(String paperClass) {
        this.paperClass = paperClass;
    }

    public String getPaperInfo() {
        return paperInfo;
    }

    public void setPaperInfo(String paperInfo) {
        this.paperInfo = paperInfo;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "paperNo=" + paperNo +
                ", paperName='" + paperName + '\'' +
                ", paperTime=" + paperTime +
                ", paperType='" + paperType + '\'' +
                ", paperDif='" + paperDif + '\'' +
                ", paperScore=" + paperScore +
                ", paperTea=" + paperTea +
                ", paperClass='" + paperClass + '\'' +
                ", paperInfo='" + paperInfo + '\'' +
                '}';
    }
}
