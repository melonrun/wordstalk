$(function(){
	$("textarea[class*=autosize]").autosize({append: "\n"});
	window.transListData;
	window.contentHtml = $("#translatorFilterDiv").html();
	$("#translatorFilterDiv").remove();$("#translatorFilterDiv").empty();
	init();
	window.project_id = getCookie("project_id");
	window.project_part_id = getCookie("project_part_id");
	loadProjectPartData();
});
function init(){
	laydate({ elem: '#startDate',  format: 'YYYY-MM-DD',istime: false, festival:true });
	laydate({ elem: '#endDate',  format: 'YYYY-MM-DD',istime: false, festival:true });
	laydate({ elem: '#settleDate',  format: 'YYYY-MM-DD',istime: false, festival:true });
	var mydate = moment().format('YYYY-MM-DD'); $('#startDate').val(mydate);$('#endDate').val(mydate);$("#settleDate").val();
	blurFunction("partName",1); blurFunction("startDate",1); blurFunction("endDate",1); blurFunction("translatorId",1); 
	blurFunction("status",1); blurFunction("salaryStd",2); blurFunction("wordsNum",2);

	$("#getSalaryBtn").click(function(){ generateSalary();});
	$("#filterTransBtn").click(function(){
		filterTransClick();
	})
    $("input[id*='score']").keyup(function(event){
        changeScoreAvg();
    });
}

function changeScoreAvg(){
    var score1 = $("#score1").val(), score2 = $("#score2").val(), score3 = $("#score3").val(),
        score4 = $("#score4").val(), score5 = $("#score5").val();
    var isn = isNaN(score1);
    if(isNaN(score1) || isNaN(score2) || isNaN(score3) || isNaN(score4) || isNaN(score5))
        $("#score_avg").val(0.0);
    else{
        var score = parseInt(score1==""?0:score1) * 0.05 + parseInt(score2==""?0:score2) * 0.3 +
            parseInt(score3==""?0:score3) * 0.3 + parseInt(score4==""?0:score4) * 0.2
            + parseInt(score5==""?0:score5) * 0.15;
        score = parseFloat(score).toFixed(2);
        $("#score_avg").val(score);
    }
}

function translatorNameChange(){
	var id = $("#translatorId").val();
    for(var i=0; i<window.transListData.length; i++){
        if(transListData[i].id == id){
            $("#salaryStd").val(transListData[i].salary);
            generateSalary();
            return;
        }
    }
}

function filterTransClick(){
	window.project_part_id;
	layer.open({
        type: 1, title:"译员筛选",
        skin: 'layui-layer-rim', //加上边框
        area: ['80%', '60%'], //宽高
        content: window.contentHtml
    });

    $.ajax({
        type: "post",
        dataType: "json",
        url: getRootPath()+'/project/getAllCustomerName.json',
        success: function (data) {
            if(data.status == 1){
                data = data.data; var customerHtml = "<option value='-1'>所有</option>";
                $("#customerName").empty();
                for(var i =0; i<data.length; i++){
					customerHtml += "<option value='"+data[i]+"'>"+data[i]+"</option>"
                }
				$("#customerName").append(customerHtml);
            }
            getTransListByProejct();
        }
    });
    $("#filterBtn").click(function(){
        getTransListByProejct();
    })
}

function getTransListByProejct(){
	$("#projectTransTbody").empty();
	$.ajax({
        type: "post",
        data: {id: window.project_id, customerName: $("#customerName").val(), remarks: $("#remarks").val(),
			temp: $("#transFilterName").val()},
        dataType: "json",
        url: getRootPath()+'/project/filterTransByProject.json',
        success: function (data) {
            if(data.status == 1){
                data = data.data;
                window.transListData = data;
				var tbodyHtml = "";
				for(var i=0; i<data.length; i++){
					tbodyHtml += "<tr><td>"+data[i].name+"</td><td>"+(data[i].workExperience==null?'':data[i].workExperience)+
					"</td><td>"+(data[i].spareDayStr==null?'':data[i].spareDayStr)+"</td>"+
					"<td>"+data[i].remarks+"</td><td><a href='#' onclick='chooseTrans("+i+")'>选择</a></td></tr>";
				}
				$("#projectTransTbody").append(tbodyHtml);
            }
        }
    });
}

function chooseTrans(id){
	//关闭弹窗 设置input值。
	layer.closeAll();
	$("#translatorId").val(window.transListData[id].id);
	$("#translatorName").val(window.transListData[id].name);
	$("#salaryStd").val(window.transListData[id].salary);

	//设置 稿费标准。
	translatorNameChange();
}


function generateSalary(){
	var wordsNum = $("#wordsNum").val(); var salaryStd = $("#salaryStd").val();
	if(!isNaN($.trim(wordsNum)) && !isNaN($.trim(salaryStd)) ){
		$("#salaryReal").val(parseFloat(parseFloat(wordsNum)/1000 * parseFloat(salaryStd)).toFixed(2));
	}
}

