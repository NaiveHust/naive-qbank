package com.naive.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

/**
 * @author YechenGu
 * @date 2021/6/28 10:38 上午
 */
public class Paper {
    @TableId(type = IdType.AUTO)
    private int paperNo;
    private String paperName;
    private Date paperTime;
    private String paperType;
    private String paperDif;
    private int paperScore;

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

    public Date getPaperTime() {
        return paperTime;
    }

    public void setPaperTime(Date paperTime) {
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

    public int getPaperScore() {
        return paperScore;
    }

    public void setPaperScore(int paperScore) {
        this.paperScore = paperScore;
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
                '}';
    }
}
