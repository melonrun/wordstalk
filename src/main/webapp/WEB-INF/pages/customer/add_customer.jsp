<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Words - Talk</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
</head>
<body class="no-skin">
	<div id="navbar" class="navbar navbar-default">
		<div class="navbar-container" id="navbar-container">
			<jsp:include page="../position/top.jsp"></jsp:include>
		</div>
		<!-- /.navbar-container -->
	</div>

	<div class="main-container" id="">
		<jsp:include page="../position/left.jsp"></jsp:include>

		<div class="main-content">
			<div class="main-content-inner" id="container">
				<div class="breadcrumbs" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">管理中心</a>
						</li>
						<li class="active">添加客户</li>
					</ul>
					<!-- /.breadcrumb -->

				</div>

				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							<form class="form-horizontal" role="form">
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="customerName"> 客户姓名<span class="red">*</span>： </label>
									<div class="col-sm-7">
										<input type="text" id="customerName" placeholder="Username" class="col-xs-10 col-sm-5" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="managerName"> 客户经理<span class="red">*</span>： </label>
									<div class="col-xs-3">
										<select class="form-control" id="managerName">
											<option value="马辰智">马辰智</option>
											<option value="边晓婕">边晓婕</option>
											<option value="陈逍雨">陈逍雨</option>
										</select>
									</div>
								</div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="organName"> 机构名称： </label>
                                    <!-- <div class="col-xs-3">
                                        <select class="form-control" id="organName">
                                        </select>
                                    </div> -->
									<div class="col-xs-10 col-sm-3">
										<select class="chosen-select" id="organName" data-placeholder="choosen..." >
                                            <option>Ala</option>
                                            <option>人民邮电出版社</option>
                                            <option>Clc</option>
                                            <option>Dld</option>
                                        </select>
									</div>
                                </div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="title"> 职位： </label>
									<div class="col-sm-7">
										<input type="text" id="title" placeholder="" class="col-xs-10 col-sm-5" />
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="cellphone"> 电话： </label>
									<div class="col-sm-7">
										<input type="text" id="cellphone" placeholder="" class="col-xs-10 col-sm-5" />
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="email"> 邮箱： </label>
									<div class="col-sm-7">
										<input type="text" id="email" placeholder="" class="col-xs-10 col-sm-5" />
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="email"> QQ： </label>
									<div class="col-sm-7">
										<input type="text" id="qq" placeholder="" class="col-xs-10 col-sm-5" />
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="email"> 地址： </label>
									<div class="col-sm-7">
										<input type="text" id="address" placeholder="" class="col-xs-10 col-sm-5" />
									</div>
								</div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="remark"> 备注： </label>
                                    <div class="col-sm-7">
                                        <textarea class="autosize-transition form-control" id="remark" ></textarea>
                                    </div>
                                </div>

							</form>
						</div>
						<div class="col-xs-12">
							<div class="clearfix">
										<div class="col-md-offset-3 col-md-9">
											<button class="btn btn-inverse btn-round" type="button" id="saveBtn">
												<i class="ace-icon fa fa-check bigger-110"></i>
												保存
											</button>
											&nbsp; &nbsp; &nbsp;
											<button class="btn btn-inverse btn-round" type="button" id="backBtn">
												<i class="ace-icon fa fa-undo bigger-110"></i>
												返回
											</button>
										</div>
									</div>
						</div>
						
						<div class="col-xs-12" id="projectListTable" style="margin-top: 2%;">
							<table id="simple-table" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>项目ID</th>
										<th>项目名称</th>
										<th>收费标准</th>
										<th>项目收入</th>
										<th>销售提成</th>
										<th>客户款到账</th>
										<th>到账时间</th>
									</tr>
								</thead>
								<tbody id="projectListTbody">
									<tr>
									</tr>
								</tbody>
							</table>
							<div class="row" id="pageBar" style="position:relative; bottom:1px;float:right;"></div> 
    					    <div class="row dataTables_info" id="new_page">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;共有&nbsp;<span class="red" id="sumBar">0</span> &nbsp;个项目，当前第&nbsp;<span class="green" id="curBar"> 0-0 </span>&nbsp;项</div>
						</div>
						
					</div>
				</div>
				<!-- /.page-content -->

			</div>
		</div>
		<jsp:include page="../position/bottom.jsp"></jsp:include>
	</div>
	<jsp:include page="../position/inc.jsp"></jsp:include>
	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/pagejs/customer/add_customer.js?v=1.7"></script>
</body>
</html>
