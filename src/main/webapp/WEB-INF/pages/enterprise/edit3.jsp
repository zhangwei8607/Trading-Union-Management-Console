<!-- Page's Owner: -->
<!-- 2015-07-23 17:10:36 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<meta charset="utf-8">

<div class="row">
	<div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
		<h1 class="page-title txt-color-blueDark">
			<i class="fa fa-hdd"></i> Edit
		</h1>
	</div>
</div>
<!-- widget grid -->
<section id="widget-grid" class="">

	<div class="row">

		<!-- NEW COL START -->
		<article class="col-sm-12 col-md-12 col-lg-12">

			<!-- Widget ID (each widget will need unique ID)-->
			<div class="jarviswidget" id="wid-id-0" data-widget-colorbutton="false" data-widget-editbutton="false" data-widget-custombutton="false">
				
				<header>
					<span class="widget-icon"> <i class="fa fa-edit"></i>
					</span>
					<h2>Form Grid</h2>

				</header>

				<!-- widget div-->
				<div>

					<!-- widget edit box -->
					<div class="jarviswidget-editbox">
						<!-- This area used as dropdown edit box -->

					</div>
					<!-- end widget edit box -->

					<!-- widget content -->
					<div class="widget-body">

					<c:url var="action" value="/enterprise/edit3" />
					<form:form class="smart-form ng-pristine ng-valid" action="${action}" method="post"  commandName="enterprise"  modelAttribute="enterprise">
					<fieldset>
					<section>
								<label class="label"><spring:message code="s_gm_groupmng_enterprise_Edit3_name"/></label>
								<label class="input"><form:input class="form-control" placeholder="企业简称" path="name" ></form:input></label>
					</section>
					<div class="row">
							<section class="col col-6">
								<label class="label"><spring:message code="s_gm_groupmng_enterprise_Edit3_country"/></label>
								<label class="input"><form:input class="form-control" placeholder="国别" path="country" ></form:input></label>
							</section>
						    <section class="col col-6">
								<label class="label"><spring:message code="s_gm_groupmng_enterprise_Edit3_province"/></label>
								<label class="input"><form:input class="form-control" placeholder="省份" path="province" ></form:input></label>
							</section>
						</div>
						<div class="row">
							<section class="col col-6">
								<label class="label"><spring:message code="s_gm_groupmng_enterprise_Edit3_city"/></label>
								<label class="input"><form:input class="form-control" placeholder="城市" path="city" ></form:input></label>
							</section>
					</div>
					<section>
								<label class="label"><spring:message code="s_gm_groupmng_enterprise_Edit3_address"/></label>
								<label class="input"><form:input class="form-control" placeholder="详细地址" path="address" ></form:input></label>
					</section>
					<div class="row">
							<section class="col col-6">
								<label class="label"><spring:message code="s_gm_groupmng_enterprise_Edit3_contactUser"/></label>
								<label class="input"><form:input class="form-control" placeholder="联系人" path="contactUser" ></form:input></label>
							</section>
						    <section class="col col-6">
								<label class="label"><spring:message code="s_gm_groupmng_enterprise_Edit3_phone"/></label>
								<label class="input"><form:input class="form-control" placeholder="电话" path="phone" ></form:input></label>
							</section>
						</div>
						<div class="row">
							<section class="col col-6">
								<label class="label"><spring:message code="s_gm_groupmng_enterprise_Edit3_mobile"/></label>
								<label class="input"><form:input class="form-control" placeholder="手机" path="mobile" ></form:input></label>
							</section>
						    <section class="col col-6">
								<label class="label"><spring:message code="s_gm_groupmng_enterprise_Edit3_fax"/></label>
								<label class="input"><form:input class="form-control" placeholder="传真" path="fax" ></form:input></label>
							</section>
						</div>
						<div class="row">
							<section class="col col-6">
								<label class="label"><spring:message code="s_gm_groupmng_enterprise_Edit3_email"/></label>
								<label class="input"><form:input class="form-control" placeholder="邮箱" path="email" ></form:input></label>
							</section>
						    <section class="col col-6">
								<label class="label"><spring:message code="s_gm_groupmng_enterprise_Edit3_zipCode"/></label>
								<label class="input"><form:input class="form-control" placeholder="邮编" path="zipCode" ></form:input></label>
							</section>
						</div>
						<section>
								<label class="label"><spring:message code="s_gm_groupmng_enterprise_Edit3_description"/></label>
								<label class="input"><form:textarea class="form-control" placeholder="描述" path="description" rows="4"></form:textarea></label>
					</section>
					</fieldset>
					<footer>
				                <button type="submit" class="btn btn-primary"><spring:message code='s_btn_submit'/></button>
				                <button type="button" class="btn btn-default" onclick="window.history.back();"><spring:message code='s_btn_cancel'/></button>
				    </footer>
				  </form:form> 
				  </div>
					<!-- end widget content -->

				</div>

			</div>
			<!-- end widget -->

		</article>
		<!-- END COL -->

	</div>

	<!-- END ROW -->

	<!-- START ROW -->
</section>

<!-- SCRIPTS ON PAGE EVENT -->
<script type="text/javascript">
	// DO NOT REMOVE : GLOBAL FUNCTIONS!
	pageSetUp();

	$(document).ready(function() {   

	    // 绑定FORM提交事件  
	    $('#enterprise').submit(function() {   
	        $.ajax( {
	          type : 'POST',
	          contentType : 'application/json',
	          url : '/gm/enterprise/edit3',
	          data : JSON.stringify($('#enterprise').serializeObject()),
	          dataType : 'json',
	          success : function(data) {
	            loadURL('/gm/enterprise/list', $('#content'));
	          },
	          error : function(data) {
	           console.log(data);
	          }
	        });
	        return false;   
	    });   
	});
	
	$(function() {
		// Validation
		$("#enterprise").validate({
			// Rules for form validation
			rules : {
				name : {
					required : true
							},
				country : {
					required : true
							},
				province : {
					required : true
							},
				city : {
					required : true
							},
				address : {
					required : true
							},
				contactUser : {
					required : true
							},
				phone : {
					required : true
							},
				email : {
					required : true
							},
				description : {
					rangelength : [20,2000],required : true
							}
				},

			// Messages for form validation
			messages : {
				 name : {
					 required : '请输入企业简称'
					},
				 country : {
					 required : '请选择国别'
					},
				 province : {
					 required : '请选择省份或直辖市'
					},
				 city : {
					 required : '请选择城市'
					},
				 address : {
					 required : '请输入详细地址'
					},
				 contactUser : {
					 required : '请输入联系人'
					},
				 phone : {
					 required : '请输入联系电话'
					},
				 email : {
					 required : '请输入Email'
					},
				 description : {
					 rangelength : $.format("20-2000个字符！"),required : '请输入企业描述'
					}
		},

			// Do not change code below
			errorPlacement : function(error, element) {
				error.insertAfter(element.parent());
			}
		});
	});
	
</script>