/*
 *@description:用来展示
 *@author: 张彦征
 *@date: 2020-07-12 17:23:54
 */
/**
 * 展示消息
 * @param {传入指针} obj
 * @param {消息} message
 * @param {类型} type
 */
export function showMessage(obj, message, type) {
  // 防止多次出现
  if (document.getElementsByClassName('el-message').length === 0) {
    obj.$message({
      showClose: true,
      message: message,
      type: type,
      center: true
    })
  }
}
/**
 * 深拷贝
 * @param {克隆对象} source
 */
export function cloneObject(source) {
  return JSON.parse(JSON.stringify(source))
}
