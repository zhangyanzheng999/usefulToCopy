import { asyncRoutes, constantRoutes } from '@/router'

/**
 * 根据用户资源动态加载路由
 * @param resources
 * @param route
 */
function hasPermission(resources, route) {
  if (route.meta && route.meta.resources) {
    for(let temp of route.meta.resources){
      if(resources.some(resource => temp.includes(resource))){
        return true
      }
    }
    return false
    //return resources.some(resource => route.meta.resources.includes(resource))
  } else {
    return true
  }
}

/**
 * 递归确定动态路由表
 * @param routes asyncRoutes
 * @param resources
 */
export function filterAsyncRoutes(routes, resources) {
  const res = []

  routes.forEach(route => {
    const tmp = { ...route }
    if (hasPermission(resources, tmp)) {
      if (tmp.children) {
        tmp.children = filterAsyncRoutes(tmp.children, resources)
      }
      res.push(tmp)
    }
  })
  return res
}

const state = {
  routes: [],
  addRoutes: []
}

const mutations = {
  SET_ROUTES: (state, routes) => {
    state.addRoutes = routes
    state.routes = constantRoutes.concat(routes)
  }
}

const actions = {
  generateRoutes({ commit }, resources) { // 权限匹配，动态加载路由
    return new Promise(resolve => {
      let accessedRoutes
      if (resources.includes('9999')) {
        accessedRoutes = asyncRoutes || []
      } else {
        accessedRoutes = filterAsyncRoutes(asyncRoutes, resources)
      }
      commit('SET_ROUTES', accessedRoutes)
      resolve(accessedRoutes)
    })
  }
}

export default {
  namespaced: true,
  state,
  mutations,
  actions
}
