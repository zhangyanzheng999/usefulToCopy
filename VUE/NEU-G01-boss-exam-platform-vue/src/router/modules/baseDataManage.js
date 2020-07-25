/** When your routing table is too long, you can split it into small modules **/

import Layout from '@/layout'

const baseDataManageRouter = {
  path: '/base-data',
  component: Layout,
  redirect: '/base-data/category',
  meta: {
    title: '基础数据管理',
    icon: 'dashboard',
    resources: ['1000604', '1000606', '1000611', '1000617', '1000621']
  },
  children: [
    {
      path: 'category',
      component: () => import('@/views/base-data/Category'),
      name: 'category',
      meta: {
        title: '题目类别管理',
        icon: 'dashboard',
        resources: ['10027', '1000601', '1000602', '1000603', '1000604',  '1000605', '1000606',  '1000607'] }
    },
    {
      path: 'combexamconfig',
      component: () => import('@/views/base-data/CombExamConfig'),
      name: 'combexamconfig',
      meta: {
        title: '组卷配置管理',
        icon: 'dashboard',
        resources: ['10028', '1000619', '1000620', '1000621', '1000622']
      }
    },
    {
      path: 'subject',
      component: () => import('@/views/base-data/Subject'),
      name: 'subject',
      meta: {
        title: '题目管理',
        icon: 'dashboard',
        resources: ['10029', '1000614', '1000615', '10006166', '1000617',  '1000618' ]
      }
    },
    {
      path: 'subjecttype',
      component: () => import('@/views/base-data/SubjectType'),
      name: 'subjecttype',
      meta: {
        title: '题目类型管理',
        icon: 'dashboard',
        resources: ['10030', '1000609', '1000610', '1000611']
      }
    }
  ]
}

export default baseDataManageRouter
