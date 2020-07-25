<template>
  <div class="auth-page">
    <h1>考试系统</h1>
    <keep-alive>
      <component v-bind:is="currentTabComponent" :buttonText="titleList[activeIndex]" :title="titleList[activeIndex]" @register-success="registerSuccess"  @login-success="loginSuccess"></component>
    </keep-alive>
    <el-button v-for="(item, index) in changeButton" :key="index" @click="currentTab = item"> {{ item }} </el-button>
  </div>
</template>

<script>
  import login from './component/login';
  import register from "@/views/mobile/component/register";
  import verification from "@/views/mobile/component/verification";
  export default {
    components: {
      login,
      register,
      verification
    },
    data() {
      return {
        titleList: ["登录", "注册", "验证码登录"],
        currentTab: "login",
        tabs: ["login", "register", "verification"]
      }
    },
    computed: {
      currentTabComponent: function () {
        return this.currentTab;
      },
      changeButton: function () {
        const self = this;
        return this.tabs.filter( function (item) {
          return item !== self.currentTab;
        })
      },
      activeIndex: function () {
        return this.tabs.indexOf(this.currentTab);
      }
    },
    methods: {
      registerSuccess() {
        alert('注册成功 请登录');
        this.currentTab = 'login';
      },
      loginSuccess(id) {
        alert('登录成功');
        const list = this.$route.fullPath.substr(this.$route.fullPath.indexOf('?') + 1).split('&');
        if(list.length > 1) {
          this.$router.push({
            name: 'problem',
            params: {
              startTime: list[1].substr(list[1].indexOf('=') + 1).replace(/%20/g, " ").replace(/%3A/g, ":"),
              endTime: list[2].substr(list[2].indexOf('=') + 1).replace(/%20/g, " ").replace(/%3A/g, ":"),
              limitTime: list[3].substr(list[3].indexOf('=') + 1),
              peopleId: id,
              examPublishRecordId: list[0].substr(list[0].indexOf('=') + 1)
            }
          })
        } else {
          alert("请用二维码进入");
        }
      }
    },
    name: "auth"
  }
</script>

<style scoped>

</style>
