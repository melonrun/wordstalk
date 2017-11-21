
$(function(){
	window.pageNum = getCookie("translator_page");
	loadCumstomerName();
	loadTranslatorData(window.pageNum);
	$("#searchCond").click( function(){loadTranslatorData(1);});
});

function loadCumstomerName(){
	$.ajax({
		type: "post",
		dataType: "json",
		url: getRootPath()+'/project/getAllCustomerName.json',
		success: function (data) {
			if(data.status == 1){
				data = data.data; var customerHtml = "<option value='-1'>所有</option>";
				$("#remarks").empty();
				for(var i =0; i<data.length; i++){
					customerHtml += "<option value='"+data[i]+"'>"+data[i]+"</option>"
				}
				$("#remarks").append(customerHtml);
			}
		}
	});
};

function loadTranslatorData(page){
	if(page == undefined || page == "null") page = 1;
	$.ajax({
        type: "post",
        dataType: "json",
        data: {page: page, customerName: $("#remarks").val(), levelStr: $("#levelStr").val(),
			name:$("#transFilterName").val(), languageFrom:$("#languageFrom").val(),
			languageTo:$("#languageTo").val(),contractEndDate: $("#contractStatus").val()},
        url: getRootPath()+'/translator/translatorList.json',
        success: function (data) {
        	$("#translatorTbody").empty();
    		if(data.data && data.data.results.length > 0){
    			var rows =data.data.results;data = data.data;
    			for(var i=0; i<rows.length; i++){
    				$("#translatorTbody").append("<tr><td><a href='#' onclick='redirectAddTran("+rows[i].id+")'>"+rows[i].name+"</a></td><td>"+
    					rows[i].remarks+"</td></tr>");
    			}
    			var endBar = (data.curPage)*data.rows > data.dataSum ? data.dataSum:(data.curPage)*data.rows;
    			$("#sumBar").html(data.dataSum);$("#curBar").html((data.curPage-1)*data.rows+1+"-"+endBar);
    			laypage({
    	            cont: 'pageBar', //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
    	            pages: data.pages, //通过后台拿到的总页数
    	            curr: data.curPage || 1, //当前页
    	            jump: function(obj, first){ //触发分页后的回调
    	                if(!first){ //点击跳页触发函数自身，并传递当前页：obj.curr
    	                    window.pageNum = obj.curr;
    	                    setCookie("translator_page", window.pageNum);
    	                	loadTranslatorData(obj.curr);
    	                }
    	            }
    	        });
    		}
        }
   	});
}

function redirectAddTran(id){
	var hrefPath = getRootPath()+'/translator/addTranslator.htm';
	setCookie("translator_id", id);
	setCookie("translator_page", window.pageNum);
	window.location.href = hrefPath;
}
