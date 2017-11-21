$(function(){
	window.pageNum = getCookie("customer_page");
	loadCustomerrData(window.pageNum);
	$("#searchCond").click( function(){loadCustomerrData(1);});
});

function loadCustomerrData(page){
	if(page == undefined || page == "null") page = 1;
	$.ajax({
        type: "post",
        dataType: "json",
        data: {page: page, customerName: $("#customerName").val(), name: $("#organName").val()},
        url: getRootPath()+'/customer/customerList.json',
        success: function (data) {
        	$("#customerTbody").empty();
    		if(data.data && data.data.results.length > 0){
    			var rows =data.data.results;data = data.data;
				var tbodyStr = "";
    			for(var i=0; i<rows.length; i++){
    				tbodyStr += "<tr><td>"+rows[i].organName+"</td>" +
						"<td><a href='#' onclick='redirectAddCustomer("+rows[i].id+")'>"+rows[i].customerName+"</a></td><td>" + rows[i].remark + "</td></tr>";
    			}
    			$("#customerTbody").append(tbodyStr);
    			var endBar = (data.curPage)*data.rows > data.dataSum ? data.dataSum:(data.curPage)*data.rows;
    			$("#sumBar").html(data.dataSum);$("#curBar").html((data.curPage-1)*data.rows+1+"-"+endBar);
    			laypage({
    	            cont: 'pageBar', //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
    	            pages: data.pages, //通过后台拿到的总页数
    	            curr: data.curPage || 1, //当前页
    	            jump: function(obj, first){ //触发分页后的回调
    	                if(!first){ //点击跳页触发函数自身，并传递当前页：obj.curr
    	                    window.pageNum = obj.curr;
    	                    setCookie("customer_page", window.pageNum);
                            loadCustomerrData(obj.curr);
    	                }
    	            }
    	        });
    		}
        }
   	});
}

function redirectAddCustomer(id){
	var hrefPath = getRootPath()+'/customer/addCustomer.htm';
	setCookie("customer_id", id);
	setCookie("customer_page", window.pageNum);
	window.location.href = hrefPath;
}
