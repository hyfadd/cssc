<template>
    <div class="app-container shebei">
      <el-row :gutter="20">
        <el-col :span="24">
          <div style="border: 1px solid #c0ccda;border-radius: 4px;padding: 20px">
            <strong>预处理</strong>
            <hr>
            <el-form ref="form" :model="form" label-width="80px">
              <el-row>
                <el-col :span="16">
                  <el-form-item label="猪粪">
                    <el-select v-model="wuliao1" placeholder="请选择" filterable multiple value="" style="width: 100%">
                      <el-option
                        v-for="item in options1"
                        :key="item.id"
                        :label="item.label"
                        :value="item.id">
                      </el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label="动力">
                    <el-select v-model="zhufen" placeholder="请选择" value="" style="width: 100%">
                      <el-option
                        v-for="item in optionsRechuli"
                        :key="item.id"
                        :label="item.label"
                        :value="item.id">
                      </el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="16">
                  <el-form-item label="玉米黄贮">
                    <el-select v-model="wuliao2" placeholder="请选择" filterable multiple value="" style="width: 100%">
                      <el-option
                        v-for="item in options2"
                        :key="item.id"
                        :label="item.label"
                        :value="item.id">
                      </el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="8">
                  <el-form-item label="动力">
                    <el-select v-model="yumi" placeholder="请选择" filterable value="" style="width: 100%">
                      <el-option
                        v-for="item in optionsRechuli"
                        :key="item.id"
                        :label="item.label"
                        :value="item.id">
                      </el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
              </el-row>
<!--              <el-form-item label="">-->
<!--                <span style="color: #ff4949;font-size: 12px">提示：点击。</span>-->
<!--              </el-form-item>-->
            </el-form>
            <strong>三沼处理</strong>
            <hr>
            <el-form ref="form" :model="form" label-width="80px">
              <el-row>
                <el-col :span="16">
                  <el-form-item label="沼渣处理">
                    <el-select v-model="zhaozha1" placeholder="请选择" filterable multiple value="" @change="selectChange" style="width: 100%">
                      <el-option
                        v-for="item in options3"
                        :key="item.id"
                        :label="item.label"
                        :value="item.id">
                      </el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
<!--                v-if="zhaozhachuli"-->
                <el-col :span="8">
                  <el-form-item label="动力">
                    <el-select v-model="gongyi1" placeholder="请选择" filterable value="" style="width: 100%">
                      <el-option
                        v-for="item in optionsRechuli"
                        :key="item.id"
                        :label="item.label"
                        :value="item.id">
                      </el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="16">
                  <el-form-item label="沼液处理">
                    <el-select v-model="zhaoye1" placeholder="请选择" filterable multiple value="" @change="selectChange1" style="width: 100%">
                      <el-option
                        v-for="item in options5"
                        :key="item.id"
                        :label="item.label"
                        :value="item.id">
                      </el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
<!--                v-if="zhaoyechuli"-->
                <el-col :span="8">
                  <el-form-item label="动力">
                    <el-select v-model="gongyi2" placeholder="请选择" filterable value="" style="width: 100%">
                      <el-option
                        v-for="item in optionsRechuli"
                        :key="item.id"
                        :label="item.label"
                        :value="item.id">
                      </el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-row>
                <el-col :span="16">
                  <el-form-item label="沼气处理">
                    <el-select v-model="zhaoqi1" placeholder="请选择" filterable multiple value="" @change="selectChange2" style="width: 100%">
                      <el-option
                        v-for="item in options7"
                        :key="item.id"
                        :label="item.label"
                        :value="item.id">
                      </el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
<!--                v-if="zhaoqichuli"-->
                <el-col :span="8">
                  <el-form-item label="动力">
                    <el-select v-model="zhaoqi2" placeholder="请选择" filterable value="" style="width: 100%">
                      <el-option
                        v-for="item in optionsRechuli"
                        :key="item.id"
                        :label="item.label"
                        :value="item.id">
                      </el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
              </el-row>

            </el-form>
            <strong>热循环</strong>
            <hr>
            <el-form ref="form" :model="form" label-width="80px">
              <el-row>
                <el-col :span="16">
                  <el-form-item label="热循环">
                    <el-select v-model="zengwen" placeholder="请选择" filterable multiple value="" @change="selectChange3" style="width: 100%">
                      <el-option
                        v-for="item in options9"
                        :key="item.id"
                        :label="item.label"
                        :value="item.id">
                      </el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
