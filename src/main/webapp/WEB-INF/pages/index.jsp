<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html lang="en-us">
	<%@ include file="includes/utils.jsp"%> 
	<body class=""> <!-- possible classes: minified, fixed-ribbon, fixed-header, fixed-width-->
		
		<!-- HEADER -->
		<header id="header">
				<div id="logo-group">
				
				<!-- PLACE YOUR LOGO HERE -->
				<span id="logo">
					<img src="img/logo.png" alt="SmartAdmin">
				</span>
				<!-- END LOGO PLACEHOLDER -->
				
				<!-- Note: The activity badge color changes when clicked and resets the number to 0 
					 Suggestion: You may want to set a flag when this happens to tick off all checked messages / notifications -->
				<span id="activity" class="activity-dropdown">
					<i class="fa fa-user"></i>
					<b class="badge">
						21
					</b>
				</span>
				
				<!-- AJAX-DROPDOWN : control this dropdown height, look and feel from the LESS variable file -->
				<div class="ajax-dropdown">
					
					<!-- the ID links are fetched via AJAX to the ajax container "ajax-notifications" -->
					<div class="btn-group btn-group-justified" data-toggle="buttons">
				        <label class="btn btn-default">
				          <input type="radio" name="activity" id="ajax/notify/mail.html"> Msgs (14)
				        </label>
				        <label class="btn btn-default">
				          <input type="radio" name="activity" id="ajax/notify/notifications.html"> notify (3)
				        </label>
				        <label class="btn btn-default">
				          <input type="radio" name="activity" id="ajax/notify/tasks.html"> Tasks (4)
				        </label>
				    </div>
					
					<!-- notification content -->
					<div class="ajax-notifications custom-scroll">
						
						<div class="alert alert-transparent">
							<h4>Click a button to show messages here</h4>
							This blank page message helps protect your privacy, or you can show the first message here automatically.
						</div>
						
						<i class="fa fa-lock fa-4x fa-border"></i>
						
					</div>
					<!-- end notification content -->
					
					<!-- footer: refresh area -->
					<span>
						Last updated on: 12/12/2013 9:43AM
						<button type="button" data-loading-text="<i class='fa fa-refresh fa-spin'></i> Loading..." class="btn btn-xs btn-default pull-right">
						  <i class="fa fa-refresh"></i>
						</button>
					</span>
					<!-- end footer -->
					
				</div>
				<!-- END AJAX-DROPDOWN -->
			</div>
			
			<!-- projects dropdown -->
			<div id="project-context">
				
				<span class="label">Projects:</span>
				<span id="project-selector" class="popover-trigger-element dropdown-toggle" data-toggle="dropdown">Recent projects <i class="fa fa-angle-down"></i></span>
				
				<!-- Suggestion: populate this list with fetch and push technique -->
				<ul class="dropdown-menu">
					<li>
						<a href="javascript:void(0);">Online e-merchant management system - attaching integration with the iOS</a>
					</li>
					<li>
						<a href="javascript:void(0);">Notes on pipeline upgradee</a>
					</li>
					<li>
						<a href="javascript:void(0);">Assesment Report for merchant account</a>
					</li>
					<li class="divider"></li>
					<li>
						<a href="javascript:void(0);"><i class="fa fa-power-off"></i> Clear</a>
					</li>
				</ul>
				<!-- end dropdown-menu-->
				
			</div>
			<!-- end projects dropdown -->
			
			<!-- pulled right: nav area -->
			<div class="pull-right">
				
				<!-- collapse menu button -->
				<div id="hide-menu" class="btn-header pull-right">
					<span>
						<a href="javascript:void(0);" title="Collapse Menu"><i class="fa fa-reorder"></i></a>
					</span>
				</div>
				<!-- end collapse menu -->
				
				<!-- logout button -->
				<div id="logout" class="btn-header transparent pull-right">
					<span>
						<a href="<c:url value="/j_spring_security_logout" />" title="Sign Out"><i class="fa fa-sign-out"></i></a>
					</span>
				</div>
				<!-- end logout button -->
			
				<!-- search mobile button (this is hidden till mobile view port) -->
				<div id="search-mobile" class="btn-header transparent pull-right">
					<span>
						<a href="javascript:void(0)" title="Search"><i class="fa fa-search"></i></a>
					</span>
				</div>
				<!-- end search mobile button -->
				
				<!-- input: search field -->	
				<form action="#ajax/search.html" class="header-search pull-right">
					<input type="text" placeholder="Find reports and more" id="search-fld">
					<button type="submit">
						<i class="fa fa-search"></i>
					</button>
					<a href="javascript:void(0);" id="cancel-search-js" title="Cancel Search"><i class="fa fa-times"></i></a>
				</form>	
				<!-- end input: search field -->					
				
				<!-- multiple lang dropdown : find all flags in the image folder -->	
				<ul class="header-dropdown-list hidden-xs">
					<li>
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							<img alt="" src="img/flags/us.png">
							<span>
								US
							</span>
							<i class="fa fa-angle-down"></i>
						</a>
						<ul class="dropdown-menu pull-right">
							<li class="active"><a href="javascript:void(0);"><img alt="" src="img/flags/us.png"> US</a></li>
							<li><a href="javascript:void(0);"><img alt="" src="img/flags/es.png"> Spanish</a></li>
							<li><a href="javascript:void(0);"><img alt="" src="img/flags/de.png"> German</a></li>
						</ul>
					</li>
				</ul>
				<!-- end multiple lang -->
				
			</div>
			<!-- end pulled right: nav area -->
			
		</header>
		<!-- END HEADER -->
		
		<!-- Left panel : Navigation area -->
		<!-- Note: This width of the aside area can be adjusted through LESS variables -->
		<aside id="left-panel">
			
			<!-- User info -->
			<div class="login-info">
				<span>
					<!-- User image size is adjusted inside CSS, it should stay as it --> 
					<img src="img/avatars/sunny.png" alt="me" class="online" />	
					<a href="javascript:void(0);" id="show-shortcut"> ${user.id} <i class="fa fa-angle-down"></i></a>
				</span>
			</div>
			<!-- end user info -->
			
			<!-- NAVIGATION : This navigation is also responsive 
				 
				 To make this navigation dynamic please make sure to link the node 
				 (the reference to the nav > ul) after page load. Or the navigation 
				 will not initialize.
			-->
			<nav>
				<!-- NOTE: Notice the gaps after each icon usage <i></i>.. 
					 Please note that these links work a bit different than
					 traditional hre="" links. See documentation for details.
					-->
				
				<ul>
					<li class=""><a href="" title="Dashboard"><i class="fa fa-lg fa-fw fa-home"></i>  <span class="menu-item-parent">管理首页</span></a></li>
					<li><a href="javascript:void(0);" ><i class="fa fa-lg fa-fw fa-user"></i>  <span class="menu-item-parent">我的企业</span></a>
						<ul>
							<li><a href="#" onclick="loadURL('/gm/cliente/', $('#content'));"><i class="fa fa-male"></i> Ajax测试</a></li>
							<li><a href=""><i class="fa fa-pencil-square-o"></i> 宝贤信息技术</a></li>
							<li><a href=""><i class="fa fa-tumblr"></i> 强生医疗器械销售</a></li>
						</ul>
					</li>
					<li><a href="javascript:void(0);" ><i class="fa fa-lg fa-fw fa-hdd"></i>  <span class="menu-item-parent">我的网站</span></a>
						<ul>
							<li><a href=""><i class="fa fa-pencil-square-o"></i> 宝贤中国</a></li>
							<li><a href=""><i class="fa fa-tumblr"></i> 强生中国</a></li>
						</ul>
					</li>
					<li><a href="javascript:void(0);" ><i class="fa fa-lg fa-fw fa-list-alt"></i>  <span class="menu-item-parent">我的群</span></a>
						<ul>
							<li><a href=""><i class="fa fa-pencil-square-o"></i> IT 群</a></li>
							<li><a href=""><i class="fa fa-tumblr"></i> 商务群</a></li>
						</ul>
					</li>
				</ul>
			</nav>
			<span class="minifyme">
				<i class="fa fa-arrow-circle-left hit"></i>
			</span>

		</aside>
		<!-- END NAVIGATION -->
		
		<!-- MAIN PANEL -->
		<div id="main" role="main">
			
			<!-- RIBBON -->
			<div id="ribbon">
				
				<span class="ribbon-button-alignment">
					<span id="refresh" class="btn btn-ribbon" data-title="refresh"  rel="tooltip" data-placement="bottom" data-original-title="<i class='text-warning fa fa-warning'></i> Warning! This will reset all your widget settings." data-html="true"><i class="fa fa-refresh"></i></span>
				</span>

				<!-- breadcrumb -->
				<ol class="breadcrumb">
					<!-- This is auto generated -->
				</ol>		
				<!-- end breadcrumb -->	
				
				<!-- You can also add more buttons to the 
					 ribbon for further usability 
					 
					 Example below: 
					 
				<span class="ribbon-button-alignment pull-right">
					<span id="search" class="btn btn-ribbon hidden-xs" data-title="search"><i class="fa-grid"></i> Change Grid</span>
					<span id="add" class="btn btn-ribbon hidden-xs" data-title="add"><i class="fa-plus"></i> Add</span>
					<span id="search" class="btn btn-ribbon" data-title="search"><i class="fa-search"></i> <span class="hidden-mobile">Search</span></span>
				</span> -->
				
			</div>
			<!-- END RIBBON -->
	
			<!-- MAIN CONTENT -->
			<div id="content">
			     <div id="button" align="center">
					<a href="javascript:void(0);" class="btn btn-default btn-lg" onclick="loadURL('/gm/enterprise/add1', $('#content'));"> <strong>登记企业</strong></a>
					<a href="javascript:void(0);" class="btn btn-default btn-lg" onclick="loadURL('/gm/enterprise/list2', $('#content'));"> <strong>企业列表</strong></a>
					<a href="javascript:void(0);" class="btn btn-default btn-lg" onclick="loadURL('/gm/enterpriseregister/add', $('#content'));"> <strong>登记企业注册信息</strong></a>
					<a href="javascript:void(0);" class="btn btn-default btn-lg" onclick="loadURL('/gm/enterpriseregister/list1', $('#content'));"> <strong>企业注册信息列表</strong></a>
					<a href="javascript:void(0);" class="btn btn-default btn-lg"> <strong>登记网站</strong></a>
					<a href="javascript:void(0);" class="btn btn-default btn-lg"> <strong>申请加入群</strong></a>
					<a href="javascript:void(0);" class="btn btn-default btn-lg" onclick="loadURL('/gm/enterprise/test', $('#content'));"> <strong>测试</strong></a>
				 </div>
				 
			</div>
			<!-- END MAIN CONTENT -->				
 	
		</div>
		<!-- END MAIN PANEL -->
		
		<!-- SHORTCUT AREA : With large tiles (activated via clicking user name tag)
			 Note: These tiles are completely responsive,
			 you can add as many as you like
			-->
		<div id="shortcut">
			<ul>
				<li>
					<a href="#ajax/inbox.html" class="jarvismetro-tile big-cubes bg-color-blue">
						<span class="iconbox">
							<i class="fa fa-envelope fa-4x"></i>
							<span>Mail <span class="label pull-right bg-color-darken">14</span></span>
						</span>
					</a>
				</li>
				<li>
					<a href="#ajax/calendar.html" class="jarvismetro-tile big-cubes bg-color-orangeDark">
						<span class="iconbox">
							<i class="fa fa-calendar fa-4x"></i>
							<span>Calendar</span>
						</span>
					</a>
				</li>
				<li>
					<a href="#ajax/gmap-xml.html" class="jarvismetro-tile big-cubes bg-color-purple">
						<span class="iconbox">
							<i class="fa fa-map-marker fa-4x"></i>
							<span>Maps</span>
						</span>
					</a>
				</li>
				<li>
					<a href="#ajax/invoice.html" class="jarvismetro-tile big-cubes bg-color-blueDark">
						<span class="iconbox">
							<i class="fa fa-book fa-4x"></i>
							<span>Invoice <span class="label pull-right bg-color-darken">99</span></span>
						</span>
					</a>
				</li>
				<li>
					<a href="#ajax/gallery.html" class="jarvismetro-tile big-cubes bg-color-greenLight">
						<span class="iconbox">
							<i class="fa fa-picture-o fa-4x"></i>
							<span>Gallery </span>
						</span>
					</a>
				</li>
				<li>
					<a href="javascript:void(0);" class="jarvismetro-tile big-cubes selected bg-color-pinkDark">
						<span class="iconbox">
							<i class="fa fa-user fa-4x"></i>
							<span>My Profile </span>
						</span>
					</a>
				</li>
			</ul>
		</div>
	</body>	
</html>