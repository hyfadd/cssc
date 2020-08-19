package com.cssceg.springjpademo.service.impl;

import com.cssceg.springjpademo.dao.CraftsDao;
import com.cssceg.springjpademo.domain.Crafts;
import com.cssceg.springjpademo.service.CraftsMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CraftsMethodImpl implements CraftsMethod {
    @Autowired
    private CraftsDao craftsDao;

    @Override
    public Crafts getCraftsByID(Integer id) {
        return craftsDao.getOne(id);
    }

}
