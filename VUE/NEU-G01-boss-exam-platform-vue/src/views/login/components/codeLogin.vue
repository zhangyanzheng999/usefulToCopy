<template>
  <el-form class="login-form" status-icon :rules="loginRules" ref="loginForm" :model="loginForm" label-width="0">
    <el-form-item prop="phone">
      <el-input size="small" @keyup.enter.native="handleLogin" v-model="loginForm.phone" auto-complete="off" placeholder="请输入手机号码">
        <i slot="prefix" class="icon-shouji"></i>
      </el-input>
    </el-form-item>
    <el-form-item prop="code">
      <el-input size="small" @keyup.enter.native="handleLogin" v-model="loginForm.code" auto-complete="off" placeholder="请输入验证码">
        <i slot="prefix" class="icon-yanzhengma yanzhengma" style=""></i>
        <template slot="append">
          <span @click="handleSend" class="msg-text" :class="[{display:msgKey}]">{{msgText}}</span>
        </template>
      </el-input>
    </el-form-item>
    <el-checkbox v-model="checked">记住手机号</el-checkbox>
    <el-form-item>
      <el-button size="small" type="primary" @click.native.prevent="handleLogin" class="login-submit">登录</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
  // import { getUserCode } from '../../api/system-manager/user'

const MSGINIT = '发送验证码'
// const MSGERROR = '验证码发送失败'
const MSGSCUCCESS = '${time}秒后重发'
const MSGTIME = 60
import Cookies from 'js-cookie'
// import { isvalidatemobile } from '@/utils/validate'
export default {
  name: 'codelogin',
  data() {
    const validatePhone = (rule, value, callback) => {
      if (isvalidatemobile(value)[0]) {
        callback(new Error(isvalidatemobile(value)[1]))
      } else {
        callback()
      }
    }
    const validateCode = (rule, value, callback) => {
      if (value.length !== 6) {
        callback(new Error('请输入6位数的验证码'))
      } else {
        callback()
      }
    }
    return {
      checked: false,
      msgText: MSGINIT,
      msgTime: MSGTIME,
      msgKey: false,
      loginForm: {
        phone: '',
        code: ''
      },
      loginRules: {
        phone: [{ required: true, trigger: 'blur', validator: validatePhone }],
        code: [{ required: true, trigger: 'blur', validator: validateCode }]
      }
    }
  },
  created() {},
  mounted() {
    this.loginForm.phone = Cookies.get('phone')
    if(Cookies.get('rememberPhone') === 'true'){
      this.checked = true
    }
  },
  computed: {
  },
  props: [],
  methods: {
    handleSend() {
      if (this.msgKey) return
      getUserCode(this.loginForm.phone).then(res => {
        if (res.data.header.responseCode === '0') {
          this.$message({
            message: '请查看手机短信，填写验证码',
            type: 'success'
          })
        } else {
          this.$notify.error({
            title: res.data.header.responseCode,
            message: res.data.header.message
          })
        }
      })
      this.msgText = MSGSCUCCESS.replace('${time}', this.msgTime)
      this.msgKey = true
      const time = setInterval(() => {
        this.msgTime--
        this.msgText = MSGSCUCCESS.replace('${time}', this.msgTime)
        if (this.msgTime === 0) {
          this.msgTime = MSGTIME
          this.msgText = MSGINIT
          this.msgKey = false
          clearInterval(time)
        }
      }, 1000)
    },
    handleLogin() {
      this.$refs.loginForm.validate(valid => {
        if (valid) {
          this.$store.dispatch('PhoneLogin', this.loginForm).then(res => {
            if (res.responseCode !== '0') {
              this.$message({
                message: res.message,
                type: 'error'
              })
            } else {
              if(this.checked == true){
                Cookies.set('phone', this.loginForm.phone)
                Cookies.set('rememberPhone', true)
              } else {
                Cookies.set('phone', '')
                Cookies.set('rememberPhone', '')
              }
              this.$router.push({ path: '/system-manager/user' })
            }
          })
        }
      })
    },

    /**
     * 判断手机号码是否正确
     */
    isvalidatemobile(phone) {
      const list = []
      let result = true
      let msg = ''
      var isPhone = /^0\d{2,3}-?\d{7,8}$/
      // 增加134 减少|1349[0-9]{7}，增加181,增加145，增加17[678]
      // const isMob = /^((\+?86)|(\(\+86\)))?(13[0123456789][0-9]{8}|15[012356789][0-9]{8}|18[012356789][0-9]{8}|14[57][0-9]{8}|17[3678][0-9]{8})$/
      if (!validatenull(phone)) {
        if (phone.length === 11) {
          if (isPhone.test(phone)) {
            msg = '手机号码格式不正确'
          } else {
            result = false
          }
        } else {
          msg = '手机号码长度不为11位'
        }
      } else {
        msg = '手机号码不能为空'
      }
      list.push(result)
      list.push(msg)
      return list
    }

  }
}
</script>

<style scoped="true">
  .el-form-item{
    height: 40px;
  }
.yanzhengma{
  display:block;
  margin-top: 8px;
}
.msg-text {
  display: block;
  width: 60px;
  font-size: 12px;
  text-align: center;
  cursor: pointer;
}
.msg-text.display {
  color: #ccc;
}
</style>
