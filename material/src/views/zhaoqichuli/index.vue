<template>
    <div class="app-container">
      <div style="border: 1px solid #c0ccda;border-radius: 4px;padding: 20px">
        <strong>预处理</strong>
        <hr>
        <el-form ref="form" :model="form" label-width="80px">
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
          <el-form-item label="">
            <span style="color: #ff4949;font-size: 12px">提示：请按顺序依次选择处理工艺。</span>
          </el-form-item>
        </el-form>
        <strong>三沼处理</strong>
        <hr>
        <el-form ref="form" :model="form" label-width="80px">
          <el-row>
            <el-col :span="8">
              <el-form-item label="沼渣处理">
                <el-select v-model="zhaozha1" placeholder="请选择" filterable value="" @change="selectChange" style="width: 100%">
                  <el-option
                    v-for="item in options3"
                    :key="item.id"
                    :label="item.label"
                    :value="item.id">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="16" v-if="zhaozhachuli">
              <el-form-item label="处理工艺">
                <el-select v-model="gongyi1" placeholder="请选择" filterable multiple value="" style="width: 100%">
                  <el-option
                    v-for="item in options4"
                    :key="item.id"
                    :label="item.label"
                    :value="item.id">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="8">
              <el-form-item label="沼液处理">
                <el-select v-model="zhaoye1" placeholder="请选择" filterable value="" @change="selectChange1" style="width: 100%">
                  <el-option
                    v-for="item in options5"
                    :key="item.id"
                    :label="item.label"
                    :value="item.id">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="16" v-if="zhaoyechuli">
              <el-form-item label="处理工艺">
                <el-select v-model="gongyi2" placeholder="请选择" filterable multiple value="" style="width: 100%">
                  <el-option
                    v-for="item in options6"
                    :key="item.id"
                    :label="item.label"
                    :value="item.id">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="8">
              <el-form-item label="沼气处理">
                <el-select v-model="zhaoqi1" placeholder="请选择" filterable value="" @change="selectChange2" style="width: 100%">
                  <el-option
                    v-for="item in options7"
                    :key="item.id"
                    :label="item.label"
                    :value="item.id">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="16" v-if="zhaoqichuli">
              <el-form-item label="处理工艺">
                <el-select v-model="gongyi3" placeholder="请选择" filterable multiple value="" style="width: 100%">
                  <el-option
                    v-for="item in options8"
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
            <el-col :span="8">
              <el-form-item label="热循环">
                <el-select v-model="zengwen" placeholder="请选择" filterable value="" @change="selectChange3" style="width: 100%">
                  <el-option
                    v-for="item in options9"
                    :key="item.id"
                    :label="item.label"
                    :value="item.id">
                  </el-option>
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="16" v-if="zengwenleixing">
              <el-form-item label="工艺">
                <el-select v-model="rechuli" placeholder="请选择" filterable multiple value="" style="width: 100%">
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
    </div>
</template>

<script>
    export default {
        name: "index",
      data() {
          return {
            form: {},
            options1: [
              {label: '存储池', id: 1},
              {label: '均质罐', id: 2},
              {label: '水解罐', id: 3},
              {label: '管道制浆机', id: 4}
            ],
            wuliao1: '',
            options2: [
              {label: '秸秆存储间', id: 1},
              {label: '破碎机', id: 2},
              {label: '均质罐', id: 3},
              {label: '水解罐', id: 4},
              {label: '管道制浆机', id: 5}
            ],
            wuliao2: '',
            options3:[
              {label: '有机肥', id: 1}
            ],
            zhaozha1: '',
            zhaozhachuli: false,
            options4: [
              {label: '干式发酵罐', id: 1},
              {label: '固液分离', id: 2},
              {label: '固体有机肥', id: 3}
            ],
            gongyi1: '',
            options5: [
              {label: '完全回流', id: 1}
            ],
            zhaoye1: '',
            options6: [
              {label: '均质罐', id: 1},
              {label: '水解罐', id: 2},
              {label: '发酵罐', id: 3}
            ],
            gongyi2: '',
            zhaoyechuli: false,
            options7: [
              {label: '天然气', id: 1}
            ],
            zhaoye2: '',
            options8: [
              {label: '发酵罐', id: 1},
              {label: '生物脱硫', id: 2},
              {label: '双膜气柜', id: 3},
              {label: '增压', id: 4},
              {label: '膜法提纯', id: 5}
            ],
            gongyi3: '',
            zhaoqichuli: false,
            zhaoqi1: '',
            options9: [
              {label: '沼气加热', id: 1}
            ],
            zengwen: '',
            optionsRechuli: [
              {label: '双膜气柜', id: 1},
              {label: '沼气锅炉', id: 2},
              {label: '热水罐', id: 3}
            ],
            zengwenleixing: false,
            rechuli: ''
          }
      },
      methods: {
        onSubmit() {
          this.$router.push('/liucheng')
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

<style scoped>

</style>
