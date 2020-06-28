<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%pageContext.setAttribute("APP_PATH",request.getContextPath());%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
<script type="text/javascript" src="${APP_PATH}/static/js/jquery-3.4.1.min.js"></script> 
<link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${APP_PATH}/his/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>现场挂号</title>
<meta name="keywords" content="">
<meta name="description" content="">
</head>
<body>
<article class="page-container">
	<form class="form form-horizontal" id="form-member-add">
		<div class="row cl">
			<label class="form-label col-xs-1 col-sm-1"><span class="c-red">*</span>发票号：</label>
			<div class="formControls col-xs-2 col-sm-2">
				<input type="text" class="input-text" value="" placeholder="" id="bill_code" name="bill_code" readonly="readonly">				
			</div>
			<div class="formControls col-xs-2 col-sm-2">
				<button class="btn btn-primary radius" type="submit" id="btn_guahao" value="">&nbsp;&nbsp;挂号&nbsp;&nbsp;</button>
			</div>
			<div class="formControls col-xs-2 col-sm-2">
				<button class="btn btn-primary radius" type="reset" value="" id="qingkong">&nbsp;&nbsp;清空&nbsp;&nbsp;</button>
			</div>		
			<label class="form-label col-xs-5 col-sm-5"></label>	
		</div>			
		<div class="row cl">
			<label class="form-label col-xs-1 col-sm-1">挂号信息</label>
			<label class="form-label col-xs-11 col-sm-11"></label>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-1 col-sm-1"><span class="c-red">*</span>病历号：</label>
			<div class="formControls col-xs-2 col-sm-2">
				<input type="text" class="input-text" value="" placeholder="" id="medrecord_code" name="medrecord_code">
				<span class="c-red"></span>
			</div>
			<label class="form-label col-xs-1 col-sm-1"><span class="c-red">*</span>姓名：</label>
			<div class="formControls col-xs-2 col-sm-2">
				<input type="text" class="input-text" value="" placeholder="" id="patient_name" name="patient_name">
			</div>
			<label class="col-xs-1 col-sm-1"><span class="c-red">*</span>性别：</label>
			<div class="formControls col-xs-1 col-sm-1">
				<span class="select-box"><select class="select" name="sex" id="sex">
					<option value="71">男</option>
					<option value="72">女</option>
				</select></span>
			</div>
			<label class="form-label col-xs-1 col-sm-1"><span class="c-red">*</span>年龄：</label>
			<div class="formControls col-xs-1 col-sm-1">
				<input type="text" class="input-text" value="" placeholder="" id="patient_age" name="patient_age">
			</div>	
			<div class="formControls col-xs-1 col-sm-1">
				<span class="select-box"><select class="select" name="year_type" id="year_type">
					<option value="岁">岁</option>
					<option value="月">月</option>
					<option value="日">日</option>
				</select></span>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-1 col-sm-1">出生日期：</label>
			<div class="formControls col-xs-2 col-sm-2">
				<input type="text" class="input-text Wdate" value="" onfocus="WdatePicker()" placeholder="" id="patient_birth" name="patient_birth">
			</div>	
			<label class="form-label col-xs-1 col-sm-1">身份证号：</label>
			<div class="formControls col-xs-2 col-sm-2">
				<input type="text" class="input-text" value="" placeholder="在此输入身份证号" id="patient_IDCard" name="patient_IDCard">
			</div>	
			<label class="form-label col-xs-1 col-sm-1">家庭住址：</label>
			<div class="formControls col-xs-2 col-sm-2">
				<input type="text" class="input-text" value="" placeholder="在此输入家庭住址" id="patient_Address" name="patient_Address">
			</div>	
			<label class="form-label col-xs-11 col-sm-11"></label>
		</div>
		<div class="row cl">		
		<label class="form-label col-xs-1 col-sm-1"><span class="c-red">*</span>结算类别：</label>
			<div class="formControls col-xs-2 col-sm-2">
				<span class="select-box"><select class="select" name="jiasuan_type" id="jiasuan_type">
					<option value="1">自费</option>
					<option value="2">公费</option>
				</select></span>
			</div>
		<label class="form-label col-xs-1 col-sm-1"><span class="c-red">*</span>看诊日期：</label>
			<div class="formControls col-xs-2 col-sm-2">
				<input type="text" class="input-text Wdate" value="" onfocus="WdatePicker({onpicked:load_regnum()})" placeholder="选择看诊日期" id="visitdate" name="visitdate">
			</div>
		<label class="form-label col-xs-1 col-sm-1"><span class="c-red">*</span>午别：</label>
			<div class="formControls col-xs-2 col-sm-2">
				<span class="select-box"><select class="select" name="noonbreak" id="noonbreak">
					<option value="上">上午</option>
					<option value="下">下午</option>
				</select></span>
			</div>
		<label class="form-label col-xs-1 col-sm-1"><span class="c-red">*</span>挂号科室：</label>
			<div class="formControls col-xs-2 col-sm-2">
				<span class="select-box"><select id="dept_Name" name="dept_Name" class="select" >			
				</select></span>
			</div>
			<label class="form-label col-xs-5 col-sm-5"></label>
		</div>		
		<div class="row cl">
		<label class="form-label col-xs-1 col-sm-1"><span class="c-red">*</span>号别：</label>
			<div class="formControls col-xs-2 col-sm-2">
				<span class="select-box"><select class="select" name="reg_type" id="reg_type">
					<option value="1">专家号</option>
					<option value="2">普通号</option>
				</select></span>
			</div>
		<label class="orm-label col-xs-1 col-sm-1"><span class="c-red">*</span>看诊医生：</label>
			<div class="formControls col-xs-2 col-sm-2">
				<span class="select-box"><select class="select" name="doctors" id="doctors">
				</select></span>
			</div>
			<label class="form-label col-xs-1 col-sm-1">初始号额：</label>
			<div class="formControls col-xs-2 col-sm-2">
					<input type="text" class="input-text" value="" placeholder="" id="start_number" name="start_number" readonly="readonly">
			</div>
			<label class="form-label col-xs-1 col-sm-1">已用号额：</label>
			<div class="formControls col-xs-2 col-sm-2">
					<input type="text" class="input-text" value="" placeholder="" id="used_number" name="used_number" readonly="readonly">
			</div>
			<label class="form-label col-xs-5 col-sm-5"></label>
		</div>
		<div class="row cl">
				<label class="form-label col-xs-1 col-sm-1">病历本</label>
				<div class="formControls col-xs-2 col-sm-2">
					<input type="checkbox" placeholder="" id="med_book" name="med_book">
			</div>
				<label class="form-label col-xs-1 col-sm-1"><span class="c-red">*</span>应收金额：</label>
			<div class="formControls col-xs-2 col-sm-2">
				<input type="text" class="input-text" value="" placeholder="" id="pay" name="pay" readonly="readonly">
			</div>
				<label class="form-label col-xs-1 col-sm-1"><span class="c-red">*</span>收费方式：</label>
			<div class="formControls col-xs-2 col-sm-2">
			<span class="select-box"><select class="select" name="payway" id="payway">
					<option value="51">现金</option>
					<option value="52">医保卡</option>
					<option value="53">银行卡</option>
					<option value="54">信用卡</option>
					<option value="55">微信</option>
					<option value="56">支付宝</option>
					<option value="57">云闪付</option>
					<option value="58">其他</option>
				</select></span>
			</div>	
		</div>	
	</form>
