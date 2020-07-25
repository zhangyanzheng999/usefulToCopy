<template>
  <div class="form">
    <h2 class="form-title">{{ title }}</h2>
    <div class="form-wrapper">
      <div class="input-line" v-for="(item, index) in form" :key="index">
        {{ descriptionList[Object.keys(form).indexOf(index)] }}
        <el-input v-model="form[index]"
                  :placeholder="'请输入'+descriptionList[Object.keys(form).indexOf(index)]"></el-input>
      </div>
      <div class="input-line graduationDate">
        请选择毕业时间
        <el-date-picker
          v-model="graduationDate"
          type="date"
          placeholder="选择日期">
        </el-date-picker>
      </div>
      <div class="input-line">
        性别
        <el-select v-model="sex" slot="prepend" placeholder="请选择">
          <el-option label="男" value="0"></el-option>
          <el-option label="女" value="1"></el-option>
        </el-select>
      </div>
      <div class="input-line">
        学历
        <el-select v-model="degree" slot="prepend" placeholder="请选择">
          <el-option label="本科" value="本科"></el-option>
          <el-option label="硕士" value="硕士"></el-option>
          <el-option label="博士" value="博士"></el-option>
        </el-select>
      </div>
      <div class="input-line">
        上传图片
        <input @change="uploadPhoto($event)" type="file" class="kyc-passin">
        <img :src="photoUrl" alt="" >
      </div>
    </div>
    <el-button @click="register"> {{ buttonText }}</el-button>
  </div>
</template>

<script>
import {format} from "@/utils/dateTool";
  import utils from "@/views/mobile/utils";
  export default {
    name: "register",
    props: {
      title: {
        type: String,
        default: ""
      },
      buttonText: {
        type: String,
        default: ""
      }
    },
    data() {
      return {
        form: {
          mobile: "",
          password: "",
          name: "",
          email: "",
          school: "",
          major: "",
          englishLevel: "",
          jobExplain: "",
          workExperience: "",
          award: "",
          remark: "",
        },
        sex: "",
        graduationDate: "",
        photoUrl: "",
        degree: "",
        descriptionList: ['手机号', '密码', '姓名', '邮箱', '毕业院校', '专业', '英语等级', '在校职务', '实习经历', '获奖信息', '备注']
      }
    },
    methods: {
      register() {
        let checkRes = utils.checkForm(this.form, utils.regexList);
        if (checkRes === '') {
          utils.request('exam/phone/register', utils.mixin(this.form, {
            sex: this.sex,
            graduationDate: format(this.graduationDate, 'yyyy-MM-dd HH:mm:ss'),
            photoUrl: this.photoUrl,
            degree: this.degree
          }), 'post', this).then((res) => {
            console.log(res);
            if (res.data === '') {
              this.$emit('register-success');
            }
          })
        } else {
          alert(checkRes);
        }
      },
      uploadPhoto(e) {
        const file = e.target.files[0];
        const reader = new FileReader();
        reader.readAsDataURL(file);
        const self = this;
        reader.onload = function (e) {
          const imgCode = e.target.result;
          console.log(imgCode)
          self.photoUrl = e.target.result;
        }
      }
    }
  }
</script>

<style scoped>

</style>
