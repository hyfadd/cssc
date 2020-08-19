package com.cssceg.springjpademo.domain;

import javax.persistence.*;

@Entity
@Table(name="type_name")
public class TypeName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer typeid;
    private String typename;

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Override
    public String toString() {
        return "TypeName{" +
                "typeid=" + typeid +
                ", typename='" + typename + '\'' +
                '}';
    }
}
