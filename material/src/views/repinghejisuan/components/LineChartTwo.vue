<template>
  <div :class="className" :style="{height:height,width:width}" />
</template>

<script>
  import echarts from 'echarts'
  require('echarts/theme/macarons') // echarts theme
  import resize from './mixins/resize'

  const animationDuration = 6000

  export default {
    mixins: [resize],
    props: {
      className: {
        type: String,
        default: 'chart'
      },
      width: {
        type: String,
        default: '100%'
      },
      height: {
        type: String,
        default: '300px'
      }
    },
    data() {
      return {
        chart: null
      }
    },
    mounted() {
      this.$nextTick(() => {
        this.initChart()
      })
    },
    beforeDestroy() {
      if (!this.chart) {
        return
      }
      this.chart.dispose()
      this.chart = null
    },
    methods: {
      initChart() {
        this.chart = echarts.init(this.$el, 'macarons')
        const that = this
        this.chart.setOption({
          title: {
            show:true,
            text: '物料月平均热耗',
            // padding: 0,
            // textAlign: 'center',
            textStyle: {//主标题文本样式
              // {"fontSize": 18,"fontWeight": "bolder","color": "#333"}
              fontSize: 12,
              color: '#000',
              fontStyle: 'normal',
              fontWeight: 'normal'
            },
          },
          tooltip: {
            trigger: 'axis',
            axisPointer: { // 坐标轴指示器，坐标轴触发有效
              type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
            }
          },
          grid: {
            top: 30,
            left: '2%',
            right: '2%',
            bottom: '3%',
            containLabel: true
          },
          xAxis: [{
            type: 'category',
            data: ['1月', '2月', '3月', '4月','5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
            axisTick: {
              alignWithLabel: true
            }
          }],
          yAxis: [{
            type: 'value',
            axisTick: {
              show: false
            }
          }],
          series: [{
            name: '猪粪',
            type: 'bar',
            tiled: 'vistors',
            barWidth: '30%',
            data: [20, 18, 16, 13, 10, 8, 5, 8, 10, 13, 15, 18],
            animationDuration
          },
          {
            name: '玉米黄贮',
            type: 'bar',
            tiled: 'vistors',
            barWidth: '30%',
            data: [30, 27, 24, 20, 16, 13, 10, 13, 16, 20, 25, 27],
            animationDuration
          }]
        })
      }
    }
  }
</script>
