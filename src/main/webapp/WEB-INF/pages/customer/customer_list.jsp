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
						<li class="active">译员信息</li>
					</ul>
					<!-- /.breadcrumb -->

					<div class="nav-search" id="nav-search">
					</div>
					<!-- /.nav-search -->
				</div>

				<div class="page-content">
					<div class="row">
						<div class="col-xs-12" style="margin-bottom: 5px;">
							<span style="margin-left: 1%;">
								机构名称：<input type="text" id="organName" style="width:10%;"/>
							</span>
							<span style="margin-left: 1%;">
								客户名称：<input type="text" id="customerName" style="width:10%;"/>
							</span>

							<span style="margin-left: 1%;">
                                <button class="btn btn-inverse btn-xs btn-round" id="searchCond" onclick="return false;">搜索</button>
                            </span>
							<div class="btn-group btn-corner" style="float: right;">
								<a href="#"><button class="btn btn-inverse btn-xs btn-round" onclick="redirectAddCustomer(-1);">添加客户</button></a>
								<a href="<%=request.getContextPath()%>/customer/exportCustomer.htm"><button class="btn btn-inverse btn-xs btn-round">导出数据</button></a>
							</div>
						</div>

						<div class="col-xs-12" >
							<div class="table-header">客户信息列表</div>
							<table id="simple-table" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th style="width: 30%;">机构名称</th>
										<th style="width: 30%;">客户名称</th>
										<th>备注</th>
									</tr>
								</thead>
								<tbody id="customerTbody">
									<tr>
									</tr>
								</tbody>
							</table>
						</div>
						<!-- /.span -->
					</div>
					<div class="row" id="pageBar" style="position:relative; bottom:1px;float:right;"></div> 
    			<div class="row dataTables_info" id="new_page">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;共有&nbsp;<span class="red" id="sumBar">0</span> &nbsp;个客户，当前第&nbsp;<span class="green" id="curBar"> 0-0 </span>&nbsp;项</div>
				</div>
				<!-- /.page-content -->

			</div>
		</div>
		<jsp:include page="../position/bottom.jsp"></jsp:include>
	</div>
	<jsp:include page="../position/inc.jsp"></jsp:include>
	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/pagejs/customer/customer_list.js?v=1.7"></script>
</body>
</html>
