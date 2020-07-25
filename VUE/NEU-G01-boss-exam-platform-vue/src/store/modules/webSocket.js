import { MessageBox } from 'element-ui'
import store from '@/store'

const state = {
  websocket: null,
  websocketonmessage: null
}

const mutations = {
  SET_WEBSOCKET: (state, websocket) => {
    state.websocket = websocket
  },
  SET_WEBSOCKETONMESSAGE: (state, websocketonmessage) => {
    // 根据接收的消息内容进行处理
    state.websocketonmessage = websocketonmessage
    if(websocketonmessage.head.code !== '0'){
      // 退出API
      store.dispatch('user/logout')
      MessageBox.confirm(websocketonmessage.head.message, '提示', {
        showClose: false,
        closeOnClickModal: false,
        closeOnPressEscape: false,
        showCancelButton: false,
        confirmButtonText: '确定',
        type: 'warning'
      }).then(() => {
        // 返回登录页面
        location.reload()
      })

    }
  }
}

const actions = {
  // 初始化websocket
  initWebSocket({commit}, userOnlineInfoId){
    return new Promise((resolve, reject) => {
      // 对应后端ws路径education/bes/v1/system-manager-center/onlineUser/websocket/
      const wsuri = `ws://localhost:9003/education/bes/v1/system-manager-center/onlineUser/websocket/${userOnlineInfoId}`
      commit('SET_WEBSOCKET', new WebSocket(wsuri))

      // 接收消息方法，因为我这边现在只需要接收消息所以只定义了这个，还有发送消息，连接失败处理等等...
      state.websocket.onmessage = function(e){
        // 因为发过来的是String类型，所以先转为json对象
        let res = JSON.parse(e.data)
        commit('SET_WEBSOCKETONMESSAGE', res)
      }
      resolve()
    })
  },
  // 销毁websocket
  destoryedWebSocket(){
    return new Promise((resolve) => {
      state.websocket.close()
      resolve()
    })
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}
