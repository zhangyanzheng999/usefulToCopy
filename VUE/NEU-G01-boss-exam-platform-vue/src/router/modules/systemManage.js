/** When your routing table is too long, you can split it into small modules **/

import Layout from '@/layout'

const systemManagerRouter = {
  path: '/systemManage',
  component: Layout,
  redirect: 'noRedirect',
  name: 'systemManage',
  meta: {
    title: '系统管理',
    resources: ['100041', '100043', '100051', '100052', '100061', '100062', '100071', '100072',
      '100082', '100083',  '100092', '100096', '100104', '100114', '100121', '10013', '100905']
  },
  children: [
    {
      path: 'organization',
      name: 'organization',
      meta: {
        title: '组织机构管理',
        resources: ['10004', '100041', '100042','100043', '100044', '100045','100046']
      },
      component: () => import('@/views/system-manage/organization.vue')
    },
    {
      path: 'company',
      name: 'company',
      meta: {
        title: '公司管理',
        resources: ['10005', '100051', '100052','100053', '100054', '100055','100056', '100057', '100058']
      },
      component: () => import('@/views/system-manage/company.vue')
    },
    {
      path: 'department',
      name: 'department',
      meta: {
        title: '部门管理' ,
        resources: ['10006', '100061', '100062','100063', '100064', '100065','100066', '100067', '100068']
      },
      component: () => import('@/views/system-manage/department.vue')
    },
    {
      path: 'resource',
      name: 'resource',
      meta: {
        title: '资源管理',
        resources: ['10007', '100071', '100072','100073', '100074', '100075','100076', '100077']
      },
      component: () => import('@/views/system-manage/resource.vue')
    },

    {
      path: 'role',
      name: 'role',
      meta: {
        title: '角色管理',
        resources: ['10008', '100081', '100082','100083', '100084', '100085','100086', '100087', '100088', '100089', '1000810']
      },
      component: () => import('@/views/system-manage/role.vue')
    },
    {
      path: 'position',
      name: 'position',
      meta: {
        title: '职位管理',
        resources: ['10009', '100091', '100092','100093', '100094', '100095', '100096']
      },
      component: () => import('@/views/system-manage/position.vue')
    },
    {
      path: 'user',
      name: 'user',
      meta: {
        title: '用户管理',
        resources: ['10010', '100101', '100102','100103', '100104', '100105', '100106']
      },
      component: () => import('@/views/system-manage/user.vue')
    },
    {
      path: 'systemParam',
      name: 'systemParam',
      meta: {
        title: '系统参数管理',
        resources: ['10011', '100111', '100112','100113', '100114', '100115', '100116', '100117']
      },
      component: () => import('@/views/system-manage/systemParam.vue')
    },
    {
      path: 'dictionary',
      name: 'dictionary',
      meta: {
       title: '字典管理',
       resources: ['10012', '100121', '100122','100123', '100124', '100125', '100126', '100127']
      },
      component: () => import('@/views/system-manage/dictionary.vue')
    },
    {
      path: 'onlineUser',
      name: 'onlineUser',
      meta: {
       title: '在线用户管理',
        resources: ['10013', '100901', '100902', '100903', '100904', '100905', '100906']
      },
      component: () => import('@/views/system-manage/userOnlineInfo.vue')
    }
  ]
}

export default systemManagerRouter
