<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%pageContext.setAttribute("APP_PATH",request.getContextPath());%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="${APP_PATH}/static/js/jquery-3.4.1.min.js"></script> 
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script> 
<link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${APP_PATH}/his/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui.admin/css/style.css" />
<title>退号</title>
</head>
<body>
<article class="page-container">
	<form action="" method="post" class="form form-horizontal" id="back_register_form">
	<div class="row cl">
			<label class="form-label col-xs-1 col-sm-1">患者信息查询</label>		
		</div>
		<div class="row cl">
			<label class="form-label col-xs-1 col-sm-1"><span class="c-red">*</span>病历号：</label>
			<div class="formControls col-xs-2 col-sm-2">
				<input type="text" class="input-text" value="" placeholder="" id="medrecord_code" name="medrecord_code">
				<span class="c-red"></span>
			</div>
			<div class="formControls col-xs-2 col-sm-2">
				<input class="btn btn-primary radius" type="button" id="med_find" value="&nbsp;&nbsp;搜索&nbsp;&nbsp;">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-1 col-sm-1">患者信息确认</label>
			
		</div>
		<div class="row cl">
			<label class="form-label col-xs-1 col-sm-1">姓名：</label>
			<div class="formControls col-xs-2 col-sm-2">
				<input type="text" class="input-text" value="" placeholder="" id="patient_name" name="patient_name" readonly="readonly">
			</div>
			<label class="form-label col-xs-1 col-sm-1">身份证号：</label>
			<div class="formControls col-xs-2 col-sm-2">
				<input type="text" class="input-text" value="" placeholder="在此输入身份证号" id="patient_IDCard" name="patient_IDCard" readonly="readonly">
			</div>
			<label class="form-label col-xs-1 col-sm-1">家庭住址：</label>
			<div class="formControls col-xs-2 col-sm-2">
				<input type="text" class="input-text" value="" placeholder="在此输入家庭住址" id="patient_Address" name="patient_Address" readonly="readonly">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-1 col-sm-1" style="left:110px;">  患者挂号信息</label>
		</div>
		
			<div class="row cl">
				<div style="position:absolute; width:1100px; height:200px;z-index:1;left:130px;top:250px;">
					<table class="table table-border table-bg" id="reg-table">
						<thead>
							<tr>
								<th style="width:100px;">病历号</th>
								<th style="width:100px;">姓名</th>
								<th style="width:200px;">身份证号</th>
								<th style="width:200px;">挂号日期</th>
								<th style="width:150px;">挂号午别</th>
								<th style="width:150px;">看诊科室</th>
								<th style="width:100px;">看诊状态</th>
								<th style="width:100px;">操作</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
			</div>
				<!-- information of devide page -->
			<div class="row">
				<!-- 分页文字信息 -->
				<div class="col-md-6" style="top:240px;" id="page-info-area"></div>
				<!-- 分页条信息 -->
				<div class="col-md-6" style="top:240px;" id="page_nav_area"></div>
			</div>
</form>	
</article>








<!--_footer 作为公共模版分离出去-->
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">
var  regnum
var  patientName
var 	deptName//获取部门名字
var totalRecord, currentPage;//页码
//查找
$("#med_find").click(function(){
	var medrecord_code=window.document.getElementById("medrecord_code").value;
	$("#medrecord_code").next("span").empty();
	if(medrecord_code!=""){
	$.ajax({
		url:"${APP_PATH}/load_medrecord",
		type:"GET",
	//	async:false,
		data:{medrecord_code:medrecord_code},
		dataType: "json",
		success:function(result){
			//console.log(result);
			if(result.extend.reglist!=""){
					 var array=result.extend.reglist[0];//数组取第n个值的方法
					 regnum=array.registerId;//给regnum赋值，确保是最新挂号，取得正确挂号码
					 patientName=array.patientName;//给病人姓名赋值
					 paitentIDCard=array.patientIdcard;//身份证号赋值
				 	$("#med_code").val(medrecord_code);
				 	$("#patient_name").val(patientName);
					 $("#patient_IDCard").val( paitentIDCard);
					 $("#patient_Address").val(array.patientAddress);
					 load_reglist(1);
					 return true;
			 }else{
				 $("#reg-table tbody").empty();
				 $("#medrecord_code").next("span").text("病历号不存在！请重新输入");
				 $("#patient_name").val("");
				 $("#patient_IDCard").val("");
				 $("#patient_Address").val("");
				 return false;
			 }
		},
		error:function(result){
			console.log("失败了啊");
		}
	});	
	
	}else{
		 $("#reg-table tbody").empty();
		 $("#medrecord_code").next("span").text("请输入病历号！");
		 $("#med_code").val("");
		 $("#patient_name").val("");
		 $("#patient_IDCard").val("");
		 $("#patient_Address").val("");
		 return false;
	}
	
	
});


