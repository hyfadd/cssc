package com.cssceg.springjpademo.domain;

import javax.persistence.*;

@Entity
@Table(name="process")
public class Process {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pr_id;

    @Column(name="pr_number")
    private String pr_number;
    @Column(name="pr_type")
    private Integer pr_type;

    @Override
    public String toString() {
        return "Process{" +
                "pr_id=" + pr_id +
                ", pr_number='" + pr_number + '\'' +
                ", pr_type=" + pr_type +
                '}';
    }

    public Integer getPr_id() {
        return pr_id;
    }

    public void setPr_id(Integer pr_id) {
        this.pr_id = pr_id;
    }

    public String getPr_number() {
        return pr_number;
    }

    public void setPr_number(String pr_number) {
        this.pr_number = pr_number;
    }

    public Integer getPr_type() {
        return pr_type;
    }

    public void setPr_type(Integer pr_type) {
        this.pr_type = pr_type;
    }
}
