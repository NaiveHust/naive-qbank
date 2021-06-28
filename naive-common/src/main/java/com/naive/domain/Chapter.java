package com.naive.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @author YechenGu
 * @date 2021/6/28 10:35 上午
 */
public class Chapter {
    @TableId(type = IdType.AUTO)
    private int chaNo;
    private String chaTitle;
    private String chaMpoint;

    public int getChaNo() {
        return chaNo;
    }

    public void setChaNo(int chaNo) {
        this.chaNo = chaNo;
    }

    public String getChaTitle() {
        return chaTitle;
    }

    public void setChaTitle(String chaTitle) {
        this.chaTitle = chaTitle;
    }

    public String getChaMpoint() {
        return chaMpoint;
    }

    public void setChaMpoint(String chaMpoint) {
        this.chaMpoint = chaMpoint;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "chaNo=" + chaNo +
                ", chaTitle='" + chaTitle + '\'' +
                ", chaMpoint='" + chaMpoint + '\'' +
                '}';
    }
}
