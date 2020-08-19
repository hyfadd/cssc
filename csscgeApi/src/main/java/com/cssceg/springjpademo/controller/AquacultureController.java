package com.cssceg.springjpademo.controller;

import com.cssceg.springjpademo.dao.TypeNameDao;
import com.cssceg.springjpademo.domain.Aquaculture;
import com.cssceg.springjpademo.domain.TypeName;
import com.cssceg.springjpademo.service.impl.AquacultureMethodImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class AquacultureController {
    @Autowired
    private AquacultureMethodImpl aquacultureMethod;
    @Autowired
    private TypeNameDao typeNameDao;

    /**
     * 下拉获取所有TypeName
     */
    @RequestMapping("/getTypeName")
    public List<TypeName> getMaterialName() {
        List<TypeName> all = typeNameDao.findAll();
        return all;
    }

    @RequestMapping("/getAquaculture")
    public List<Aquaculture> getAllAquaculture() {
        return aquacultureMethod.getAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestBody Aquaculture aquaculture) {
        //处理经纬度
        Aquaculture newAq=aquacultureMethod.getNewAquaculture(aquaculture);
        //保存到数据库
        aquacultureMethod.SaveAquaculture(newAq);
        return "成功";
    }

}
