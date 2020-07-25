import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

/* Router Modules */
import systemManagerRouter from './modules/systemManage'
import examManagerRouter from '@/router/modules/examManage'
import paperManageRouter from '@/router/modules/paperManage'
import baseDataManageRouter from "@/router/modules/baseDataManage";
import mobileManageRouter from "@/router/modules/mobileManage";
import extraFunctionRouter from "@/router/modules/extraFunction";

/**
 * constantRoutes
 * a base page that does not have permission requirements
 * all roles can be accessed
 */
export const constantRoutes = [{
    path: '/redirect',
    component: Layout,
    hidden: true,
    children: [{
      path: '/redirect/:path(.*)',
      component: () => import('@/views/redirect/index')
    }]
  },
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    meta: {
      title: '登录'
    },
    hidden: true
  },
  {
    path: '/auth-redirect',
    component: () => import('@/views/login/auth-redirect'),
    hidden: true
  },
  {
    path: '/404',
    component: () => import('@/views/error-page/404'),
    hidden: true
  },
  {
    path: '/401',
    component: () => import('@/views/error-page/401'),
    hidden: true
  },
  {
    path: '/',
    component: Layout,
    redirect: '/bes',
    name: 'system',
    children: [{
      path: 'bes',
      name: 'bes',
      meta: {
        title: '考试系统',
        icon: 'dashboard',
        affix: true
      }, // affix:固定在标签页
      component: () => import('@/views/bes/index')
    }]
  }
]

/**
 * 异步路由器
 * 动态展示路由
 */
export const asyncRoutes = [
  systemManagerRouter,
  examManagerRouter,
  paperManageRouter,
  baseDataManageRouter,
  mobileManageRouter,
  extraFunctionRouter,
  {
    path: '*',
    redirect: '/404',
    hidden: true
  }
]

const createRouter = () => new Router({
  scrollBehavior: () => ({
    y: 0
  }),
  routes: constantRoutes
})

const router = createRouter()

export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
