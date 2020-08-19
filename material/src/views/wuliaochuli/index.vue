<template>
    <div class="app-container wuliao">
      <el-form :model="ruleForm" ref="ruleForm" label-width="120px" class="borderSty box-shadow">
        <el-form-item label="物料选择" prop="value" :rules="[{required: true, message: '请选择物料', trigger: 'change'}]">
          <el-select v-model="ruleForm.value" placeholder="请选择" filterable multiple value="" @change="handleChanges"
                     style="width: 100%;flex: 1">
            <el-option
              v-for="item in options"
              :key="item.material_id"
              :label="item.material_name"
              :value="item.material_id">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="" v-if="ruleForm.numArr.length>0">
          <el-row :gutter="10">
            <div v-for="(item,index) in ruleForm.numArr" :key="index">
              <el-col :span="6" style="padding-bottom: 5px">
                <el-card class="box-card">
                  <div slot="header" class="clearfix" style="display: flex;align-items: center">
                    <div style="flex: 1">{{item.material_name}}</div>
                    <!--                  <div style="float: right; padding: 3px 0">-->
                    <div style="flex: 3">
                      <div>
                        <p style="width: 60px;display: inline-block">ts值:</p><el-input-number v-model="item.material_ts" controls-position="right" :precision="2" placeholder="请填写ts值"/>
                        <br>
                        <p style="width: 60px;display: inline-block">日上料量:</p><el-input-number v-model="item.ri_shangll" controls-position="right" :precision="2" placeholder="请填写日上料量"/>
                      </div>
                    </div>
                  </div>
                  <div class="text item">
                    <p>碳氮比：{{ item.material_cnratio }}</p>
                    <p>密度：{{ item.material_density }}</p>
                  </div>
                </el-card>
              </el-col>
            </div>
          </el-row>
        </el-form-item>
        <el-form-item>
          <div class="btn-right">
            <el-button type="success" round @click="submitForm('ruleForm')">物料分析</el-button>
<!--            <el-button round @click="resetForm('ruleForm')">重置</el-button>-->
          </div>
        </el-form-item>
      </el-form>
<!--      <el-row v-if="message">-->
      <div v-if="show" style="border: 1px solid #c0ccda;border-radius: 4px;padding: 20px">
        <h4 style="text-align: center">物料分析结果</h4>
        <hr>
        <el-row>
          <el-col :span="12" style="border-right: 1px solid #c0ccda;padding: 0 20px">
            <el-row>
              <el-col :span="12"><pie-chart></pie-chart></el-col>
              <el-col :span="12"><yi-bai-chart :valueKey="21.37"></yi-bai-chart></el-col>
            </el-row>
            <div style="display: flex;padding-bottom: 10px">
              <div style="width: 100px">混合料TS：</div>
              <el-progress :text-inside="true" :stroke-width="20" :percentage="26.85" style="flex: 1"></el-progress>
            </div>
            <p style="padding-bottom: 10px"><span style="width: 100px;display: inline-block">工艺建议：</span>含固率较高，建议使用干式发酵</p>
          </el-col>
          <el-col :span="12" style="padding-left: 20px">
            <p style="padding-bottom: 10px"><span style="width: 100px;display: inline-block">工艺类型：</span>
              <el-radio-group v-model="ruleForm.radio" @change="radioChange">
                <el-radio :label="1">干式工艺</el-radio>
                <el-radio :label="2">湿式工艺</el-radio>
              </el-radio-group>
            </p>
<!--            <div style="display: flex;padding-bottom: 10px" v-if="show1">-->
<!--              <p style="width: 100px">补充物：</p>-->
<!--              <el-select v-model="buchongwu" placeholder="请选择" filterable value="" style="width: 100%;flex: 1">-->
<!--                <el-option-->
<!--                  v-for="item in options1"-->
<!--                  :key="item.id"-->
<!--                  :label="item.label"-->
<!--                  :value="item.id">-->
<!--                </el-option>-->
<!--              </el-select>-->
<!--            </div>-->
            <div style="display: flex" v-if="show1">
              <p style="width: 100px">需补充物料：</p>
              <el-row style="flex: 1">
                <el-col :span="24">
                  <el-card class="box-card">
                    <div slot="header" class="clearfix" style="display: flex;align-items: center">
                      <div style="flex: 1">沼液</div>
                      <!--                  <div style="float: right; padding: 3px 0">-->
                      <div style="flex: 3">
                        <div>
                          <p style="width: 70px;display: inline-block">ts值:</p><el-input-number v-model="aaa" controls-position="right" :precision="2" placeholder="请填写ts值"/>
                          <br>
                          <p style="width: 70px;display: inline-block">日上料量:</p><el-input-number v-model="bbb" controls-position="right" :precision="2" placeholder="请填写日上料量"/>
                        </div>
                      </div>
                    </div>
                    <div class="text item">
                      <p>碳氮比：0.0</p>
                      <p>密度：1.05</p>
                    </div>
                  </el-card>
                </el-col>
              </el-row>
            </div>
            <div style="padding-top: 20px;display: flex;justify-content: flex-end">
              <el-button type="success" round @click="next">下一步</el-button>
            </div>
          </el-col>
        </el-row>
      </div>
