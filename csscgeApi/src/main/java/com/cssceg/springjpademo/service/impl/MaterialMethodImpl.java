package com.cssceg.springjpademo.service.impl;


import com.cssceg.springjpademo.dao.CraftsDao;
import com.cssceg.springjpademo.dao.MaterialDao;
import com.cssceg.springjpademo.dao.ProcessDao;
import com.cssceg.springjpademo.dao.TechnologyDao;
import com.cssceg.springjpademo.domain.Crafts;
import com.cssceg.springjpademo.domain.Material;
import com.cssceg.springjpademo.domain.MaterialResult;
import com.cssceg.springjpademo.domain.Process;
import com.cssceg.springjpademo.domain.Technology;
import com.cssceg.springjpademo.service.MaterialMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MaterialMethodImpl implements MaterialMethod {
    @Autowired
    private MaterialDao materialDao;
    @Autowired
    private ProcessDao processDao;
    @Autowired
    private TechnologyDao technologyDao;
    @Autowired
    private CraftsDao craftsDao;

    /**
     * 获取全部list
     *
     * @return
     */


    @Override
    public List<Map<String, Object>> getMaterialName() {
        List<Map<String, Object>> materials = materialDao.getMaterials();
        return materials;
    }

    /**
     * getTsRange ts 范围 日TS量=日上料量 X 物料TS TS范围计算
     */
    @Override
    public Double getTsRange(List<Material> materials) {
        Double ts_riShangLL = 0.0;
        Double all_riShangLL = 0.0;
        for (Material material : materials) {
            ts_riShangLL += material.getMaterial_ts() * material.getRi_shangll();
            all_riShangLL += material.getRi_shangll();

        }
        return ts_riShangLL / all_riShangLL;
    }

    @Override
    public Double getCN(List<Material> materials) {
        Double Chl = 0.0;
        Double Nhl = 0.0;
        for (Material material : materials) {
            Chl += material.getMaterial_ccontent() * material.getRi_shangll();
            Nhl += material.getMaterial_ncontent() * material.getRi_shangll();
        }
        return Chl / Nhl;
    }
    /**
     * 根据计算的ts值给出意见
     */
    @Override
    public String getGongyi(Double tsRange) {
        if (tsRange >= 15) {
            return "含固率较高，建议选择干式发酵";
        } else {
            return "含固率较低，建议选择湿式发酵";
        }
    }
    /**
     * 传入materialList，查询数据库包装新的materialList
     */
    @Override
    public List<Material> getRealList(List<Material> realList) {
        List<Material> newMaterial = new ArrayList<>();
        for (Material material : realList) {
            Material one = materialDao.getOne(material.getMaterial_id());
            one.setMaterial_ts(material.getMaterial_ts());
            one.setRi_shangll(material.getRi_shangll());
            newMaterial.add(one);
        }
        return newMaterial;
    }
    /**
     * 传入包装后的realList，以及工艺（干式，湿式）导出使用的set<String>工艺流程</>
     *
     * @return
     */
    @Override
    public List<String> getLiuCheng(List<Material> materialList, Integer type) {
        String gongyi = "";
        if (type == 1) {//干式节点加16
            gongyi = ",16";
        } else {
            gongyi = ",15";
        }
        /**
         * 预处理
         */
        List<String> liucheng = new ArrayList<>();
        Set<Integer> pr = new HashSet<Integer>();
        for (Material material : materialList) {
            pr.add(material.getMaterial_pr());
        }
        for (Integer id : pr) {
            Optional<Process> one = processDao.findById(id);
            String pr_number = one.get().getPr_number();
            pr_number += gongyi;
            liucheng.add(pr_number);
        }
        /**
         * 处理工艺流程
         */
        List<Process> bytype = processDao.findBytype(type);
        for (Process process : bytype) {
            liucheng.add(process.getPr_number());
        }
        return liucheng;
    }
    /**
     * 将List<String> liucheng转换为List<数组></>数字
     */
    public List<int[]> getIntList(List<String> liucheng) {
        List<int[]> arrList = new ArrayList<int[]>();
        for (int i = 0; i < liucheng.size(); i++) {
            String[] split = liucheng.get(i).split(",");
            int arr[] = new int[split.length];
            for (int i1 = 0; i1 < arr.length; i1++) {
                arr[i1] = Integer.parseInt(split[i1]);
            }
            arrList.add(arr);
        }
        return arrList;
    }
    private Technology getByid(Integer id) {
        Technology one = technologyDao.getOne(id);
        return one;
    }
    public List<Technology> getTList(int[] ints) {
        List<Technology> technologies = new LinkedList<>();
        for (int i1 = 0; i1 < ints.length; i1++) {
            Technology one = new Technology();
            Technology two = getByid(ints[i1]);
            one.setTn_id(two.getTn_id());
            one.setLabel(two.getLabel());
            one.setCaozuo(two.getCaozuo());
            one.setImg(two.getImg());
            if (i1 == ints.length - 1) {
                one.setNext_node(0);
            } else if (i1 < ints.length - 1) {
                one.setNext_node(ints[i1 + 1]);
            }
            technologies.add(one);
        }
        return technologies;
    }
    @Override
    public Set<Technology> getTechnologySet(List<String> liucheng) {
        List<Technology> technologies = new LinkedList<>();
        List<int[]> intList = getIntList(liucheng);
        for (int[] ints : intList) {
            List<Technology> tList = getTList(ints);
            technologies.addAll(tList);
        }
        Set<Technology> technologySet = new HashSet<>(technologies);

        return technologySet;

    }
    /**
     * 计算所需沼液量
     */
    public Double addZy(Material material) {
        return (material.getMaterial_ts() - 0.4) * material.getRi_shangll() / 0.35;
    }
    /**
     * 判断工艺
     *
     * @param realList
     * @param craftsList
     * @param id
     * @return
     */
    @Override
    public List<Material> judgeMaterial(List<Material> realList, Crafts craftsList, Integer id) {
       Material gaohangu=new Material();
       gaohangu=materialDao.getOne(id);
        List<Material> checkList = check(realList);
        Double ts_riShangLL = 0.0;
        Double all_riShangLL = 0.0;
        Double hangulv = 0.0;
        Material zhaoyeMaterial = new Material();
        for (Material material : checkList) {//注意此处realList的值，是否需要上一步传参？如何传
            ts_riShangLL += material.getMaterial_ts() * material.getRi_shangll();
            all_riShangLL += material.getRi_shangll();
            if (material.getMaterial_id()==110){
                zhaoyeMaterial=material;
            }else {
                zhaoyeMaterial = materialDao.getOne(10);
            }
        }
        hangulv = ts_riShangLL / all_riShangLL;
        Double addzy=0.0;
        Double needwl = 0.0;
        Material balanc = new Material();
        String needname = null;
        List<Material> finalList = checkList;
        if (hangulv < craftsList.getCrafts_tsmin()) {
            //小于要求最低含固率，补充该list中含固率高的值并计算出补充量
            //选择物料的方法X
//            System.out.println("小于要求最低含固率");
            //***************补充物料计算*********
            for (Material mtc : checkList) {
                if (mtc.getMaterial_ts() > craftsList.getCrafts_tsmax()) {
                    if(mtc.getMaterial_id()==7&&gaohangu.getMaterial_ts()>0.4){
                        balanc=gaohangu;
                        balanc.setMaterial_name("另需" + gaohangu.getMaterial_name());
                        System.out.println(ts_riShangLL+gaohangu.getRi_shangll());
                        balanc.setRi_shangll((ts_riShangLL-0.4*all_riShangLL)/(0.4-gaohangu.getMaterial_ts()));
                        finalList.add(balanc);
                        zhaoyeMaterial.setRi_shangll(addZy(gaohangu));
                        zhaoyeMaterial.setMaterial_id(110);
                        zhaoyeMaterial.setMaterial_name("补充沼液");
                        finalList.add(zhaoyeMaterial);
                    }else {
                        balanc = mtc;//取出大于最大设定含固率的物料
                        needname = mtc.getMaterial_name();
                        needwl = (ts_riShangLL - craftsList.getCrafts_tsdefault() * all_riShangLL) / (craftsList.getCrafts_tsdefault() - balanc.getMaterial_ts());
                        balanc.setRi_shangll(needwl);
                        balanc.setMaterial_name("另需" + needname);
                        finalList.add(balanc);//循环着finalrealList是不能在finalrealList添加东西的，所以用finalList
                    }
                        break;
                }else {

                    if(id==7&&gaohangu.getMaterial_ts()>0.4){
                        balanc=gaohangu;
                        balanc.setMaterial_name("另需" + gaohangu.getMaterial_name());
                        System.out.println(ts_riShangLL+gaohangu.getRi_shangll());
                        balanc.setRi_shangll((ts_riShangLL-0.4*all_riShangLL)/(0.4-gaohangu.getMaterial_ts()));
                        finalList.add(balanc);
                        if(zhaoyeMaterial.getMaterial_id()==110){
                            zhaoyeMaterial.setRi_shangll(zhaoyeMaterial.getRi_shangll()+addZy(gaohangu));
                        }else {
                        zhaoyeMaterial.setRi_shangll(addZy(gaohangu));
                        zhaoyeMaterial.setMaterial_id(110);
                        zhaoyeMaterial.setMaterial_name("补充沼液");
                        finalList.add(zhaoyeMaterial);
                        }
                    }else {
                        balanc=gaohangu;
                        balanc.setMaterial_name("另需" + gaohangu.getMaterial_name());
                        System.out.println(ts_riShangLL+gaohangu.getRi_shangll());
                        balanc.setRi_shangll((ts_riShangLL-craftsList.getCrafts_tsdefault()*all_riShangLL)/(craftsList.getCrafts_tsdefault()-gaohangu.getMaterial_ts()));
                        finalList.add(balanc);
                    }
                    break;
                }

            }
        } else if (hangulv > craftsList.getCrafts_tsmax()) {
            //大于要求最高含固率,补充水
            //选择物料的方法X
            // System.out.println("大于要求最高含固率");
            //***************补充水计算*********
            needwl = ts_riShangLL / (craftsList.getCrafts_tsdefault()) - all_riShangLL;//需水量
            balanc = materialDao.getOne(12);
            balanc.setMaterial_name("需水量");
            balanc.setMaterial_ts(0.0);//注意：看后续是否需要水的其他参数
            balanc.setRi_shangll(needwl);
//            balanc.setMaterial_birerong(4.19);
//            balanc.setMaterial_density(1);
//            balanc.setMaterial_tsgas(0);
            balanc.setMaterial_id(12);
            finalList.add(balanc);
        }
        return finalList;//如果能在此方法中完成物料添加及计算，可以直接调用materialBalanceA，不必有返回值
    }

    /**
     * 进行物料平衡计算，对应方法materialBalance，计算结果返回值realList
     */
    private MaterialResult materialBalanceA(Material material) {
        MaterialResult resultA = new MaterialResult();
        List<MaterialResult> resultList = new ArrayList<>();
        Double richanqiliang = 0.0;//日产气量
        Double wuliaotiji = 0.0;//物料体积
        Double canliuwu = 0.0;//日发酵残留物量
        Double canliuwuts = 0.0;//日发酵残留物TS比例
        Double canliuwutszhiliang = 0.0;//日发酵残留物TS质量
        Double paicuqizhong = 0.0;//日排出气体质量
        Double zhaozha = 0.0;//日沼渣量
        Double zhaoye = 0.0;//日沼液量
        Double youjifei = 0.0;//日有机肥量
        Double ricng = 0.0;//日CNG
        Double Chanliang = 0.0;//碳含量
        Double nhanliang = 0.0;//氮含量
        Double cn = 0.0;//碳氮比
        resultA.setResult_id((int) material.getMaterial_id());//物料ID
        resultA.setResult_name(material.getMaterial_name());//物料名字
        wuliaotiji = material.getRi_shangll() / material.getMaterial_density();
        resultA.setResult_rjgtiji(wuliaotiji);//物料体积
        resultA.setResult_rsll(material.getRi_shangll());//日上料量
        richanqiliang = material.getMaterial_ts() * material.getRi_shangll() * material.getMaterial_tsgas();
        resultA.setResult_rcgas(richanqiliang);//日产气量
        ricng = 0.6 * richanqiliang;
        resultA.setResult_ricng(ricng);//日产气量
        resultA.setResult_ts(material.getMaterial_ts());//ts含量
        paicuqizhong = richanqiliang * (material.getMaterial_ch4density() / 1000 + material.getMaterial_h2o() / 1000 - material.getMaterial_h2s() / 100000 / 100000);//日排出气体质量
        canliuwutszhiliang = material.getMaterial_ts() * material.getRi_shangll() - paicuqizhong;//日发酵残留物TS质量
        canliuwu = material.getRi_shangll() - paicuqizhong;//日发酵残留物量
        canliuwuts = canliuwutszhiliang / canliuwu;//日发酵残留物TS比例
        resultA.setResult_canliuwu(canliuwu);//日发酵残留物量
        resultA.setResult_canliuwuts(canliuwuts);//日发酵残留物TS比例
        zhaozha = (canliuwutszhiliang - canliuwu * 0.05) / (0.3 - 0.05);//假设固液分离后沼渣TS30，沼液5.（与固液分离机性能有关）
        zhaoye = canliuwu - zhaozha;//日沼液量
        resultA.setResult_rizhaozha(zhaozha);//日沼渣量
        resultA.setResult_rizhaoye(zhaoye);//日沼液量
        youjifei = zhaozha * (1 + 1 / material.getMaterial_zzjg()) * 0.35;
        resultA.setResult_riyoujifei(youjifei);//日有机肥量
        resultA.setResult_cn(material.getMaterial_cnratio());
        return resultA;
    }

    public List<MaterialResult> materialBalanceB(List<Material> finalList) {
        List<MaterialResult> result = new ArrayList<>();
        MaterialResult finalsum = new MaterialResult();
        MaterialResult cacu = new MaterialResult();
        Double zongchanqiliang = 0.0;//总产气量
        Double zongtshanliang = 0.0;//总ts含量/t
        Double zongshangliaoliang = 0.0;//总上料量（日发酵罐进液量）/t
        Double zongwuliaotiji = 0.0;//总物料体积
        Double hangulv = 0.0;//总含固率ts
        Double Chanliang = 0.0;//碳含量
        Double nhanliang = 0.0;//氮含量
        Double cn = 0.0;//碳氮比
        Double zongzhaozha = 0.0;//日总沼渣量
        Double zongzhaoye = 0.0;//日总沼液量
        Double zongyoujifei = 0.0;//日总有机肥量
        Double zongcanliuwutszhiliang = 0.0;//日总发酵残留物TS质量
        Double canliuwuts = 0.0;//日发酵残留物TS比例
        Double canliuwu = 0.0;//日发酵残留物量
        Double rizongcng = 0.0;//日CNG
        for (Material mat : finalList) {
            cacu = materialBalanceA(mat);
            result.add(cacu);
            zongchanqiliang += cacu.getResult_rcgas();
            ;
            zongtshanliang += cacu.getResult_ts() * cacu.getResult_rsll();
            zongshangliaoliang += cacu.getResult_rsll();
            zongwuliaotiji += cacu.getResult_rjgtiji();
            if (cacu.getResult_id() == 12) {
                cacu.setResult_rizhaoye(cacu.getResult_rsll());
                cacu.setResult_rizhaozha(0.0);
                cacu.setResult_riyoujifei(0.0);
            } else if (cacu.getResult_id() == 110) {
                cacu.setResult_rizhaoye(0.0);
                cacu.setResult_riyoujifei(0.0);
                cacu.setResult_rizhaozha(0.0);
            }
            zongzhaozha += cacu.getResult_rizhaozha();
            zongzhaoye += cacu.getResult_rizhaoye();
            zongyoujifei += cacu.getResult_riyoujifei();
            zongcanliuwutszhiliang += cacu.getResult_canliuwuts() * cacu.getResult_canliuwu();
            canliuwu += cacu.getResult_canliuwu();
            rizongcng += cacu.getResult_ricng();
        }
        hangulv = zongtshanliang / zongshangliaoliang;//总混合物料ts
        canliuwuts = zongcanliuwutszhiliang / canliuwu;
        /**
         * 总物料和
         */
        finalsum.setResult_riyoujifei(zongyoujifei);
        finalsum.setResult_rizhaoye(zongzhaoye);
        finalsum.setResult_rizhaozha(zongzhaozha);
        finalsum.setResult_ts(zongtshanliang);
        finalsum.setResult_ts(hangulv);
        finalsum.setResult_canliuwuts(canliuwuts);
        finalsum.setResult_rcgas(zongchanqiliang);
        finalsum.setResult_rjgtiji(zongwuliaotiji);
        finalsum.setResult_name("混合物料");
        finalsum.setResult_ricng(rizongcng);
        finalsum.setResult_wlratio(1.0);
        finalsum.setResult_rsll(zongshangliaoliang);
        finalsum.setResult_id(200);
        finalsum.setResult_canliuwu(canliuwu);

        for (int ii = 0; ii < result.size(); ii++) {
            result.get(ii).setResult_wlratio(result.get(ii).getResult_rsll() / finalsum.getResult_rsll());

            cn += result.get(ii).getResult_cn() * result.get(ii).getResult_wlratio();
        }
        finalsum.setResult_cn(cn);
        result.add(finalsum);
        return result;
    }

    public List<Material> getMaterials() {
        return materialDao.findAll();
    }

    /**
     * 查看是否存在秸秆，存在则补充沼液(无秸秆不执行)
     *
     * @param
     * @return
     */


    public List<Material> check(List<Material> realList) {
        Double addzy = 0.0;
        int jiegan = 0;
        int zhaoye = 0;
        Material zhaoyeMaterial = materialDao.getOne(10);
        Material buchongMateril = null;
        for (int i = 0; i < realList.size(); i++) {
            if (realList.get(i).getMaterial_id() == 7 && realList.get(i).getMaterial_ts() > 0.4) {
                //计算沼液量
                addzy = addZy(realList.get(i));
                jiegan = 1;
            }
            if (realList.get(i).getMaterial_id() == 10) {
                zhaoyeMaterial = realList.get(i);
                zhaoye = 1;
            }
        }
        if (jiegan == 1) {
            if (zhaoye == 1) {
                if (zhaoyeMaterial.getRi_shangll() < addzy) {
                    addzy = addzy - zhaoyeMaterial.getRi_shangll();
                    buchongMateril = zhaoyeMaterial;
                    buchongMateril.setRi_shangll(addzy);
                }
            } else {
                buchongMateril = zhaoyeMaterial;
                buchongMateril.setRi_shangll(addzy);
            }
            buchongMateril.setMaterial_id(110);
            buchongMateril.setMaterial_name("补充沼液");
            realList.add(buchongMateril);
        }
        return realList;
    }

    /**
     * 判断MAterials中是否满足含固率，不满足则抛出所需添加的物料，
     *
     * @param
     * @return
     */
    public boolean getBCList(List<Material> realList, Integer gongyi) {
        Crafts one = craftsDao.getOne(gongyi);
        Double ts_riShangLL = 0.0;
        Double all_riShangLL = 0.0;
        Double hangulv = 0.0;
        for (Material material : realList) {
            //注意此处realList的值，是否需要上一步传参？如何传
            ts_riShangLL += material.getMaterial_ts() * material.getRi_shangll();
            all_riShangLL += material.getRi_shangll();
        }
        hangulv = ts_riShangLL / all_riShangLL;
        if (hangulv < one.getCrafts_tsmin()) {
            return false;//小于要求的含固率
        }else {
            return true; //大于或者等于要求的含固率
        }
    }

    /**
     * 获取高含固物料
     * @return
     */
    public List<Map<String, Object>>  getGaoHanGu() {
        List<Map<String, Object>> gaoHanGu = materialDao.getGaoHanGu();
        return gaoHanGu;
    }

    public List<Material> getList() {
        return materialDao.getList();
    }
}


