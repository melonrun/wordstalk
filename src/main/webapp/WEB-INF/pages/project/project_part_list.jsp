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
						<li class="active">项目区块信息</li>
					</ul>

					<div class="nav-search" id="nav-search">
						<form class="form-search">
							<span class="input-icon">
								<button class="btn btn-inverse btn-xs btn-round" id="addProjectPartBtn" onclick="return false;">添加区块</button>
								<button class="btn btn-inverse btn-xs btn-round" id="exportPartBtn" onclick="return false;">导出数据</button>
							</span>
						</form>
					</div>
					<!-- /.nav-search -->
				</div>

				<div class="page-content">
					<div class="row">
						<div class="col-xs-12" style="margin-bottom: 5px;">
							<h3 class="row header smaller blue">
								<span class="col-sm-7" style="margin-left: 1%;">项目名称：<span id="projectName"></span></span>
							</h3>
						</div>
						<div class="col-xs-12">
							<div class="table-header">区块信息列表</div>
							<table id="simple-table" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>区块名称</th>
										<th>区块字数</th>
										<th>译员名字</th>
										<th>稿费结算</th>
									</tr>
								</thead>
								<tbody id="projectPartTbody">
									<tr>
									</tr>
								</tbody>
							</table>
						</div>
						<!-- /.span -->
					</div>
					<div class="row" id="pageBar" style="position:relative; bottom:1px;float:right;"></div> 
    			<div class="row dataTables_info" id="new_page">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;共有&nbsp;<span class="red" id="sumBar">0</span> &nbsp;个区块，当前第&nbsp;<span class="green" id="curBar"> 0-0 </span>&nbsp;项</div> 
				</div>
				<!-- /.page-content -->

			</div>
		</div>
		<jsp:include page="../position/bottom.jsp"></jsp:include>
	</div>
	<jsp:include page="../position/inc.jsp"></jsp:include>
	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/pagejs/project/project_part_list.js?v=1.7"></script>
</body>
</html>
