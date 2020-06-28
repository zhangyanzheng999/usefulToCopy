/**
 * 下面是webSocket
 */
var websocket = null;
//浏览器是否支持
if ('WebSocket' in window) {
    // 上面我们给webSocket定位的路径
    websocket = new WebSocket('ws://localhost:8080/storm/websocket');
} else {
    alert('该浏览器不支持websocket!');
}
//建立连接
websocket.onopen = function (event) {
    //console.log('建立连接');
}
//关闭连接
websocket.onclose = function (event) {
    //console.log('连接关闭');
}
//消息来的时候的事件
websocket.onmessage = function (event) {
    // 这里event.data就是我们从后台推送过来的消息
    // console.log('收到消息:' + event.data);
    alert(event.data)
}

//发生错误时
websocket.onerror = function () {
    alert('websocket通信发生错误！');
}
//窗口关闭时，Websocket关闭
window.onbeforeunload = function () {
    websocket.close();
}