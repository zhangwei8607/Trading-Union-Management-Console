<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<meta charset="utf-8">

<div class="row">
	<div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
		<h1 class="page-title txt-color-blueDark">
			<i class="fa fa-hdd"></i> 登记 <span> 用户</span>
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
									<label class="col-md-2 control-label" for="text-field">姓名: </label>
									<div class="col-md-5">
										<form:input class="form-control" path="nome" ></form:input>	
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-2 control-label" for="text-field">上传图片: </label>
									<div class="col-md-5">
									    <div id="uploadImage" style="float:left;margin-right:20px;"></div>
									    <div style="float:left">
										  <div style="float:left"><input type="file" id="myBlogImage" class="btn btn-default" name="myfiles" /></div>
                                           <div style="margin-left:20px;float:left"><input type="button" class="btn btn-default" value="上传图片" onclick="ajaxFileUpload()"/></div>
									    </div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-2 control-label" for="text-field">日期: </label>
									<div class="col-md-5">
										<input class="datepicker" size="20"></input>	
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-2 control-label" for="select">企业状态: </label>
									<div class="col-md-5">
										<form:select path="nome" name="compStatus" class="select2">
										<form:options items="${items}" itemValue="key.id" itemLabel="name" />
										</form:select>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-md-2 control-label" for="textarea">描述: </label>
									<div class="col-md-5">
										<textarea class="form-control" placeholder="Textarea" rows="4"></textarea>
									</div>
								</div>

							</fieldset>

							<div class="form-actions">
								<div class="row">
									<div class="col-md-12">
										<button class="btn btn-default" type="submit">取消
										</button>
										<button class="btn btn-primary" type="submit">
											<i class="fa fa-save"></i> 提交
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
	$(document).ready(function() {   

	    // 绑定FORM提交事件  
	    $('#cliente').submit(function() {   
	        $.ajax( {
	          type : 'POST',
	          contentType : 'application/json',
	          url : '/gm/cliente/add',
	          data : JSON.stringify($('#cliente').serializeObject()),
	          dataType : 'json',
	          success : function(data) {
	            loadURL('/gm/cliente/', $('#content'));
	          },
	          error : function(data) {
	            alert("error")
	          }
	        });
	        return false;   
	    });   
	}); 
	
	function ajaxFileUpload(){
    //开始上传文件时显示一个图片,文件上传完成将图片隐藏
    //$("#loading").ajaxStart(function(){$(this).show();}).ajaxComplete(function(){$(this).hide();});
    //执行上传文件操作的函数
    $.ajaxFileUpload({
        //处理文件上传操作的服务器端地址(可以传参数,已亲测可用)
        url:'/gm/fileUpload',
        secureuri:false,
        fileElementId:'myBlogImage', 
        dataType:'text', 
        success:function(data, status){  
            
            console.log(data);
            data = data.replace('<pre style="word-wrap: break-word; white-space: pre-wrap;">', '');
            data = data.replace('<pre>','');
            data = data.replace('</pre>', '');
            if(status=="success"){     //0表示上传成功(后跟上传后的文件路径),1表示失败(后跟失败描述)
                $("#uploadImage").html("<img class=\"upload-img\" src=\"" + data + "\" />");
            }else{
                $('#result').html('图片上传失败，请重试！！');
            }
        },
        error:function(data, status, e){ 
            $('#result').html('图片上传失败，请重试！！');
        }
    });
  }
</script>
