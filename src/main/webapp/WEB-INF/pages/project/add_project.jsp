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
						<li class="active">添加项目</li>
					</ul>
					<!-- /.breadcrumb -->

					<div class="nav-search" id="nav-search">
                        <form class="form-search">
                            <span class="input-icon">
                                <button style="display: none;" class="btn btn-inverse btn-xs btn-round" id="adminProjectBtn" onclick="return false;">Admin管理</button>
                            </span>
							<span class="input-icon">
                                <button class="btn btn-inverse btn-xs btn-round" id="addProjectPartBtn" onclick="return false;">添加区块</button>
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
									<label class="col-sm-3 control-label no-padding-right" for=""> 项目期限： </label>
									<div class="col-sm-7">
										<input type="text" id="startDate" placeholder="" class="col-xs-2" />
										<input type="text" id="endDate" placeholder="" style="margin-left: 15px;" class="col-xs-2" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="projectName"> 项目名称<span class="red">*</span>： </label>
									<div class="col-sm-7">
										<input type="text" id="projectName" placeholder="project" class="col-xs-10 col-sm-5" />
									</div>
								</div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="projectName"> 项目类型<span class="red">*</span>： </label>
                                    <div class="col-sm-7">
                                        <select class="col-sm-3" id="projectType">
                                            <option value="1">非书籍</option>
                                            <option value="2">书籍</option>
                                        </select>
                                    </div>
                                </div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="customerName"> 客户名称<span class="red">*</span>： </label>
									<!--
									<div class="col-sm-7">
										<input type="text" id="customerName" placeholder="name" class="col-xs-10 col-sm-5" />
									</div>
									-->
                                    <div class="col-xs-10 col-sm-3">
                                        <select class="chosen-select col-xs-10 col-sm-5" id="customerName" data-placeholder="choosen" >
                                            <option>Ala</option>
                                            <option>人民邮电出版社</option>
                                            <option>Clc</option>
                                            <option>Dld</option>
                                        </select>
                                    </div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="languageFrom"> 语言： </label>
									<div class="col-sm-9">
										<select class="col-sm-1" id="languageFrom">
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
										<select style="margin-left: 15px;" class="col-sm-1" id="languageTo">
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
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="wordsCount"> 初译合计字数： </label>
									<div class="col-sm-7">
										<input type="text" id="wordsCount" placeholder="0" class="col-xs-10 col-sm-5" disabled="disabled"/>
									</div>
								</div>
								<div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="reviewWordsCount"> 审校合计字数： </label>
                                    <div class="col-sm-7">
                                        <input type="text" id="reviewWordsCount" placeholder="0" class="col-xs-10 col-sm-5" disabled="disabled"/>
                                    </div>
                                </div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="wordsNoSpace"> 不计空格字数： </label>
									<div class="col-sm-7">
										<input type="text" id="wordsNoSpace" placeholder="0" class="col-xs-10 col-sm-5" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="remarks"> 备注： </label>
									<div class="col-sm-7">
										<textarea id="remarks" style="overflow-y:visible;" class="autosize-transition form-control"></textarea>
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
					</div>
					<div class="row">
						<div class="col-xs-12" id="projectPartListTable" style="margin-top: 2%;display:none;">
                            <table id="simple-table" class="table table-striped table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th><a onclick="loadProjectPartWithOrder('part_name')">区块名称</a></th>
                                        <th><a onclick="loadProjectPartWithOrder('translator_id')">译员名字</a></th>
                                        <th>区块字数</th>
                                        <th>稿费</th>
										<th>与PM结算</th>
                                        <th>稿费结算</th>
										<th>操作</th>
                                    </tr>
                                </thead>
                                <tbody id="projectPartTbody">
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
	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/pagejs/project/add_project.js?v=1.7"></script>
</body>
</html>
