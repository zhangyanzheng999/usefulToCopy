/** When your routing table is too long, you can split it into small modules **/

import Layout from '@/layout'
import Vue from 'vue'
const paperManageRouter = {
  path: '/paperManagement',
  component: Layout,
  redirect: '/paperManagement/uploadPaper',
  name: '试卷管理',
  meta: {
    title: '试卷管理',
    icon: 'excel',
    resources: ['1000221', '100221', '100223, 100227', '100228', '10023', '10024', '10025']
  },
  children: [
    {
      path: 'uploadPaper', // 设置页面的路由
      name: '上传试卷',
      meta: {
        title: '上传试卷',
        resources: ['10021', '1000221', '1000222', '100213', '100214']
      },
      component: () => import('@/views/paperManagement/uploadPaper'),
    },
    {
      path: 'createPaper',
      component: () => import('@/views/paperManagement/createPaper'),
      name: '组卷',
      meta: {
        title: '组卷',
        resources: ['10022', '100221', '100222', '100223', '100224', '100225', '100226', '100227', '100228', '100229']
      }
    },
    {
      path: 'downloadPaper',
      component: () => import('@/views/paperManagement/downloadPaper'),
      name: '下载试卷',
      meta: {
        title: '下载试卷',
        resources: ['10023', '100231']
      }
    },
    {
      path: 'maintainPaper',
      component: () => import('@/views/paperManagement/maintainPaper'),
      name: '维护试卷',
      meta: {
        title: '维护试卷',
        resources: ['10024', '100241', '100242', '100243', '100244', '100245', '100246']
      }
    },
    {
      path: 'paperTemplateManagement',
      component: () => import('@/views/paperManagement/paperTemplateManagement'),
      name: '试卷模板管理',
      meta: {
        title: '试卷模板管理',
        resources: ['10025']
      }
    }
  ]
}

export default paperManageRouter
export var bus = new Vue()
