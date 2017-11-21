$(function(){
	$("textarea[class*=autosize]").autosize({append: "\n"});
	laydate({ elem: '#endDate',  format: 'YYYY-MM-DD',istime: false, festival:true });
	$('#endDate').val("");
    laydate({ elem: '#pmCheckoutDate',  format: 'YYYY-MM-DD',istime: false, festival:true });
    $('#pmCheckoutDate').val("");
	window.project_id = getCookie("project_id");
	window.projectDetail; 
	loadProject();
	bindClick();
	
});

function bindClick(){
	//计算项目收入
	$("#getProjectIncomeBtn").click(function(){
		if(!isNum($("#chargeStd").val()) ) {alert("请输入收费标准。"); return;};
		var income = parseFloat( parseFloat($.trim($("#chargeStd").val())) * parseFloat(window.projectDetail.wordsNoSpace) / 1000).toFixed(2);
		if(isNum(income))
			$("#projectIncome").val(income);
		else
			$("#projectIncome").val("0.00");
	});
	$("#getProjectIncomeDetailBtn").click(function(){
		if(!isNum($("#chargeStd").val()) ) {alert("请输入收费标准。"); return;};
		var income = parseFloat( parseFloat($.trim($("#chargeStd").val())) * parseFloat(window.projectDetail.wordsNoSpace) / 1000).toFixed(2);

		var trHtml = "<tr><td>"+window.projectDetail.wordsNoSpace+"</td><td>"+$("#chargeStd").val()+"</td><td>" +
			income+"</td></tr>";
		var tableHtml = "<table id='simple-table' class='table table-striped table-bordered table-hover'> <thead> <tr>"+
			"<th>不计空格字数</th><th>收费标准(千字)</th><th>收入</th></tr></thead><tbody id=>"+trHtml+"</tbody></table>";
		layer.open({
			type: 1, title:"项目收入（收入 ＝ 不计空格字数／1000 * 收费标准）",
			skin: 'layui-layer-rim', //加上边框
			area: ['800px', '400px'], //宽高
			content: tableHtml
		});
	});
	//计算译员稿费
	$("#getTranCostBtn").click(function(){
		$.ajax({
	        type: "post",
	        dataType: "json",
	        data: {id: window.project_id},
	        url: getRootPath()+'/adminproject/queryTransCost.json',
	        success: function (data) {
	        	if(data.status == 1 && data.data.length > 0){
					var tranCost = 0;
					for(var i=0; i<data.data.length; i++)
						tranCost += parseFloat(data.data[i].salaryReal);
	        		$("#tranCost").val(parseFloat(tranCost).toFixed(2));
	        	}else{
	        	    $("#tranCost").val("0.00");
	        	}
	        }
	   	});
	});
	//译员稿费明细
	$("#getTranCostDetailBtn").click(function(){
		$.ajax({
            type: "post",
            dataType: "json",
            data: {id: window.project_id},
            url: getRootPath()+'/adminproject/queryTransCost.json',
            success: function (data) {
                if(data.status == 1 && data.data.length > 0){
                    var tranCost = 0;
                    var trHtml = ""; data = data.data;
					var salaryCount = 0;
                    for(var i=0; i<data.length; i++){
						trHtml += "<tr><td>"+data[i].partName+"</td><td>"+data[i].wordsNum+"</td><td>"+data[i].translatorName+
						"</td><td>"+data[i].salaryStd+"</td><td>"+data[i].salaryReal+"</td></tr>";
						salaryCount += parseFloat(parseFloat(data[i].salaryReal).toFixed(2));
                    }
                    trHtml += "<tr><td></td><td></td><td></td><td></td><td>总计："+salaryCount+"</td></tr>";
					var tableHtml = "<table id='simple-table' class='table table-striped table-bordered table-hover'> <thead> <tr> <th>区块名字</th><th>区块字数</th>"+
                        "<th>译员名字</th><th>稿费标准(千字)</th><th>稿费</th></tr></thead><tbody id=>"+trHtml+"</tbody></table>";
                    layer.open({
						type: 1, title:"译员稿费明细（稿费 ＝ 区块字数／1000 * 稿费标准）",
						skin: 'layui-layer-rim', //加上边框
						area: ['800px', '400px'], //宽高
						content: tableHtml
                    });
                }else{
					alert("译员稿费为空！");
				}
            }
        });
	});
	//计算审校稿费
	$("#getReviewCostBtn").click(function(){
		$.ajax({
            type: "post",
            dataType: "json",
            data: {id: window.project_id},
            url: getRootPath()+'/adminproject/queryReviewCost.json',
            success: function (data) {
                if(data.status == 1 && data.data.length > 0){
                    var tranCost = 0;
                    for(var i=0; i<data.data.length; i++)
                        tranCost += parseFloat(data.data[i].salaryReal);
                    $("#reviewCost").val(tranCost);
                }else{
                    $("#reviewCost").val("0.00");
                }
            }
        });
	});
	//审校明细
    $("#getReviewCostDetailBtn").click(function(){
        $.ajax({
            type: "post",
            dataType: "json",
            data: {id: window.project_id},
            url: getRootPath()+'/adminproject/queryReviewCost.json',
            success: function (data) {
                if(data.status == 1 && data.data.length > 0){
                    var tranCost = 0;
                    var trHtml = ""; data = data.data;
					var salaryCount = 0;
                    for(var i=0; i<data.length; i++){
                        trHtml += "<tr><td>"+data[i].partName+"</td><td>"+data[i].wordsNum+"</td><td>"+data[i].translatorName+
                        "</td><td>"+data[i].salaryStd+"</td><td>"+data[i].salaryReal+"</td></tr>";
						salaryCount += parseFloat(parseFloat(data[i].salaryReal).toFixed(2));
                    }
					trHtml += "<tr><td></td><td></td><td></td><td></td><td>总计："+salaryCount+"</td></tr>";
                    var tableHtml = "<table id='simple-table' class='table table-striped table-bordered table-hover'> <thead> <tr> <th>区块名字</th><th>区块字数</th>"+
                        "<th>译员名字</th><th>稿费标准</th><th>稿费</th></tr></thead><tbody id=>"+trHtml+"</tbody></table>";
                    layer.open({
                        type: 1, title:"审校明细（稿费 ＝ 区块字数／1000 * 审校稿费）",
                        skin: 'layui-layer-rim', //加上边框
                        area: ['800px', '400px'], //宽高
                        content: tableHtml
                    });
                }else{
					alert("审校稿费为空！");
				}
            }
        });
    });

	//计算管理费
	$("#getManageCostBtn").click(function(){
		$.ajax({
	        type: "post",
	        dataType: "json",
	        data: {id: window.project_id},
	        url: getRootPath()+'/adminproject/queryWordsNum.json',
	        success: function (data) {
	        	if(data.status == 1){
	        		$("#manageCost").val(parseFloat(data.data*0.01).toFixed(2));
	        	}
	        }
	   	});
	});
	//计算税费
    $("#getTaxCostBtn").click(function(){
        var income = $("#projectIncome").val();
        if(isNum(income)){
            $("#taxCost").val( parseFloat(income * 0.03).toFixed(2) );
        }else
            $("#taxCost").val("0.00");
    });
	//计算利润;
	$("#getProjectProfitBtn").click(function(){
		var income = $("#projectIncome").val(), trancost=$("#tranCost").val(),managecost=$("#manageCost").val(),
			salecommi=$("#saleCommission").val(), reviewCost=$("#reviewCost").val(), taxCost=$("#taxCost").val();
		if(isNum(income) && isNum(trancost) && isNum(managecost) && isNum(salecommi) && isNum(reviewCost)){
			var projectProfit = parseFloat(income) - parseFloat(trancost) - parseFloat(managecost) -
				parseFloat(salecommi) - taxCost - parseFloat(reviewCost);
			$("#projectProfit").val(projectProfit.toFixed(2));
		}else
			$("#projectProfit").val(0);
	});
	//计算利润率
	$("#getProfitRatioBtn").click(function(){
		var profit = $("#projectProfit").val();var income = $("#projectIncome").val();
		if(isNum(profit) && isNum(income)){
			var profitRatio = parseFloat(parseFloat(profit) /  parseFloat(income) * 100).toFixed(2);
			if(profitRatio > 0){
				$("#profitRatio").val(profitRatio+"%");
				return;
			}
		}
		$("#profitRatio").val("0.00%");
	});
    //计算销售提成
    $("#getSaleCommissionCostBtn").click(function(){
        var per = $("#saleCommissionPer").val();var income = $("#projectIncome").val();
        if(isNum(per) && isNum(income)){
            var profitRatio = parseFloat((parseFloat(per) *  parseFloat(income)) / 100).toFixed(2);
            if(profitRatio > 0){
                $("#saleCommission").val(profitRatio);
                return;
            }
        }
        $("#saleCommission").val("0.00");
    });

	$("button[name='saveProjectAdminBtn']").click(function(){ saveProjectAdmin(); });
	
	$("#exportPartAdminBtn").click(function(){	window.location.href=getRootPath()+'/adminproject/exportPartAdmin.htm?id='+window.project_id;	});
	$("#backProjectBtn").click(function(){
		var hrefPath = getRootPath()+'/project/addProjectPage.htm';
		setCookie("project_id", getCookie("project_id"));
		setCookie("customer_name", window.projectDetail.customerName);
		window.location.href = hrefPath;
	})

	$("#backBtn").click(function(){
		//window.location.href=getRootPath()+'/project/projectPage.htm';	
		window.history.back();
	});
}

