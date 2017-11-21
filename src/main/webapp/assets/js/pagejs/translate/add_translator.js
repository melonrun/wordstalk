$(function(){
	$("textarea[class*=autosize]").autosize({append: "\n"});
	window.languageSkillArr = [];
	window.spareDaysArr = [];
	window.translatorId = -1;
	loadData();
});
function loadData(){
	translatorId = getCookie("translator_id");$("#projectListTable").hide();
	if(translatorId == -1) {
		init();return;
	}
	
	loadTranslatorDetail(translatorId);
	loadProjectList(translatorId, 1);
}

function loadTranslatorDetail(translatorId){
	$.ajax({
		type: "post",
        dataType: "json",
        data: {id:translatorId},
        url: getRootPath()+'/translator/getTranslatorDetail.json',
        success: function (data) {
        	if(data.status == 1){
        		data = data.data; $("#name").val(data.name); $("#level").val(data.level);
        		$("#workExperience").val(data.workExperience);$("#skillfulField").val(data.skillfulField);
        		$("#startDate").val(data.contractStartDate);$("#endDate").val(data.contractEndDate);
        		$("#salary").val(data.salary);$("#telephone").val(data.telephone);
        		$("#email").val(data.email);$("#remarks").val(data.remarks);$("#status").val(data.status);
                var textareaHeight = document.getElementById("remarks").scrollHeight;
                $("#remarks").height(textareaHeight)
        		if(data.languageList != '' && data.languageList != null){
	        		languageSkillArr = data.languageList.split(",");
		        		for(var i in languageSkillArr){
		        			$("#languageDiv").show();var bHtml = $("#languageDivTag").html();
		        			$("#languageDivTag").html(bHtml+"<span class='tag' data-val='"+languageSkillArr[i]+"'>"+languageSkillArr[i]+"<button type='button' class='close'>×</button></span>");
		        		}
        		}
        		
        		if(data.spareDayStr != '' && data.spareDayStr != null){
        			window.spareDaysArr = data.spareDayStr.split(",");
		        		for(var i in spareDaysArr){
		        			$("#spareDaysDiv").show();var bHtml = $("#spareDaysDivTag").html();
		        			$("#spareDaysDivTag").html(bHtml+"<span class='tag' data-val='"+spareDaysArr[i]+"'>"+spareDaysArr[i]+"<button type='button' class='close'>×</button></span>");
		        		}
		        		$("#spareCountDays").html(spareDaysArr.length);
        		}
        		
        		init();
        		bindRemoveClick();
        	}
        }
   	});
}

function bindRemoveClick(){
	$("#languageDiv .tag").click(function(){
		languageSkillArr.splice($.inArray($.trim($(this).attr("data-val"),languageSkillArr),1));
		$(this).remove();
		if($.trim($("#languageDivTag").html()) == '')$("#languageDiv").hide();
	});
	
	$("#spareDaysDiv .tag").click(function(){
		spareDaysArr.splice($.inArray($.trim($(this).attr("data-val"),spareDaysArr),1));
		$(this).remove();$("#spareCountDays").html(spareDaysArr.length);
		if($.trim($("#spareDaysDivTag").html()) == '')$("#spareDaysDiv").hide();
	});
}

