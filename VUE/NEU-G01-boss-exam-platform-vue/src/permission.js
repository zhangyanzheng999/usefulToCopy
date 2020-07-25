import router from './router'
import store from './store'
import {
  Message
} from 'element-ui'
import NProgress from 'nprogress' // progress bar
import 'nprogress/nprogress.css' // progress bar style
import {
  getToken
} from '@/utils/auth' // get token from cookie
import getPageTitle from '@/utils/get-page-title'
import {initWebSocket} from "@/utils/userOnline";

NProgress.configure({
  showSpinner: false
}) // NProgress Configuration

const whiteList = ['/login', '/auth-redirect', '/mobile/mobileLogin', '/mobile/problem'] // no redirect whitelist

router.beforeEach(async (to, from, next) => {
  // 显示导航栏
  NProgress.start()
  // 设置页面的标题
  document.title = getPageTitle(to.meta.title)
  // 确定用户是否登录
  const hasToken = getToken()
  if (hasToken) {
    if (to.path === '/login') {
      // 登录成功则跳转倒主页
      next({
        path: '/'
      })
      NProgress.done()
    } else {
      // 获取角色信息
      const hasRoles = store.getters.roles && store.getters.roles.length > 0
      if (hasRoles) {
        next()
      } else {
        try {
          // 异步获取资源信息
          const { resources } = await store.dispatch('user/getInfo')
          // 通过资源动态添加路由
          const accessRoutes = await store.dispatch('permission/generateRoutes', resources)
          //initWebSocket()
          router.addRoutes(accessRoutes)
          next({
            ...to,
            replace: true
          })
        } catch (error) {
          // 移除token
          await store.dispatch('user/resetToken')
          Message.error('Has Error')
          next(`/login?redirect=${to.path}`)
          NProgress.done()
        }
      }
    }
  } else {
    /* has no token*/
    if (whiteList.indexOf(to.path) !== -1) {
      // in the free login whitelist, go directly
      next()
    } else {
      // other pages that do not have permission to access are redirected to the login page.
      next(`/login?redirect=${to.path}`)
      NProgress.done()
    }
  }
})

router.afterEach(() => {
  // finish progress bar
  NProgress.done()
})