//加载项目
  function load_reglist(pageNumber){
	var medrecord_code=window.document.getElementById("medrecord_code").value;
	$.ajax({
		url:"${APP_PATH}/load_reglist",
		type:"GET",
		data:{medrecord_code:medrecord_code,pageNumber:pageNumber},
		 dataType: "json",
		success:function(result){
		if(result.extend.pageInfo.list!=""){	
			
		$("#reg-table tbody").empty();//先清空
			 $.each(result.extend.pageInfo.list,function(index,item){
				var mednum = $("<td></td>").append(medrecord_code);
				var patientname = $("<td></td>").append(patientName);
				var patientidcard = $("<td></td>").append(item.patientIdcard);
				var regdate = $("<td></td>").append(item.registerTime);
				var regnoon = $("<td></td>").append(item.noonBreak);
				 turntoDeptName(item.registerDeptId);
				var state=item.thisVisitState;
				if(state==1){
				 	state = $("<td></td>").append("已看诊");
				}else if(state==2){
					state = $("<td></td>").append("已退号");
				}else{
					state = $("<td></td>").append("已挂号");
				}
				state=state.attr("state",item.thisVisitState);
				var delBtn = $("<button></button>").addClass(
				"btn btn-danger btn-sm delete_btn").append(
				$("<span></span>")
				.addClass("glyphicon glyphicon-trash")).append(
				"退号");
			//为退号按钮添加属性表示id
			delBtn.attr({"type":"button"});//防止退号自动刷新界面
			delBtn.attr("reg_id", item.registerId);
				$("<tr></tr>").append(mednum).append(patientname).append(
						patientidcard).append(regdate).append(regnoon)
					.append(deptName).append(state).append(delBtn).appendTo("#reg-table tbody");
			}); 
			 	bulid_page_info(result);
				bulid_page_nav(result);
		}
		},
		error:function(result){
			console.log("失败");
		}
		
		
	});
	
} 
  function bulid_page_info(result) {
		$("#page-info-area").empty().append(
			"当前" + result.extend.pageInfo.pageNum + "页，总" +
			result.extend.pageInfo.pages + "页，共" +
			result.extend.pageInfo.total + "条记录");
		totalRecord = result.extend.pageInfo.total;
		//更新员工信息后，需返回显示当前页
		currentPage = result.extend.pageInfo.pageNum;
	}

	function bulid_page_nav(result) {
		//page_nav_area
		$("#page_nav_area").empty();
		var ul = $("<ul></ul>").addClass("pagination");

		//构建元素
		var firstPageLi = $("<li></li>").append(
			$("<a></a>").append("首页").attr("href", "#"));
		var prePageLi = $("<li></li>").append(
			$("<a></a>").append("&laquo;"));
		if (result.extend.pageInfo.hasPreviousPage == false) {
			firstPageLi.addClass("disabled");
			prePageLi.addClass("disabled");
		} else {
			//为元素添加翻页事件
			firstPageLi.click(function() {
				load_reglist(1);
			});
			prePageLi.click(function() {
				load_reglist(result.extend.pageInfo.pageNum - 1);
			});
		}

		var nextPageLi = $("<li></li>").append(
			$("<a></a>").append("&raquo;"));
		var lastPageLi = $("<li></li>").append(
			$("<a></a>").append("末页").attr("href", "#"));
		if (!result.extend.pageInfo.hasNextPage) {
			nextPageLi.addClass("disabled");
			lastPageLi.addClass("disabled");
		} else {
			nextPageLi.click(function() {
				load_reglist(result.extend.pageInfo.pageNum + 1);
			});
			lastPageLi.click(function() {
				load_reglist(result.extend.pageInfo.pages);
			});
		}

		//页码1，2，3，4
		ul.append(firstPageLi).append(prePageLi);
		$.each(result.extend.pageInfo.navigatepageNums, function(index,
			item) {
			var numLi = $("<li></li>").append($("<a></a>").append(item));
			if (result.extend.pageInfo.pageNum == item) {
				numLi.addClass("active");
			}
			numLi.click(function() {
				load_reglist(item);
			});
			ul.append(numLi);
		});
		ul.append(nextPageLi).append(lastPageLi);

		//把ul加入到nav
		var navEle = $("<nav></nav>").append(ul);
		navEle.appendTo("#page_nav_area");
	}



function turntoDeptName(deptID){
	$.ajax({
		url:"${APP_PATH}/turn_to_deptName",
		type:"GET",
		async:false,//进行异步处理
		data:"deptName="+deptID,
		 dataType: "json",
		 success:function(result){
				if(result.extend!=""){
					
					deptName = $("<td></td>").append(result.extend.dept.deptName);
					deptName=deptName.attr("dept_id",deptID);
					
				
					return true;
				}
				},
				error:function(result){
					console.log(result);
					console.log("失败");
				}
				
		 
	});
	
	
	
	
}


//退号
$(document).on("click", ".delete_btn", function() {
	var state = $(this).parents("tr").find("td:eq(6)").text() ;
	var registerId = $(this).attr("reg_id");
	if(state=="已挂号"){
		//发送ajax请求删除
		if (confirm("确认退号吗？")) {
		$.ajax({
			url: "${APP_PATH}/tuihao",
			type:"GET",
			async:false,//进行异步处理
			data:"reg_id="+ registerId,
			dataType: "json",
			success: function(result) {
				
				window.alert("退号成功!");
				load_reglist();
				return true;
			}
		});
		}
	}else{
		window.alert("已经看诊或退号的不能进行退号！");
		return false;
	}
	
});



</script> 
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>