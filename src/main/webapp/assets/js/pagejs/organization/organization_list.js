$(function(){
	loadOrganizationData();
    $("#saveBtn").click(function(){
        if($.trim($("#organName").val()) == ''){
            alert("请输入机构名称");
            return;
        }
        $.ajax({
            type: "post",
            dataType: "json",
            data: {organName: $("#organName").val()},
            url: getRootPath()+'/organization/addOrganization.json',
            success: function(data) {
                if (data.status == 1) {
                    alert("保存成功");
                } else if (data.status == -1) {
                    alert("保存失败")
                }
                window.location.href = getRootPath() + "/organization/organizationPage.htm"
            }
        });
    });
});

function loadOrganizationData(){
	$.ajax({
        type: "post",
        dataType: "json",
        data: {},
        url: getRootPath()+'/organization/organizationList.json',
        success: function (data) {
        	$("#organizationTbody").empty();
    		if(data.data && data.data.results.length > 0){
    			var rows =data.data.results;data = data.data;
    			window.rows = rows;
                for(var i=0; i<rows.length; i++){
    				$("#organizationTbody").append("<tr><td>"+rows[i].id+"</td>" +
						"<td>"+rows[i].organName+
                        "</td><td onclick='deleteOrganization("+rows[i].id+", \""+rows[i].organName+"\")'><a>删除</a></td></tr>");
    			}
    		}
        }
   	});
}

function deleteOrganization(organ_id, organ_name){
    if(confirm("确认删除:"+organ_name+"?")) {
        $.ajax({
            type: "post",
            dataType: "json",
            data: {id: organ_id},
            url: getRootPath() + '/organization/delOrganization.json',
            success: function (data) {
                if (data.status == 1) {
                    alert("删除成功");
                } else if (data.status == -1) {
                    alert("删除失败")
                }
                window.location.href = getRootPath() + "/organization/organizationPage.htm"
            }
        });
    }
}