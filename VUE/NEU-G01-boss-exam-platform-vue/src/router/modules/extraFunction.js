/** When your routing table is too long, you can split it into small modules **/

import Layout from '@/layout'

const extraFunctionRouter =
  {
    path: '/extra',
    component: Layout,
    redirect: '/extra/index',
    name: 'extra',
    meta: {
      title: '额外功能',
      icon: 'excel',
      resources: ['10000']

    },
    children: [
      {
        path: 'index',
        component: () => import('@/views/extra-function/index'),
        name: 'extra-test',
        meta: {
          title: '新增功能',
          resources: ['10000']
        }
      }
    ]
  }

export default extraFunctionRouter
