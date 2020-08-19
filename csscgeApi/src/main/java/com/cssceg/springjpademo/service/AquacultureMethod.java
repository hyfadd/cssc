package com.cssceg.springjpademo.service;

import com.cssceg.springjpademo.domain.Aquaculture;

import java.util.List;

public interface AquacultureMethod  {
    /**
     * 将时分秒计算为小数
     */
    public Double GetDouble(Integer x,Integer y,Integer z);
    /**
     * 格式化数据后插入数据库
     */
    public void  SaveAquaculture(Aquaculture aquaculture);

    public List<Aquaculture> getAll();

    Aquaculture getNewAquaculture(Aquaculture aquaculture);
}
