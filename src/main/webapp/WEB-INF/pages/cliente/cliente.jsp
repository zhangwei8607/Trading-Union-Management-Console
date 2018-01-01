<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<meta charset="utf-8">

<div class="row">
	<div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
		<h1 class="page-title txt-color-blueDark">
			<i class="fa fa-hdd"></i> Cadastro <span>> Cliente</span>
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
					<!-- <c:url var="action" value="${pageContext.request.contextPath}/cliente/add" /> -->
					<c:url var="action" value="/cliente/add" />
					<form:form class="form-horizontal" action="${action}" method="post"  commandName="cliente"  modelAttribute="cliente">	
							<fieldset>
								<div class="form-group">
									<label class="col-md-2 control-label" for="text-field">Nome: </label>
									<div class="col-md-5">
										<form:input class="form-control" path="nome" ></form:input>	
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-2 control-label" for="textarea">Observações: </label>
									<div class="col-md-5">
										<textarea class="form-control" placeholder="Textarea" rows="4"></textarea>
									</div>
								</div>

							</fieldset>

							<div class="form-actions">
								<div class="row">
									<div class="col-md-12">
										<button class="btn btn-default" type="submit">Cancel
										</button>
										<button class="btn btn-primary" type="submit">
											<i class="fa fa-save"></i> Submit
										</button>
									</div>
								</div>
							</div>

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
	// PAGE RELATED SCRIPTS
</script>
