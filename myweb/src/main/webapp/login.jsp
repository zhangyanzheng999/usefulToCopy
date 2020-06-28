<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%pageContext.setAttribute("APP_PATH",request.getContextPath());%>
 <!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<script type="text/javascript" src="${APP_PATH}/static/js/jquery-3.4.1.min.js"></script> 
<link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${APP_PATH}/his/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui.admin/css/style.css" />
<link rel="stylesheet" href="${APP_PATH}/his/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>登陆界面</title>
</head>
<body>
<header class="navbar-wrapper">
	<div class="navbar navbar-fixed-top">
		<div class="container-fluid cl"> <a class="logo navbar-logo f-l mr-10 hidden-xs">东软云医院HIS系统</a>
			<span class="logo navbar-slogan f-l mr-10 hidden-xs">v1.0</span>
			<nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
			<ul class="cl">
				<li>登录界面</li>			
			</ul>
		</nav>
	</div>
</div>
</header>
<article class="page-container">
	<form   class="form form-horizontal" id="form-login">
		<div class="row cl">
		<label class="form-label col-xs-4 col-sm-4"></label>
			<label class="form-label col-xs-1 col-sm-1"><span class="c-red">*</span>用户名：</label>
			<div class="formControls col-xs-2 col-sm-2">
				<input type="text" class="input-text" value="" placeholder="请输入账号" id="username" name="username">
			</div>
		</div>
		<div class="row cl">
		<label class="form-label col-xs-4 col-sm-4"></label>
			<label class="form-label col-xs-1 col-sm-1"><span class="c-red">*</span>密码：</label>
			<div class="formControls col-xs-2 col-sm-2">
				<input type="password" class="input-text" value="" placeholder="请输入密码" id="passward" name="passward">
			</div>
		</div>	
		<div class="row cl">
		<label class="form-label col-xs-5 col-sm-5"></label>
			<div class="formControls col-xs-2 col-sm-2">
				<input class="btn btn-primary radius" type="button" value="&nbsp;&nbsp;登录&nbsp;&nbsp;"  id="login_btn">
			</div>
			<div >
				<input class="btn btn-primary radius" type="reset" value="&nbsp;&nbsp;清空&nbsp;&nbsp;">
			</div>			
		</div>
		</form>
</article>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${APP_PATH}/his/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${APP_PATH}/his/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/his/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<script type="text/javascript" src="${APP_PATH}/his/lib/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script> 
<script type="text/javascript">
$(function(){


	
});
$("#login_btn").click(function(){
	check_login();
});
function check_login(){
	var name=window.document.getElementById("username").value;
	var passward=window.document.getElementById("passward").value;
	 if (name == ""||passward ==""){
		window.alert("用户名或密码不能为空!");
		return false;
	}  
	$.ajax({
		url:"${APP_PATH}/checklogin",
		data:"username="+name+"&passward="+passward,
		type:"POST",
		dataType: "json",
		success:function(result){
			//console.log(result);
			if(result.code==100){
						window.alert("登陆成功");
						
						window.location.href="index.jsp?login_doctorid="+result.extend.doclist[0].userId+"&login_doctorname="+result.extend.doclist[0].userRealname;
						return true;
					}
			else{
				 window.alert("用户名或者密码错误");
				 return false; 
			}
					
		}
	});
	
	
		
} 

	
</script>	
</body>
</html>