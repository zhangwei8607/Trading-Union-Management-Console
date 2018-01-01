<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<meta charset="utf-8">
<div class="row">
	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
		<h1 class="page-title txt-color-blueDark">
			<i class="fa fa-hdd"></i> 列表 <span>> 客户</span>
			<a class="btn btn-primary btn-lg pull-right" href="#" onclick="loadURL('/gm/cliente/novo', $('#content'));"> 新增</a>
		</h1>
		
	</div>
			
</div>
<c:if test="${not empty msgSucesso}">
<div class="alert alert-success fade in">
				<button class="close" data-dismiss="alert">
					×
				</button>
				<i class="fa-fw fa fa-check"></i>
				<strong>Success</strong> ${msgSucesso }
</div>
</c:if>
<!-- widget grid -->
<section id="widget-grid" class="">

	<div class="row">

		<!-- NEW COL START -->
		<article class="col-sm-12 col-md-12 col-lg-12">
					
			<div class="jarviswidget jarviswidget-color-darken" id="wid-id-1" data-widget-editbutton="false">
				<!-- widget options:
				usage: <div class="jarviswidget" id="wid-id-0" data-widget-editbutton="false">

				data-widget-colorbutton="false"
				data-widget-editbutton="false"
				data-widget-togglebutton="false"
				data-widget-deletebutton="false"
				data-widget-fullscreenbutton="false"
				data-widget-custombutton="false"
				data-widget-collapsed="true"
				data-widget-sortable="false"

				-->
				
				<header>
					<span class="widget-icon"> <i class="fa fa-table"></i> </span>
					<h2>No Padding</h2>
				</header>

				<!-- widget div-->
				<div>

					<!-- widget edit box -->
					<div class="jarviswidget-editbox">
						<!-- This area used as dropdown edit box -->

					</div>
					<!-- end widget edit box -->

					<!-- widget content -->
					<div class="widget-body no-padding">
						
						<table class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>序列</th>
									<th>名称</th>
									<th>列名</th>
									<th>列名</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${clientes}" var="cliente">
								<tr>
									<td>${cliente.id }</td>
									<td>${cliente.nome }</td>
									<td>Row 3</td>
									<td>Row 4</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>

					</div>
					<!-- end widget content -->

				</div>
				<!-- end widget div -->

			</div>

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
	// PAGE RELATED SCRIPTS
</script>