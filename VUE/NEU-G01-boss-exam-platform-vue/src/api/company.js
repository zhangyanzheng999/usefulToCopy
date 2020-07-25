/*
 *@description:公司的js
 *@author: 张彦征
 *@date: 2020-07-12 17:21:50
*/
// 查询
export function getCompanyWithPage(url, pageNum, pageSize) {
  return axios.post(url + 'queryWithPage', {
    pageNum: pageNum,
    pageSize: pageSize,
    name: ''
  })
}
