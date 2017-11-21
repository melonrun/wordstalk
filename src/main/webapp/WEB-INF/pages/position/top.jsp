<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
	<span class="sr-only">Toggle sidebar</span>

	<span class="icon-bar"></span>

	<span class="icon-bar"></span>

	<span class="icon-bar"></span>
</button>

<div class="navbar-header pull-left">
	<a href="#" class="navbar-brand"> <small> <i
			class="fa fa-pencil-square-o"></i> Words Talk 项目管理平台
	</small>
	</a>
</div>

<div class="navbar-buttons navbar-header pull-right">
	<ul class="nav ace-nav">
		<li class="light-blue"><a data-toggle="dropdown" href="#"
			class="dropdown-toggle" aria-expanded="false"> <img
				class="nav-user-photo" src="/wordstalk/assets/avatars/user.jpg"
				alt="Jason's Photo"> <span id="wordsTalkRole"></span> <i class="ace-icon fa fa-caret-down"></i>
		</a>

			<ul
				class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
				<li class="divider"></li>
				<li id="userLogoutLi"><a href="#"> <i
						class="ace-icon fa fa-power-off"></i> Logout
				</a></li>
			</ul></li>
	</ul>
</div>
