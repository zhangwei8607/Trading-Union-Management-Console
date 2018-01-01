<!-- Page's Owner: -->
<!-- 2015-07-23 17:10:38 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<meta charset="utf-8">

<div class="row">
	<div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
		<h1 class="page-title txt-color-blueDark">
			<i class="fa fa-hdd"></i>List
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
					<!-- List -->
					<div class="widget-body no-padding">
					<c:url var="action" value="/enterpriseregister/list1" />
					<form:form class="smart-form ng-pristine ng-valid"  action="${action}" method="post"  commandName="enterpriseregisterquery"  modelAttribute="enterpriseregisterquery">
						<fieldset>
						<div class="row">
							<section class="col col-6">
								<label class="label"><spring:message code="s_gm_groupmng_enterpriseregister_List1_businessEntity"/></label>
								<label class="input"><form:input class="form-control" placeholder="法人" path="businessEntity" ></form:input></label>
							</section>
							<section class="col col-6">
								<label class="label"><spring:message code="s_gm_groupmng_enterpriseregister_List1_fullName"/></label>
								<label class="input"><form:input class="form-control" placeholder="全称" path="fullName" ></form:input></label>
							</section>
				</div>
							<div class="row">
							<section class="col col-6">
								<label class="label"><spring:message code="s_gm_groupmng_enterpriseregister_List1_registerNo"/></label>
								<label class="input"><form:input class="form-control" placeholder="注册证号" path="registerNo" ></form:input></label>
							</section>
							<section class="col col-6">
								<label class="label"><spring:message code="s_gm_groupmng_enterpriseregister_List1_taxNo"/></label>
								<label class="input"><form:input class="form-control" placeholder="税务登记号" path="taxNo" ></form:input></label>
							</section>
				</div>
							<div class="row">
							<section class="col col-6">
								<label class="label"><spring:message code="s_gm_groupmng_enterpriseregister_List1_openAccountNo"/></label>
								<label class="input"><form:input class="form-control" placeholder="开户许可证号" path="openAccountNo" ></form:input></label>
							</section>
							<section class="col col-6">
								<label class="label"><spring:message code="s_gm_groupmng_enterpriseregister_List1_createDateStart"/></label>
								<label class="input"><input class="datepicker" size="20" path="createDateStart"></input></label>
							</section>
				</div>
							<div class="row">
							<section class="col col-6">
								<label class="label"><spring:message code="s_gm_groupmng_enterpriseregister_List1_createDateEnd"/></label>
								<label class="input"><input class="datepicker" size="20" path="createDateEnd"></input></label>
							</section>
							<section class="col col-6">
								<label class="label"><spring:message code="s_gm_groupmng_enterpriseregister_List1_failureDateStart"/></label>
								<label class="input"><input class="datepicker" size="20" path="failureDateStart"></input></label>
							</section>
				</div>
							<div class="row">
							<section class="col col-6">
								<label class="label"><spring:message code="s_gm_groupmng_enterpriseregister_List1_failureDateEnd"/></label>
								<label class="input"><input class="datepicker" size="20" path="failureDateEnd"></input></label>
							</section>
						</fieldset>
						<footer>
				                <button type="submit" class="btn btn-primary" ><spring:message code="s_btn_query" /></button>
				        </footer>
					</form:form>
					<!-- List -->
					<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>创建日期</th>
							<th>失效日期</th>
							<th>开户许可证号</th>
							<th>法人</th>
							<th>税务登记号</th>
							<th>全称</th>
							<th>注册证号</th>
						</tr>
					</thead>
					<tbody id="ajaxLoad">
					<c:forEach items="${enterpriseregisters }" var="_enterpriseregister">
						<tr>
							<td><fmt:formatDate value="${_enterpriseregister.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td>${_enterpriseregister.failureDate}</td>
							<td>${_enterpriseregister.openAccountNo}</td>
							<td>${_enterpriseregister.businessEntity}</td>
							<td>${_enterpriseregister.taxNo}</td>
							<td>${_enterpriseregister.fullName}</td>
							<td>${_enterpriseregister.registerNo}</td>
						</tr>
					</c:forEach>
					</tbody>
					</table>
					</div>
					<!-- End List -->
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
	    $('#enterpriseregisterquery').submit(function() {   
	    	$.ajax( {
				type : 'POST',
						contentType : 'application/json',
						url : '/gm/enterpriseregister/list1',
						data : JSON.stringify($('#enterpriseregisterquery').serializeObject()),
						dataType : 'json',
						success : function(data) {
							var temp="";
	    				   $.each(data.data, function(i, item) {
								temp += "<tr>"
														temp += "<td>" + (new Date(item.createDate)).pattern('yyyy-MM-dd hh:mm:ss') + "</td>";
									temp += "<td>" + (new Date(item.failureDate)).pattern('yyyy-MM-dd hh:mm:ss') + "</td>";
									temp += "<td>" + item.openAccountNo + "</td>";
									temp += "<td>" + item.businessEntity + "</td>";
									temp += "<td>" + item.taxNo + "</td>";
									temp += "<td>" + item.fullName + "</td>";
									temp += "<td>" + item.registerNo + "</td>";
									temp += "</tr>";
						   });
						   $("#ajaxLoad").html(temp);
						},
						error : function(data) {
	          			 console.log(data);
						}
					  });
	        return false;   
		});
	});
</script>