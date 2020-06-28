import Vue from 'vue'
import VueRouter from 'vue-router'
import FindUser from '../views/FindUser.vue'
import AddUser from '../views/AddUser.vue'
import Index from '../views/index.vue'
import UpdateUser from '../views/UpdateUser.vue'
Vue.use(VueRouter)

const routes = [{
  path: '/',
  name: '用户管理',
  component: Index,
  redirect: '/FindUser',
  children: [{
      path: '/FindUser',
      name: '查询用户',
      component: FindUser
    },
    {
      path: '/AddUser',
      name: '添加用户',
      component: AddUser
    },
    {
      path: '/UpdateUser',
      name: '修改用户',
      hide:true,
      component: UpdateUser
    }
  ]
}]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router