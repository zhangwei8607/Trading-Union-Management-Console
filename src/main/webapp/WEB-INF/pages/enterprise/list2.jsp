<!-- Page's Owner: -->
<!-- 2015-07-23 17:10:37 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
					<c:url var="action" value="/enterprise/list2" />
					<form:form class="smart-form ng-pristine ng-valid"  action="${action}" method="post"  commandName="enterprisequery"  modelAttribute="enterprisequery">
						<fieldset>
						<div class="row">
							<section class="col col-6">
								<label class="label"><spring:message code="s_gm_groupmng_enterprise_List2_name"/></label>
								<label class="input"><form:input class="form-control" placeholder="企业简称" path="name" ></form:input></label>
							</section>
							<section class="col col-6">
								<label class="label"><spring:message code="s_gm_groupmng_enterprise_List2_country"/></label>
								<label class="input"><form:input class="form-control" placeholder="国别" path="country" ></form:input></label>
							</section>
				</div>
							<div class="row">
							<section class="col col-6">
								<label class="label"><spring:message code="s_gm_groupmng_enterprise_List2_province"/></label>
								<label class="input"><form:input class="form-control" placeholder="省份" path="province" ></form:input></label>
							</section>
							<section class="col col-6">
								<label class="label"><spring:message code="s_gm_groupmng_enterprise_List2_city"/></label>
								<label class="input"><form:input class="form-control" placeholder="城市" path="city" ></form:input></label>
							</section>
				</div>
							<div class="row">
							<section class="col col-6">
								<label class="label"><spring:message code="s_gm_groupmng_enterprise_List2_contactUser"/></label>
								<label class="input"><form:input class="form-control" placeholder="联系人" path="contactUser" ></form:input></label>
							</section>
							<section class="col col-6">
								<label class="label"><spring:message code="s_gm_groupmng_enterprise_List2_email"/></label>
								<label class="input"><form:input class="form-control" placeholder="邮箱" path="email" ></form:input></label>
							</section>
				</div>
							<div class="row">
							<section class="col col-6">
								<label class="label"><spring:message code="s_gm_groupmng_enterprise_List2_zipCode"/></label>
								<label class="input"><form:input class="form-control" placeholder="邮编" path="zipCode" ></form:input></label>
							</section>
							<section class="col col-6">
								<label class="label"><spring:message code="s_gm_groupmng_enterprise_List2_regDateStart"/></label>
								<label class="input"><input class="datepicker" size="20" path="regDateStart"></input></label>
							</section>
				</div>
							<div class="row">
							<section class="col col-6">
								<label class="label"><spring:message code="s_gm_groupmng_enterprise_List2_regDateEnd"/></label>
								<label class="input"><input class="datepicker" size="20" path="regDateEnd"></input></label>
							</section>
							<section class="col col-6">
								<label class="label"><spring:message code="s_gm_groupmng_enterprise_List2_status"/></label>
								<label class="input">
									<form:select path="status" class="select2">
									<form:options items="${items}" itemValue="key.id" itemLabel="name" />
									</form:select>
								</label>
							</section>
				</div>
							</fieldset>
						<footer>
				                <button type="submit" class="btn btn-primary" ><spring:message code="s_btn_query" /></button>
				        </footer>
					</form:form>
					<!-- List -->
					<table class="table table-bordered table-striped">
					<thead>
						<tr>
							<th>主键</th>
							<th>企业简称</th>
							<th>国别</th>
							<th>联系人</th>
							<th>电话</th>
							<th>手机</th>
							<th>邮箱</th>
							<th>登记日期</th>
							<th>企业状态</th>
						</tr>
					</thead>
					<tbody id="ajaxLoad">
					<c:forEach items="${enterprises }" var="_enterprise">
						<tr>
							<td>${_enterprise.id}</td>
							<td>${_enterprise.name}</td>
							<td>${_enterprise.country}</td>
							<td>${_enterprise.contactUser}</td>
							<td>${_enterprise.phone}</td>
							<td>${_enterprise.mobile}</td>
							<td>${_enterprise.email}</td>
							<td>${_enterprise.regDate}</td>
							<td>${_enterprise.status}</td>
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
	    $('#enterprisequery').submit(function() {   
	    	$.ajax( {
				type : 'POST',
						contentType : 'application/json',
						url : '/gm/enterprise/list2',
						data : JSON.stringify($('#enterprisequery').serializeObject()),
						dataType : 'json',
						success : function(data) {
							var temp="";
	    				   $.each(data.data, function(i, item) {
								temp += "<tr>"
														temp += "<td>" + item.id + "</td>";
									temp += "<td>" + item.name + "</td>";
									temp += "<td>" + item.country + "</td>";
									temp += "<td>" + item.contactUser + "</td>";
									temp += "<td>" + item.phone + "</td>";
									temp += "<td>" + item.mobile + "</td>";
									temp += "<td>" + item.email + "</td>";
									var strDate = new Date(item.regDate);
temp += "<td>" + strDate.format("yyyy-MM-dd hh:mm:ss") + "</td>";
									temp += "<td>" + item.status + "</td>";
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