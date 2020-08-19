package com.cssceg.springjpademo.service;


import com.cssceg.springjpademo.domain.Crafts;
import com.cssceg.springjpademo.domain.Material;
import com.cssceg.springjpademo.domain.Technology;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface MaterialMethod {
    /**
     * 查询所有名称和id
     */
    public List<Map<String, Object>> getMaterialName();
    /**
     * 日TS量=日上料量 X 物料TS TS范围计算
     */
    public Double getTsRange(List<Material> materials);

    Double getCN(List<Material> materials);

    /**
     * 根据计算的ts值给出意见
     * @return
     */
    public String getGongyi(Double tsRange);

    /**
     * 传入materialList，查询数据库包装新的materialList
     */
    public List<Material> getRealList(List<Material> materialsList);

    /**
     * 传入包装后的realList，以及工艺（干式，湿式）导出使用的List<Technology></>
     * @return
     */
    public List<String> getLiuCheng(List<Material> materialList, Integer type);
    /**
     *
     * @return
     */

    public Set<Technology> getTechnologySet(List<String> liucheng);
    public  List<Material> judgeMaterial(List<Material> realList, Crafts craftsList, Integer id);
}
