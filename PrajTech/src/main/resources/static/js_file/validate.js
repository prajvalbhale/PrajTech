/**
 * 
 */
var seconds=0;
function displaysec(){
	seconds += 1;
}
setInterval(displaysec, 1000);

function redirectpage() {
	window.location="/login-after-signup";
}
setTimeout('redirectpage()', 3000);