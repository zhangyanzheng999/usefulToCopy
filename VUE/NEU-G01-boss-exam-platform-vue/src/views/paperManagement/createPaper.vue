<template>
  <div class="app-container">
     <el-tabs v-model="activeName" @tab-click="clickTab" type="card">
       <el-tab-pane  name="zero">
        <span slot="label"><i class="el-icon-document"></i> 试卷明细</span>
        <PaperDetails v-if="isZero"></PaperDetails>
        </el-tab-pane>
        <el-tab-pane  name="first">
            <span slot="label"><i class="el-icon-edit"></i> 快速组卷</span>
            <QuickCreatePaper v-if="isFirst"></QuickCreatePaper>
        </el-tab-pane>
        <el-tab-pane label="标准组卷" name="second">
            <span slot="label"><i class="el-icon-star-off"></i> 标准组卷</span>
            <StandardCreatePaper v-if="isSecond"></StandardCreatePaper>
        </el-tab-pane>
        <el-tab-pane label="模板组卷" name="third">
            <span slot="label"><i class="el-icon-edit-outline"></i> 模板组卷</span>
            <CreatePaperWithTemplate v-if="isthird"></CreatePaperWithTemplate>
        </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
// options components
import PaperDetails from "./components/PaperDetails";
import CreatePaperWithTemplate from "./components/CreatePaperWithTemplate"
import QuickCreatePaper from "./components/QuickCreatePaper"
import StandardCreatePaper from "./components/StandardCreatePaper"
import {bus} from '@/router/modules/paperManage'
export default {
  name: "MaintainPaper",
  components: {
    PaperDetails,
    CreatePaperWithTemplate,
    QuickCreatePaper,
    StandardCreatePaper
  },
  data(){
    return{
      activeName: 'zero',
      isZero: true,
      isFirst:false,
      isSecond:false,
      isthird: false
    };
  },
  created(){

  },
  methods:{
    clickTab(tab){ 
      bus.$on('open',(val)=>{
          this.isZero = false,
          this.isFirst = val,
          this.isSecond = false,
          this.isthird = false
          this.activeName='first'
      })
      if (tab.name === 'zero') {
        this.isZero = true,
        this.isFirst = false,
        this.isSecond = false,
        this.isthird = false
      } else if (tab.name === 'first') {
        this.isZero = false,
        this.isFirst = true,
        this.isSecond = false,
        this.isthird = false
      } else if (tab.name === 'second') {
        this.isZero = false,
        this.isFirst = false,
        this.isSecond = true,
        this.isthird = false
      } else if (tab.name === 'third') {
        this.isZero = false,
        this.isFirst = false,
        this.isSecond = false,
        this.isthird = true
      }

    }
  },
};
</script>
<style>

</style>