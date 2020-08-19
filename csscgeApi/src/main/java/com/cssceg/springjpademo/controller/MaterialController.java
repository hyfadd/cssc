package com.cssceg.springjpademo.controller;

import com.cssceg.springjpademo.domain.*;
import com.cssceg.springjpademo.service.impl.CraftsMethodImpl;
import com.cssceg.springjpademo.service.impl.MaterialMethodImpl;
import com.cssceg.springjpademo.utils.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.NumberFormat;
import java.util.*;

@RestController
@CrossOrigin
public class MaterialController {
    @Autowired
    private MaterialMethodImpl materialMethod;
    @Autowired
    private CraftsMethodImpl craftsMethod;
    /**
     * 下拉获取所有选项
     */
//    @RequestMapping("/getMaterialName")
//    public List<Map<String, Object>> getMaterialName() {
//        return materialMethod.getMaterialName();
//    }
    @RequestMapping("/getMaterialName")
    public List<Material> getMaterialName() {
        return materialMethod.getList();
    }
    /**
     * 获取全部信息
     * @return
     */
    @RequestMapping("/getMaterials")
    public List<Material> getMaterials() {
        return materialMethod.getMaterials();
    }
    @RequestMapping("/getBC/{gongyi}")
    public List<Map<String, Object>>  getBC(@RequestBody List<Material> materialList, @PathVariable Integer gongyi) {
        //获判断是否有秸秆添加沼液
        List<Material> check = materialMethod.check(materialList);
        //处理后的物料判断是否满足含固率
        boolean bcList = materialMethod.getBCList(check,gongyi);
        if (!bcList){
            //小于含固率，输出需添加的高含固物料
            return  materialMethod.getGaoHanGu();
        }else {
            return null;
        }
    }


    /**
     * 根据上传物料id以及ts以及日上料量计算推荐的处理工艺（干式，湿式）
     */
    @RequestMapping(value = "/getGongYi", method = RequestMethod.POST)
    public GYResult getMassage(@RequestBody List<Material> materialList, HttpServletRequest request) {
        Double tsRange = NumberUtils.formatDouble(materialMethod.getTsRange(materialList),2);
        Double tsCN = NumberUtils.formatDouble(materialMethod.getCN(materialList),2);
        String gongyi = materialMethod.getGongyi(tsRange);
        GYResult gyResult=new GYResult();
        gyResult.setGongyi(gongyi);
        gyResult.setTsCN(tsCN);
        gyResult.setTs(tsRange);
        return gyResult;
    }

    /**
     * 根据传递的工艺值,以及物料类型、ts、日上料量计算所需添加的物料种类和量（string），
     * 同时返回流程数据id（List<process></>），
     * 1 干式
     * 2 湿式
     */
    @RequestMapping(value = "/getMassage/{gongyi}/{id}", method = RequestMethod.POST)
    public List<MaterialResult> getMassage(@RequestBody List<Material> materialList, @PathVariable Integer gongyi,@PathVariable Integer id ) {
        Crafts crafts = craftsMethod.getCraftsByID(gongyi);
        //查询包装新的list
//        List<Material> realList = materialMethod.getRealList(materialList);
        List<Material> finalMaterialList = materialMethod.judgeMaterial(materialList, crafts,id);
        List<MaterialResult> materialResults = materialMethod.materialBalanceB(finalMaterialList);
        return materialResults;
    }

    /**
     * 获取流程图
     */
    @RequestMapping(value = "/getLCT/{gongyi}", method = RequestMethod.POST)
    public Set<Technology> getLCT(@RequestBody List<Material> materialList, @PathVariable Integer gongyi) {
        Crafts crafts = craftsMethod.getCraftsByID(gongyi);
        //查询包装新的list
        List<Material> realList = materialMethod.getRealList(materialList);
        List<String> liuCheng = materialMethod.getLiuCheng(realList, gongyi);
        Set<Technology> technologySet = materialMethod.getTechnologySet(liuCheng);
        return technologySet;
    }

}
