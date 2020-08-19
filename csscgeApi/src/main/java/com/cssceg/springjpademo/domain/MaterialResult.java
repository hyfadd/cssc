package com.cssceg.springjpademo.domain;

import javax.persistence.*;

@Entity
@Table(name = "material_result")
public class MaterialResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer result_id;//         //'id',
    private String result_name;//           //'名字',
    private Double result_rsll;//           //'日上料量',
    private Double result_rjgtiji;//            //'日进罐体积',
    private Double result_wlratio;//            //'进料占比',
    private Double result_ts;//         //'ts',
    private Double result_rcgas;//          //'日产沼气量',
    private Double result_ricng;//          //'日天然气',
    private Double result_canliuwu;//           //'日发酵残留物量',
    private Double result_canliuwuts;//         //'日发酵残留物TS',
    private Double result_rizhaozha;//          //'日沼渣',
    private Double result_rizhaoye;//           // 日沼液',
    private Double result_riyoujifei;//         //'日有机肥',
    private Double result_cn;//         //'日有机肥',
    //private String result;//


    @Override
    public String toString() {
        return "MaterialResult{" +
                "result_id=" + result_id +
                ", result_name='" + result_name + '\'' +
                ", result_rsll=" + result_rsll +
                ", result_rjgtiji=" + result_rjgtiji +
                ", result_wlratio=" + result_wlratio +
                ", result_ts=" + result_ts +
                ", result_rcgas=" + result_rcgas +
                ", result_ricng=" + result_ricng +
                ", result_canliuwu=" + result_canliuwu +
                ", result_canliuwuts=" + result_canliuwuts +
                ", result_rizhaozha=" + result_rizhaozha +
                ", result_rizhaoye=" + result_rizhaoye +
                ", result_riyoujifei=" + result_riyoujifei +
                '}';
    }

    public Double getResult_cn() {
        return result_cn;
    }

    public void setResult_cn(Double result_cn) {
        this.result_cn = result_cn;
    }

    public Integer getResult_id() {
        return result_id;
    }

    public void setResult_id(Integer result_id) {
        this.result_id = result_id;
    }

    public String getResult_name() {
        return result_name;
    }

    public void setResult_name(String result_name) {
        this.result_name = result_name;
    }

    public Double getResult_rsll() {
        return result_rsll;
    }

    public void setResult_rsll(Double result_rsll) {
        this.result_rsll = result_rsll;
    }

    public Double getResult_rjgtiji() {
        return result_rjgtiji;
    }

    public void setResult_rjgtiji(Double result_rjgtiji) {
        this.result_rjgtiji = result_rjgtiji;
    }

    public Double getResult_wlratio() {
        return result_wlratio;
    }

    public void setResult_wlratio(Double result_wlratio) {
        this.result_wlratio = result_wlratio;
    }

    public Double getResult_ts() {
        return result_ts;
    }

    public void setResult_ts(Double result_ts) {
        this.result_ts = result_ts;
    }

    public Double getResult_rcgas() {
        return result_rcgas;
    }

    public void setResult_rcgas(Double result_rcgas) {
        this.result_rcgas = result_rcgas;
    }

    public Double getResult_ricng() {
        return result_ricng;
    }

    public void setResult_ricng(Double result_ricng) {
        this.result_ricng = result_ricng;
    }

    public Double getResult_canliuwu() {
        return result_canliuwu;
    }

    public void setResult_canliuwu(Double result_canliuwu) {
        this.result_canliuwu = result_canliuwu;
    }

    public Double getResult_canliuwuts() {
        return result_canliuwuts;
    }

    public void setResult_canliuwuts(Double result_canliuwuts) {
        this.result_canliuwuts = result_canliuwuts;
    }

    public Double getResult_rizhaozha() {
        return result_rizhaozha;
    }

    public void setResult_rizhaozha(Double result_rizhaozha) {
        this.result_rizhaozha = result_rizhaozha;
    }

    public Double getResult_rizhaoye() {
        return result_rizhaoye;
    }

    public void setResult_rizhaoye(Double result_rizhaoye) {
        this.result_rizhaoye = result_rizhaoye;
    }

    public Double getResult_riyoujifei() {
        return result_riyoujifei;
    }

    public void setResult_riyoujifei(Double result_riyoujifei) {
        this.result_riyoujifei = result_riyoujifei;
    }
}
