<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html lang="en-us">

    <%@ include file="includes/utils.jsp"%> 
	<body id="login" class="animated fadeInDown">
		<!-- possible classes: minified, no-right-panel, fixed-ribbon, fixed-header, fixed-width-->
		<header id="header">
			<!--<span id="logo"></span>-->

			<div id="logo-group">
				<span id="logo"> <img src="img/logo.png" alt="SmartAdmin"> </span>

				<!-- END AJAX-DROPDOWN -->
			</div>

			<span id="login-header-space"> <h4 class="hidden-mobile"><spring:message code="s_need_new"></spring:message></h4> <a href='<c:url value="/register/"/>' class="btn btn-danger"><spring:message code="s_register"></spring:message></a> </span>

		</header>

		<div id="main" role="main">

			<!-- MAIN CONTENT -->
			<div id="content" class="container">
				<div class="row" >
					<div class="col-xs-12 col-sm-12 col-md-5 col-lg-4 centered">
						<div class="well no-padding">
							<form name='f' action="<c:url value='j_spring_security_check' />" id="login-form" class="smart-form client-form" method='POST'>
								<header>
									 <spring:message code="s_login"></spring:message>
								</header>
								<c:if test="${not empty error}">
									<div class="alert alert-danger fade in">
										<button class="close" data-dismiss="alert">×</button>
										<i class="fa-fw fa fa-times"></i><strong>错误</strong>
											${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
									</div>
								</c:if>
								<fieldset>
									
									<section>
										<label class="label"><spring:message code="s_email"></spring:message></label>
										<label class="input"> <i class="icon-append fa fa-user"></i>
											<!-- <input type="email" name='j_username'> -->
											<input type="email" name="j_username" >
											<b class="tooltip tooltip-top-right"><i class="fa fa-user txt-color-teal"></i> <spring:message code="s_in_email"></spring:message></b></label>
									</section>

									<section>
										<label class="label"><spring:message code="s_pwd"></spring:message></label>
										<label class="input"> <i class="icon-append fa fa-lock"></i>
											<input type="password" name="j_password" >
											<b class="tooltip tooltip-top-right"><i class="fa fa-lock txt-color-teal"></i> <spring:message code="s_in_pwd"></spring:message></b> </label>
										<div class="note">
											<a href="javascript:void(0)"><spring:message code="s_forgot_pwd"></spring:message></a>
										</div>
									</section>

									<section>
										<label class="checkbox">
											<input type="checkbox" name="remember" checked="">
											<i></i><spring:message code="s_remain_login"></spring:message></label>
									</section>
								</fieldset>
								<footer>
									<button type="submit" class="btn btn-primary">
										<spring:message code="s_login"></spring:message>
									</button>
								</footer>
							</form>

						</div>
						
					</div>
				</div>
			</div>

		</div>

		<script type="text/javascript">
			runAllForms();

			$(function() {
				// Validation
				$("#login-form").validate({
					// Rules for form validation
					rules : {
						j_username : {
							required : true,
							//email : true
						},
						j_password : {
							required : true,
							minlength : 3,
							maxlength : 20
						}
					},

					// Messages for form validation
					messages : {
						j_username : {
							required : '请输入您注册的邮箱',
							email : '请输入一个正确的邮箱地址'
						},
						j_password : {
							required : '请输入您的密码'
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