import Layout from "@/layout/index";


const mobileManageRouter = {
  path : '/mobile',
  component: Layout,
  redirect: '/mobileLogin',
  hidden: true,
  meta: {
    title: '手机端',
    icon: 'dashboard',
    //resources: ['10003']
  },
  children: [
    {
      path: '/mobileLogin',
      name: 'mobileLogin',
      meta: {title: '登陆'},
      component: () => import('@/views/mobile/auth.vue')
    },
    {
      path: '/problem',
      name: 'problem',
      meta: {title: '做题'},
      component: () => import('@/views/mobile/exam.vue')
    },
  ]
}

export default mobileManageRouter;