function loadProjectList(translatorId, page){
	$.ajax({
		type: "post",
        dataType: "json",
        data: {searchKey: translatorId, page: page},
        url: getRootPath()+'/project_part/getProjectPartByTid.json',
        success: function (data) {
            sdata = data;
        	if(data.data && data.data.results.length > 0){
        		$("#projectListTable").show();$("#translatorTbody").empty();
        		var rows =data.data.results;data = data.data;
				window.rows = rows;
    			for(var i=0; i<rows.length; i++){
    				var statusStr = rows[i].status == -1?"":"checked";
    				var statusSpan = '<input name="switch-field-1" class="ace ace-switch ace-switch-6" type="checkbox" '
    				+statusStr+' data-val='+rows[i].id+' /><span class="lbl"></span>';
                    var pmCheckoutStr = (rows[i].pmCheckout == -1)?"否":"<span style='color:red;'>是</span>";
    				$("#translatorTbody").append("<tr><td>"+rows[i].projectIdStr+"</td><td id='aliasName"+rows[i].id+"'><a href='#' onclick='redirectEditProj("+i+")'>"+rows[i].projectName+"</a></td>"
						+"<td><a href='#' onclick='redirectEditProjPart("+rows[i].id+", "+rows[i].projectId+")'>"+rows[i].partName+"</a></td><td>"+rows[i].startDate+"~~"+rows[i].endDate+"</td><td>"+
    					rows[i].wordsNum+"</td><td>¥ "+rows[i].salaryReal+"</td><td>"+pmCheckoutStr+"</td><td>"+statusSpan+"</td><td>"+rows[i].comment+"</td></tr>");
    			}
    			$("#translatorTbody").append("<tr><td></td><td></td><td></td><td></td><td>总计：</td><td>¥" +
                    sdata.msg+"</td><td></td><td></td><td></td></tr>")
    			var endBar = (data.curPage)*data.rows > data.dataSum ? data.dataSum:(data.curPage)*data.rows;
				$(".ace-switch-6").change(function(event){
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

    			$("#sumBar").html(data.dataSum);$("#curBar").html((data.curPage-1)*data.rows+1+"-"+endBar);
    			laypage({
    	            cont: 'pageBar', //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
    	            pages: data.pages, //通过后台拿到的总页数
    	            curr: data.curPage || 1, //当前页
    	            jump: function(obj, first){ //触发分页后的回调
    	                if(!first){ //点击跳页触发函数自身，并传递当前页：obj.curr
    	                	loadProjectList(window.translatorId, obj.curr);
    	                }
    	            }
    	        });
        	}
        }
   	});
}

function init(){
	laydate({ elem: '#startDate',  format: 'YYYY-MM-DD',istime: false, festival:true });
	laydate({ elem: '#endDate',  format: 'YYYY-MM-DD',istime: false, festival:true});
	laydate({ elem: '#spareDays',  format: 'YYYY-MM-DD',istime: false, festival:true, choose : function(datas){ addSpareDaysChoose();}});
	if($.trim($("#languageDivTag").html()) == '')
		$("#languageDiv").hide();
	if($.trim($("#spareDaysDivTag").html()) == '')
		$("#spareDaysDiv").hide();
	$("#addTranLanguageBtn").click(function(){
		$("#languageDiv").show();
		var bHtml = $("#languageDivTag").html();
		var languageSkill = $("#languageFromSelect").val()+"-"+$("#languageToSelect").val();
		languageSkillArr.push(languageSkill);
		$("#languageDivTag").html(bHtml+"<span class='tag' data-val='"+languageSkill+"'>"+languageSkill+"<button type='button' class='close'>×</button></span>");
		$("#languageDiv .tag").click(function(){
			languageSkillArr.splice($.inArray($.trim($(this).attr("data-val"),languageSkillArr),1));
			$(this).remove();
			if($.trim($("#languageDivTag").html()) == '')$("#languageDiv").hide();
		});
	});
	
	$("#backBtn").click(function(){
//		window.location.href=getRootPath()+"/translator/translatorPage.htm?pageNum="+window.pageNum;
		window.history.back();
	});
	
	$("#saveBtn").click(function(){ saveTranslator();});
	$("#name").blur(function(){
		if($.trim($("#name").val()) != ''){ $("#name").css("border", "1px solid #858585"); }});
	$("#workExperience").blur(function(){
		if($.trim($("#workExperience").val()) != ''){ $("#workExperience").css("border", "1px solid #858585"); }});
	$("#salary").blur(function(){
		if($.trim($("#salary").val()) == '' || !(isNaN($.trim($("#salary").val())))){ $("#salary").css("border", "1px solid #858585"); }});
	
	$("#exportDataBtn").click(function(){	window.location.href=getRootPath()+"/translator/exportTranslatorDetail.htm?id="+window.translatorId;	});
};

function addSpareDaysChoose(){
	if($("#spareDays").val() != ''){
		$("#spareDaysDiv").show();
		var bHtml = $.trim($("#spareDaysDivTag").html());
		var spareDays = $("#spareDays").val();
		spareDaysArr.push(spareDays);$("#spareCountDays").html(spareDaysArr.length);
		$("#spareDaysDivTag").html(bHtml+"<span class='tag' data-val='"+spareDays+"'>"+spareDays+"<button type='button' class='close'>×</button></span>");
		$("#spareDaysDiv .tag").click(function(){
			spareDaysArr.splice($.inArray($.trim($(this).attr("data-val"),spareDaysArr),1));
			$(this).remove();$("#spareCountDays").html(spareDaysArr.length);
			if($.trim($("#spareDaysDivTag").html()) == '')$("#spareDaysDiv").hide();
		});
	}
}

function saveTranslator(){
	var pData={};
	pData.id = translatorId;
	pData.name = $("#name").val();
	pData.workExperience = $("#workExperience").val();
	pData.level = $("#level").val();
	pData.skillfulField = $("#skillfulField").val();
	pData.contractStartDate = $("#startDate").val();
	pData.contractEndDate = $("#endDate").val();
	pData.salary = $("#salary").val();
	pData.telephone = $("#telephone").val();
	pData.email = $("#email").val();
	pData.remarks = $("#remarks").val();
	pData.languageList = languageSkillArr.join(",");
	pData.spareDayStr = spareDaysArr.join(",");
	pData.status = $("#status").val();
	
	if(verifyData(pData)){
		if(translatorId == -1){
			$.ajax({
				type: "post",
		        dataType: "json",
		        data: pData,
		        url: getRootPath()+'/translator/addTranslatorSubmit.json',
		        success: function (data) {
		    		if(data.status == 1){
		    			alert("添加成功");
		    			window.location.href=getRootPath()+"/translator/translatorPage.htm";
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
		        url: getRootPath()+'/translator/updateTranslatorSubmit.json',
		        success: function (data) {
		        	if(data.status == 1){
		    			alert("更新成功");
		    			// window.location.href=getRootPath()+"/translator/translatorPage.htm";
		    		}else if(data.status == -1){
		    			alert(data.msg);
		    		}
		        }
		   	});
		}
	}
}

function redirectEditProjPart(id, projectId){
	var hrefPath = getRootPath()+'/project/addProjectPartPage.htm';
	setCookie("project_id", projectId);
	setCookie("project_part_id", id);
	setCookie("project_name", $("#aliasName"+id).html());
	window.location.href = hrefPath; 
}

function verifyData(pData){
	if($.trim(pData.name) == ''){
		$("#name").css("border", "1px solid red");
		return false;
	}
	if($.trim(pData.salary) != '' && isNaN($.trim(pData.salary))){
		$("#salary").css("border", "1px solid red");
		return false;
	}
	
	return true;
}

function redirectEditProj(i){
	var hrefPath = getRootPath()+'/project/addProjectPage.htm';
	setCookie("project_id", window.rows[i].projectId);
	setCookie("project_page", 1);
	setCookie("project_name", window.rows[i].projectName);
	window.location.href = hrefPath;
}