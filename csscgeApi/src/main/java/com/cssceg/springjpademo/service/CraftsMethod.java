package com.cssceg.springjpademo.service;


import com.cssceg.springjpademo.domain.Crafts;


public interface CraftsMethod {
    /**
     * 根据工艺id查询所需参数
     */
    public Crafts getCraftsByID(Integer id);

}
