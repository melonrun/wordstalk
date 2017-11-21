$(function(){
	$("textarea[class*=autosize]").autosize({append: "\n"});
	loadData();
});
function loadData(){
    $.ajax({
        type:"post",
        dataType: "json",
        url: getRootPath()+'/organization/organizationList.json',
        success: function(data){
            if(data.status == 1){
                data = data.data.results;
                var optionStr = "";
                for(var i=0; i<data.length; i++)
                    optionStr += "<option value='"+data[i].organName+"'>"+data[i].organName+"</option>"
                $("#organName").html(optionStr);
                $(".chosen-select").chosen({allow_single_deselect:true});

                $("#managerName").val($("#wordsTalkRole").html());
                init();
            }
        }
    });

};

function init(){
    var customerId = getCookie("customer_id");$("#projectListTable").hide();

    $("#backBtn").click(function(){
        window.history.back();
    });
    $("#saveBtn").click(function(){
        saveCustomer(customerId);
    });

    if(customerId == -1 || customerId == "-1") {
        return;
    }
    laodCustomerDetail(customerId);

};

function laodCustomerDetail(customerId){
	$.ajax({
		type: "post",
        dataType: "json",
        data: {id:customerId},
        url: getRootPath()+'/customer/getCustomerDetail.json',
        success: function (data) {
        	if(data.status == 1){
        		data = data.data[0]; $("#customerName").val(data.customerName);
                $("#managerName").val(data.managerName);
        		$("#address").val(data.address);$("#cellphone").val(data.cellphone);
        		$("#qq").val(data.qq);$("#organName").val(data.organName);
        		$("#title").val(data.title);
        		$("#email").val(data.email);$("#remark").val(data.remark);
                $("#organName").val(data.organName);
                $(".chosen-single span").html(data.organName);
                var textareaHeight = document.getElementById("remark").scrollHeight;
                $("#remark").height(textareaHeight);

                loadProjectList(data.organName+"-"+data.customerName);
        	}
        }
   	});
};

function loadProjectList(customerName){
    $.ajax({
        type: "post",
        dataType: "json",
        data: {customerName: customerName},
        url: getRootPath()+'/customer/getProjectListByCustomer.json',
        success: function (data) {
            if(data.status == 1){
                data = data.data;
                $("#projectListTable").show();
                $("#projectListTbody").empty();
                $("#sumBar").html(data.length);$("#curBar").html("1-"+data.length);
                for(var i=0; i<data.length; i++){
                    var pId = data[i].startDate + "-" + data[i].endDate;
                    var aStatus = data[i].accountStatus;
                    if(aStatus == "-1") aStatus = "否";
                    if(aStatus == "1") aStatus = "<span class='red'>是</span>"
                    if(aStatus == null) aStatus = "";
                    var aDate = data[i].accountDate;
                    if(aDate == null) aDate = "";
                    $("#projectListTbody").append("<tr><td>"+pId+"</td><td>"+data[i].projectName+"</td><td>"+
                        data[i].chargeStd+"</td><td>"+data[i].projectIncome+"</td><td>"+data[i].saleCommission+"</td><td>"
                        +aStatus+"</td><td>"+aDate+"</td></tr>");
                }
            }
        }
    });
};

function saveCustomer(customerId){
    var cData={};
    cData.id = customerId;
    cData.customerName = $("#customerName").val();
    cData.organName = $(".chosen-single span").html();
    cData.managerName = $("#managerName").val();
    cData.title = $("#title").val();
    cData.cellphone = $("#cellphone").val();
    cData.email = $("#email").val();
    cData.qq = $("#qq").val();
    cData.address= $("#address").val();
    cData.remark = $("#remark").val();

    if(verifyData(cData)){
        $.ajax({
            type: "post",
            dataType: "json",
            data: cData,
            url: getRootPath()+'/customer/updateCustomerSubmit.json',
            success: function (data) {
                if(data.status == 1){
                    alert("保存成功");
                }else if(data.status == -1){
                    alert(data.msg);
                }
                window.location.href = getRootPath() + "/customer/customerPage.htm";
            }
        });
    }


};

function verifyData(cData){
    if($.trim(cData.customerName) == ''){
        $("#customerName").css("border", "1px solid red");
        return false;
    }
    if($.trim(cData.managerName) == ''){
        $("#managerName").css("border", "1px solid red");
        return false;
    }
    return true;
}

