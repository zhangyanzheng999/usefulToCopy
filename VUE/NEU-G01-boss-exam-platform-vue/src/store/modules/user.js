import {
  login,
  logout,
  getInfo
} from '@/api/user'
import {
  getToken,
  setToken,
  removeToken
} from '@/utils/auth'
import {
  getUserId,
  setUserId,
  removeUserId,
  getCompanyId,
  setCompanyId,
  removeCompanyId,
  getOrganizationId,
  setOrganizationId,
  removeOrganizationId
} from '@/utils/userInfo'
import router, {
  resetRouter
} from '@/router'

const state = {
  token: getToken(),
  name: '',
  avatar: '',
  introduction: '',
  roles: [],
  resources: []
}

const mutations = {
  SET_TOKEN: (state, token) => {
    state.token = token
  },
  SET_INTRODUCTION: (state, introduction) => {
    state.introduction = introduction
  },
  SET_NAME: (state, name) => {
    state.name = name
  },
  SET_AVATAR: (state, avatar) => {
    state.avatar = avatar
  },
  SET_ROLES: (state, roles) => {
    state.roles = roles
  },
  SET_RESOURCES: (state, resources) => {
    state.resources = resources
  }
}

const actions = {
  // 用户登录
  login({
    commit
  }, userInfo) {
    const {
      code,
      password
    } = userInfo
    return new Promise((resolve, reject) => {
      login({
        code: code.trim(),
        password: password
      }).then(response => {
        const data = response.data.body
        setToken(data.token)
        setUserId(data.userId)
        setCompanyId(data.companyId)
        setOrganizationId(data.organizationId)


        resolve()
      }).catch(error => {
        reject(error)
      })
    })
  },

  // get user info
  getInfo({
    commit,
    state
  }) {
    return new Promise((resolve, reject) => {
      const token = getToken()
      getInfo(token).then(response => {
        const data = response.data.body
        //console.log(data)
        if (!data) {
          reject('Verification failed, please Login again.')
        }

        const {
          roles,
          resources /*, name, avatar, introduction*/
        } = data

        //console.log(resources)
        // roles must be a non-empty array
        if (!roles || roles.length <= 0) {
          reject('角色为空！')
        }

        commit('SET_ROLES', roles)
        commit('SET_RESOURCES', resources)
        commit('SET_NAME', 'Normal manager')
        commit('SET_AVATAR', 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif')
        commit('SET_INTRODUCTION', 'introduction')
        resolve(data)
      }).catch(error => {
        reject(error)
      })
    })
  },

  // user logout
  logout({
    commit,
    state,
    dispatch
  }) {
    const userId = getUserId()
    return new Promise((resolve, reject) => {
      logout({
        id: userId
      }).then(() => {
        commit('SET_ROLES', [])
        commit('SET_RESOURCES', [])
        removeToken()
        removeUserId()
        removeCompanyId()
        removeOrganizationId()
        resetRouter()

        // reset visited views and cached views
        // to fixed https://github.com/PanJiaChen/vue-element-admin/issues/2485
        dispatch('tagsView/delAllViews', null, {
          root: true
        })

        resolve()
      }).catch(error => {
        reject(error)
      })
    })
  },

  // remove token
  resetToken({
    commit
  }) {
    return new Promise(resolve => {
      commit('SET_ROLES', [])
      removeToken()
      resolve()
    })
  },

  // dynamically modify permissions
  async changeRoles({
    commit,
    dispatch
  }, role) {
    const token = role + '-token'

    commit('SET_TOKEN', token)
    setToken(token)

    const {
      roles
    } = await dispatch('getInfo')

    resetRouter()

    // generate accessible routes map based on roles
    const accessRoutes = await dispatch('permission/generateRoutes', roles, {
      root: true
    })
    // dynamically add accessible routes
    router.addRoutes(accessRoutes)

    // reset visited views and cached views
    dispatch('tagsView/delAllViews', null, {
      root: true
    })
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}
