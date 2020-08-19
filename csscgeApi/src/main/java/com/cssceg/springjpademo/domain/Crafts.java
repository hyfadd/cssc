package com.cssceg.springjpademo.domain;

import javax.persistence.*;

@Entity
@Table(name = "crafts")
public class Crafts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer crafts_id;//'工艺选择ID',
    private String crafts_name;                    //'工艺名称',
    private Double crafts_tsmin;//
    private Double crafts_tsmax;//
    private Double crafts_tsdefault;//'默认TS',
    private Double crafts_cnratiomin;//'cn比极小值',
    private Double crafts_cnratiomax;//
    private Double crafts_cndefault;//'默认cn比',
    private Double crafts_timed;//'停留时间',
    private Double crafts_temperature;//'温度',
    private Integer crafts_pr;//'对应罐体/工艺',

    @Override
    public String toString() {
        return "Crafts{" +
                "crafts_id=" + crafts_id +
                ", crafts_name='" + crafts_name + '\'' +
                ", crafts_tsmin=" + crafts_tsmin +
                ", crafts_tsmax=" + crafts_tsmax +
                ", crafts_tsdefault=" + crafts_tsdefault +
                ", crafts_cnratiomin=" + crafts_cnratiomin +
                ", crafts_cnratiomax=" + crafts_cnratiomax +
                ", crafts_cndefault=" + crafts_cndefault +
                ", crafts_timed=" + crafts_timed +
                ", crafts_temperature=" + crafts_temperature +
                ", crafts_pr=" + crafts_pr +
                '}';
    }

    public Integer getCrafts_id() {
        return crafts_id;
    }

    public void setCrafts_id(Integer crafts_id) {
        this.crafts_id = crafts_id;
    }

    public String getCrafts_name() {
        return crafts_name;
    }

    public void setCrafts_name(String crafts_name) {
        this.crafts_name = crafts_name;
    }

    public Double getCrafts_tsmin() {
        return crafts_tsmin;
    }

    public void setCrafts_tsmin(Double crafts_tsmin) {
        this.crafts_tsmin = crafts_tsmin;
    }

    public Double getCrafts_tsmax() {
        return crafts_tsmax;
    }

    public void setCrafts_tsmax(Double crafts_tsmax) {
        this.crafts_tsmax = crafts_tsmax;
    }

    public Double getCrafts_tsdefault() {
        return crafts_tsdefault;
    }

    public void setCrafts_tsdefault(Double crafts_tsdefault) {
        this.crafts_tsdefault = crafts_tsdefault;
    }

    public Double getCrafts_cnratiomin() {
        return crafts_cnratiomin;
    }

    public void setCrafts_cnratiomin(Double crafts_cnratiomin) {
        this.crafts_cnratiomin = crafts_cnratiomin;
    }

    public Double getCrafts_cnratiomax() {
        return crafts_cnratiomax;
    }

    public void setCrafts_cnratiomax(Double crafts_cnratiomax) {
        this.crafts_cnratiomax = crafts_cnratiomax;
    }

    public Double getCrafts_cndefault() {
        return crafts_cndefault;
    }

    public void setCrafts_cndefault(Double crafts_cndefault) {
        this.crafts_cndefault = crafts_cndefault;
    }

    public Double getCrafts_timed() {
        return crafts_timed;
    }

    public void setCrafts_timed(Double crafts_timed) {
        this.crafts_timed = crafts_timed;
    }

    public Double getCrafts_temperature() {
        return crafts_temperature;
    }

    public void setCrafts_temperature(Double crafts_temperature) {
        this.crafts_temperature = crafts_temperature;
    }

    public Integer getCrafts_pr() {
        return crafts_pr;
    }

    public void setCrafts_pr(Integer crafts_pr) {
        this.crafts_pr = crafts_pr;
    }
}
