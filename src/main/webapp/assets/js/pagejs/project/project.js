$(function(){
	window.pageNum = getCookie("project_page");
	window.rows={};
	init();
	loadTranslatorData(window.pageNum);
});

function init(){
	$("#addProjectBtn").click(function(){ 
		setCookie("project_id", -1);
		window.location.href=getRootPath()+'/project/addProjectPage.htm';});
	
	$("#searchCond").click(function(){
		loadTranslatorData(1);
	});
	$("#exportProjectBtn").click(function(){
		var status = $("#projectStatus").val();
		var export_url = getRootPath()+"/project/exportAllProject.htm?status="+status+
			"&other="+($("#customerName").val())+"&searchKey="+($("#projectName").val())
			+ "&name=" + ($("#projectType").val());
		var f_url = encodeURI(export_url);
		window.location.href=f_url;
	});
}

function loadTranslatorData(page){
	if(page == undefined || page == null || page == 'undefined' || page == 'null') page = 1;
	$.ajax({
        type: "post",
        dataType: "json",
        data: {page: page, searchKey : $("#projectName").val(), 
        		status:$("#projectStatus").val(), other: $("#customerName").val(),
				name: $("#projectType").val()},
        url: getRootPath()+'/project/projectList.json',
        success: function (data) {
        	$("#translatorTbody").empty();
    		if(data.data && data.data.results.length > 0){
    			var msg = data.msg;
    			window.rows =data.data.results;data = data.data;
    			var str = "", adminStr="";
    			for(var i=0; i<rows.length; i++){
    				if(msg == "admin"){
        				adminStr = "&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;&nbsp;<a href='#' onclick='redirectProjAdmin("+rows[i].id+")'>管理员管理</a>";
        			}
    				str += "<tr><td>"+rows[i].projectId+"</td><td>"+rows[i].projectName+"</td><td>"+
    					rows[i].customerName+"</td><td><a href='#' onclick='redirectEditProj("+i+")'>项目管理</a>"+adminStr+"</td></tr>";
    			}
    			$("#translatorTbody").append(str);
    			var endBar = (data.curPage)*data.rows > data.dataSum ? data.dataSum:(data.curPage)*data.rows;
    			$("#sumBar").html(data.dataSum);$("#curBar").html((data.curPage-1)*data.rows+1+"-"+endBar);
    			laypage({
    	            cont: 'pageBar', //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
    	            pages: data.pages, //通过后台拿到的总页数
    	            curr: data.curPage || 1, //当前页
    	            jump: function(obj, first){ //触发分页后的回调
    	                if(!first){ //点击跳页触发函数自身，并传递当前页：obj.curr
                            window.pageNum = obj.curr;
                            setCookie("project_page", window.pageNum);
    	                	loadTranslatorData(obj.curr);
    	                }
    	            }
    	        }); 
    		}
        }
   	});
}
function redirectProjAdmin(id){
	var hrefPath = getRootPath()+'/adminproject/adminProjectPage.htm';
	setCookie("project_id", id);
	setCookie("project_page", window.pageNum);
	window.location.href = hrefPath; 
}

function redirectEditProj(i){
	var hrefPath = getRootPath()+'/project/addProjectPage.htm';
	setCookie("project_id", window.rows[i].id);
	setCookie("project_page", window.pageNum);
	setCookie("project_name", window.rows[i].projectName);
	setCookie("customer_name", window.rows[i].customerName);
	window.location.href = hrefPath; 
}

function redirectProjPart(i){
	var hrefPath = getRootPath()+'/project_part/projectPartPage.htm';
	setCookie("project_id", window.rows[i].id);
	setCookie("project_page", window.pageNum);
	setCookie("project_name", window.rows[i].projectName);
	setCookie("customer_name", window.rows[i].customerName);
	window.location.href = hrefPath; 
}
