<template>
  <div class="app-container">
    <el-table :data="tableData" border style="width: 100%">
      <el-table-column prop="result_name" label="名字 " width=""></el-table-column>
      <el-table-column prop="result_rsll" label="日上料量(t/d)" min-width="122"></el-table-column>
      <el-table-column prop="result_rjgtiji" label="日进罐体积(m³/d)" min-width="142"></el-table-column>
      <el-table-column prop="result_wlratio" label="进料占比(%)" min-width="109"></el-table-column>
      <el-table-column prop="result_ts" label="含固率(%)"></el-table-column>
      <el-table-column prop="result_cn" label="碳氮比"></el-table-column>
      <el-table-column prop="result_rcgas" label="日产沼气量(m³/d)" min-width="147"></el-table-column>
      <el-table-column prop="result_ricng" label="日天然气(m³/d)" min-width="119"></el-table-column>
      <el-table-column prop="result_canliuwu" label="日发酵残留物量(t/d)" min-width="155"></el-table-column>
      <el-table-column prop="result_canliuwuts" label="日发酵残留物TS(%)" min-width="153"></el-table-column>
      <el-table-column prop="result_rizhaozha" label="日沼渣(t/d)"></el-table-column>
      <el-table-column prop="result_rizhaoye" label="日沼液(t/d)"></el-table-column>
      <el-table-column prop="result_riyoujifei" label="日有机肥(t/d)" min-width="105"></el-table-column>
    </el-table>
  </div>
</template>

<script>
    export default {
        name: "index",
      data() {
          return {
            tableData: [
              {
                result_name: '猪粪',
                result_rsll: 120,
                result_rjgtiji: 144.58,
                result_wlratio: 0.74,
                result_ts: 0.18,
                result_cn: 12.6,
                result_rcgas: 6750,
                result_ricng: 4050,
                result_canliuwu: 111.43,
                result_canliuwuts: 0.12,
                result_rizhaozha: 29.83,
                result_rizhaoye: 81.6,
                result_riyoujifei: 15.08
              },
              {
                result_name: '玉米黄贮',
                result_rsll: 20,
                result_rjgtiji: 66.67,
                result_wlratio: 0.12,
                result_ts: 0.8,
                result_cn: 53,
                result_rcgas: 5508,
                result_ricng: 3304.8,
                result_canliuwu: 13.01,
                result_canliuwuts: 0.69,
                result_rizhaozha:33.42,
                result_rizhaoye: -20.42,
                result_riyoujifei: 15.6
              },
              {
                result_name: '补充沼液',
                result_rsll: 22.86,
                result_rjgtiji: 21.77,
                result_wlratio: 0.14,
                result_ts: 0.05,
                result_cn: 0,
                result_rcgas: 114.29,
                result_ricng: 68.57,
                result_canliuwu: 22.71,
                result_canliuwuts: 0.04,
                result_rizhaozha:-0.55,
                result_rizhaoye: 0,
                result_riyoujifei: 0
              },
              {
                result_name: '混合物料',
                result_rsll: 162.86,
                result_rjgtiji: 233.01,
                result_wlratio: 1,
                result_ts: 0.24,
                result_cn: 15.79,
                result_rcgas: 12372.29,
                result_ricng: 7423.37,
                result_canliuwu: 147.15,
                result_canliuwuts: 0.16,
                result_rizhaozha:62.7,
                result_rizhaoye: 61.18,
                result_riyoujifei: 30.68
              }
            ]
          }
      }
    }
</script>

<style scoped>

</style>
