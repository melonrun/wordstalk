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
							<span style="margin-left: 1%;">译员客户筛选：
								<select id="remarks" style="width:10%;">
								</select>
                            </span>
							<span style="margin-left: 1%;">
                                译员级别筛选：<select id="levelStr" style="width:10%;">
                                    <option value="-1">所有</option>
                                    <option value="1">新</option>
                                    <option value="2">低</option>
                                    <option value="3">中</option>
                                    <option value="4">高</option>
                                </select>
                            </span>
							<span style="margin-left: 1%;">
								译员姓名：<input type="text" id="transFilterName" style="width:10%;"/>
							</span>
							<span style="margin-left: 1%;">
								语言：
								<select style="width:5%;" id="languageFrom">
									<option value="-1">所有</option>
									<option value="中">中</option>
									<option value="英">英</option>
									<option value="日">日</option>
									<option value="法">法</option>
									<option value="德">德</option>
									<option value="韩">韩</option>
									<option value="西">西</option>
									<option value="意">意</option>
									<option value="俄">俄</option>
									<option value="蒙">蒙</option>
								</select>
								<select style="width:5%;" id="languageTo">
									<option value="-1">所有</option>
									<option value="中">中</option>
									<option value="英">英</option>
									<option value="日">日</option>
									<option value="法">法</option>
									<option value="德">德</option>
									<option value="韩">韩</option>
									<option value="西">西</option>
									<option value="意">意</option>
									<option value="俄">俄</option>``
									<option value="蒙">蒙</option>
								</select>
							</span>
							<span style="margin-left: 1%;">
                                <button class="btn btn-inverse btn-xs btn-round" id="searchCond" onclick="return false;">搜索</button>
                            </span>

							<div class="btn-group btn-corner" style="float: right;">
								<a href="#"><button class="btn btn-inverse btn-xs btn-round" onclick="redirectAddTran(-1);">添加译员</button></a>
								<a href="<%=request.getContextPath()%>/translator/exportTranslator.htm"><button class="btn btn-inverse btn-xs btn-round">导出数据</button></a>
							</div>
						</div>
						<!--<div class="col-xs-12" style="margin-bottom: 5px;">
							<span style="margin-left: 1%;">
								合同到期检查：
								<select style="width:10%;" id="contractStatus">
									<option value="-1">所有</option>
									<option value="1">已到期</option>
									<option value="2">不到一个月</option>
								</select>
							</span>

						</div> -->
						<div class="col-xs-12" >
							<div class="table-header">译员信息列表</div>
							<table id="simple-table" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th style="width: 10%;">姓名</th>
										<th>备注</th>
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
    			<div class="row dataTables_info" id="new_page">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;共有&nbsp;<span class="red" id="sumBar">0</span> &nbsp;个译员，当前第&nbsp;<span class="green" id="curBar"> 0-0 </span>&nbsp;项</div>
				</div>
				<!-- /.page-content -->

			</div>
		</div>
		<jsp:include page="../position/bottom.jsp"></jsp:include>
	</div>
	<jsp:include page="../position/inc.jsp"></jsp:include>
	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/pagejs/translate/translate.js?v=1.7"></script>
</body>
</html>
