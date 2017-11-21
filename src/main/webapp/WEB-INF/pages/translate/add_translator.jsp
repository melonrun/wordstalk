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
						<li class="active">添加译员</li>
					</ul>
					<!-- /.breadcrumb -->

					<div class="nav-search" id="nav-search">
						<form class="form-search">
							<span class="input-icon">
								<button class="btn btn-inverse btn-xs btn-round" id="exportDataBtn" onclick="return false;">导出数据</button>
							</span>
						</form>
					</div>
					<!-- /.nav-search -->
				</div>

				<div class="page-content">
					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							<form class="form-horizontal" role="form">
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 译员姓名<span class="red">*</span>： </label>
									<div class="col-sm-7">
										<input type="text" id="name" placeholder="Username" class="col-xs-10 col-sm-5" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 级别<span class="red">*</span>： </label>
									<div class="col-xs-3">
										<select class="form-control" id="level">
											<option value="1">新</option>
											<option value="2">低</option>
											<option value="3">中</option>
											<option value="4">高</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 在职<span class="red">*</span>： </label>
									<div class="col-xs-3">
										<select class="form-control" id="status">
											<option value="1">是</option>
											<option value="-1">否</option>
										</select>
									</div>
								</div>
								<div class="form-group" style="display: none;">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 背景<span class="red">*</span>： </label>
									<div class="col-sm-7">
										<input type="text" id="workExperience" placeholder="Exprience.." class="col-xs-10 col-sm-5" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 语言： </label>
									<div class="col-sm-9">
										<select class="col-sm-1" id="languageFromSelect">
											<option value="中">中</option>
											<option value="英">英</option>
											<option value="日">日</option>
											<option value="法">法</option>
											<option value="德">德</option>
											<option value="韩">韩</option>
											<option value="西">西</option>
											<option value="意">意</option>
											<option value="俄">俄</option>
											<option value=""蒙>蒙</option>
										</select>
										<select style="margin-left: 10px;"class="col-sm-1" id="languageToSelect">
											<option value="英">英</option>
											<option value="中">中</option>
											<option value="日">日</option>
											<option value="法">法</option>
											<option value="德">德</option>
											<option value="韩">韩</option>
											<option value="西">西</option>
											<option value="意">意</option>
											<option value="意">意</option>
											<option value="蒙">蒙</option>
										</select>
										<div><button style="margin-left: 20px;" class="btn btn-inverse btn-xs" id="addTranLanguageBtn" onclick="return false;">添加</button></div>
									</div>
								</div>
								<div class="form-group" id="languageDiv">
									<label class="col-sm-3 control-label no-padding-right" for="languageDivTag"> </label>
									<div class="col-sm-7">
										<div class="inline">
											<div style="width:105%;" class="tags" id="languageDivTag">
											</div>
										</div>
									</div>
								</div>
								<div class="form-group" style="display: none;">
									<label class="col-sm-3 control-label no-padding-right" for="skillfulField"> 擅长领域： </label>
									<div class="col-sm-7">
										<input type="text" id="skillfulField" placeholder="eg：汽车" class="col-xs-10 col-sm-5" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for=""> 合同期限： </label>
									<div class="col-sm-7">
										<input type="text" id="startDate" placeholder="" class="col-xs-2" />
										<span class="col-sm-1 help-inline">-----</span>
										<input type="text" id="endDate" placeholder="" class="col-xs-2" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="salary"> 稿费标准(千字)： </label>
									<div class="col-sm-7">
										<input type="text" id="salary" placeholder="0" class="col-xs-10 col-sm-5" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="telephone"> 电话： </label>
									<div class="col-sm-7">
										<input type="text" id="telephone" placeholder="Phone" class="col-xs-10 col-sm-5" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 邮箱： </label>
									<div class="col-sm-7">
										<input type="text" id="email" placeholder="Email" class="col-xs-10 col-sm-5" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 不可兼职时间(天)： </label>
									<div class="col-sm-7">
										<input type="text" id="spareDays" placeholder="Spare time" class="col-xs-10 col-sm-5"/>
										<h6>&nbsp;&nbsp;&nbsp;共计&nbsp;&nbsp; <span id="spareCountDays" style="font-size: 16px;color:red;">0</span>&nbsp;&nbsp;天</h6>
									</div>
								</div>
								<div class="form-group" id="spareDaysDiv">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> </label>
									<div class="col-sm-7">
										<div class="inline">
											<div style="width:105%;" class="tags" id="spareDaysDivTag"> </div>
										</div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="remarks"> 说明： </label>
									<div class="col-sm-7">
										<textarea class="autosize-transition form-control" id="remarks" ></textarea>
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
										<th style="width: 5%;">项目ID</th>
										<th>项目名称</th>
										<th>区块名称</th>
										<th style="width: 12%;">翻译时间</th>
										<th style="width: 6%;">字数</th>
										<th style="width: 8%;">稿费</th>
										<th style="width: 8%;">可结算</th>
										<th style="width: 6%;">稿费结算</th>
										<th style="width: 8%;">质量评价</th>
									</tr>
								</thead>
								<tbody id="translatorTbody">
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
	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/pagejs/translate/add_translator.js?v=1.7"></script>
</body>
</html>
