package com.naive.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @author YechenGu
 * @date 2021/6/28 10:33 上午
 */
public class Problem {
    @TableId(type = IdType.AUTO)
    private int proNo;
    private String proDetail;
    private String proKeyw;
    private String proDif;
    private String proType;
    private String proAns;
    private String proCha;

    public int getProNo() {
        return proNo;
    }

    public void setProNo(int proNo) {
        this.proNo = proNo;
    }

    public String getProDetail() {
        return proDetail;
    }

    public void setProDetail(String proDetail) {
        this.proDetail = proDetail;
    }

    public String getProKeyw() {
        return proKeyw;
    }

    public void setProKeyw(String proKeyw) {
        this.proKeyw = proKeyw;
    }

    public String getProDif() {
        return proDif;
    }

    public void setProDif(String proDif) {
        this.proDif = proDif;
    }

    public String getProType() {
        return proType;
    }

    public void setProType(String proType) {
        this.proType = proType;
    }

    public String getProAns() {
        return proAns;
    }

    public void setProAns(String proAns) {
        this.proAns = proAns;
    }

    public String getProCha() {
        return proCha;
    }

    public void setProCha(String proCha) {
        this.proCha = proCha;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "proNo=" + proNo +
                ", proDetail='" + proDetail + '\'' +
                ", proKeyw='" + proKeyw + '\'' +
                ", proDif='" + proDif + '\'' +
                ", proType='" + proType + '\'' +
                ", proAns='" + proAns + '\'' +
                ", proCha='" + proCha + '\'' +
                '}';
    }
}
