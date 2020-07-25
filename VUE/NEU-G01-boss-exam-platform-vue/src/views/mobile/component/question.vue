<template>
  <div class="problem-main">
    <div class="problem">{{problem.paperSubjectInfo  + ' (' + problem.subjectTotalGrade + ')分'}}</div>
    <div class="select-section">
      <el-radio-group v-model="res" v-if="problem.subjectType === '单选题'">
        <el-radio v-for="( item, index ) in problem.answers" :key="index" :label="item">{{ item }}</el-radio>
      </el-radio-group>
      <el-checkbox-group v-model="res" v-if="problem.subjectType === '多选题'">
        <el-checkbox v-for="( item, index ) in problem.answers" :label="item" :key="index">{{ item }}</el-checkbox>
      </el-checkbox-group>
      <el-input type="textarea" v-model="res" v-if="problem.subjectType === '填空题' || problem.subjectType === '简答题'"></el-input>
      <div class="input-line"  v-if="problem.subjectType === '编程题'">
        给编程题上传图片
        <input @change="uploadPhoto($event)" type="file" class="kyc-passin">
        <img :src="res" alt="" >
      </div>
     </div>
  </div>
</template>
<script>
  // 虽然看起来有很多种题目 但是实际上就是单选 多选 填空 和 传图片的问答 暂时有数据bug 有时间梳理一下 但是不重要
  export default {
    name: "question",
    data() {
      return {
        res: ""
      }
    },
    watch: {
      res: function(val) {
        console.log(val);
        this.$emit('res-change', val);
      }
    },
    props: {
      problem: {
        type: Object,
        default: null
      },
      // 这里用来做保存 就是返回上一题能看到自己之前的结果 没时间就不做了
      oldRes: {
        type: String,
        default: ''
      }
    },
    methods: {
      uploadPhoto(e) {
        const file = e.target.files[0];
        const reader = new FileReader();
        reader.readAsDataURL(file);
        const self = this;
        reader.onload = function (e) {
          const imgCode = e.target.result;
          console.log(imgCode)
          self.res = e.target.result;
        }
      }
    }
  }
</script>

<style scoped>

</style>
