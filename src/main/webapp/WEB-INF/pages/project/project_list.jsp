<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
						<li class="active">项目信息</li>
					</ul>

					<div class="nav-search" id="nav-search">
						<form class="form-search">
							<span class="input-icon">
								<button class="btn btn-inverse btn-xs btn-round" id="addProjectBtn" onclick="return false;">添加项目</button>
								<button class="btn btn-inverse btn-xs btn-round" id="exportProjectBtn" onclick="return false;">导出数据</button>
							</span>
						</form>
					</div>
					<!-- /.nav-search -->
				</div>

				<div class="page-content">
					<div class="row">
						<div class="col-xs-12" style="margin-bottom: 5px;">
							<span style="margin-left: 1%;">项目名称：<input type="text" class="input-sm" id="projectName" /></span>
							<span style="margin-left: 2%;">
								项目状态：<select id="projectStatus" style="width:10%;">
									<option value="-1">全部</option>
									<option value="0">正在进行</option>
									<option value="1">交稿未结算</option>
									<option value="2">已结项</option>
									<option value="3">未录入</option>
								</select>	
							</span>
							<span style="margin-left: 2%;">
								客户名称：<input type="text" class="input-sm" id="customerName" />
							</span>
							<span style="margin-left: 2%;">
								项目类型：<select id="projectType" style="width:10%;">
                                    <option value="-1">全部</option>
									<option value="1">非书籍</option>
									<option value="2">书籍</option>
								</select>
							</span>
							<span style="margin-left: 2%;">
								<button class="btn btn-inverse btn-xs btn-round" id="searchCond" onclick="return false;">搜索</button>
							</span>
						</div>
						<div class="col-xs-12">
							<div class="table-header">项目信息列表</div>
							<table id="simple-table" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>项目 ID </th>
										<th>项目名称</th>
										<th>客户名称</th>
										<th>管理项目</th>
									</tr>
								</thead>
								<tbody id="translatorTbody">
									<tr>
									</tr>
								</tbody>
							</table>
						</div>
						<!-- /.span -->
					</div>
					<div class="row" id="pageBar" style="position:relative; bottom:1px;float:right;"></div> 
    			<div class="row dataTables_info" id="new_page">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;共有&nbsp;<span class="red" id="sumBar">0</span> &nbsp;个项目，当前第&nbsp;<span class="green" id="curBar"> 0-0 </span>&nbsp;项</div> 
				</div>
				<!-- /.page-content -->

			</div>
		</div>
		<jsp:include page="../position/bottom.jsp"></jsp:include>
	</div>
	<jsp:include page="../position/inc.jsp"></jsp:include>
	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/pagejs/project/project.js?v=1.7"></script>
</body>
</html>