function loadProject(){
	$.ajax({
        type: "post",
        dataType: "json",
        data: {id: window.project_id},
        url: getRootPath()+'/adminproject/getProjectDetail.json',
        success: function (data) {
        	if(data.status == 1){
        		window.projectDetail = data.data;
        		$("#projectName").html(window.projectDetail.projectName);
        		$("#wordsCount").html(window.projectDetail.wordsCount);
        		$("#reviewWordsCount").html(window.projectDetail.reviewWordsCount);
        	}
        }
   	});
	
	$.ajax({
		type: "POST",
		dataType: "json",
		data: {projectId: window.project_id},
		url: getRootPath()+'/adminproject/getProjectAdminDetail.json',
		success: function(data){
			if(data.status == 1){
				var data = data.data;
				$("#chargeStd").val(data.chargeStd); $("#projectIncome").val(data.projectIncome);$("#tranCost").val(data.tranCost);
				$("#manageCost").val(data.manageCost); $("#saleCommission").val(data.saleCommission);$("#saleRecord").val(data.saleRecord);
                var textareaHeight = document.getElementById("saleRecord").scrollHeight;
                $("#saleRecord").height(textareaHeight)
				$("#projectProfit").val(data.projectProfit);$("#profitRatio").val(data.profitRatio+"%");$("#accountStatus").val(data.accountStatus);
				$("#endDate").val(data.endDate);$("#taxCost").val(data.taxCost); $("#reviewCost").val(data.reviewCost);
				$("#wordsCountReal").val(data.wordsCount); $("#reviewWordsCountReal").val(data.reviewWordsCount);
				$("#pmCheckout").val(data.pmCheckout); $("#pmCheckoutDate").val(data.pmCheckoutDate);
			}
		}
		
	});
}


