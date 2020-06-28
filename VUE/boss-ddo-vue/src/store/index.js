import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
  state: {
    // 存储token
    Authorization: localStorage.getItem('Authorization') ? localStorage.getItem('Authorization') : ''
  },
  mutations: {
    // 修改token，并将token存入localStorage
    setToken(state,data) {
      state.Authorization = data.Authorization;
      localStorage.setItem('Authorization', data.Authorization);
    }
  },
  actions: {},
  modules: {}
})
export default store