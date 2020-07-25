<template>
  <div class="form">
    <h2 class="form-title">{{ title }}</h2>
    <div class="form-wrapper">
      <el-input v-model="form.phoneNum"></el-input>
      <el-input v-model="form.password" type="password" show-password></el-input>
    </div>
    <el-button @click.native="handleLogin">{{ buttonText }}</el-button>

  </div>
</template>

<script>
  import util from '../utils';

  export default {
    data() {
      return {
        form: {
          phoneNum: "",
          password: ""
        }
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
      handleLogin() {
        util.request('exam/phone/login', this.form, 'post', this).then(res => {
          if (res.data.body !== -1) {
            console.log(res.data.body)
            this.$emit('login-success', res.data.body);
            util.resetForm(this.form);
          } else {
            alert('用户名或密码错误');
          }
        });
      }
    },
    name: "login"
  }
</script>

<style scoped>

</style>
