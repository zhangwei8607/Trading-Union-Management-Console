<!-- Page's Owner: -->
<!-- 2015-07-23 17:10:37 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<meta charset="utf-8">

<div class="row">
	<div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
		<h1 class="page-title txt-color-blueDark">
			<i class="fa fa-hdd"></i> Add
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

					<c:url var="action" value="/enterpriseregister/add" />
					<form:form class="smart-form ng-pristine ng-valid" action="${action}" method="post"  commandName="enterpriseregister"  modelAttribute="enterpriseregister">
					<fieldset>
					<section>
								<label class="label"><spring:message code="s_gm_groupmng_enterpriseregister_Add_fullName"/></label>
								<label class="input"><form:input class="form-control" placeholder="全称" path="fullName" ></form:input></label>
					</section>
					<div class="row">
							<section class="col col-6">
								<label class="label"><spring:message code="s_gm_groupmng_enterpriseregister_Add_registerNo"/></label>
								<label class="input"><form:input class="form-control" placeholder="注册证号" path="registerNo" ></form:input></label>
							</section>
						    <section class="col col-6">
								<label class="label"><spring:message code="s_gm_groupmng_enterpriseregister_Add_taxNo"/></label>
								<label class="input"><form:input class="form-control" placeholder="税务登记号" path="taxNo" ></form:input></label>
							</section>
						</div>
						<div class="row">
							<section class="col col-6">
								<label class="label"><spring:message code="s_gm_groupmng_enterpriseregister_Add_openAccountNo"/></label>
								<label class="input"><form:input class="form-control" placeholder="开户许可证号" path="openAccountNo" ></form:input></label>
							</section>
					</div>
					<section>
								<label class="label"><spring:message code="s_gm_groupmng_enterpriseregister_Add_registerAddress"/></label>
								<label class="input"><form:input class="form-control" placeholder="注册地址" path="registerAddress" ></form:input></label>
					</section>
					<div class="row">
							<section class="col col-6">
								<label class="label"><spring:message code="s_gm_groupmng_enterpriseregister_Add_createDate"/></label>
								<label class="input"><form:input class="datepicker" size="20" path="createDate"></form:input></label>
							</section>
						    <section class="col col-6">
								<label class="label"><spring:message code="s_gm_groupmng_enterpriseregister_Add_failureDate"/></label>
								<label class="input"><form:input class="datepicker" size="20" path="failureDate"></form:input></label>
							</section>
						</div>
						<section>
								<label class="label"><spring:message code="s_gm_groupmng_enterpriseregister_Add_scope"/></label>
								<label class="input"><form:textarea class="form-control" placeholder="经营范围" path="scope" rows="4"></form:textarea></label>
					</section>
					<div class="row">
							<section class="col col-6">
								<label class="label"><spring:message code="s_gm_groupmng_enterpriseregister_Add_businessEntity"/></label>
								<label class="input"><form:input class="form-control" placeholder="法人" path="businessEntity" ></form:input></label>
							</section>
						    <section class="col col-6">
								<label class="label"><spring:message code="s_gm_groupmng_enterpriseregister_Add_entityIDNo"/></label>
								<label class="input"><form:input class="form-control" placeholder="法人证件号码" path="entityIDNo" ></form:input></label>
							</section>
						</div>
						<div class="row">
							<section class="col col-6">
								<label class="label"><spring:message code="s_gm_groupmng_enterpriseregister_Add_entityIDType"/></label>
								<label class="input">
									<form:select path="entityIDType" class="select2">
									<form:options items="${items}" itemValue="key.id" itemLabel="name" />
									</form:select>
								</label>
							</section>
					</div>
					<section>
								<label class="label"><spring:message code="s_gm_groupmng_enterpriseregister_Add_description"/></label>
								<label class="input"><form:textarea class="form-control" placeholder="企业描述" path="description" rows="4"></form:textarea></label>
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
	    $('#enterpriseregister').submit(function() {   
	        $.ajax( {
	          type : 'POST',
	          contentType : 'application/json',
	          url : '/gm/enterpriseregister/add',
	          data : JSON.stringify($('#enterpriseregister').serializeObject()),
	          dataType : 'json',
	          beforeSend : function(){
	          	
	          },
	          success : function(data) {
	            loadURL('/gm/enterpriseregister/list', $('#content'));
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
		$("#enterpriseregister").validate({
			// Rules for form validation
			rules : {
				fullName : {
					required : true
							},
				registerNo : {
					required : true
							},
				taxNo : {
					required : true
							},
				openAccountNo : {
					required : true
							},
				failureDate : {
					required : true
							},
				businessEntity : {
					required : true
							}
				},

			// Messages for form validation
			messages : {
				 fullName : {
					 required : '请输入企业全称'
					},
				 registerNo : {
					 required : '请输入注册证号'
					},
				 taxNo : {
					 required : '请输入税务登记号'
					},
				 openAccountNo : {
					 required : '请输入开户许可证号'
					},
				 failureDate : {
					 required : '请输入失效日期'
					},
				 businessEntity : {
					 required : '请输入法人姓名'
					}
		},

			// Do not change code below
			errorPlacement : function(error, element) {
				error.insertAfter(element.parent());
			}
		});
	});
	
</script>