package com.naive.domain;

/**
 * @author YechenGu
 * @date 2021/7/7 11:27 上午
 */
public class Relation {
    private int cid;
    private int tid;
    private int sid;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "Relation{" +
                "cid=" + cid +
                ", tid=" + tid +
                ", sid=" + sid +
                '}';
    }
}
