import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from '../views/Index.vue'
import DdFind from '../views/DdFind.vue'
import DdAdd from '../views/DbAdd.vue'
Vue.use(VueRouter)

const routes = [{
    path: '/',
    name: '数据字典管理',
    redirect: '/login',
    component: Index,
    children: [{
        path: '/show',
        name: '数据字典信息',
        component: DdFind
      }, {
        path: '/add',
        name: '数据字典添加',
        component: DdAdd
      }

    ]
  }, {
    path: '/login',
    component: () => import('@/views/login/index.vue'),
    name: '登录界面',
    hidden: true
  }

]

const router = new VueRouter({
  routes
})
// 导航守卫
// 使用 router.beforeEach 注册一个全局前置守卫，判断用户是否登陆
router.beforeEach((to, from, next) => {

  if (to.path === '/login') {
    next();
  } else {
    let token = localStorage.getItem('Authorization');

    if (token === null || token === '') {
      next('/login');
    } else {
      next();
    }
  }
});
export default router