$(function(){
        $.ajax({
            type: "post",
            dataType: "json",
            url: getRootPath()+'/customer/getAllCustomerList.json',
            success: function (data) {
                data = data.data;
                var optionStr = "";
                for(var i=0; i<data.length; i++)
                    optionStr += "<option>"+data[i].organName+ "-"+data[i].customerName+"</option>";
                $("#customerName").html(optionStr);


                $(".chosen-select").chosen({allow_single_deselect:true});
                $(window).off('resize.chosen').on('resize.chosen', function(){
                    $('.chosen-select').each(function(){
                        var $this = $(this);
                        $this.next().css({'width': $this.parent().width()});
                    })
                }).trigger('resize.chosen');

                $("textarea[class*=autosize]").autosize();
                init();
                window.projectId = -1;
                window.sortOrderBy = "";
                window.sortRule = "desc";
                loadData();
                $("#saveBtn").click(function(){
                    saveProject();
                });
            }
        });


});

function saveProject(){
	if(window.disableFlag == 1){
		alert("当前状态不能修改，请联系管理员。");
		return;
	}
	var pData={};
	pData.id = projectId;
	pData.projectName = $("#projectName").val();pData.customerName = $(".chosen-single span").html();
	pData.startDate=$("#startDate").val(); pData.endDate=$("#endDate").val();
	pData.languageFrom=$("#languageFrom").val();pData.languageTo=$("#languageTo").val();
	pData.wordsCount=$("#wordsCount").val(); pData.wordsNoSpace=$("#wordsNoSpace").val();
	pData.reviewWordsCount=$("#reviewWordsCount").val();pData.remarks=$("#remarks").val();
    pData.projectType=$("#projectType").val();

	if(verifyData(pData)){
		if(projectId == -1){
			$.ajax({
				type: "post",
		        dataType: "json",
		        data: pData,
		        url: getRootPath()+'/project/addProjectSubmit.json',
		        success: function (data) {
		    		if(data.status == 1){
                        setCookie("project_id", data.msg);
                        setCookie("project_page", window.pageNum);
                        setCookie("project_name", $("#projectName").val());
                        setCookie("customer_name", $("#customerName").val());
		    			alert("添加成功");
                        window.location.href = getRootPath()+'/project/addProjectPage.htm';
                    }else if(data.status == -1){
		    			alert(data.msg);
		    		}
		        }
		   	});
		}else{
			$.ajax({
				type: "post",
		        dataType: "json",
		        data: pData,
		        url: getRootPath()+'/project/updateTranslatorSubmit.json',
		        success: function (data) {
		        	if(data.status == 1){
		    			alert("更新成功");
		    			//window.location.href=getRootPath()+"/project/projectPage.htm";
		    		}else if(data.status == -1){
		    			alert(data.msg);
		    		}
		        }
		   	});
		}
	}
}

function loadData(){
	projectId = getCookie("project_id");
	//添加项目区块 项目id －1 不能添加区块
    $("#addProjectPartBtn").click(function(){
        projectId = getCookie("project_id");
        if(projectId == -1){
            alert("请先保存项目信息。"); return;
        }
        setCookie("project_id", projectId);setCookie("project_part_id", -1);
        window.location.href = getRootPath()+'/project_part/addProjectPartPage.htm';
    });

	if(projectId == -1) {init();return;}

	$.ajax({
		type: "post",
        dataType: "json",
        data: {id:projectId},
        url: getRootPath()+'/project/getProjectDetail.json',
        success: function (data) {
        	if(data.status == 1){
                if(data.msg == "admin")
                    $("#adminProjectBtn").show()
        		data = data.data; $("#startDate").val(data.startDate); $("#endDate").val(data.endDate);
        		$("#projectName").val(data.projectName);$("#customerName").val(data.customerName);
				$(".chosen-single span").html(data.customerName);
        		$("#languageFrom").val(data.languageFrom);$("#languageTo").val(data.languageTo);
        		$("#wordsCount").val(data.wordsCount);$("#wordsNoSpace").val(data.wordsNoSpace);
        		$("#reviewWordsCount").val(data.reviewWordsCount);$("#remarks").val(data.remarks);
                $("#projectType").val(data.projectType);
                var textareaHeight = document.getElementById("remarks").scrollHeight;
                $("#remarks").height(textareaHeight)
                $("#adminProjectBtn").click(function(){
                    var hrefPath = getRootPath()+'/adminproject/adminProjectPage.htm';
                    setCookie("project_id", data.id);
                    window.location.href = hrefPath;
                });
        	}
        }
   	});
	window.projectId = projectId;
   	loadProjectPartList(1);
}

function init(){
	laydate({ elem: '#startDate',  format: 'YYYY-MM-DD',istime: false, festival:true });
	laydate({ elem: '#endDate',  format: 'YYYY-MM-DD',istime: false, festival:true });
	var mydate = moment().format('YYYY-MM-DD'); $('#startDate').val(mydate);$('#endDate').val(mydate);
	$("#backBtn").click(function(){ 
		window.location.href=getRootPath()+"/project/projectPage.htm";
		window.history.back();
	});
	$("#projectName").blur(function(){
		if($.trim($("#projectName").val()) != ''){ $("#projectName").css("border", "1px solid #858585"); }});
	$("#projectName").blur(function(){
		if($.trim($("#projectName").val()) != ''){ $("#projectName").css("border", "1px solid #858585"); }});
	$("#customerName").blur(function(){
		if($.trim($("#customerName").val()) != ''){ $("#customerName").css("border", "1px solid #858585"); }});
}

