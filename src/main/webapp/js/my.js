var interval;

function startSecond() {

	interval = window.setInterval("changeSecond()", 1000);

};

function changeSecond() {
	var second = document.getElementById("second");

	var svalue = second.innerHTML;

	svalue = svalue - 1;

	if (svalue == 0) {
		window.clearInterval(interval);
		location.href = "/index.jsp";
		return;
	}

	second.innerHTML = svalue;
}
/*window.setInterval()
功能：按照指定的周期（以毫秒计）来调用函数或计算表达式。
语法：setInterval(code,millisec)
 
解释：code：在定时时间到时要执行的JavaScript代码串。
millisec：设定的定时时间，用毫秒数表示。
返回值：定时器的ID值，可用于clearInterval()方法停止指定的定时器。
注：setInterval()方法会不停地调用函数，直到用clearInterval()终止定时或窗口被关闭。

window.clearInterval()
功能：取消由setInterval()方法设置的定时器。
语法：clearInterval(id_of_setinterval)
解释：id_of_setinterval：由setInterval()返回的ID值。该值标识了一个setInterval定时器。
也就是：window.setInterval()返回的就是window.clearInterval的参数
*/