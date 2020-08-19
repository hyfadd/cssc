package com.cssceg.springjpademo.domain;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="aquaculture")
public class Aquaculture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;// '编号'
    private Date date;//数据提交日期',
    private String plant_name;//养殖场名称',
    private String province;//所在省',
    private String city;//所在市',
    private String area;//所在县',
    private String town;//所在乡',
    private String people_name;//联系人姓名',
    private String phone_number;//手机号码'
    private String type;//养殖种类',
    private Integer cunll;//'年末存栏量',
    private Integer chull;//'全年出栏量',
    private Integer clean_method;//'清粪方式',
    private Double water_volume;//水洗清粪量',
    private Double longitude;//经度',
    private Double latitude;//纬度',
    private Integer x;
    private Integer y;
    private Integer z;
    private Integer x1;
    private Integer y1;
    private Integer z1;

    @Override
    public String toString() {
        return "Aquaculture{" +
                "id=" + id +
                ", date=" + date +
                ", plant_name='" + plant_name + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", town='" + town + '\'' +
                ", type='" + type + '\'' +
                ", cunll=" + cunll +
                ", chull=" + chull +
                ", clean_method=" + clean_method +
                ", water_volume=" + water_volume +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", people_name='" + people_name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", x1=" + x1 +
                ", y1=" + y1 +
                ", z1=" + z1 +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlant_name() {
        return plant_name;
    }

    public void setPlant_name(String plant_name) {
        this.plant_name = plant_name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCunll() {
        return cunll;
    }

    public void setCunll(Integer cunll) {
        this.cunll = cunll;
    }

    public Integer getChull() {
        return chull;
    }

    public void setChull(Integer chull) {
        this.chull = chull;
    }

    public Integer getClean_method() {
        return clean_method;
    }

    public void setClean_method(Integer clean_method) {
        this.clean_method = clean_method;
    }

    public Double getWater_volume() {
        return water_volume;
    }

    public void setWater_volume(Double water_volume) {
        this.water_volume = water_volume;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getPeople_name() {
        return people_name;
    }

    public void setPeople_name(String people_name) {
        this.people_name = people_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getZ() {
        return z;
    }

    public void setZ(Integer z) {
        this.z = z;
    }

    public Integer getX1() {
        return x1;
    }

    public void setX1(Integer x1) {
        this.x1 = x1;
    }

    public Integer getY1() {
        return y1;
    }

    public void setY1(Integer y1) {
        this.y1 = y1;
    }

    public Integer getZ1() {
        return z1;
    }

    public void setZ1(Integer z1) {
        this.z1 = z1;
    }
}