function loadProjectPartWithOrder(sortOrderBy){
    window.sortOrderBy = sortOrderBy;
    if(window.sortRule == "desc")
        window.sortRule = "asc";
    else
        window.sortRule = "desc";
    loadProjectPartList(1);
}

function loadProjectPartList(page){
	$("#projectPartListTable").show();
    $.ajax({
        type: "post",
        dataType: "json",
        data: {page: page,projectId: window.projectId, sortOrderBy:window.sortOrderBy, sortRule:window.sortRule},
        url: getRootPath()+'/project_part/projectPartList.json',
        success: function (data) {
            $("#projectPartTbody").empty();
            if(data.data && data.data.results.length > 0){
                source_data = data;
                window.rows =data.data.results;data = data.data;
				window.dixdsableFlag = 0;
                for(var i=0; i<rows.length; i++){
	                var statusStr = rows[i].status == -1?"":"checked";
					var disabledStr = (rows[i].pmCheckout == -1)?"disabled":"";
                    var pmCheckoutDisabledStr = getCookie("words_talk_user_role")=="PM"?"disabled":"";
					window.disableFlag = (rows[i].pmCheckout == -1)?0:1;
					var statusSpan = '<input class="ace ace-switch ace-switch-6 status-input" type="checkbox" '
	                    +statusStr+' data-val='+rows[i].id+' '+disabledStr+'/><span class="lbl"></span>';
                    var pmCheckoutSpan = '<input class="ace ace-switch ace-switch-6 pm-checkout-input" type="checkbox" '
                        + (rows[i].pmCheckout == -1?'':'checked') + ' data-val='+rows[i].id+' '+pmCheckoutDisabledStr+'/><span class="lbl"></span>';
                    $("#projectPartTbody").append("<tr><td><a href='#' onclick='redirectEditProjPart("+rows[i].id+")'>"
						+rows[i].partName+"</a></td><td>"+rows[i].translatorName+"</td><td>"+
                        rows[i].wordsNum+"</td><td>¥ "+rows[i].salaryReal+"</td>" +
                        "<td>"+pmCheckoutSpan+"</td><td>"+statusSpan+"</td><<td>" +
						"<button class='btn btn-xs btn-danger' onclick='deleteButtonClick("+i+")'>" +
						"<i class='ace-icon fa fa-trash-o bigger-120'></i></button></td>/tr>");
                }
                $("#projectPartTbody").append("<tr><td></td><td></td><td></td><td></td><td></td>" +
                    "<td>稿费总计：</td><td>" + source_data.msg+"</td></tr>");

                if(window.disableFlag == 1){
					$("#startDate").attr("disabled","disabled");$("#endDate").attr("disabled","disabled");
					$("#projectName").attr("disabled","disabled");$("#customerName").attr("disabled","disabled");
					$("#languageFrom").attr("disabled","disabled");$("#languageTo").attr("disabled","disabled");
					$("#wordsNoSpace").attr("disabled","disabled");$("#remarks").attr("disabled","disabled");
                    $("#projectType").attr("disabled", "disabled");
				}

				$(".pm-checkout-input").change(function(event){
                    /* 单独更新与PM结算状态*/
                    $.ajax({
                        type: "post",
                        dataType: "json",
                        data: {pmCheckout: event.target.checked==true?1:-1, id: event.target.getAttribute("data-val") },
                        url: getRootPath()+'/adminproject/updatePartPmCheckout.json',
                        success: function (data) {
                            if(data.status == 1){
                                alert("更新成功");
                            }else if(data.status == -1){
                                alert(data.msg);
                            }
                        }
                    });
                });

                $(".status-input").change(function(event){
                    /* 更新结算状态*/
                    $.ajax({
                        type: "post",
                        dataType: "json",
                        data: {status: event.target.checked==true?1:-1, id: event.target.getAttribute("data-val") },
                        url: getRootPath()+'/project_part/updatePartSettleStatus.json',
                        success: function (data) {
                            if(data.status == 1){
                                alert("更新成功");
                            }else if(data.status == -1){
                                alert(data.msg);
                            }
                        }
                    });
                });


				$("button .btn-danger").click(function(event){

				});

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
function deleteButtonClick(pos){
	if(confirm("确认删除:"+rows[pos].partName+"?")){
		var id = event.target.getAttribute("data-val");
		$.ajax({
			type:"post",
			dataType: "json",
			data:{id: rows[pos].id},
			url: getRootPath() + '/project_part/deleteProjectPart.json',
			success: function(data){
				if(data.status == 1){
					alert("删除成功");
				}else {
					alert("删除失败");
				}
				window.location.reload();
			}
		});
	}
}

function redirectEditProjPart(id){
	var hrefPath = getRootPath()+'/project/addProjectPartPage.htm';
	setCookie("project_part_id", id);
	window.location.href = hrefPath;
}

function verifyData(pData){
	if($.trim(pData.projectName) == ''){
		$("#projectName").css("border", "1px solid red");
		return false;
	}
	if($.trim(pData.customerName) == ''){
		$("#customerName").css("border", "1px solid red");
		return false;
	}
	
	return true;
}
