
export function login(data) {
  return axios({
    url: '/education/bes/v1/gateway/shiro/checkLogin',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  return axios({
    url: '/education/bes/v1/gateway/shiro/getList',
    method: 'get',
    params: { token:token }
  })
}

export function logout(data) {
  return axios({
    url: '/education/bes/v1/gateway/shiro/logout',
    method: 'post',
    data
  })
}
