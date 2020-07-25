/** When your routing table is too long, you can split it into small modules **/

import Layout from '@/layout'

const examManagerRouter =
{
  path: '/exam',
    component: Layout,
  redirect: '/exam/exam-publish',
  name: 'exam',
  meta: {
    title: '考试管理',
    icon: 'excel',
    resources: ['100802', '100808', '10018', '100815', '100820']

},
  children: [

    {
      path: 'exam-publish',
      component: () => import('@/views/exam-service/exam-publish'),
      name: 'exam-publish',
      meta: {
        title: '发布考卷管理',
        resources: ['10015', '100801', '100802', '100803', '100804', '100805']
      }
    },
    {
      path: 'exam-query',
      component: () => import('@/views/exam-service/exam-query'),
      name: 'exam-query',
      meta: {
        title: '答卷查询',
        resources: ['10016', '100806', '100807', '100808']
      }
    },
    {
      path: 'exam-score-manager',
      component: () => import('@/views/exam-service/evaluation'),
      name: 'exam-score-manager',
      meta: {
        title: '评卷管理',
        resources: ['10017']
      }
    },
    {
      path: 'qs-comment',
      component: () => import('@/views/exam-service/subtopic'),
      name: 'qs-comment',
      meta: {
        title: '分题评卷',
        resources: ['10018', '100814', '100815', '100816', '100817', '100818']
      }
    },
    {
      path: 'exam-res',
      component: () => import('@/views/exam-service/exam-res'),
      name: 'exam-res',
      meta: {
        title: '考试报表',
        resources: ['10019', '100819', '100820', '100821']
      }
    }
  ]
}

export default examManagerRouter
