package com.cssceg.springjpademo.service.impl;

import com.cssceg.springjpademo.dao.AquacultureDao;
import com.cssceg.springjpademo.domain.Aquaculture;
import com.cssceg.springjpademo.service.AquacultureMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AquacultureMethodImpl implements AquacultureMethod {
    @Autowired
    private AquacultureDao aquacultureDao;
    @Override
    public Double GetDouble(Integer x, Integer y, Integer z) {
        Double number= (double)x+((double)y+(double)z/60)/60;
        return number;
    }

    @Override
    public void SaveAquaculture(Aquaculture aquaculture) {
        aquacultureDao.save(aquaculture);
    }

    @Override
    public List<Aquaculture> getAll() {
        return aquacultureDao.findAll();
    }

    @Override
    public Aquaculture getNewAquaculture(Aquaculture aquaculture) {
        aquaculture.setDate(new Date());
        aquaculture.setLongitude(GetDouble(aquaculture.getX(),aquaculture.getY(),aquaculture.getZ()));
        aquaculture.setLatitude(GetDouble(aquaculture.getX1(),aquaculture.getY1(),aquaculture.getZ1()));
        return aquaculture;
    }
}
