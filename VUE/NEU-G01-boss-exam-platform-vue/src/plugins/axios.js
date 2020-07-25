'use strict'

import Vue from 'vue'
import axios from 'axios'
import store from '@/store'
import router from "@/router";
import { getToken, removeToken } from '@/utils/auth'
import {getUserId} from "@/utils/userInfo";
import {
  isMobile
} from '../utils/validate'
import {
  format
} from '../utils/dateTool'
import {Message} from "element-ui";

// Full config:  https://github.com/axios/axios#request-config
// axios.defaults.baseURL = process.env.baseURL || process.env.apiUrl || '';
// axios.defaults.headers.common['Authorization'] = AUTH_TOKEN;
// axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';

const config = {
  // baseURL: process.env.baseURL || process.env.apiUrl || ""
  // timeout: 60 * 1000, // Timeout
  // withCredentials: true, // Check cross-site Access-Control
}

const _axios = axios.create(config)

_axios.interceptors.request.use(
  function(config) {
    config.headers.common = {
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Headers': 'X-Requested-With,Content-Type',
      'Access-Control-Allow-Methods': 'PUT,POST,GET,DELETE,OPTIONS'
    }
    if (getToken()) {
      config.headers.token = getToken()
    }
    //设备类型 0为pc 1为手机
    const deviceType = isMobile()
    const device = navigator.userAgent; // 设备机型的相关信息
    const deviceId = navigator.userAgent.substring(device.indexOf('(') + 1, device.indexOf(';')); //处理信息，输出设备
    // 先拿到这之后的，之后再切分
    const tempBrowser = device.substring(device.lastIndexOf(')') + 2)
    const browser = tempBrowser.substring(0, tempBrowser.indexOf(' '))
    //格式化日期
    const globalMessageNumber = format(new Date(), 'yyyyMMddHHmmss')

    const tempData = config.data
    config.data = {
      head: {
        deviceId: deviceId,
        deviceType: deviceType,
        operateSystemOrBrowser: browser,
        globalMessageNumber: globalMessageNumber
      },
      body: tempData
    }
    return config
  },
  function(error) {
    alert(error)
    return Promise.reject(error)
  }
)

// 回复拦截器
_axios.interceptors.response.use(
  function(response) {
    const { data } = response
    const { head } = data
    const { body } = data
    if( head.code != 200){
      console.log(body)
      console.log(head.code == 250101)
      if( head.code != 100102){
        console.log(body)
        Message({
          message: head.code + ':' + body,
          type: 'error',
          duration: 5 * 1000
        })
        //token失效等异常则返回登录界面
        if( head.code == 100101 || head.code == 100103 || head.code == 100104){
          //移除cookie的token
          removeToken()
          router.push('/login')
        }
      }
    } else{
      return response
    }
  },
  function(error) {
    Message({
      message: error,
      type: 'error',
      duration: 5 * 1000
    })
    return Promise.reject(error)
  }
)

Plugin.install = function(Vue, options) {
  Vue.axios = _axios
  window.axios = _axios
  Object.defineProperties(Vue.prototype, {
    axios: {
      get() {
        return _axios
      }
    },
    $axios: {
      get() {
        return _axios
      }
    }
  })
}

Vue.use(Plugin)

export default Plugin
