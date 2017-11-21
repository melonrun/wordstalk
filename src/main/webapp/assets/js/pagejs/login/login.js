$(function(){
	$("#wordsTalkLoginBtn").click(function(){ login(); });
});
function isBlank(strName){
	strName = $.trim(strName);
	if(strName == '' || strName == null || strName == undefined)
		return true;
	return false;
};
function setCookie(name,value) {
	var Hours = 1;
	var exp = new Date();
	exp.setTime(exp.getTime() + Hours*60*60*1000);
	document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString()+";path=/";
}
function login(){
	$("#backMessage").hide();
	var userName = $("#wordsTalkName").val();
	var userPass = $("#wordsTalkPass").val();
	if(isBlank(userName)){
		$("#backMessage").html("请输入用户名。");return;
	}
	if(isBlank(userPass)){
		$("#backMessage").html("请输入密码。");return;
	}
	$.ajax({
        type: "post",
        dataType: "json",
        data: {'userName':userName, 'userPass':userPass},
        url: getRootPath()+'/user/login.json',
        success: function (data) {
        	if(data.status == -1){
        		$("#backMessage").html(data.msg).show(50);
        		return;
        	}else if(data.status == 1){
				setCookie("words_talk_user_role", data.data);
				setCookie("words_talk_user_name", data.msg);
                if(data.data==="manager")
        		    window.location.href=getRootPath()+'/customer/customerPage.htm';
                else
                    window.location.href=getRootPath()+'/translator/translatorPage.htm';
        	}
        }
   	});
}

function getRootPath() {
	var curWwwPath = window.document.location.href;
	var pathName = window.document.location.pathname;
	var pos = curWwwPath.indexOf(pathName);
	var localhostPath = curWwwPath.substring(0, pos);
	var projectName = pathName.substring(0, pathName.substr(1).indexOf(
			'/') + 1);
	return (localhostPath + projectName);
}
