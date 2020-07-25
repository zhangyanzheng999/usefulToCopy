import { MessageBox } from 'element-ui'
import store from '@/store'
import websocket from "@/api/websocket";

export function initWebSocket() {
  var testId = 3
  websocket.websocket = new WebSocket(websocket.baseUrl + testId)
  websocket.websocket.onmessage = this.websocketonmassage
  websocket.websocket.onerror = this.websocketonerror
  websocket.websocket.onclose = this.breakLink

}

//关闭websocket
export function closeWebSocket() {
  if (websocket.websocket != null) {
    websocket.websocket.close()
  }
}
//实时接收websocket的消息
export function websocketonmassage(event) {
  if (event.data == 1) {
    alert("操作完成，请刷新")
    this.closeWebSocket();
    this.log_out();
  }
  if (event.data == 2) {
    this.closeWebSocket();
    alert("被强制下线")
    this.log_out();
  }
}
//服务器断开
export function breakLink() {
  // alert("服务器连接断开")
  //this.$message.info("服务器连接断开")
  this.log_out();
}
//连接建立失败重连
export function websocketonerror() {
  this.initWebSocket();
}
//退出登录
export function log_out() {

  //yichu
  this.$router.push('/login');
}

// 销毁监听事件
export function destroyed() {
  this.breakLink();
}