function loadProjectPartData(){
	$("#projectName").html(getCookie("project_name"));
	$("#saveBtn").click(function(){ saveProjectPart();});
	$("#backBtn").click(function(){ 
		//window.location.href = getRootPath()+'/project_part/projectPartPage.htm';
		window.history.back();
	});

	if(window.project_part_id != -1){
		$.ajax({
			type: "post",
	        dataType: "json",
	        data: {id: window.project_part_id},
	        url: getRootPath()+'/project_part/getProjectPartDetail.json',
	        success: function (data) {
	    		if(data.status == 1){
	    			data = data.data; $("#partName").val(data.partName);
	    			$("#partType").val(data.partType);$("#wordsNum").val(data.wordsNum);
	        		$("#translatorId").val(data.translatorId);
	        		$("#translatorName").val(data.translatorName);$("#salaryStd").val(data.salaryStd);
	        		$("#salaryReal").val(data.salaryReal);$("#startDate").val(data.startDate);
	        		$("#endDate").val(data.endDate);$("#comment").val(data.comment);
                    $("#score1").val(data.score1);$("#score2").val(data.score2);$("#score3").val(data.score3);
                    $("#score4").val(data.score4);$("#score5").val(data.score5);$("#score_avg").val(data.scoreAvg);
                    var textareaHeight = document.getElementById("comment").scrollHeight;
                    $("#comment").height(textareaHeight)
	        		$("#status").val(data.status);$("#settleDate").val(data.settleDate);
	    		}else if(data.status == -1){
	    			alert(data.msg);
	    		}
	    		if(parseInt(data.pmCheckout) == -1){//不能结算，都可以修改
					$("#status").attr("disabled","disabled");$("#settleDate").attr("disabled","disabled");
				}else{// 可以结算，不可以修改
					$("#partName").attr("disabled","disabled");$("#partType").attr("disabled","disabled");
					$("#wordsNum").attr("disabled","disabled");$("#startDate").attr("disabled","disabled");
					$("#endDate").attr("disabled","disabled");$("#salaryReal").attr("disabled","disabled");
					$("#salaryStd").attr("disabled","disabled");$("#comment").attr("disabled","disabled");
					$("#filterTransBtn").remove();$("#getSalaryBtn").remove();
				}


	        }
	   	});
	}
};

function saveProjectPart(){
	var pData={}; pData.id = window.project_part_id;
	pData.projectId=getCookie("project_id");pData.partName=$("#partName").val();
	pData.wordsNum=$("#wordsNum").val();pData.translatorId=$("#translatorId").val();
	pData.partType=$("#partType").val();
	pData.salaryStd=$("#salaryStd").val();pData.salaryReal=$("#salaryReal").val();
	pData.startDate=$("#startDate").val();pData.endDate=$("#endDate").val();
	pData.comment=$("#comment").val();pData.status=$("#status").val();
	pData.settleDate=$("#settleDate").val();pData.score1=$("#score1").val()==""?"0":$("#score1").val();
    pData.score2=$("#score2").val()==""?"0":$("#score2").val();pData.score3=$("#score3").val()==""?"0":$("#score3").val();
    pData.score4=$("#score4").val()==""?"0":$("#score4").val();pData.score5=$("#score5").val()==""?"0":$("#score5").val();
    pData.scoreAvg=$("#score_avg").val()==""?"0":$("#score_avg").val();

	if(verifyData(pData)){
		if(pData.projectId == -1)return;
		else {//part id
			$.ajax({
				type: "post",
		        dataType: "json",
		        data: pData,
		        url: getRootPath()+'/project_part/addProjectPartSubmit.json',
		        success: function (data) {
		    		if(data.status == 1){
		    			alert("添加成功");setCookie("project_id", pData.projectId);
		    			//window.location.href=getRootPath()+"/project_part/projectPartPage.htm";
		    		}else if(data.status == -1){
		    			alert(data.msg);
		    		}
		        }
		   	});
		}
	}
	
}

function blurFunction(id, type){
	if(type == 1){
		$("#"+id).blur(function(){
			if($.trim($("#"+id).val()) != ''){ $("#"+id).css("border", "1px solid #858585"); }});
	}else if(type == 2){
		$("#"+id).blur(function(){
			if($.trim($("#"+id).val()) != '' && !(isNaN($.trim($("#"+id).val())))){ $("#"+id).css("border", "1px solid #858585"); }});
	}
}
function verifyData(pData){
	if($.trim(pData.partName) == ''){
		$("#partName").css("border", "1px solid red");
		return false;
	} if($.trim(pData.wordsNum) == '' || isNaN($.trim(pData.wordsNum))){
		$("#wordsNum").css("border", "1px solid red");
		return false;
	} if($.trim(pData.salaryStd) == '' || isNaN($.trim(pData.salaryStd))){
		$("#salaryStd").css("border", "1px solid red");
		return false;
	} if($.trim(pData.startDate) == ''){
		$("#startDate").css("border", "1px solid red");
		return false;
	} if($.trim(pData.endDate) == ''){
		$("#endDate").css("border", "1px solid red");
		return false;
	} if($.trim(pData.status) == ''){
		$("#status").css("border", "1px solid red");
		return false;
	} if($("#translatorId").val() == -1){
		alert("请选择译员。");
		return false;
	}
	
	return true;
}

