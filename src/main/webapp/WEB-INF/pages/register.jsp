<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html lang="en-us">
    <%@ include file="includes/utils.jsp"%> 
	<body id="login" class="animated fadeInDown">
		<!-- possible classes: minified, no-right-panel, fixed-ribbon, fixed-header, fixed-width-->
		<header id="header">

			<div id="logo-group">
				<span id="logo"> <img src="../img/logo.png" alt="SmartAdmin"> </span>

				<!-- END AJAX-DROPDOWN -->
			</div>

			<span id="login-header-space"> <h4 class="hidden-mobile"><spring:message code="s_has_account"/></h4> <a href='<c:url value="/"/>' class="btn btn-danger"><spring:message code="s_login"/></a> </span>

		</header>

		<div id="main" role="main">

			<!-- MAIN CONTENT -->
			<div id="content" class="container">

				<div class="row" >
					<div class="col-xs-12 col-sm-12 col-md-5 col-lg-4 centered">
						<div class="well no-padding">
							<c:url var="action" value="/register/add" />
					        <form:form id="reg_form" class="smart-form client-form"  action="${action}" method="post"  commandName="user"  modelAttribute="user">	
								<header>
									<spring:message code="s_reg_new"/>
								</header>
								<fieldset>
								   <section>
										<label class="label"><spring:message code="s_user"/></label>
										<label class="input"> <i class="icon-append fa fa-user"></i>
											<form:input name="j_username" type="text" class="form-control" path="name" ></form:input>
											<b class="tooltip tooltip-top-right"><i class="fa fa-user txt-color-teal"></i><spring:message code="s_in_user"/></b></label>
									</section>
									<section>
										<label class="label"><spring:message code="s_email"/></label>
										<label class="input"> <i class="icon-append fa fa-inbox"></i>
											<form:input name="j_email" type="email" class="form-control" path="email" ></form:input>
											<b class="tooltip tooltip-top-right"><i class="fa fa-user txt-color-teal"></i><spring:message code="s_in_email"/></b></label>
									</section>

									<section>
										<label class="label"><spring:message code="s_pwd"/></label>
										<label class="input"> <i class="icon-append fa fa-lock"></i>
											<form:input name="j_password" type="password" class="form-control" path="password" ></form:input>	
											<b class="tooltip tooltip-top-right"><i class="fa fa-lock txt-color-teal"></i><spring:message code="s_in_pwd"/></b> </label>
									</section>
									
									<section>
										<label class="label"><spring:message code="s_re_pwd"/></label>
										<label class="input"> <i class="icon-append fa fa-lock"></i>
											<input id="re_password" name="re_password" type="password" class="form-control"></input>	
											<b class="tooltip tooltip-top-right"><i class="fa fa-lock txt-color-teal"></i><spring:message code="s_in_repwd"/></b> </label>
									</section>
									
									<!--section>
										<label class="label">验证码</label>
										<label class="input"> <i class="icon-append fa fa-pencil"></i>
											<form:input name="j_name" type="text" class="form-control" path="name" ></form:input>	
											<b class="tooltip tooltip-top-right"><i class="fa fa-pencil txt-color-teal"></i>请输入企业名称</b> </label>
									</section-->

									<section>
										<label class="checkbox">
											<input type="checkbox" name="accept" checked="">
											<i></i><spring:message code="s_accept_terms"/></label>
									</section>
							</fieldset>
								<footer>
									<button type="submit" class="btn btn-primary">
										<spring:message code="s_register"/>
									</button>
								</footer>
							</form:form>

						</div>

					</div>
				</div>
			</div>

		</div>

		<script type="text/javascript">
			runAllForms();
			
			$(function() {
				// Validation
				$("#reg_form").validate({
					// Rules for form validation
					rules : {
						name : {
							required : true,
							remote: {
	                         url : 'checkUserName',
	                         type:'get',
	                         data: { name : function(){return $("#name").val();} }
	                        }
						},
						email : {
							required : true,
							email : true,
							remote: {
	                         url : 'checkEmail',
	                         type:'get',
	                         data: { email : function(){return $("#email").val();} }
	                        }
						},
						password : {
							required : true,
							rangelength:[6,20]
						},
						re_password : {
							required : true,
							rangelength:[6,20],
							equalTo:"#password" 
						},
						accept : {
							required : true
						}
					},

					// Messages for form validation
					messages : {
						name : {
							required : '请输入您的用户名',
							remote : '该用户名已被注册'
						},
						email : {
							required : '请输入您注册的邮箱',
							email : '请输入一个正确的邮箱地址',
							remote : '该邮箱已经被注册'
						},
						password : {
							required : '请输入您的密码',
							rangelength : $.format("{0}-{1}个字符，只能包含大小写，数字以及标点（空格除外）！")
						},
						re_password : {
							required : '请再次输入您的密码',
							rangelength : $.format("{0}-{1}个字符，只能包含大小写，数字以及标点（空格除外）！"),
							equalTo: '两次输入的密码不一样，请重新输入'
						},
						accept : {
							required : '请确认您已接受企业搜索群用户协议'
						}
					},

					// Do not change code below
					errorPlacement : function(error, element) {
						error.insertAfter(element.parent());
					}
					
				});
				
			});
			
		</script>

	</body>
</html>