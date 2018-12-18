var host = window.location.host;
//host = "http://127.0.0.1:8081";
var ws;
if ('WebSocket' in window) {
	ws = new WebSocket("ws://" + host + "/user/webSocketIMServer");
} else if ('MozWebSocket' in window) {
	ws = new MozWebSocket("ws://" + host + "/user/webSocketIMServer");
} else {
	ws = new SockJS("http://" + host + "/user/sockjs/webSocketIMServer");
}
ws.onopen = function(evnt) {
    console.log("websocket连接上");
};
ws.onmessage = function(evnt) {
	console.log(evnt.data);
};
ws.onerror = function(evnt) {
    console.log("websocket错误");
};
ws.onclose = function(evnt) {
    console.log("websocket关闭");
}
$("#input-btn").click(function(){
	var sendtext = document.getElementById("input-text").value;
	if(sendtext != ''){
		ws.send(sendtext);
	}
});