function saveProjectAdmin(){
	var chargeStd = $("#chargeStd").val(),projectIncome = $("#projectIncome").val(),tranCost = $("#tranCost").val(),
	manageCost = $("#manageCost").val(), saleCommission = $("#saleCommission").val(), saleRecord = $("#saleRecord").val(),
	projectProfit = $("#projectProfit").val(), profitRatio = $("#profitRatio").val(), accountStatus = $("#accountStatus").val(),
	endDate = $("#endDate").val(), taxCost = $("#taxCost").val(), reviewCost = $("#reviewCost").val(),
	profitRatio = profitRatio.replace("%",""), adminWordsCount = $("#wordsCountReal").val(),
	adminReviewWordsCount = $("#reviewWordsCountReal").val(), pmCheckout = $("#pmCheckout").val(),
    pmCheckoutDate = $("#pmCheckoutDate").val();
	//if(!isNum(chargeStd) ){ alert("请输入收费标准."); return;}
	if(!isNum(projectIncome) ){ alert("请输入项目收入"); return;}
	if(!isNum(tranCost) ){ alert("请输入译员稿费"); return;}
	if(!isNum(manageCost) ){ alert("请输入管理费"); return;}
	if(!isNum(saleCommission) ){ alert("请输入消费提成"); return;}
	if(!isNum(projectProfit) ){ alert("请输入项目利润"); return;}
	if(!isNum(profitRatio) ){ alert("请输入利润率"); return;}
	if(isBlank(accountStatus) ){ alert("请输入客户款到账"); return;}
	// if(!isNum(adminWordsCount) ){ alert("请输入初译合计字数"); return;}
	// if(!isNum(adminReviewWordsCount) ){ alert("请输入审校合计字数"); return;}
	if(!isNum(pmCheckout) ) { alert("请确认是否与PM结算。"); return;}
    if(pmCheckout == "-1") pmCheckoutDate = "";

	var data = {projectId: window.project_id, chargeStd: $.trim(chargeStd), projectIncome: $.trim(projectIncome), 
		tranCost: $.trim(tranCost), manageCost: $.trim(manageCost),
		saleCommission: $.trim(saleCommission), saleRecord: $.trim(saleRecord), projectProfit: $.trim(projectProfit),
		profitRatio: $.trim(profitRatio), accountStatus: $.trim(accountStatus), endDate: $.trim(endDate),
		taxCost: $.trim(taxCost), reviewCost: $.trim(reviewCost), wordsCount:adminWordsCount,pmCheckout:pmCheckout,
		 reviewWordsCount: adminReviewWordsCount, pmCheckoutDate: pmCheckoutDate};
	$.ajax({
        type: "post",
        dataType: "json",
        data: data,
        url: getRootPath()+'/adminproject/saveProjectAdmin.json',
        success: function (data) {
        	if(data.status == 1){
        		alert("保存成功.");
        		//window.location.href=getRootPath()+"/project/projectPage.htm";
        	}else{
        		alert("保存失败.");
        	}
        }
   	});
	
}
