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
						<li class="active">机构信息</li>
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
                                <button class="btn btn-inverse btn-xs btn-round" id="saveBtn" onclick="return false;">添加</button>
                            </span>
                        </div>

                        <div class="col-xs-12" >
							<div class="table-header">机构信息列表</div>
							<table id="simple-table" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>序号</th>
										<th>机构名称</th>
                                        <th>操作</th>
									</tr>
								</thead>
								<tbody id="organizationTbody">
									<tr>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
			<!-- /.page-content -->
			</div>
		</div>
		<jsp:include page="../position/bottom.jsp"></jsp:include>
	</div>
	<jsp:include page="../position/inc.jsp"></jsp:include>
	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/pagejs/organization/organization_list.js?v=1.7"></script>
</body>
</html>
