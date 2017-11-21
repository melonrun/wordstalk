<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div id="sidebar" class="sidebar responsive">
	<ul class="nav nav-list">
		<li class="active"><a href="#"> <i
				class="menu-icon fa fa-tachometer"></i> <span class="menu-text">
					Dashboard </span>
		</a> <b class="arrow"></b></li>

		<li class="open"><a href="#" class="dropdown-toggle"> <i
				class="menu-icon fa fa-list"></i> <span class="menu-text">
					管理中心 </span> <b class="arrow fa fa-angle-down"></b>
		</a> <b class="arrow"></b>

			<ul class="submenu">
				<li id="translatorLeft" style="display: none;"><a href="<%=request.getContextPath()%>/translator/translatorPage.htm"> <i
						class="menu-icon fa fa-caret-right"></i> 译员信息
				</a> <b class="arrow"></b></li>

				<li id="projectLeft" style="display: none;"><a href="<%=request.getContextPath()%>/project/projectPage.htm"> <i
						class="menu-icon fa fa-caret-right"></i> 项目信息
				</a> <b class="arrow"></b></li>
				<li id="customerLeft"><a href="<%=request.getContextPath()%>/customer/customerPage.htm"> <i
						class="menu-icon fa fa-caret-right"></i> 客户信息
				</a> <b class="arrow"></b></li>
				<li id="organizationLeft"><a href="<%=request.getContextPath()%>/organization/organizationPage.htm"> <i
						class="menu-icon fa fa-caret-right"></i> 机构信息
				</a> <b class="arrow"></b></li>
			</ul></li>

	</ul>
	<!-- /.nav-list -->

	<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
		<i class="ace-icon fa fa-angle-double-left"
			data-icon1="ace-icon fa fa-angle-double-left"
			data-icon2="ace-icon fa fa-angle-double-right"></i>
	</div>
	<script type="text/javascript">
				try {
					ace.settings.check('sidebar', 'collapsed')
				} catch (e) {
				}

			</script>
</div>