package com.answer.dto;

import java.util.Date;

public class Answer {
    private int bno;
    private int gno;
    private int gseq;
    private int titletab;
    private String title;
    private String content;
    private String writer;
    private Date regdate;

    public Answer() {}

    public Answer(int bno, int gno, int gseq, int titletab, String title, String content, String writer, Date regdate) {
        this.bno = bno;
        this.content = content;
        this.gno = gno;
        this.gseq = gseq;
        this.regdate = regdate;
        this.title = title;
        this.titletab = titletab;
        this.writer = writer;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getGno() {
        return gno;
    }

    public void setGno(int gno) {
        this.gno = gno;
    }

    public int getGseq() {
        return gseq;
    }

    public void setGseq(int gseq) {
        this.gseq = gseq;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTitletab() {
        return titletab;
    }

    public void setTitletab(int titletab) {
        this.titletab = titletab;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "bno=" + bno +
                ", gno=" + gno +
                ", gseq=" + gseq +
                ", titletab=" + titletab +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", regdate=" + regdate +
                '}';
    }
}
