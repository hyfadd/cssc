<template>
  <div class="dashboard-editor-container">
    <!--    省市县联动下拉框-->
    <div class="citySty">
      <strong>项目地：</strong>
      <s-c-x-address @getProvice="ProviceChange" @getCity="CityChange" @getCounty="CountyChange"></s-c-x-address>
    </div>

    <el-row :gutter="32" v-if="show">
      <el-col :xs="24" :sm="24" :lg="12">
        <img src="./map.gif" alt="" style="height: 316px;width: 100%">
      </el-col>
      <el-col :xs="24" :sm="24" :lg="12">
        <div class="chart-wrapper">
          <line-chart :chart-data="lineChartData" />
        </div>
      </el-col>
      <el-col :xs="24" :sm="24" :lg="12">
        <div class="chart-wrapper">
          <line-chart-qi-wen :chart-data="lineChartData" />
        </div>
      </el-col>
      <el-col :xs="24" :sm="24" :lg="12">
        <div class="chart-wrapper">
          <bar-chart />
        </div>
      </el-col>
    </el-row>

<!--    <el-row :gutter="8">-->
<!--      <el-col :xs="{span: 24}" :sm="{span: 24}" :md="{span: 24}" :lg="{span: 12}" :xl="{span: 12}" style="padding-right:8px;margin-bottom:30px;">-->
<!--        <transaction-table />-->
<!--      </el-col>-->
<!--      <el-col :xs="{span: 24}" :sm="{span: 12}" :md="{span: 12}" :lg="{span: 6}" :xl="{span: 6}" style="margin-bottom:30px;">-->
<!--        <todo-list />-->
<!--      </el-col>-->
<!--      <el-col :xs="{span: 24}" :sm="{span: 12}" :md="{span: 12}" :lg="{span: 6}" :xl="{span: 6}" style="margin-bottom:30px;">-->
<!--        <box-card />-->
<!--      </el-col>-->
<!--    </el-row>-->
  </div>
</template>

<script>
import GithubCorner from '@/components/GithubCorner'
import PanelGroup from './components/PanelGroup'
import LineChart from './components/LineChart'
import LineChartQiWen from './components/LineChart_qiwen'
import RaddarChart from './components/RaddarChart'
import PieChart from './components/PieChart'
import BarChart from './components/BarChart'
import TransactionTable from './components/TransactionTable'
import TodoList from './components/TodoList'
import BoxCard from './components/BoxCard'
import SCXAddress from '../../components/SCXAddress/index'

const lineChartData = {
  newVisitis: {
    expectedData: [30, 100, 91, 154, 140, 162, 145, 82, 55, 60, 40, 10],
    actualData: [120, 82, 91, 154, 162, 140, 145, 100, 55, 60, 40, 10]
  },
  messages: {
    expectedData: [200, 192, 120, 144, 160, 130, 140],
    actualData: [180, 160, 151, 106, 145, 150, 130]
  },
  purchases: {
    expectedData: [80, 100, 121, 104, 105, 90, 100],
    actualData: [120, 90, 100, 138, 142, 130, 130]
  },
  shoppings: {
    expectedData: [130, 140, 141, 142, 145, 150, 160],
    actualData: [120, 82, 91, 154, 162, 140, 130]
  }
}

export default {
  name: 'DashboardAdmin',
  components: {
    GithubCorner,
    PanelGroup,
    LineChart,
    LineChartQiWen,
    RaddarChart,
    PieChart,
    BarChart,
    TransactionTable,
    TodoList,
    BoxCard,
    SCXAddress
  },
  data() {
    return {
      lineChartData: lineChartData.newVisitis,
      address_mode: "default", // default普通 cascader级联
      address_data: "", // 选中地址,
      Provice: '',
      City: '',
      County: '',
      show: false
    }
  },
  methods: {
    handleSetLineChartData(type) {
      this.lineChartData = lineChartData[type]
    },
    ProviceChange(obj) {
      this.Provice = obj.ProName || ''
      if (this.Provice && this.City && this.County) {
        this.show = true
      }
    },
    CityChange(obj) {
      this.City = obj.CityName || ''
      if (this.Provice && this.City && this.County) {
        this.show = true
      }
    },
    CountyChange(obj) {
      this.County = obj.DisName || ''
      if (this.Provice && this.City && this.County) {
        this.show = true
      }
    }
  }
}
</script>

<style lang="scss" scoped>
.dashboard-editor-container {
  padding: 20px;
  background-color: rgb(240, 242, 245);
  position: relative;

  .github-corner {
    position: absolute;
    top: 0px;
    border: 0;
    right: 0;
  }

  .chart-wrapper {
    background: #fff;
    padding: 16px 16px 0;
    margin-bottom: 32px;
  }
}

@media (max-width:1024px) {
  .chart-wrapper {
    padding: 8px;
  }
}
  .citySty{
    display: flex;
    align-items: center;
    padding-bottom: 10px;
  }
</style>
