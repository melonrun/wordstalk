<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/font-awesome/4.2.0/css/font-awesome.min.css" />

<!-- page specific plugin styles -->
<!-- text fonts -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/fonts/fonts.googleapis.com.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/chosen.css?v=0.1" />

<!-- ace styles -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />
<!--[if lte IE 9]>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
<![endif]-->
<!--[if lte IE 9]>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/ace-ie.min.css" />
<![endif]-->
		
<!--[if !IE]> -->
<script src="<%=request.getContextPath()%>/assets/js/lib/jquery.2.1.1.min.js"></script>
<!-- page specific plugin scripts -->
<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/lib/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/lib/bootstrapValidator.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/lib/ace-elements.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/lib/ace.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/lib/moment.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/lib/laypage.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/lib/laydate/laydate.dev.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/lib/layer/layer.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/lib/jquery.autosize.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/lib/chosen.jquery.js?v=0.2"></script>
<!-- <![endif]-->

<!-- inline scripts related to this page -->
<script type="text/javascript">
		function isBlank(strName){
			strName = $.trim(strName);
			if(strName == '' || strName == null || strName == undefined)
				return true;
			return false;
		};

		function isNum(num){
			num = $.trim(num);
			if(num == '' || num == null || num == undefined)
				return false;
			if(isNaN(num))
				return false;
			return true;
		}
		function getRootPath() {
			var curWwwPath = window.document.location.href;
			var pathName = window.document.location.pathname;
			var pos = curWwwPath.indexOf(pathName);
			var localhostPath = curWwwPath.substring(0, pos);
			var projectName = pathName.substring(0, pathName.substr(1)
					.indexOf('/') + 1);
			return (localhostPath + projectName);
		}
		function logout(){
			$.ajax({
        type: "post",
        dataType: "json",
        data: {},
        url: getRootPath()+'/user/logout.json',
        success: function (data) {
    			window.location.href=getRootPath()+'/login.html'; 
        }
		   	});
		}
		function getCookie(name) {
				var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
				if(arr=document.cookie.match(reg))
					return unescape(arr[2]);
				else
					return null;
		}
		function setCookie(name,value) {
				var Hours = 1;
				var exp = new Date();
				exp.setTime(exp.getTime() + Hours*60*60*1000);
				document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString()+";path=/";
		}
		
		$(function(){
			$("#userLogoutLi").click(function(){ logout(); });
            var user_name = getCookie("words_talk_user_name")
			var user_role = getCookie("words_talk_user_role");
			$("#wordsTalkRole").html(user_name);
            if(user_role != "manager"){
                $("#projectLeft").show();$("#translatorLeft").show();
            }
		});
		
	</script>
		