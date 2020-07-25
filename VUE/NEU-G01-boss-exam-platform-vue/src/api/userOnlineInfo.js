import request from '@/utils/request'

/**
 * 在线用户操作
 * xjc
 */


/**
 * 显示在线用户 query
 * @param {*} body
 */
export function queryUserOnlineInfo(data){
  return axios.post('/education/bes/v1/system-manager-center/onlineUser/queryByCondition',data)
}


/**
 * 新增在线用户 add
 * @param {*} body
 */
export function addUserOnlineInfo(data){
  return axios.post('/education/bes/v1/system-manager-center/onlineUser/add',data)

}


/**
 * 修改在线用户 update
 * @param {*} body
 */
export function logoutOne(data){
  return axios.post('/education/bes/v1/system-manager-center/onlineUser/update',data)

}


/**
 * 删除在线用户 delete
 * @param {*} body
 */

export function deleteUserOnlineInfo(data){
  return axios.post('/education/bes/v1/system-manager-center/onlineUser/offlineUserOnlineInfo',data)

}

/**
 * 显示在线用户
 * @param {*} body
 */
export function getAll(data){
  return axios.post('/education/bes/v1/system-manager-center/onlineUser/queryWithPage',data)

}



