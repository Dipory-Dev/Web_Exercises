package com.boot.jpa.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="MYBOARD")
public class JpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int myno;

    @Column
    private String myname;
    @Column
    private String mytitle;
    @Column
    private String mycontent;

    @Column(updatable = false)
    @Temporal(TemporalType.DATE)
    private Date mydate;

    public JpaEntity() {}

    public JpaEntity(int myno, String myname, String mytitle, String mycontent, Date mydate) {
        this.myno = myno;
        this.myname = myname;
        this.mytitle = mytitle;
        this.mycontent = mycontent;
        this.mydate = mydate;
    }

    public int getMyno() {
        return myno;
    }

    public void setMyno(int myno) {
        this.myno = myno;
    }

    public String getMyname() {
        return myname;
    }

    public void setMyname(String myname) {
        this.myname = myname;
    }

    public String getMytitle() {
        return mytitle;
    }

    public void setMytitle(String mytitle) {
        this.mytitle = mytitle;
    }

    public String getMycontent() {
        return mycontent;
    }

    public void setMycontent(String mycontent) {
        this.mycontent = mycontent;
    }

    public Date getMydate() {
        return mydate;
    }

    public void setMydate(Date mydate) {
        this.mydate = mydate;
    }
}