</article>
<!--_footer 作为公共模版分离出去-->
<%-- <script type="text/javascript" src="${APP_PATH}/his/lib/jquery/1.9.1/jquery.min.js"></script> --%>
<script type="text/javascript" src="${APP_PATH}/his/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${APP_PATH}/his/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/his/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${APP_PATH}/his/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${APP_PATH}/his/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${APP_PATH}/his/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="${APP_PATH}/his/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
//加载界面就会加载的函数
$(function(){
	getBillCode();//得到发票号
	getMaxmed();//得到可用病历号
	getDepts();//动态生成部门下拉框
	setTimeout(function(){
		loaddoc();//设置延迟加载出医生，否则一生不能加载
		},100);
	setTimeout(function(){
		load_start_num();//设置延迟加载初始号额
		},100);
});
	//为了防止清空时清空掉病历号发票号等信息
	$("#qingkong").click(function(){
		getMaxmed();
		getBillCode();
		load_start_num();
	});
	//显示所有部门信息在下拉框中
	function getDepts(){
	$.ajax({
		url:"${APP_PATH}/dept",
		type:"GET",
		 dataType: "json",
		success:function(result){
		//	console.log(result);
			 $.each(result.extend.deptlist,function(){
				var optionEle=$("<option></option>").append(this.deptName).attr("value",this.deptId);
				optionEle.appendTo("#dept_Name");
			}); 
		},
		error:function(result){
			console.log("失败");
		}
	});
}	
	$("#patient_birth").change(function(){
	    $("#patient_birth").attr("value",$(this).val()); //赋值
	});
	$("#visitdate").change(function(){
	    $("#visitdate").attr("value",$(this).val()); //赋值
	});
	//把挂号信息存储到挂号信息表
	$("#btn_guahao").click(function(){

		var	start_number=window.document.getElementById("start_number").value; 
		var	used_number=window.document.getElementById("used_number").value; 

		var	bill_code=window.document.getElementById("bill_code").value; 
		var	medrecord_code=window.document.getElementById("medrecord_code").value; 
		var	patient_name=window.document.getElementById("patient_name").value; 
		var	sex=window.document.getElementById("sex").value; 
		var	patient_age=window.document.getElementById("patient_age").value; 
		var	year_type=window.document.getElementById("year_type").value; 
		var	patient_birth=window.document.getElementById("patient_birth").value; 
		var	patient_IDCard=window.document.getElementById("patient_IDCard").value; 
		var	patient_Address=window.document.getElementById("patient_Address").value; 
		var	jiasuan_type=window.document.getElementById("jiasuan_type").value; 
		var	visitdate=window.document.getElementById("visitdate").value; 
		var	noonbreak=window.document.getElementById("noonbreak").value; 
		var	dept_Name=window.document.getElementById("dept_Name").value; 
		var	reg_type=window.document.getElementById("reg_type").value; 
		var	doctors=window.document.getElementById("doctors").value; 
		var	medbook=$("#med_book").is(':checked'); 
		var med_book
		if(medbook==""){
			med_book=0;
		}else{
			med_book=1;
		}
		var	payway=window.document.getElementById("payway").value; 	
		if(bill_code==""||medrecord_code==""||patient_name==""||sex==""||
				patient_age==""||year_type==""||patient_birth==""||
				patient_IDCard==""||patient_Address==""||jiasuan_type==""||
				visitdate==""||noonbreak==""||dept_Name==""||reg_type==""||payway==""
				){
				window.alert("挂号失败,请完善你的信息");
				return false;
		}
	if(parseInt(start_number)>parseFloat(used_number)){		
		$.ajax({
			url:"${APP_PATH}/start_regist",
			type:"GET",
			async:false,
			data:"bill_code="+bill_code+"&medrecord_code="+medrecord_code+"&patient_name="+patient_name+"&sex="+sex
							+"&patient_age="+patient_age+"&year_type="+year_type+"&patient_birth="+patient_birth
							+"&patient_IDCard="+patient_IDCard+"&patient_Address="+patient_Address+"&jiasuan_type="+jiasuan_type
							+"&visitdate="+visitdate+"&noonbreak="+noonbreak+"&dept_Name="+dept_Name+"&reg_type="+reg_type
							+"&doctors="+doctors+"&med_book="+med_book+"&payway="+payway,
			dataType: "json",
			
			success:function(result){
				if(result.code==100){
					window.alert("挂号成功");
					return true;
				}else{
					window.alert("挂号失败");
					return true;
				}
			},error:function(result){
				window.alert("error");
				return false;
			}
		});	
		}else{
			window.alert("名额已满，挂号失败");
		}
	});
	//动态加载医生下拉框
	function loaddoc(){
		var dept=window.document.getElementById("dept_Name").value; 
		var typeid=window.document.getElementById("reg_type").value;
		if(dept!=""&&typeid!=""){
			$.ajax({
				url:"${APP_PATH}/load_doctor",
				type:"GET",
				data:"deptId="+dept+"&regtypeid="+typeid,
				dataType: "json",
				success:function(result){
						$("#doctors").empty();
						 var op=$("<option></option>").append("请选择").attr("value","");
						op.appendTo("#doctors"); 
						 $.each(result.extend.doclist,function(){
							var optionEle=$("<option></option>").append(this.userRealname).attr("value",this.userId);
							optionEle.appendTo("#doctors");
						}); 
					},
					error:function(result){
						console.log("失败");
					}					
			});		
		}
	}
	//为了显示出已存在的病历号的信息以及验证是否存在病历号
	$("#medrecord_code").change(function(){	
		var medrecord=window.document.getElementById("medrecord_code").value; 
		var date=window.document.getElementById("patient_birth").value;
		$.ajax({
			url:"${APP_PATH}/load_medrecord",
			type:"GET",
			data:"medrecord_code="+medrecord,
			dataType: "json",
			success:function(result){	
				$("#medrecord_code").next("span").empty();
				if(result.extend.reglist !=""){
					var array=result.extend.reglist[0];
					 $("#patient_name").val(array.patientName);
					 $("select#sex").val(array.patientSex);
					 $("#patient_age").val(array.patientYear);
					 $("#year_type").val(array.patientYearType);
					 $("#patient_birth").val(array.patientBirth);
					 $("#patient_IDCard").val(array.patientIdcard);
					 $("#patient_Address").val(array.patientAddress);
					 return true;
				}else{
					$("#medrecord_code").next("span").text("病历号不存在！已为您自动生成了病历号,如果已有病历号则请重新输入");	
					$("#form-member-add").find("input,textarea").each(function(){
						   this.value ="";
						});
					getMaxmed();
					getBillCode();
					load_start_num();
					loaddoc();						
				}
				},
				error:function(result){
					console.log("失败");
				}							
		});		
	});
	//生成可用的发票号码
	function getBillCode(){
		$.ajax({
			url:"${APP_PATH}/load_billcode",
			type:"GET",
			dataType: "json",
			success:function(result){
				$("#bill_code").val(result.extend.billcode);
				return true;
			},error:function(result){
				console.log("失败了啊");
			}
		});	
	}
	//得到可以用的病历号
	function getMaxmed(){
		 $.ajax({
			 	url:"${APP_PATH}/load_maxmedrecord",
				type:"GET",
				dataType: "json",
				success:function(result){
					$("#medrecord_code").empty();
					$("#medrecord_code").val(result.extend.maxmed);
					return true;
				},
				error:function(result){				
					return false;
				}
		 });
	}
	//为了在部门和挂号类别改变时改变初始号额
	$("#reg_type,#dept_Name").change(function(){
		load_start_num();	
	});
	
	//为了加载初始号额
	function load_start_num(){
		$("#used_number").val("");
		loaddoc();
		var typeid=window.document.getElementById("reg_type").value;
		$.ajax({
			url:"${APP_PATH}/load_typeid",
			type:"GET",
			data:"regtypeid="+typeid,
			dataType: "json",
			success:function(result){
				$("#pay").val(result.extend.reg.regCost);
				$("#start_number").val(result.extend.reg.regLimitnum);
				return true;
			}
		});
	}
	//统计挂号人数
$(document).on('change','#doctors,#noonbreak',function(){
	 load_regnum();
});  
$(document).on('change','#dept_Name',function(){
	$("#used_number").val("");
	loaddoc();
});
	//加载这个医生的已用号额
	function load_regnum(){
		var	visitdate=window.document.getElementById("visitdate").value;
		var	noonbreak=window.document.getElementById("noonbreak").value;
		var	doctors=window.document.getElementById("doctors").value; 
		if(visitdate!=""&&noonbreak!=""&&doctors!=""){
		$.ajax({
			url:"${APP_PATH}/load_regnum",
			type:"GET",
			data:{visitdate:visitdate,noonbreak:noonbreak,doctors:doctors},
			dataType: "json",
			success:function(result){
				$("#used_number").val(result.extend.num);
				return true;
			}
		});
		}
		
	}
</script> 
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>