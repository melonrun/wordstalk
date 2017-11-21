$(function(){
	window.project_id = getCookie("project_id");
	init(project_id);
	loadProjectPartData(project_id);
});

function init(project_id){
	$("#addProjectPartBtn").click(function(){
		setCookie("project_id", project_id);setCookie("project_part_id", -1);
		window.location.href = getRootPath()+'/project_part/addProjectPartPage.htm';
	});
	
	$("#exportPartBtn").click(function(){	window.location.href = getRootPath()+'/project_part/exportAllProjectPart.htm?id='+window.project_id;	});
}

function loadProjectPartData(project_id){
	$("#projectName").html(getCookie("project_name"));
	loadProjectPartList(1);
}

function loadProjectPartList(page){
	$.ajax({
        type: "post",
        dataType: "json",
        data: {page: page,projectId: window.project_id},
        url: getRootPath()+'/project_part/projectPartList.json',
        success: function (data) {
        	$("#projectPartTbody").empty();
    		if(data.data && data.data.results.length > 0){
    			window.rows =data.data.results;data = data.data;
    			for(var i=0; i<rows.length; i++){
    				$("#projectPartTbody").append("<tr><td><a href='#' onclick='redirectEditProjPart("+rows[i].id+")'>"+rows[i].partName+"</a></td><td>"+rows[i].wordsNum+"</td><td>"+
    					rows[i].translatorName+"</td><td>"+(rows[i].status==-1?"未结算":"已结算")+"</td></tr>");
    			}
    			var endBar = (data.curPage)*data.rows > data.dataSum ? data.dataSum:(data.curPage)*data.rows;
    			$("#sumBar").html(data.dataSum);$("#curBar").html((data.curPage-1)*data.rows+1+"-"+endBar);
    			laypage({
    	            cont: 'pageBar', //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
    	            pages: data.pages, //通过后台拿到的总页数
    	            curr: data.curPage || 1, //当前页
    	            jump: function(obj, first){ //触发分页后的回调
    	                if(!first){ //点击跳页触发函数自身，并传递当前页：obj.curr
    	                	loadProjectPartList(obj.curr);
    	                }
    	            }
    	        }); 
    		}
        }
   	});
}

function redirectEditProjPart(id){
	var hrefPath = getRootPath()+'/project/addProjectPartPage.htm';
	setCookie("project_part_id", id);
	window.location.href = hrefPath; 
}