<!--                v-if="zengwenleixing"-->
                <el-col :span="8">
                  <el-form-item label="动力">
                    <el-select v-model="rechuli" placeholder="请选择" filterable value="" style="width: 100%">
                      <el-option
                        v-for="item in optionsRechuli"
                        :key="item.id"
                        :label="item.label"
                        :value="item.id">
                      </el-option>
                    </el-select>
                  </el-form-item>
                </el-col>
              </el-row>
              <el-form-item>
                <el-button type="primary" @click="onSubmit">立即创建</el-button>
                <el-button>取消</el-button>
              </el-form-item>
            </el-form>
          </div>
        </el-col>
<!--        <el-col :span="4" style="border: 1px solid #c0ccda;border-radius: 4px;padding: 20px">-->
<!--          <h3 style="text-align: center">备选库</h3>-->
<!--          <strong>类型</strong>-->
<!--          <hr>-->
<!--          <div style="text-align: center">-->
<!--            <p>螺旋泵</p>-->
<!--            <p>转子泵</p>-->
<!--            <p>离心泵</p>-->
<!--            <p>真空泵</p>-->
<!--            <p>柱塞泵</p>-->
<!--            <p>螺旋输送</p>-->
<!--            <p>传送带</p>-->
<!--          </div>-->
<!--          <strong>品牌（暂无）</strong>-->
<!--          <div style="text-align: center">-->


<!--          </div>-->
<!--          <hr>-->
<!--        </el-col>-->
      </el-row>
    </div>
</template>

<script>
    export default {
        name: "index",
      data() {
          return {
            zhaoqi2: '',
            form: {},
            options1: [
              {label: '立式储存罐', id: 1},
              {label: '均质罐', id: 2},
              {label: '水解罐', id: 3},
              {label: '管道制浆机', id: 4}
            ],
            wuliao1: [1, 2, 3, 4],
            options10: [
              {label: '螺杆泵', id: 1}
            ],
            zhufen: '',
            options2: [
              {label: '秸秆存储间', id: 1},
              {label: '破碎机', id: 2},
              {label: '均质罐', id: 3},
              {label: '水解罐', id: 4},
              {label: '管道制浆机', id: 5}
            ],
            wuliao2: [1,2,3,4,5],
            options3:[
              {label: '卧式发酵罐', id: 1},
              {label: '板框压滤机', id: 2}

            ],
            options11: [
              {label: '螺旋输送', id: 1}
            ],
            yumi: '',
            zhaozha1: [1,2],
            zhaozhachuli: false,
            options4: [
              {label: '螺旋输送', id: 1},
            ],
            gongyi1: '',
            options5: [
              {label: '无', id: 1}
            ],
            zhaoye1: [1],
            options6: [
              {label: '螺杆泵', id: 1}
            ],
            gongyi2: '',
            zhaoyechuli: false,
            options7: [
              {label: '正负压保护器', id: 1},
              {label: '脱硫系统', id: 2},
              {label: '双模储柜', id: 3},
              {label: '汽水分离机', id: 4},
              {label: '罗茨风机', id: 5},
              {label: '冷干机', id: 6},
              {label: '撬装膜提纯系统', id: 7}
            ],
            zhaoye2: '',
            options8: [
              {label: '罗茨风机', id: 1}
            ],
            gongyi3: '',
            zhaoqichuli: false,
            zhaoqi1: [1,2,3,4,5,6,7],
            options9: [
              {label: '阻火器', id: 1},
              {label: '常压沼气锅炉', id: 2},
              {label: '钢制热水罐', id: 3}
            ],
            zengwen: [1,2,3],
            optionsRechuli: [
              {label: '螺杆泵', id: 1},
              {label: '转子泵', id: 2},
              {label: '离心泵', id: 3},
              {label: '真空泵', id: 4},
              {label: '传送带', id: 5},
              {label: '柱塞泵', id: 6},
              {label: '螺旋输送', id: 7},
              {label: '风机', id:8}
            ],
            zengwenleixing: false,
            rechuli: ''
          }
      },
      methods: {
        onSubmit() {
          this.$router.push('/pingheng')
        },
        selectChange(str) {
          this.zhaozhachuli = !!str
        },
        selectChange1(str) {
          this.zhaoyechuli = !!str
        },
        selectChange2(str) {
          this.zhaoqichuli = !!str
        },
        selectChange3(str) {
          this.zengwenleixing = !!str
        }
      }
    }
</script>

<style>
.shebei h3{
  margin: 0;
}
</style>
