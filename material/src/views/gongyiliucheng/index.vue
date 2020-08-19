<template>
  <div class="app-container">
    <el-tabs v-model="activeName" type="border-card" @tab-click="tabChange">
      <el-tab-pane label="工艺流程" name="first">
        <img src="./timg.jpg" alt="">
      </el-tab-pane>
      <el-tab-pane label="物料平衡" name="second">
        <img src="./timg1.jpg" alt="">
      </el-tab-pane>
    </el-tabs>
    <el-button type="primary" @click="next" style="padding-top: 10px">下一步</el-button>
  </div>
</template>

<script>
export default {
  name: 'Tab',
  data() {
    return {
      activeName: 'first',
    }
  },
  watch: {
    activeName(val) {
      this.$router.push(`${this.$route.path}?tab=${val}`)
    }
  },
  created() {
    // init the default selected tab
    const tab = this.$route.query.tab
    if (tab) {
      this.activeName = tab
    }
  },
  methods: {
    next() {
      this.$router.push('/shebei')
    },
    tabChange(obj) {
      console.log(obj, 'sssssssss')
      this.activeName = obj.name
    }
  }
}
</script>
