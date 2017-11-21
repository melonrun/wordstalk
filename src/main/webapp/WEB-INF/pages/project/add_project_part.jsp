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
						<li class="active">添加项目区块</li>
					</ul>
					<!-- /.breadcrumb -->

					<div class="nav-search" id="nav-search">
						<form class="form-search">
							<span class="input-icon">
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
							<!-- PAGE CONTENT BEGINS -->
							<form class="form-horizontal" role="form">
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for=""> 区块类型： </label>
									<div class="col-sm-7">
										<select class="col-sm-2" id="partType">
											<option value="1">初译</option>
											<option value="2">审校</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for=""> 区块名称： </label>
									<div class="col-sm-7">
										<input type="text" id="partName" placeholder="part" class="col-xs-10 col-sm-5" />
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="wordsNum"> 区块字数： </label>
									<div class="col-sm-7">
										<input type="text" id="wordsNum" placeholder="0" class="col-xs-10 col-sm-5" />
									</div>
								</div>
								<div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for=""> 翻译期限： </label>
                                    <div class="col-sm-7">
                                        <input type="text" id="startDate" placeholder="" class="col-xs-2" />
                                        <input type="text" id="endDate" placeholder="" style="margin-left: 15px;" class="col-xs-2" />
                                    </div>
                                </div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="translatorName"> 译员： </label>
									<div class="col-sm-7">
										<input type="text" id="translatorName" placeholder="" class="col-xs-10 col-sm-2" disabled="disabled"/>
										<input type="hidden" id="translatorId" class="col-xs-10 col-sm-5" />
										<button class="btn btn-inverse btn-xs btn-round" id="filterTransBtn" onclick="return false;" style="margin-left:2%;">筛选</button>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="salaryStd"> 稿费标准： </label>
									<div class="col-sm-7">
										<input type="text" id="salaryStd" placeholder="0" class="col-xs-10 col-sm-5" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="salaryReal"> 稿费： </label>
									<div class="col-sm-7">
										<input type="text" id="salaryReal" placeholder="0" class="col-xs-10 col-sm-5" />
										<button class="btn btn-inverse btn-xs btn-round" id="getSalaryBtn" onclick="return false;" style="margin-left:1%;">计算</button>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="status"> 稿费结算： </label>
									<div class="col-sm-7">
										<select class="col-sm-2" id="status">
											<option value="-1">否</option>
											<option value="1">是</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="settleDate"> 结算时间： </label>
									<div class="col-sm-7">
										<input type="text" id="settleDate" placeholder="" class="col-xs-10 col-sm-5" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"> 翻译打分： </label>
									<div class="col-sm-7">
										<table class="table table-striped table-bordered">
											<thead>
											<tr><th>拼写</th>
											<th>准确</th>
											<th>完整</th>
											<th>用词</th>
											<th>语言</th>
											<th>总分</th>
											</tr>
											</thead>
											<tbody>
												<tr>
													<td><input type="number" max="10" id="score1" placeholder="0" class="col-xs-10 col-sm-10" /></td>
													<td><input type="number" max="10" id="score2" placeholder="0" class="col-xs-10 col-sm-10"/></td>
													<td><input type="number" max="10" id="score3" placeholder="0" class="col-xs-10 col-sm-10"/></td>
													<td><input type="number" max="10" id="score4" placeholder="0" class="col-xs-10 col-sm-10"/></td>
													<td><input type="number" max="10" id="score5" placeholder="0" class="col-xs-10 col-sm-10"/></td>
													<td><input type="text" max="10" id="score_avg" placeholder="0" class="col-xs-10 col-sm-10"/></td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="comment"> 备注： </label>
									<div class="col-sm-7">
										<textarea id="comment" class="autosize-transition form-control"></textarea>
									</div>
								</div>
							</form>
						</div>
							<div class="col-xs-12">
							<div class="clearfix">
								<div class="col-md-offset-3 col-md-9">
									<button class="btn btn-inverse btn-round" type="button" id="saveBtn">
										<i class="ace-icon fa fa-check bigger-110"></i>
										添加
									</button>
									&nbsp; &nbsp; &nbsp;
									<button class="btn btn-inverse btn-round" type="button" id="backBtn">
										<i class="ace-icon fa fa-undo bigger-110"></i>
										返回
									</button>
								</div>
							</div>
						</div>
					</div>

					<div class="row" id="translatorFilterDiv" style="display:none;">
						<div class="col-xs-12" style="margin-bottom: 5px;">
                            <span style="margin-left: 1%;">译员客户筛选：
								<select id="customerName" style="width:10%;">
								</select>
                            </span>
                            <span style="margin-left: 2%;">
                                译员级别筛选：<select id="remarks" style="width:10%;">
                                    <option value="-1">所有</option>
                                    <option value="1">新</option>
                                    <option value="2">低</option>
                                    <option value="3">中</option>
                                    <option value="4">高</option>
                                </select>
                            </span>
							<span style="margin-left: 2%;">
								译员姓名：<input type="text" id="transFilterName" style="width:10%;"/>
							</span>
                            <span style="margin-left: 2%;">
                                <button class="btn btn-inverse btn-xs btn-round" id="filterBtn" onclick="return false;">筛选</button>
                            </span>
                        </div>
                        <div class="col-xs-12" id="projectPartListTable">
                            <table id="simple-table" class="table table-striped table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th style="width: 8%;">译员姓名</th>
                                        <th style="width: 30%;">背景</th>
                                        <th style="width: 25%;">非空闲时间</th>
                                        <th>说明</th>
                                        <th style="width:5%;">操作</th>
                                    </tr>
                                </thead>
                                <tbody id="projectTransTbody">
                                    <tr>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>

				</div>
				<!-- /.page-content -->

			</div>
		</div>
		<jsp:include page="../position/bottom.jsp"></jsp:include>
	</div>
	<jsp:include page="../position/inc.jsp"></jsp:include>
	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/pagejs/project/add_project_part.js?v=1.7"></script>
</body>
</html>
