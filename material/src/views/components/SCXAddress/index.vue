<template>
  <div class="linkage">
    <div>
      <el-select v-model="selectProvince" filterable placeholder="请选择省份" size="small" @change="selectProvinceFun" value="">
        <el-option
          v-for="item in city.provinceList"
          :key="item.ProID"
          :label="item.ProName"
          :value="item.ProID">
        </el-option>
      </el-select>
    </div>
    <div>
      <el-select v-model="selectCity" filterable placeholder="请选择城市" size="small" @change="selectCityFun" value="">
        <el-option
          v-for="item in cityList"
          :key="item.CityID"
          :label="item.CityName"
          :value="item.CityID">
        </el-option>
      </el-select>
    </div>
    <div>
      <el-select v-model="selectArea" filterable placeholder="请选择区县" size="small" @change="selectAreaFun" value="">
        <el-option
          v-for="item in areaList"
          :key="item.Id"
          :label="item.DisName"
          :value="item.Id">
        </el-option>
      </el-select>
    </div>
  </div>
</template>
<script>
  import city from './city.json'
  export default {
    name: 'linkage',
    data () {
      return {
        // 整个省市县数据
        city: city,
        // 被选中的市数据
        cityList: [],
        // 被选中的县数据
        areaList: [],
        selectProvince: '',
        selectCity: '',
        selectArea: ''
      }
    },
    mounted () {
    },
    methods: {
      // 省份 市 县联动
      selectProvinceFun (event) {
        this.selectCity = ''
        this.selectArea = ''
        this.cityList = []
        let provice = {}
        if (event) {
          city.cityList.forEach(item => {
            if (item.ProID === event) {
              this.cityList.push(item)
            }
          })
          city.provinceList.forEach(item => {
            if (item.ProID === event) {
              provice = item
            }
          })
        }
        this.$emit('getProvice', provice)
      },
      selectCityFun (event) {
        this.selectArea = ''
        let cities = {}
        this.areaList = []
        if (event) {
          city.countyList.forEach(item => {
            if (item.CityID === event) {
              this.areaList.push(item)
            }
          })
          city.cityList.forEach(item => {
            if (item.CityID === event) {
              cities = item
            }
          })
        }
        this.$emit('getCity', cities)
      },
      selectAreaFun (event) {
        let county = {}
        city.countyList.forEach(item => {
          if (item.Id === event) {
            county = item
          }
        })
        this.$emit('getCounty', county)
      }
    }
  }
</script>
<style lang="scss" scoped>
  .linkage {
    display: flex;
    div {
      margin-right: 5px;
    }
  }
</style>
