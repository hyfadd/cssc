<template>
  <div :class="className" :style="{height:height,width:width}" />
</template>

<script>
  import echarts from 'echarts'
  require('echarts/theme/macarons') // echarts theme
  import resize from './mixins/resize'

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
      },
      autoResize: {
        type: Boolean,
        default: true
      },
      chartData: {
        type: Object,
        required: true
      }
    },
    data() {
      return {
        chart: null,
        chartList: [12, 78, 93, 65, 34, 78, 45, 87, 77, 34, 54, 99]
      }
    },
    watch: {
      chartData: {
        deep: true,
        handler(val) {
          this.setOptions(val)
        }
      }
    },
    mounted() {
      const _this = this //声明一个变量指向Vue实例this，保证作用域一致
      this.timer = setInterval(function(){
        for (let i=0;i<_this.chartList.length;i++) {
          _this.chartList[i] = parseInt(Math.random()*100)
        }
      },5000)
      console.log(_this.chartList, 'kkkkkkkkkkkkkkkkkkkkk')
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
      if(this.timer){
        clearInterval(this.timer);  //在Vue实例销毁前，清除我们的定时器
      }
    },
    methods: {
      initChart() {
        this.chart = echarts.init(this.$el, 'macarons')
        this.setOptions(this.chartData)
      },
      setOptions({ expectedData, actualData } = {}) {
        this.chart.setOption({
          title: {
            show:true,
            text: '当地月平均气温',
            textStyle: {//主标题文本样式{"fontSize": 18,"fontWeight": "bolder","color": "#333"}
              fontSize: 12,
              color: '#3888fa',
              fontStyle: 'normal',
              fontWeight: 'normal',
            },
          },
          xAxis: {
            data: [],
            boundaryGap: false,
            axisTick: {
              show: false
            }
          },
          grid: {
            left: 10,
            right: 10,
            bottom: 20,
            top: 30,
            containLabel: true
          },
          tooltip: {
            trigger: 'axis',
            axisPointer: {
              type: 'cross'
            },
            padding: [5, 10]
          },
          yAxis: {
            axisTick: {
              show: false
            }
          },
          legend: {
            data: [
              'expected',
              '当地月平均气温'
            ]
          },
          series: [
            //   {
            //   name: 'expected', itemStyle: {
            //     normal: {
            //       color: '#FF005A',
            //       lineStyle: {
            //         color: '#FF005A',
            //         width: 2
            //       }
            //     }
            //   },
            //   smooth: true,
            //   type: 'line',
            //   data: expectedData,
            //   animationDuration: 2800,
            //   animationEasing: 'cubicInOut'
            // },
            {
              name: '气温（℃）',
              smooth: true,
              type: 'line',
              itemStyle: {
                normal: {
                  color: '#3888fa',
                  lineStyle: {
                    color: '#3888fa',
                    width: 2
                  },
                  areaStyle: {
                    color: '#f3f8ff'
                  }
                }
              },
              data: this.chartList,
              animationDuration: 2800,
              animationEasing: 'quadraticOut'
            }]
        })
      }
    }
  }
</script>
