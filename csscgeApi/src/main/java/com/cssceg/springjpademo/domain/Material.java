package com.cssceg.springjpademo.domain;

import javax.persistence.*;

@Entity
@Table(name="material_properties")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_id")
    private Integer material_id;//` int(11) NOT NULL AUTO_INCREMENT COMMENT '物料ID',
    private String material_name;//` varchar(255) DEFAULT NULL,
    private Double material_sand;//` double(255,2) NOT NULL COMMENT '含沙率',
    private Double material_density;//` double(255,2) NOT NULL COMMENT '密度',
    private Double material_ts;//` double(255,2) NOT NULL COMMENT 'TS',
    private Double material_vs;// ` double(255,2) NOT NULL COMMENT 'VS',
    private Double material_ts_vs;//     ` double(255,2) NOT NULL COMMENT 'VS/TS',
    private Double material_birerong;//       ` double(255,2) NOT NULL COMMENT '比热容',
    private Double material_vsgas;//       ` double(255,2) NOT NULL COMMENT 'VS产气量',
    private Double material_tsgas;//      ` double(255,2) NOT NULL COMMENT 'TS产气量',
    private Double material_ch4;//     ` double(255,2) NOT NULL COMMENT '甲烷含量',
    private Double material_h2s;//    ` double(255,2) NOT NULL COMMENT '硫化氢含量',
    private Double material_h2o;//    ` double(255,2) NOT NULL COMMENT '饱和水蒸气含量',
    private Double material_ch4cv;//     ` double(255,2) NOT NULL COMMENT '甲烷热值',
    private Double material_cnratio;//      ` double(255,2) NOT NULL COMMENT '碳氮比',
    private Double material_ccontent;//       ` double(255,2) NOT NULL COMMENT '碳含量',
    private Double material_ncontent;//       ` double(255,2) NOT NULL COMMENT '氮含量',
    private Integer material_pr; //对应流程
    private Double ri_shangll;//       `
    private Double material_ch4density;//
    private Double material_zzjg;//       ` do

    public Double getMaterial_zzjg() {
        return material_zzjg;
    }

    public void setMaterial_zzjg(Double material_zzjg) {
        this.material_zzjg = material_zzjg;
    }

    public Double getMaterial_ch4density() {
        return material_ch4density;
    }

    public void setMaterial_ch4density(Double material_ch4density) {
        this.material_ch4density = material_ch4density;
    }

    @Override
    public String toString() {
        return "Material{" +
                "material_id=" + material_id +
                ", material_name='" + material_name + '\'' +
                ", material_sand=" + material_sand +
                ", material_density=" + material_density +
                ", material_ts=" + material_ts +
                ", material_vs=" + material_vs +
                ", material_ts_vs=" + material_ts_vs +
                ", material_birerong=" + material_birerong +
                ", material_vsgas=" + material_vsgas +
                ", material_tsgas=" + material_tsgas +
                ", material_ch4=" + material_ch4 +
                ", material_h2s=" + material_h2s +
                ", material_h2o=" + material_h2o +
                ", material_ch4cv=" + material_ch4cv +
                ", material_cnratio=" + material_cnratio +
                ", material_ccontent=" + material_ccontent +
                ", material_ncontent=" + material_ncontent +
                ", material_pr=" + material_pr +
                ", riShangLL=" + ri_shangll +
                '}';
    }

    public Integer getMaterial_pr() {
        return material_pr;
    }

    public void setMaterial_pr(Integer material_pr) {
        this.material_pr = material_pr;
    }

    public Double getRi_shangll() {
        return ri_shangll;
    }

    public void setRi_shangll(Double riShangLL) {
        this.ri_shangll = riShangLL;
    }

    public Integer getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(Integer material_id) {
        this.material_id = material_id;
    }

    public String getMaterial_name() {
        return material_name;
    }

    public void setMaterial_name(String material_name) {
        this.material_name = material_name;
    }

    public Double getMaterial_sand() {
        return material_sand;
    }

    public void setMaterial_sand(Double material_sand) {
        this.material_sand = material_sand;
    }

    public Double getMaterial_density() {
        return material_density;
    }

    public void setMaterial_density(Double material_density) {
        this.material_density = material_density;
    }

    public Double getMaterial_ts() {
        return material_ts;
    }

    public void setMaterial_ts(Double material_ts) {
        this.material_ts = material_ts;
    }

    public Double getMaterial_vs() {
        return material_vs;
    }

    public void setMaterial_vs(Double material_vs) {
        this.material_vs = material_vs;
    }

    public Double getMaterial_ts_vs() {
        return material_ts_vs;
    }

    public void setMaterial_ts_vs(Double material_ts_vs) {
        this.material_ts_vs = material_ts_vs;
    }

    public Double getMaterial_birerong() {
        return material_birerong;
    }

    public void setMaterial_birerong(Double material_birerong) {
        this.material_birerong = material_birerong;
    }

    public Double getMaterial_vsgas() {
        return material_vsgas;
    }

    public void setMaterial_vsgas(Double material_vsgas) {
        this.material_vsgas = material_vsgas;
    }

    public Double getMaterial_tsgas() {
        return material_tsgas;
    }

    public void setMaterial_tsgas(Double material_tsgas) {
        this.material_tsgas = material_tsgas;
    }

    public Double getMaterial_ch4() {
        return material_ch4;
    }

    public void setMaterial_ch4(Double material_ch4) {
        this.material_ch4 = material_ch4;
    }

    public Double getMaterial_h2s() {
        return material_h2s;
    }

    public void setMaterial_h2s(Double material_h2s) {
        this.material_h2s = material_h2s;
    }

    public Double getMaterial_h2o() {
        return material_h2o;
    }

    public void setMaterial_h2o(Double material_h2o) {
        this.material_h2o = material_h2o;
    }

    public Double getMaterial_ch4cv() {
        return material_ch4cv;
    }

    public void setMaterial_ch4cv(Double material_ch4cv) {
        this.material_ch4cv = material_ch4cv;
    }

    public Double getMaterial_cnratio() {
        return material_cnratio;
    }

    public void setMaterial_cnratio(Double material_cnratio) {
        this.material_cnratio = material_cnratio;
    }

    public Double getMaterial_ccontent() {
        return material_ccontent;
    }

    public void setMaterial_ccontent(Double material_ccontent) {
        this.material_ccontent = material_ccontent;
    }

    public Double getMaterial_ncontent() {
        return material_ncontent;
    }

    public void setMaterial_ncontent(Double material_ncontent) {
        this.material_ncontent = material_ncontent;
    }
}
