/*
 *@description:这个存放所有基础的操作
 *@author: 张彦征
 *@date: 2020-07-12 17:21:35
*/

const baseUrl = '/education/bes/v1/system-manager-center/'
/**
 * 用来分页
 * @param {模块名} url
 * @param {数据} data
 */
export function queryWithPage(url, data) {

    return axios.post(baseUrl + url + '/queryWithPage', data)
}

/**
 * 进行删除
 * @param {模块名} url
 * @param {数据} data
 */
export function deleteInfo(url, data) {
    return axios.post(baseUrl + url + '/delete', data)
}
/**
 *  批量删除
 * @param {模块名} url
 * @param {数据} data
 */
export function multiDelete(url, data) {
    return axios.post(baseUrl + url + '/multiDelete', data)
}


/**
 *  进行查询防止数据过于老旧
 * @param {模块名} url
 * @param {数据} data
 */
export function queryInfo(url, data) {
    return axios.post(baseUrl + url + '/query', data)
}
/**
 * 用来更新信息
 * @param {模块名} url
 * @param {数据} data
 */

export function updateInfo(url, data) {

    return axios.put(baseUrl + url + '/update', data)
}
/**
 * 进行全部查询，无条件
 * @param {模块名} url
 */
export function queryAll(url) {

    return axios.get(baseUrl + url + '/queryAll')
}
/**
 * 查询按照条件
 * @param {模块名} url
 * @param {数据} data
 */
export function postQueryAll(url,data) {

    return axios.post(baseUrl + url + '/queryAll',data)
}

/**
 * 进行添加
 * @param {模块名} url
 * @param {数据} data
 */
export function insert(url, data) {
    return axios.post(baseUrl + url + '/insert', data)
}
/**
 * 查询树
 * @param {模块名} url
 */
export function queryTree(url) {
    return axios.get(baseUrl + url + '/queryTree')
}
/**
 * 查询树，附带一些组织Id或者公司Id
 * @param {模块名} url
 * @param {数据} data
 */
export function postQueryTree(url,data) {
    return axios.post(baseUrl + url + '/queryTree',data)
}

/**
 * 为了校验Code是否用过
 * @param {模块名} url
 * @param {数据} data
 */
export function validateCode(url, data) {
  return axios.get(baseUrl + url + '/validateCode', {
    params: {
      code: data
    }
  })
}
/**
 * 为了校验Name是否用过
 * @param {模块名} url
 * @param {数据} data
 */
export function validateName(url, data) {
  return axios.get(baseUrl + url + '/validateName', {
    params: {
      name: data
    }
  })
}
