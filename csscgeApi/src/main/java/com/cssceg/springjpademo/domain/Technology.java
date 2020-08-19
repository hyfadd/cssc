package com.cssceg.springjpademo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
@Entity
@Table(name = "technology")
public class Technology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tn_id;

    @Column(name = "tn_name")
    private String label;
    private Integer next_node;
    private String caozuo;
    private String img;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Technology)) return false;
        Technology that = (Technology) o;
        return Objects.equals(tn_id, that.tn_id) ||
                Objects.equals(next_node, that.next_node);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tn_id, next_node);
    }

    public String getCaozuo() {
        return caozuo;
    }

    public void setCaozuo(String caozuo) {
        this.caozuo = caozuo;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Technology{" +
                "tn_id=" + tn_id +
                ", label='" + label + '\'' +
                ", next_node=" + next_node +
                ", caozuo='" + caozuo + '\'' +
                ", img='" + img + '\'' +
                '}';
    }

    public Technology() {
    }


    public Integer getTn_id() {
        return tn_id;
    }

    public void setTn_id(Integer tn_id) {
        this.tn_id = tn_id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getNext_node() {
        return next_node;
    }

    public void setNext_node(Integer next_node) {
        this.next_node = next_node;
    }




}
