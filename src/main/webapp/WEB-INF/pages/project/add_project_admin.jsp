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
						<li class="active">项目-管理员管理</li>
					</ul>
					<!-- /.breadcrumb -->

					<div class="nav-search" id="nav-search">
						<form class="form-search">
							 <span class="input-icon">
                                <button class="btn btn-inverse btn-xs btn-round" id="backProjectBtn" onclick="return false;">项目页面</button>
                            </span>
							<span class="input-icon">
								<button class="btn btn-inverse btn-xs btn-round" id="exportPartAdminBtn" onclick="return false;">导出数据</button>
							</span>
						</form>
					</div>
					<!-- /.nav-search -->
				</div>

				<div class="page-content">
					<div class="row">
					
						<div class="col-xs-12" style="margin-bottom: 5px;">
							<h3 class="row header smaller blue">
								<span class="col-sm-7" style="margin-left: 1%;">项目名称：<span id="projectName"></span>(管理员)</span>
							</h3>
						</div>
					
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							<form class="form-horizontal" role="form">
								<!--
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for=""> 初译合计字数(admin)： </label>
									<div class="col-sm-7">
										<input type="text" id="wordsCountReal" placeholder="0" class="col-xs-10 col-sm-5" value="0"/>
										<span class="col-xs-10 col-sm-5" style="font-size: 18px;">初译区块合计字数
											<span id="wordsCount" style="color:red;">0</span> </span>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for=""> 审校合计字数(admin)： </label>
									<div class="col-sm-7">
										<input type="text" id="reviewWordsCountReal" placeholder="0" class="col-xs-10 col-sm-5" value="0"/>
										<span class="col-xs-10 col-sm-5" style="font-size: 18px;">审计合计字数
											<span id="reviewWordsCount" style="color:red;">0</span> </span>
									</div>
								</div>
								-->
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for=""> 收费标准： </label>
									<div class="col-sm-7">
										<input type="text" id="chargeStd" placeholder="0" class="col-xs-10 col-sm-5" /><span class="col-xs-10 col-sm-5" style="font-size: 18px;">(千字)</span>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 项目收入<span class="red">*</span>： </label>
									<div class="col-sm-7">
										<input type="text" id="projectIncome" placeholder="0" class="col-xs-10 col-sm-5" value="0.00"/>
										<button class="btn btn-inverse btn-xs btn-round" id="getProjectIncomeBtn" onclick="return false;" style="margin-left:1%;">计算</button>
										<button class="btn btn-inverse btn-xs btn-round" id="getProjectIncomeDetailBtn" onclick="return false;">明细</button>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 译员稿费<span class="red">*</span>： </label>
									<div class="col-sm-7">
										<input type="text" id="tranCost" placeholder="0" class="col-xs-10 col-sm-5" value="0.00"/>
										<button class="btn btn-inverse btn-xs btn-round" id="getTranCostBtn" onclick="return false;" style="margin-left:1%;">计算</button>
										<button class="btn btn-inverse btn-xs btn-round" id="getTranCostDetailBtn" onclick="return false;">明细</button>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 审校稿费<span class="red">*</span>： </label>
									<div class="col-sm-7">
										<input type="text" id="reviewCost" placeholder="0" class="col-xs-10 col-sm-5" value="0.00"/>
										<button class="btn btn-inverse btn-xs btn-round" id="getReviewCostBtn" onclick="return false;" style="margin-left:1%;">计算</button>
										<button class="btn btn-inverse btn-xs btn-round" id="getReviewCostDetailBtn" onclick="return false;">明细</button>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 管理费<span class="red">*</span>： </label>
									<div class="col-sm-7">
										<input type="text" id="manageCost" placeholder="0" class="col-xs-10 col-sm-5" value="0.00"/>
										<button class="btn btn-inverse btn-xs btn-round" id="getManageCostBtn" onclick="return false;" style="margin-left:1%;">计算</button>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 销售提成： </label>
									<div class="col-sm-7">
										<input type="text" id="saleCommission" placeholder="0" class="col-xs-10 col-sm-5" value="0.00"/>
                                        <input type="text" id="saleCommissionPer" placeholder="0" class="col-xs-2 col-sm-1" value="1.00" style="margin-left:1%;"/>
                                        <span style="font-size: 20px;margin-top: 1%;">%</span>
                                        <button class="btn btn-inverse btn-xs btn-round" id="getSaleCommissionCostBtn" onclick="return false;">计算</button>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 税费： </label>
									<div class="col-sm-7">
										<input type="text" id="taxCost" placeholder="0" class="col-xs-10 col-sm-5" value="0.00"/>
										<button class="btn btn-inverse btn-xs btn-round" id="getTaxCostBtn" onclick="return false;" style="margin-left:1%;">计算</button>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 项目利润： </label>
									<div class="col-sm-7">
										<input type="text" id="projectProfit" placeholder="0" class="col-xs-10 col-sm-5" value="0.00"/>
										<button class="btn btn-inverse btn-xs btn-round" id="getProjectProfitBtn" onclick="return false;" style="margin-left:1%;">计算</button>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 利润率： </label>
									<div class="col-sm-7">
										<input type="text" id="profitRatio" placeholder="" class="col-xs-10 col-sm-5" value="0.00%"/>
										<button class="btn btn-inverse btn-xs btn-round" id="getProfitRatioBtn" onclick="return false;" style="margin-left:1%;">计算</button>
										<!--
											<button class="btn btn-inverse btn-xs btn-round" name="saveProjectAdminBtn" onclick="return false;">入库</button>
										-->
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 客户款到账： </label>
									<div class="col-sm-7">
										<select class="col-sm-2" id="accountStatus">
											<option value="-1">否</option>
											<option value="1">是</option>
										</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="pmCheckout"> 到账时间： </label>
									<div class="col-sm-7">
										<input type="text" id="endDate" placeholder="" class="col-xs-10 col-sm-5" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="">与PM结算</label>
									<div class="col-sm-7">
										<select class="col-sm-2" id="pmCheckout">
											<option value="-1">否</option>
											<option value="1">是</option>
										</select>
									</div>
								</div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="pmCheckoutDate"> 与PM结算时间： </label>
                                    <div class="col-sm-7">
                                        <input type="text" id="pmCheckoutDate" placeholder="" class="col-xs-10 col-sm-5" />
                                    </div>
                                </div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 备注： </label>
									<div class="col-sm-7">
										<textarea id="saleRecord" class="autosize-transition form-control"></textarea>
									</div>
								</div>

							</form>
						</div>
							<div class="col-xs-12">
							<div class="clearfix">
								<div class="col-md-offset-3 col-md-9">
									<button class="btn btn-inverse btn-round" type="button" name="saveProjectAdminBtn">
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
				</div>
				<!-- /.page-content -->

			</div>
		</div>
		<jsp:include page="../position/bottom.jsp"></jsp:include>
	</div>
	<jsp:include page="../position/inc.jsp"></jsp:include>
	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/js/pagejs/project/add_project_admin.js?v=1.7.1"></script>
</body>
</html>
