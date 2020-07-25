<template>
  <div class="form">
    <h2 class="form-title">{{ title }}</h2>
    <div class="form-wrapper">
      <el-input v-model="phone" placeholder="请输入手机号"></el-input>
      <el-input v-model="verificationCode" placeholder="请输入短信验证码"></el-input>
      <el-button @click.native="sendCode"> 发送验证码</el-button>
    </div>
    <el-button @click.native="login">{{ buttonText }}</el-button>
  </div>
</template>

<script>
  import utils from "@/views/mobile/utils";
  export default {
    name: "verification",
    data() {
      return {
        phone: "",
        verificationCode: "",
        checkCode: "",
        peopleId: ""
      }
    },
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
    methods: {
      sendCode() {
        utils.request('exam/phone/login/message', this.phone, 'post', this).then(res => {
          console.log(res);
          this.checkCode = res.data.body.authCode;
          this.peopleId = res.data.body.peopleId;
        });
      },
      login() {
        if (this.checkCode === this.verificationCode) {
          console.log("登录成功");
          this.$emit('login-success', this.peopleId);
        } else {
          alert("验证码错误");
        }
      }

    }
  }
</script>

<style scoped>

</style>
