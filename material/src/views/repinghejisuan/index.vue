<template>
    <div class="app-container">
      <el-button type="primary">填写信息</el-button>
      <el-button type="primary" @click="clickHandle">导入信息</el-button>
      <el-row v-if="show">
        <el-col :span="12">
          <line-chart :chart-data="lineChartData" />
        </el-col>
        <el-col :span="12">
          <line-chart-two />
        </el-col>
        <el-col :span="12">
          <bar-chart :titleVal="val" :nameVal="val3" />
        </el-col>
        <el-col :span="12">
          <bar-chart :titleVal="val2" :nameVal="val4" />
        </el-col>
      </el-row>
    </div>
</template>

<script>
  import LineChart from './components/LineChart'
  import LineChartTwo from './components/LineChartTwo'
  import BarChart from './components/BarChart'
  export default {
    name: "index",
    components: {
      LineChartTwo,
      LineChart,
      BarChart
    },
    data() {
      return {
        show: false,
        val: '设备月平均热损',
        val2: '月需补充热',
        val3: '热损',
        val4: '补充热',
        lineChartData: {
          expectedData: [30, 100, 91, 154, 140, 162, 145, 82, 55, 60, 40, 10],
          actualData: [ -7.8,-3.5, 2.9, 10.6, 18.7, 24.3, 25.8, 22.6, 17.1, 10.7, 0.8, 0.9]
        }
      }
    },
    methods: {
      clickHandle() {
        this.show = true
      }
    }
    }
</script>

<style scoped>

</style>