<!--      <el-row :gutter="20">-->
<!--        <el-col :span="24">-->
<!--          <el-row style="padding-top: 10px">-->
<!--            <el-col :span="12"><pie-chart></pie-chart></el-col>-->
<!--            <el-col :span="12"><yi-bai-chart :valueKey="message.tsCN"></yi-bai-chart></el-col>-->
<!--          </el-row>-->
<!--          <div>-->
<!--            <div style="display: flex;padding-bottom: 10px">-->
<!--              <div style="width: 100px">混合料TS:</div>-->
<!--              <el-progress :text-inside="true" :stroke-width="20" :percentage="message.ts * 100" style="flex: 1"></el-progress>-->
<!--            </div>-->
<!--            <p style="padding-bottom: 10px"><span style="width: 100px;display: inline-block">工艺建议：</span>{{message.gongyi}}</p>-->
<!--            <p style="padding-bottom: 10px"><span style="width: 100px;display: inline-block">工艺类型：</span>-->
<!--              <el-radio-group v-model="ruleForm.radio">-->
<!--                <el-radio :label="1">干式工艺</el-radio>-->
<!--                <el-radio :label="2">湿式工艺</el-radio>-->
<!--              </el-radio-group>-->
<!--            </p>-->
<!--            <div style="display: flex;padding-bottom: 10px">-->
<!--              <p style="width: 100px">补充物：</p>-->
<!--              <el-select v-model="buchongwu" placeholder="请选择" filterable value="" style="width: 100%;flex: 1">-->
<!--                <el-option-->
<!--                  v-for="item in options1"-->
<!--                  :key="item.id"-->
<!--                  :label="item.label"-->
<!--                  :value="item.id">-->
<!--                </el-option>-->
<!--              </el-select>-->
<!--            </div>-->
<!--            <div style="display: flex">-->
<!--              <p style="width: 100px">需补充物料：</p>-->
<!--              <el-row style="flex: 1">-->
<!--                <el-col :span="8">-->
<!--                  <el-card class="box-card">-->
<!--                    <div slot="header" class="clearfix" style="display: flex;align-items: center">-->
<!--                      <div style="flex: 1">秸秆</div>-->
<!--                      &lt;!&ndash;                  <div style="float: right; padding: 3px 0">&ndash;&gt;-->
<!--                      <div style="flex: 3">-->
<!--                        <div>-->
<!--                          <p style="width: 70px;display: inline-block">ts值:</p><el-input-number v-model="aaa" controls-position="right" :precision="2" placeholder="请填写ts值"/>-->
<!--                          <br>-->
<!--                          <p style="width: 70px;display: inline-block">日上料量:</p><el-input-number v-model="bbb" controls-position="right" :precision="2" placeholder="请填写日上料量"/>-->
<!--                        </div>-->
<!--                      </div>-->
<!--                    </div>-->
<!--                    <div class="text item">-->
<!--                      <p>碳氮比：25.36</p>-->
<!--                      <p>密度：34</p>-->
<!--                    </div>-->
<!--                  </el-card>-->
<!--                </el-col>-->
<!--              </el-row>-->
<!--            </div>-->
<!--          </div>-->
<!--        </el-col>-->
<!--      </el-row>-->
    </div>
</template>

<script>
  import PieChart from './component/PieChart'
  import YiBaiChart from './component/yibiaopan'
    export default {
      name: "index",
      components: {PieChart,YiBaiChart},
      data(){
        return{
          show: false,
          show1: false,
          aaa: 0.05,
          bbb:22.86,
          message: '',
          hunheliaoTS: '',
          loading: false,
          tableData: [],
          pVal: '',
          pVal1: [],
          options: [],
          value: '',
          material_ts: '',
          obj: {},
          ruleForm: {
            radio: ''
            ,
            numArr: []
          },
          middleVal: [],
          // middlekey: 0,
          params: [],
          buchongwu: '',
          options1:[
            { label: '秸秆',id: 1},
            { label: '羊粪',id: 2},
            { label: '沼液',id: 3},
            { label: '无',id: 3}
          ]
        }
      },
      created() {
        this.getVal()
      },
      methods: {
        // 获取物料种类
        getVal () {
          this.$axios.get('http://10.10.5.115:10100/getMaterialName')
            .then(res => {
              if (res.status === 200) {
                this.options = res.data
              }
            })
        },
        radioChange() {
          this.show1 = true
        },
        handleChanges (val) {
          this.ruleForm.numArr = []
          this.message = ''
          for (let i = 0; i < val.length; i++) {
            this.options.forEach(item => {
              if (item.material_id === val[i]) {
                this.ruleForm.numArr.push(item)
              }
            })
          }
        },
        submitForm() {
          this.show = true
          this.$axios.post('http://10.10.5.115:10100/getGongYi', this.ruleForm.numArr)
            .then(res => {
              if (res.status === 200) {
                this.message = res.data
              }
            })
        },
        next() {
          this.$router.push('/zhaoqi')
        }
      }
    }
</script>

<style>
.wuliao{
  color: #606266;
}
.wuliao .el-card__body{
  padding: 10px;
}
.wuliao .el-form-item__content{
  line-height: 15px;
}
.wuliao .el-card__header{
  padding: 10px;
}
.wuliao p{
  padding: 0;
  margin: 0;
}
.wuliao h4{
  margin: 0;
}
</style>
